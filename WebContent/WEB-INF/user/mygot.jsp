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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basepath%>css/style.css" type="text/css"
	media="all" />
<link rel="stylesheet" href="<%=basepath%>css/content.css"
	type="text/css" media="all" />
<link href="<%=basepath%>EasyUI/themes/icon.css" rel="stylesheet" />
<link href="<%=basepath%>EasyUI/themes/default/easyui.css"
	rel="stylesheet" />


<!--[if lte IE 6]><link rel="stylesheet" href="css/ie6.css" type="text/css" media="all" /><![endif]-->
<!-- JS -->
<script src="<%=basepath%>js/jquery-1.10.2.min.js"
	type="text/javascript"></script>
<script src="<%=basepath%>js/jquery-1.4.1.min.js" type="text/javascript"></script>
<script src="<%=basepath%>js/jquery.jcarousel.pack.js"
	type="text/javascript"></script>
<script src="<%=basepath%>EasyUI/jquery.min.js"></script>
<script src="<%=basepath%>EasyUI/jquery.easyui.min.js"></script>
<script src="<%=basepath%>EasyUI/locale/easyui-lang-zh_CN.js"></script>
<!-- End JS -->
<title>我的购买</title>
<style type="text/css">
body {
	background: white !important;
}
</style>
</head>
<body>

	<!-- Header -->
	<div id="header">
		<h1 id="logo">
			<a href="#">phoneweb</a>
		</h1>


		<!-- Navigation -->
		<div id="navigation">
			<ul>
				<li><a href="<%=basepath%>">首页</a></li>
				<li><a href="<%=basepath%>user-newslist">新闻中心</a></li>
				<li><a href="<%=basepath%>user-getlist" class="active">我的购买</a></li>
				<li><a href="<%=basepath%>user-phonelist">产品展示</a></li>
				<li><a href="<%=basepath%>user-contact">联系我们</a></li>
			</ul>
		</div>
		<!-- End Navigation -->
	</div>
	<!-- End Header -->
	<h1 id="h1title" class="ep-h1">我的购买</h1>
	<hr />
	<div class="contain1">
		<ul class="list">
			<s:iterator id="list" value="listorder" status="sta">
				<li>
					<dl>
						<dt>
							${list.phone.phonename }
						</dt>
						<dd class="time">购买于${list.createdate}</dd>
						<dd class="type">价格：${list.phone.price}</dd>
					</dl>
				</li>
			</s:iterator>
		</ul>
	</div>
	<div class="clear"></div>
	<div id="pp" style="background: #efefef; border: 1px solid #ccc;"></div>
</body>
</html>
<script>
	//var pagesize = 10;
	load();
	function load() {
		$("#pp").pagination(
				{
					total : "${gettotal}",
					pageSize : "${getpageSize}",//每页显示的大小。
					pageNumber : "${getpageNumber}",
					pageList : [ 10, 20, 50 ],//选择每页显示的记录数的下拉框的值
					beforePageText : '第', //页数文本框前显示的汉字  
					afterPageText : '页    共 ${getpages} 页',
					onSelectPage : function(pageNumber, pageSize) {
						$("#pp").pagination('loading');
						$("#pp").pagination('loaded');
						window.location.href = "user-getlist?getpageNumber="
								+ pageNumber + "&getpageSize=" + pageSize;
						load();
					}

				});

	}

	
</script>