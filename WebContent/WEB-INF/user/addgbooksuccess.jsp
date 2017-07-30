<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/images/logo.gif" rel="icon">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<title>留言发送成功</title>
<style type="text/css">
body {
	background-color: #eee !important;
}
</style>
</head>
<body>
	<div class="jumbotron">
			<h1>
				${addguestbook }
			</h1>
		<p>
			<a class="btn btn-primary btn-lg"
				href="user-guestbook" role="button">返回留言</a>
		</p>
		<p>
			<a class="btn btn-primary btn-lg"
				href="http://localhost:8000/PhoneWeb" role="button">返回首页</a>
		</p>

	</div>

</body>
</html>
