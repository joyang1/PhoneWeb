<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basepath%>" />
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<meta name="keywwords" content="基于web的手机销售管理系统  手机" />
<meta name="description" content="基于web的手机销售管理系统 手机" />
<link href="<%=basepath%>css/images/logo.gif" rel="icon">
<link rel="stylesheet" href="<%=basepath%>css/style.css" type="text/css"
	media="all" />
<!--[if lte IE 6]><link rel="stylesheet" href="css/ie6.css" type="text/css" media="all" /><![endif]-->
<!-- JS -->
<script src="<%=basepath%>js/jquery-1.10.2.min.js"
	type="text/javascript"></script>
<script src="<%=basepath%>js/jquery-1.4.1.min.js" type="text/javascript"></script>
<script src="<%=basepath%>js/jquery.jcarousel.pack.js"
	type="text/javascript"></script>
<script src="<%=basepath%>js/jquery-func.js" type="text/javascript"></script>

<!-- End JS -->

</head>
<body>


	<!-- Shell -->
	<div class="shell">

		<!-- Header -->
		<div id="header">
			<h1 id="logo">
				<a href="<%=basepath%>">phoneweb</a>
			</h1>

			<!-- Navigation -->
			<div id="navigation">
				<ul>
					<li><a href="<%=basepath%>" class="active">首页</a></li>
					<li><a href="<%=basepath%>user-newslist">新闻中心</a></li>
					<li><a href="<%=basepath%>user-getlist">我的购买</a></li>
					<li><a href="<%=basepath%>user-phonelist">产品展示</a></li>
					<li><a href="<%=basepath%>user-contact">联系我们</a></li>
				</ul>
			</div>
			<!-- End Navigation -->
		</div>
		<!-- End Header -->

		<!-- Main -->
		<div id="main">
			<div class="cl">&nbsp;</div>

			<!-- Content -->
			<div id="content">

				<!-- Content Slider -->
				<div id="slider" class="box">
					<div id="slider-holder">
						<ul>
							<s:iterator id="list" value="listproduct" status="sta">
								<li><a href="user-phonedetail?product.id=${list.id }"><img
										style="width: 720px; height: 250px"
										src="<%=basepath%>phoneimg/${list.phonebigimg}"
										title="${list.phonename }" alt="" /></a></li>
							</s:iterator>
						</ul>
					</div>
					<div id="slider-nav">
						<a href="#" class="active">1</a> <a href="#">2</a> <a href="#">3</a>
						<a href="#">4</a>
					</div>
				</div>
				<!-- End Content Slider -->

				<!-- Products -->
				<div class="products">
					<div class="cl">&nbsp;</div>
					<ul>
						<s:iterator id="list" value="listproduct1" status="sta">
							<li><a href="user-phonedetail?product.id=${list.id }"><img
									src="<%=basepath%>phoneimg/${list.phonebigimg}"
									title="${list.phonename }" alt="" /></a>
								<div class="product-info">
									<h3>${list.productsort.fatherId }</h3>
									<div class="product-desc">
										<h4>热销</h4>
										<p>
											大家 <br />都 说 好<br />合适
										</p>
										<strong class="price">${list.price }￥</strong>
									</div>
								</div></li>
						</s:iterator>
					</ul>
					<div class="cl">&nbsp;</div>
				</div>
				<!-- End Products -->

			</div>
			<!-- End Content -->

			<!-- Sidebar -->
			<div id="sidebar">

				<!-- Search -->
				<div class="box search">
					<h2>
						搜索 <span></span>
					</h2>
					<div class="box-content">
						<form action="user-search" method="post">

							<label>关键词</label> <input type="text" class="field" name="product.phonename"/> <label>类别</label>
							<select class="field" name="productsort.id">
								<s:iterator id="list" value="listproductsort" status="sta">
									<option value="${list.id }">${list.fatherId }</option>
								</s:iterator>
							</select>

							<div class="inline-field">
								<label>价格</label> <select class="field small-field" name="sprice1">
									<option value="100">100￥</option>
									<option value="200">200￥</option>
									<option value="500">500￥</option>
									<option value="1000">1000￥</option>
								</select> <label>到:</label> <select class="field small-field" name="sprice2">
									<option value="10000">6000￥</option>
									<option value="10000">7000￥</option>
									<option value="10000">8000￥</option>
									<option value="10000">10000￥</option>
								</select>
							</div>

							<input type="submit" class="search-submit" value="查询" />

							<p>
								<s:if test="#session.user.username!=null">
									<font style="font-size: 14px; font-weight: bold;">
										欢迎${session.user.username }</font>
									<br />
									<a href="user-loginout" class="bul">退出</a>
								</s:if>
								<s:else>
									<a href="user-login" class="bul">登陆</a>
									<br />
									<a href="user-reg" class="bul">注册</a>
								</s:else>

							</p>

						</form>
					</div>
				</div>
				<!-- End Search -->

				<!-- Categories -->
				<div class="box categories">
					<h2>
						新闻中心 <span></span>
					</h2>
					<div class="box-content">
						<ul>
							<s:iterator id="list" value="listnews" status="sta">
								<li><a href="user-newscontent?news.id=${list.id}">${list.title }
								</a></li>
							</s:iterator>

						</ul>
					</div>
				</div>
				<!-- End Categories -->

			</div>
			<!-- End Sidebar -->

			<div class="cl">&nbsp;</div>
		</div>
		<!-- End Main -->

		<!-- Side Full -->
		<div class="side-full">

			<!-- More Products -->
			<div class="more-products">
				<div class="more-products-holder">
					<ul>
						<s:iterator id="list" value="listproduct2" status="sta">
							<li><a href="user-phonedetail?product.id=${list.id }"><img
									width="94px" height="94px"
									src="<%=basepath%>phoneimg/${list.phonebigimg}"
									title="${list.phonename }" alt="" /></a></li>
						</s:iterator>

					</ul>
				</div>
				<div class="more-nav">
					<a href="#" class="prev">previous</a> <a href="#" class="next">next</a>
				</div>
			</div>
			<!-- End More Products -->

			<!-- Text Cols -->
			<div class="cols">
				<div class="cl">&nbsp;</div>
				<div class="col">
					<h3 class="ico ico1">留言模块</h3>
					<p>大家可以给我们的产品进行好坏留言和建议。也可以对我们的网站前台能更好的进行人性化交流提一些宝贵的意见。</p>
					<p class="more">
						<a href="user-guestbook" class="bul">进入留言</a>
					</p>
				</div>
				<div class="col">
					<h3 class="ico ico2">联系我们</h3>
					<p>大家可以随时的联系我们，对我们的服务以及销售有什么意见和好的建议，可以随时的与我们交流，我们会谢谢大家的！</p>
					<p class="more">
						<a href="user-contact" class="bul">联系我们</a>
					</p>
				</div>
				<div class="col">
					<h3 class="ico ico3">关于系统</h3>
					<p>该系统才使用jsp动态网页技术实现，使用了ssh框架开发的一套基于web的手机销售管理系统。</p>
					<p class="more">
						<a href="user-about" class="bul">关于系统</a>
					</p>
				</div>
				<div class="col col-last">
					<h3 class="ico ico4">管理员入口</h3>
					<p>管理员后台入口</p>
					<p class="more">
						<a href="admin-alogin" class="bul">管理员入口</a>
					</p>
				</div>
				<div class="cl">&nbsp;</div>
			</div>
			<!-- End Text Cols -->

		</div>
		<!-- End Side Full -->
		<!-- Footer -->
		<div id="footer">
			<p class="left">
				<a href="http://localhost:8000/PhoneWeb">首页</a> <span>|</span> <a
					href="user-newslist">新闻中心</a> <span>|</span> <a href="#">我的购买</a> <span>|</span>
				<a href="user-phonelist">产品展示</a> <span>|</span> <a
					href="user-contact">联系我们</a>
			</p>
			<p class="right">
				&copy; 2015 基于web的手机销售管理系统@copyright. Design by 舒东林 <a href="#"
					target="_blank" title="The Sweetest CSS Templates WorldWide">PhoneWeb</a>
			</p>
		</div>
		<!-- End Footer -->


	</div>
	<!-- End Shell -->


</body>
</html>