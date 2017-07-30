<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="kindeditor/plugins/code/prettify.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/common.css" />
<script charset="utf-8" src="kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="js/jquery-1.10.2.min.js"></script>
<script charset="utf-8" src="js/bootstrap.min.js"></script>
<script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="kindeditor/plugins/code/prettify.js"></script>
<script>
	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[name="news.content"]', {
			cssPath : 'kindeditor/plugins/code/prettify.css',
			uploadJson : 'kindeditor/jsp/upload_json.jsp',
			fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function() {
				var self = this;
				K.ctrl(document, 13, function() {
					self.sync();
					document.forms['releasenews'].submit();
				});
				K.ctrl(self.edit.doc, 13, function() {
					self.sync();
					document.forms['releasenews'].submit();
				});
			}
		});
		prettyPrint();
	});
</script>

<style type="text/css">
body {
	margin: 0 auto;
	height: 100%
}

#submit {
	text-align: center;
	margin-left: 410px;
}

.input-group {
	width: 900px;
}
</style>

<title>添加新闻</title>
</head>
<body>
	<s:if test="#request.addsuccess!=null">
		<font
			style="color: red; font-size: 14px; font-weight: bold; margin-left: 400px;"><s:property
				value="#request.addsuccess"></s:property></font>
	</s:if>
	<s:form name="releasenews" action="admin-addnews" method="post">
		<br />
		<div class="input-group">
			<span class="input-group-addon">新闻标题</span> <input type="text"
				name="news.title" class="form-control" placeholder="news-title">
		</div>
		<font class="font">新闻内容</font>
		<textarea name="news.content" cols="100" rows="8"
			style="width: 900px; height: 300px; visibility: hidden;"></textarea>
		<br />
		<input id="submit" class="btn btn-success btn-lg" type="submit"
			value="添加">(提交快捷键: Ctrl + Enter)
	</s:form>
</body>
</html>


