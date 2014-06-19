<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
  <base href="<%=basePath%>">
   
  <title>3xH笼</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="HTML5,js,字符画">
	<meta http-equiv="description" content="前段开发，具体内容未定，即兴而作">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
* {
	margin: 0;
	padding: 0;
}

body{
	background: #f8f8f8;
}

.box-top {
	height: 35px;
	overflow: hidden;
	border-bottom: solid 1px #C6CACD;
	background: rgba(255, 255, 255, 0.9);
	z-index: 1000;
	box-shadow: 0 1px 4px rgba(49, 49, 64, 0.1);
	position: relative;
	top: 1px;
	left: 1px;
	right: 1px;
}

.top-content,.footer-content {
	width: 960px;
	margin: 0 auto;
}

.nav {
	list-style: none;
	text-decoration: none;
	color: #525252;
}

.top-content,.nav li {
	height: 35px;
	line-height: 35px;
}

.nav .item {
	float: left;
	margin: 0 8px 0 0;
}

.nav .link {
	float: right;
	margin: 0 3px;
}

.link a {
	font-size: 18px;
	font-weight: bold;
	text-decoration: none;
	color: #525252;
}

.box-content {
	padding: 0 0 50px 0;
	position: relative;
	width: 960px;
	margin: 0 auto;
}

.component .page-tip {
	border: 1px solid #e49e2e;
	color: #666;
	background: #fefaf7;
	padding: 0 9px;
	line-height: 29px;
	font-size: 12px;
}

.box-footer {
	font-size: 12px;
	bottom: 0;
	position: absolute;
	width: 100%;
	color: #878787;
	text-align: center;
	padding: 8px 0;
	background-color: #f0f0f0;
	overflow: hidden;
}
</style>
</head>
  
<body>
	<div class="box-top">
		<div class="top-content">
			<ul class="nav">
				<li class="link">
					<a href="<%=basePath%>works/Ascii">字符画</a>
				</li>
				<li class="link">
					<span>|</span>
				</li>
				<li class="link">
					<a href="<%=basePath%>feedback/" target="_blank">意见反馈</a>
				</li>
				<li class="link">
					<span>|</span>
				</li>
				<li class="link">
					<a href="<%=basePath%>contact/">联系方式</a>
				</li>
				<li class="item">
					<span>欢迎光临！</span>
				</li>
			</ul>
		</div>
	</div>
	<video height="0" width="0" name="media" loop="loop" autoplay="autoplay" id="music">
 		<source src="http://bcs.duapp.com/xxxholic/Music/Zashiki%20Warashi.ogg" type="audio/ogg">
 		<source src="http://bcs.duapp.com/xxxholic/Music/Zashiki%20Warashi.mp3" type="audio/mpeg">
	</video>
	<div class="box-content">
		<div class="component">
		  <div class="page-tip">
		    <span style="color:#CC0000;font-weight:bold;">公告：2014年6月4日BAE2.0下线！</span>BAE3.0 要收费，BAE2.0的应用代码和数据库等服务最多保留至6月30号，届时本网站将停止服务&nbsp;<a target="_blank" href="http://developer.baidu.com/wiki/index.php?title=docs/cplat/bae/bill">计费说明</a>
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
