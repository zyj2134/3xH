<%@page contentType="text/html;charset=UTF-8" isErrorPage="true"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<title>404请求页面不存在</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="<%=basePath%>css/error.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="error">
		<!-------头部开始---------->
		<div class="head">
			<h2>哎呀，不小心就找不到页面了！</h2>
			<h5>有人真的喜欢这个页面，也许你打错了网址。</h5>
		</div>
		<!-------头部结束---------->
		<!-----错误提示开始-------->
		<div class="errors">
			<div class="notfound"></div>
			<div class="msg">
				<div class="error404">
					对不起，看样子你要找的文件已被移动或已被永久删除。<br/>
					<br/>
				</div>
				<div class="clear"></div>
				<div class="suggest">
					我们建议...<br/>
					<br/>
					请检查您输入的网址是否正确。<br/>
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