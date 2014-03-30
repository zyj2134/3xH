<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<title>意见建议</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="keywords" content="意见建议" />
	<meta name="description" content="意见建议，3xH" />
	<link rel="stylesheet" href="<%=basePath%>css/feedback.css" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>js/libs/jquery-1.4.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/feedback/feedback.js"></script>
</head>
<body>
	<div class="shadow" id="shadow"></div>
	<div class="pop" id="pop">
		<div class="pop-title">
			<span>提交反馈</span>
			<input type="button" id="close" title="关闭" class="pop-close" value="×" />
		</div>
		<div class="pop-content">
			<div class="pop-msg">
				<span id="msg"></span>
			</div>
			<div>
				<span id="thanks"></span>
			</div>
			<div class="pop-btn">
				<input type="button" id="commit" value="确 定" class="pop-commit" />
			</div>
		</div>
	</div>
	<div class="box-top">
		<div class="top-content">
			<ul class="nav">
				<li class="link">
					<a href="<%=basePath%>">首页</a>
				</li>
				<li class="item">
					<span>欢迎您使用意见反馈平台！</span>
				</li>
			</ul>
		</div>
	</div>
	<div class="box-content">
		<input type="hidden" value="${ret}" id="ret"/>
		<div class="title">
			<span>您在浏览本网站中遇到了什么问题或者有什么意见，可以在这里自由吐槽。也可以发邮件到<a target="_blank" href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=h-3_7bSztbbH9vap5Ojq" style="text-decoration:none;">zyj3421@qq.com</a>，我会每天关注反馈，并在第一时间解决问题，感谢您的支持。</span>
		</div>
		<div class="content">
			<form action="submit" class="feedback" id="form" method="post">
				<div class="clear inputLayer">
					<span class="iptxt">
						<textarea name="content" id="formContent" maxlength="500">${content}</textarea>
					</span>
				</div>
				<div class="content_err">
					<span class="error" id="formContent_err">${formContent_err}</span>
				</div>
				<div class="contact">
					<div class="contactTxt">
						<span>请在此留下您的联系方式，以便问题解决时联系您。</span>
					</div>
					<div class="clear contactIpt">
						<span class="emailTxt">您的邮箱：</span>
						<span class="iptxt"><input name="email" type="email" size="35" id="formEmail" value="${email}" maxlength="35"/></span>
						<span class="error" id="formEmail_err">${formEmail_err}</span>
					</div>
				</div>
				<div class="btnArea">
					<input type="submit" value="发 送" class="btn" id="btnSubmit">
				</div>
			</form>
		</div>
	</div>
	<div class="box-footer">
		<div class="footer-content">
			&copy; 2014 左右君
		</div>
	</div>
</body>
</html>