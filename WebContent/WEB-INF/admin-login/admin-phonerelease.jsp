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
		var editor1 = K.create('textarea[name="product.introduce"]', {
			cssPath : 'kindeditor/plugins/code/prettify.css',
			uploadJson : 'kindeditor/jsp/upload_json.jsp',
			fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function() {
				var self = this;
				K.ctrl(document, 13, function() {
					self.sync();
					document.forms['releasephone'].submit();
				});
				K.ctrl(self.edit.doc, 13, function() {
					self.sync();
					document.forms['releasephone'].submit();
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

#divimg {
	margin-top: 15px;
	height: 30px;
}

#divtype {
	height: 30px;
}

#combobox {
	margin-top: -110px;
	margin-left: 30px;
}

#picture {
	margin-top: -130px;
	margin-left: 30px;
}

.input-group {
	width: 900px;
}
</style>
<title>手机详细信息上传</title>
</head>
<body>
	<s:if test="#request.addphonesuccess!=null">
		<font
			style="color: red; font-size: 14px; font-weight: bold; margin-left: 400px;"><s:property
				value="#request.addphonesuccess"></s:property></font>
	</s:if>
	<s:form name="releasephone" action="admin-addphone" enctype="multipart/form-data" method="post">
		<br />
		<div class="input-group">
			<span class="input-group-addon">手机名</span> <input type="text"
				name="product.phonename" class="form-control" placeholder="手机名">
		</div>
		<div class="input-group">
			<span class="input-group-addon">手机型号</span> <input type="text"
				name="product.phone" class="form-control" placeholder="手机型号">
		</div>
		<div class="input-group">
			<span class="input-group-addon">手机价格</span> <input type="text"
				name="product.price" class="form-control" placeholder="手机价格">
		</div>
		<div>
			<font class="font">>>手机介绍</font>
			<textarea name="product.introduce" cols="100" rows="8"
				style="width: 900px; height: 300px; visibility: hidden;"></textarea>
		</div>
		<div id="divimg">
			<font class="font">添加图片:</font>
			<s:file name="picture" id="picture" label="图片"></s:file>
			<font
				style="color: red; font-size: 14px; font-weight: bold; margin-left: 400px;">${imgerror}</font>
		</div>
		<div id="divtype">
			<font class="font">选择手机类别:</font>
			<s:select id="combobox" list="#request.productsorts" listKey="id"
				listValue="fatherId" name="productsort.id" label="手机类别">
			</s:select>
		</div>
		<br />
		<div>
			<input id="submit" class="btn btn-success btn-lg" type="submit"
				value="添加">(提交快捷键: Ctrl + Enter)
		</div>
	</s:form>
</body>
</html>