/*
 * 说明：意见反馈表单验证，显示反馈提交成功或者失败提示
 * 作者：左右君
 * 邮箱：zyj3421@qq.com
 * 日期：2014年2月23日
 */
// 文本内容提示
var tips = "亲爱的用户：\n　　请在这里输入您的意见、建议，我将用心倾听，不断优化，为您提供更优质的服务（500字以内）。";
var isEmpty = false; // 判断文本域是否为空
var maxlength = 500;
// 页面加载
$(function(){
	if($("#ret").val() != ""){
		pop();
	}
	if($("#formContent").val() == ""){
		// 初始化文本域内容
		$("#formContent").val(tips);
		isEmpty = true;
	}
	$("#formContent").focus(function(){
		if(isEmpty){
			$("#formContent").val("");
		}
	});
	
	$("#formContent").blur(function(){
		if($("#formContent").val() == ""){
			$("#formContent").val(tips);
			$("#formContent_err").html("发送内容不能为空哦");
			isEmpty = true;
		} else {
			// fuck IE...
			if($("#formContent").val().length > maxlength){
				var over = $("#formContent").val().length - maxlength;
				$("#formContent_err").html("发送内容不能超过500字哦，您已超出" + over + "个字，请删减。");
			} else {
				$("#formContent_err").html("");
			}
			isEmpty = false;
		}
	});
	
	$("#formEmail").blur(function(){
		if(/^([\w\.\-]+@([\w\-]+\.)+[a-zA-Z]{2,4})?$/.test($("#formEmail").val())){
			$("#formEmail_err").html("");
		} else {
			$("#formEmail_err").html("请输入正确邮箱地址");
		} 
	});
	
	$("#form").submit(function(){
		return valiForm();
	});
})

// 表单验证
function valiForm(){
	if(isEmpty){
		$("#formContent_err").html("发送内容不能为空哦");
		$("#formContent_err").css("display","block");
		return false;
	} else if($("#formContent").val().length > maxlength){
		var over = $("#formContent").val().length - maxlength;
		$("#formContent_err").html("发送内容不能超过500字哦，您已超出" + over + "个字，请删减后再发送。");
		$("#formContent_err").css("display","block");
		return false;
	}
	if(!/^([\w\.\-]+@([\w\-]+\.)+[a-z]{2,4})?$/i.test($("#formEmail").val())){
		$("#formEmail_err").css("display","inline");
		return false;
	}
	return true;
}

// 弹出层
function pop(){
	// 弹出层信息
	if($("#ret").val() == "true"){
		$("#msg").html("提交成功！");
		$("#thanks").html("感谢您的宝贵建议，处理后我将通过您留下的邮箱与您联系，感谢您对本网站的支持。");
	} else {
		$("#msg").html("提交失败！");
		$("#thanks").html("非常抱歉，您的反馈没有提交成功，您可以稍后再试或者将反馈邮件至<a target=\"_blank\" href=\"http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=h-3_7bSztbbH9vap5Ojq\" style=\"text-decoration:none;\">zyj3421@qq.com</a>，由此给您带来的不便，敬请原谅，感谢您的理解与支持！");
	}
	// 显示阴影层
	$("#shadow").css("height",$(document).height()).css("display", "block");
	var screenWidth = window.screen.width;
	var screenHeight = window.screen.height;
	var dialogWidth = $("#pop").width();
	var dialogHeight = $("#pop").height();
	//计算弹出层的位置，显示在正中间
	var dialogLeft = (screenWidth - dialogWidth) / 2 >> 0;
	var dialogTop = (screenHeight - dialogHeight) / 2 >> 0;
	$("#pop").css("left", dialogLeft + "px").css("top", dialogTop + "px").css("display", "block");
	$("#close").click(function(){
		closePop();
	});
	$("#commit").click(function(){
		closePop();
	});
}

// 关闭弹出层
function closePop(){
	$("#shadow").css("display", "none");
	$("#pop").css("display", "none");
}