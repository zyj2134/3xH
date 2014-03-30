<%@page contentType="text/html;charset=UTF-8" isErrorPage="true"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<title>500系统错误</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="<%=basePath%>css/error.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="error">
		<!-------头部开始---------->
		<div class="head">
			<h2>服务器可能病了！</h2>
			<h5>正在医院打点滴呢，没有生命危险的。</h5>
		</div>
		<!-------头部结束---------->
		<!-----错误提示开始-------->
		<div class="errors">
			<div class="wrong"></div>
			<div class="msg">
				<div class="error500">
					对不起，无法找到该页面，服务器内部错误。<br/>
					<br/>
				</div>
				<div class="clear"></div>
				<div class="suggest">
					我们建议...<br/>
					<br/>
					<div class="refresh xxlarge">
						F5
					</div>
					<div class="refresh xlarge">
						刷新试试！
					</div>
					<br/>
					或联系我们给他找医生：<a target="_blank" href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=h-3_7bSztbbH9vap5Ojq" style="text-decoration:none;">zyj3421@qq.com</a><br/>
					<br/>
					<ul>
						<li>
							<a href="javascript:void(0);" onclick="history.go(-1);">&lt;&lt;返回上一页</a>
						</li>
						<li>
							<a href="<%=basePath%>">&lt;&lt;返回主页</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!-----错误提示结束-------->
		<!-------页尾开始---------->
		<div class="clear"></div>
		<div class="footer">
			&copy; 2014 左右君
		</div>
		<!-------页尾结束---------->
	</div>
</body>
</html>