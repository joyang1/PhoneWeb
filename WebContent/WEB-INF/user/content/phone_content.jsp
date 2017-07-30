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
<link href="<%=basepath%>css/images/logo.gif" rel="icon">
<link href="<%=basepath%>css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="<%=basepath%>css/phonecontent.css" rel="stylesheet"
	type="text/css">
<link href="<%=basepath%>EasyUI/themes/icon.css" rel="stylesheet" />
<link href="<%=basepath%>EasyUI/themes/default/easyui.css"
	rel="stylesheet" />

<script src="<%=basepath%>EasyUI/jquery.min.js"></script>
<script src="<%=basepath%>EasyUI/jquery.easyui.min.js"></script>
<script src="<%=basepath%>EasyUI/locale/easyui-lang-zh_CN.js"></script>

<title>购买界面</title>
<style type="text/css">
body {
	background-color: #eee !important;
}
</style>
</head>
<body>
	<div class="jumbotron">
		<h1>欢迎购买</h1>
		<p>${getsuccess }</p>
		<div id="product-intro">
			<div id="product-left">
				<img title="" src="<%=basepath%>phoneimg/${product.phonebigimg}"
					width="380px" height="600px">
			</div>
			<div id="product-right">
				<div>
					<p id="name" name="product.phonename">${product.phonename }</p>
					<p id="price" name="product.price">${product.price }￥</p>
				</div>
				<div>
					<p id="content">${product.introduce }</p>
				</div>
				<div>
					<input type="button" id="getphone" class="btn btn-info"
						value="购买该手机">
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<script>
	$("#getphone").click(function() {
		$.ajax({
			url : "user-getphone",
			type : "post",
			dataType : "json",
			//传送请求数据
			data : {
				"product.id" : "${product.id}",
			},
			//根据返回值进行状态显示
			success : function(data) {
				if (data == "1") {
					$.messager.alert('我的消息', '购买成功!', '提示');
					//alert('购买成功!');
				} else if (data == "3") {
					window.location.href="user-login?ly=getphone";
				} else {
					$.messager.alert('我的消息', '购买失败!', '提示');
					//alert('购买失败!');
				}
			}

		});
	});

	
</script>