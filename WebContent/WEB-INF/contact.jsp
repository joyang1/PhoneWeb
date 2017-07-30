<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basepath%>css/images/logo.gif" rel="icon">
<link href="<%=basepath%>css/bootstrap.min.css" rel="stylesheet" type="text/css">
<title>联系我们</title>
<style type="text/css">
	body{
		background-color:#eee !important; 
	}
</style>
</head>
<body>
<div class="jumbotron">
  <h1>联系我们</h1>
  <p>手机:18525453520</p>
  <p>QQ:1173870805</p>
  <p>邮箱:1173870805@qq.com</p>
  <p><a class="btn btn-primary btn-lg" href="http://localhost:8000/PhoneWeb" role="button">返回首页</a></p>
</div>
</body>
</html>