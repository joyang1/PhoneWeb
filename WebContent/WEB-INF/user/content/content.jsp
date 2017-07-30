<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=basepath%>css/style.css" type="text/css"
	media="all" />
<link rel="stylesheet" href="<%=basepath%>css/content.css"
	type="text/css" media="all" />
<!--[if lte IE 6]><link rel="stylesheet" href="css/ie6.css" type="text/css" media="all" /><![endif]-->
<!-- JS -->
<script src="<%=basepath%>js/jquery-1.10.2.min.js"
	type="text/javascript"></script>
<script src="<%=basepath%>js/jquery-1.4.1.min.js" type="text/javascript"></script>
<script src="<%=basepath%>js/jquery.jcarousel.pack.js"
	type="text/javascript"></script>
<script src="<%=basepath%>js/jquery-func.js" type="text/javascript"></script>

<!-- End JS -->
<title>新闻内容页</title>
</head>
<body>
	<!-- Header -->
	<div id="header">
		<h1 id="logo">
			<a href="<%=basepath%>">phoneweb</a>
		</h1>


		<!-- Navigation -->
		<div id="navigation">
			<ul>
				<li><a href="<%=basepath%>">首页</a></li>
				<li><a href="<%=basepath%>user-newslist" class="active">新闻中心</a></li>
				<li><a href="<%=basepath%>user-getlist">我的购买</a></li>
				<li><a href="<%=basepath%>user-phonelist">产品展示</a></li>
				<li><a href="<%=basepath%>user-contact">联系我们</a></li>
			</ul>
		</div>
		<!-- End Navigation -->
	</div>
	<!-- End Header -->
	<div id="c_news">
		<h1 id="h1title" class="ep-h1">${news.title}</h1>
		<div class="ep-time-soure cDGray">
			${news.newsdate } 来源: phoneweb
		</div>
		<div id="content">${news.content}</div>
	</div>
</body>
</html>