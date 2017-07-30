<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/reg.css" rel="stylesheet" type="text/css">
<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>

<title>登陆界面</title>
</head>
<body>
	<div class="main">
		<!-----start-login---->
		<h2> <font color="red">欢迎用户</font></h2>
		<p>${loginerror}</p>
		<p>${loginfirst}</p>
		<form action="user-dologin" method="post">
			<div class="clear"></div>
			<div class="lable">
				<input id="username" name="user.email" type="text" class="text"
					value="注册邮箱" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '注册邮箱';}"> 
				<input id="name" name="user.passwd" type="password" class="text" value="密码"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '密码';}"> 
				

			</div>
			<div class="clear"></div>

			<div class="submit">
				<input type="submit" value="确定登陆">
			</div>
			<div class="clear"></div>
		</form>
		<!-----//end-login---->
	</div>
	

</body>
</html>