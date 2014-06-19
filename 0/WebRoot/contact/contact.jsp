<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
  <base href="<%=basePath%>">
   
  <title>获取最新联系方式</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="keywords" content="联系方式" />
	<meta name="description" content="获取最新联系方式" />
	<link rel="stylesheet" href="<%=basePath%>css/contact.css" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>js/libs/jquery-1.4.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/contact/contact.js"></script>
</head>
  
<body>
	<div class="box-top">
		<div class="top-content">
			<ul class="nav">
				<li class="link">
					<a href="<%=basePath%>">首页</a>
				</li>
				<li class="link">
					<span>|</span>
				</li>
				<li class="link">
					<a href="<%=basePath%>works/Ascii">字符画</a>
				</li>
				<li class="link">
					<span>|</span>
				</li>
				<li class="link">
					<a href="<%=basePath%>feedback/" target="_blank">意见反馈</a>
				</li>
				<li class="item">
					<span>${step}</span>
				</li>
			</ul>
		</div>
	</div>
	<div class="box-content">
		<div class="content-layer">
			<div class="content-message">
				<form action="<%=basePath%>${action}" method="post" id="info" onsubmit="return false;">
					<p>${type}：${question}<c:if test="${empty contact}"><input type="text" name="answer" class="answer" value="${answer}"/></c:if></p>
					<c:if test="${sessionScope.answer_err_count ge 3}">
					<p>验证码：<input type="text" name="randomCode" class="random-code"/><img src="randomCode" alt="验证码" title="请输入图片上的字符，不区分大小写"/></p>
					</c:if>
					<span id="tips">${empty tips?"":"提示："}${tips}</span><br/>
					<span id="err_msg">${empty err?"":"请检查："}${err}</span>
				</form>
			</div>
		</div>
	</div>
	<div class="box-footer">
		<div class="footer-content">
			&copy; 2014 左右君
		</div>
	</div>
</body>
</html>
