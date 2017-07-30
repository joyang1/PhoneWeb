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
<title>关于系统</title>
<style type="text/css">
	body{
		background-color:#eee !important; 
	}
</style>
</head>
<body>
<div class="jumbotron">
  <h1>关于系统</h1>
  <p>该系统采用JSP(SSH框架)动态网页技术实现，以Mysql为后台数据库，以NetbeansIDE为前台开发工具设计而成。</p>
  <p>SSH 为 struts+spring+hibernate的一个集成框架，是目前较流行的一种Web应用程序开源框架。<p/>
  <p>集成SSH框架的系统从职责上分为四层：表示层、业务逻辑层、数据持久层和域模块层，以帮助开发人员在短期内搭建结构清晰、可复用性好、维护方便的Web应用程序。其中使用Struts作为系统的整体基础架构，负责MVC的分离，在Struts框架的模型部分，控制业务跳转，利用Hibernate框架对持久层提供支持，Spring做管理，管理struts和hibernate。具体做法是：用面向对象的分析方法根据需求提出一些模型，将这些模型实现为基本的Java对象，然后编写基本的DAO(Data Access Objects)接口，并给出Hibernate的DAO实现，采用Hibernate架构实现的DAO类来实现Java类与数据库之间的转换和访问，最后由Spring做管理，管理struts和hibernate。</p>
  <p><a class="btn btn-primary btn-lg" href="http://localhost:8000/PhoneWeb" role="button">返回首页</a></p>

</div>
</body>
</html>