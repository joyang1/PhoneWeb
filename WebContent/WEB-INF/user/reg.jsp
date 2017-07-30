<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/reg.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="js/reg.js" type="text/javascript"></script>
<title>用户注册</title>
</head>
<body>
	<div class="main">
		<!-----start-reg---->
		<h2><font color="red">欢迎用户注册</font></h2>
		<form action="user-regedit" method="post">
			<div class="clear"></div>
			<div class="lable">
				<input id="username" name="user.username" type="text" class="text" value="用户名"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '用户名';}">
				<input id="name" name="user.name" type="text" class="text" value="姓名"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '姓名';}"> 
				<input id="email" name="user.email" type="text" class="text" value="邮箱 " onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '邮箱 ';}"> 
				<input id="phonenum" name="user.phonenum" type="text" class="text" value="手机号码 " onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '手机号码  ';}">
				<input id="passwd" name="user.passwd" type="password" class="text" value="密码 " onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '密码 ';}"> 
				<input id="rpasswd" type="password" class="text" value="确认密码 "
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '确认密码 ';}">
			</div>
			<div class="clear"></div>
			<h3>
				已有账号，请登录 <span><a href="user-login">登陆</a> <span>
			</h3>
			<div class="submit">
				<input type="submit" value="确定注册">
			</div>
			<div class="clear"></div>
		</form>
		<!-----//end-reg---->
	</div>
	<!-- Footer -->
	<div id="footer">
		<p class="left">
			<a href="#">首页</a> <span>|</span> <a href="#">新闻中心</a> <span>|</span>
			<a href="#">我的购买</a> <span>|</span> <a href="#">产品展示</a> <span>|</span>
			<a href="#">联系我们</a>
		</p>
		<p class="right">
			&copy; 2015 基于web的手机销售管理系统@copyright. Design by 舒东林 <a href="#"
				target="_blank" title="The Sweetest CSS Templates WorldWide">PhoneWeb</a>
		</p>
	</div>
	<!-- End Footer -->
</body>
</html>