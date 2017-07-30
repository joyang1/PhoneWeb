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
<link href="css/images/logo.gif" rel="icon">
<link rel="stylesheet" href="<%=basepath%>kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="<%=basepath%>kindeditor/plugins/code/prettify.css" />
<link rel="stylesheet" href="<%=basepath%>css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=basepath%>css/common.css" />
<script charset="utf-8" src="<%=basepath%>kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=basepath%>js/jquery-1.10.2.min.js"></script>
<script charset="utf-8" src="<%=basepath%>js/bootstrap.min.js"></script>
<script charset="utf-8" src="<%=basepath%>kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=basepath%>kindeditor/plugins/code/prettify.js"></script>
<script>
	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[name="guestbook.content"]', {
			cssPath : 'kindeditor/plugins/code/prettify.css',
			uploadJson : 'kindeditor/jsp/upload_json.jsp',
			fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function() {
				var self = this;
				K.ctrl(document, 13, function() {
					self.sync();
					document.forms['releaseguestbook'].submit();
				});
				K.ctrl(self.edit.doc, 13, function() {
					self.sync();
					document.forms['releaseguestbook'].submit();
				});
			}
		});
		prettyPrint();
	});
</script>
<title>留言模块</title>
<style type="text/css">
body {
	background-color: #eee !important;
	margin: 0 auto;
	height: 100%
}
</style>
</head>
<body>
	<div class="jumbotron">
		<h1>欢迎留言</h1>
		
		<s:form name="releaseguestbook" action="user-addguestbook" method="post">
			<br />
			<div class="input-group">
				<span class="input-group-addon">留言标题</span> <input type="text"
					name="guestbook.title" class="form-control" placeholder="标题">
			</div>
			<font class="font">>>留言内容</font>
			<textarea name="guestbook.content" cols="100" rows="8"
				style="width: 1286px; height: 300px; visibility: hidden;"></textarea>
			<br />
			<input id="submit" class="btn btn-success btn-lg" type="submit"
				value="提交">(提交快捷键: Ctrl + Enter)
	</s:form>
		<br />
		<br />
		<p>
			<a class="btn btn-primary btn-lg"
				href="http://localhost:8000/PhoneWeb" role="button">返回首页</a>
		</p>
	</div>
</body>
</html>