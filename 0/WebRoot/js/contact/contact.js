/*
 * 说明：联系方式表单提交
 * 作者：左右君
 * 邮箱：zyj3421@qq.com
 * 创建日期：2014年5月27日
 * 最后修改日期：2014年5月29日
 */
// 回车事件
function keyDown(e) {
	e = e || window.event;
	var keycode = e.which ? e.which : e.keyCode;
	if (keycode == 13 || keycode == 108) { //如果按下ENTER键
		submitHandle();
	}
}
// 提交处理
function submitHandle(){
	if(valiForm()){
		$("#info").submit();
	}
	return false;
}

$(function() {
	if($(":text")){
		// 获得第一个文本输入框焦点
		$(":text:first").focus();
		// 获取第一个为空的文本输入框的焦点
		for(var i = 0; i < $(":text").size(); i++){
			if($(":text:eq(" + i + ")").val() == ""){
				$(":text:eq(" + i + ")").focus();
				break;
			}
		}
		// 绑定按键事件
		document.onkeydown = keyDown;
	}
	if($("img")){
		// 点击验证码换一个验证码
		$("img:first").click(function() {
			$(this).attr("src", 'randomCode?' + Math.random());
		});
	}
})

// 表单验证
function valiForm(){
	if($("[name='randomCode']") && $("[name='randomCode']").val() == ""){
		$("#err_msg").html("请检查：您还未填写验证码");
		return false;
	}
	if($("[name='answer']").val() == ""){
		$("#err_msg").html("请检查：您还未回答问题");
		return false;
	}
	return true;
}