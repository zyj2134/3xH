<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<title>_8(:зゝ∠)_ ASCII Art Video Player</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="keywords" content="字符画,字符动画,ASCII艺术,字符画生成,字符播放器" />
	<meta name="description" content="基于HTML5实现的多功能播放器，选择一个本地视频、音频、图片即可查看效果，其中图片和视频会转为字符画，音频直接播放，具体的支持格式因浏览器而异。" />
	<link rel="stylesheet" href="<%=basePath%>css/ascii.css" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>js/libs/anime.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/libs/tween.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/works/ascii.js"></script>
</head>
<body>
	<div class="box-top" id="header">
		<ul class="nav">
			<li class="spread" id="spread" title="点击展开">
				<span>▶</span>
			</li>
			<li class="item">
				<input type="file" id="file" class="file">
			</li>
			<li class="item">
				填充字符：
				<select id="characters" class="characters">
					<option value="█▓▒░">█▓▒░</option>
					<option value="M80V1;:*-. ">M80V1;:*-. </option>
					<option value="MNHQ$OC?7>!:-;. ">MNHQ$OC?7&gt;!:-;. </option>
					<option value="#8XOHLTI)i=+;:,. ">#8XOHLTI)i=+;:,.</option>
					<option value="M@WB08Za2SX7r;i:;. ">M@WB08Za2SX7r;i:,. </option>
					<option value="@#MBHAGh93X25Sisr;:, ">@#MBHAGh93X25Sisr;:, </option>
					<option value="01 ">01 </option>
					<option value="1234567890 ">1234567890 </option>
					<option value="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ">ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz </option>
					<option value="#,.0123456789:;@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz$ ">#,.0123456789:;@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz$ </option>
					<option value="MN#$&;@*QEHKRBDW89F6hg5A0OUXZGdPSpmJI4LbTVfq2n3YCyluw7?axev|s1j+rz=toi!~-;^:',. ">MN#$&amp;@*QEHKRBDW89F6hg5A0OUXZGdPSpmJI4LbTVfq2n3YCyluw7?axev|s1j+rz=toi!~-;^:',. "</option>
				</select>
			</li>
			<li class="item">
				<span id="fps"></span>
			</li>
			<li class="item">
				<input id="stop" type="button" value="停止" class="stop" />
			</li>
			<li class="item">
				<input id="play" type="button" value="暂停" class="play" />
			</li>
			<li class="link">
				<a href="<%=basePath%>">首页</a>
			</li>
			<li class="link">
				<span>|</span>
			</li>
			<li class="link">
				<a href="<%=basePath%>feedback/" target="_blank">意见反馈</a>
			</li>
		</ul>
	</div>
	<div>
		<video id="video" height="0" width="0" name="media" loop="loop" autoplay="autoplay">
			消灭IE6 从你我开始
		</video>
		<img id="image"/>
	</div>
	<div class="box-content" id="txt">
		✧*｡٩(ˊᗜˋ*)و✧*｡基于HTML5实现的多功能播放器，选择一个本地视频、音频、图片即可查看效果，其中图片和视频会转为字符画，音频直接播放，具体的支持格式因浏览器而异。<br /><br />
		Chrome浏览器播放效果最佳。<a href="http://www.google.cn/intl/zh-CN/chrome/browser/" title="Chrome 浏览器 " target="_blank">下载 Google Chrome</a>
	</div>
	<script type="text/javascript" src="<%=basePath%>js/works/effect.js"></script>
</body>
</html>