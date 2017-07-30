<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/common.css" />
<script charset="utf-8" src="js/jquery-1.10.2.min.js"></script>
<script charset="utf-8" src="js/bootstrap.min.js"></script>

<title>手机类别上传</title>
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
</head>
<body>
<s:if test="#request.addphonetypesuccess!=null">
		<font
			style="color: red; font-size: 14px; font-weight: bold; margin-left: 400px;"><s:property
				value="#request.addphonetypesuccess"></s:property></font>
	</s:if>
	<s:form name="releasephonetype" action="admin-addphonetype" method="post">
		<br />
		<div class="input-group">
			<span class="input-group-addon">手机种类</span> <input type="text"
				name="productsort.fatherId" class="form-control" placeholder="手机种类">
		</div>
		<input id="submit" class="btn btn-success btn-lg" type="submit"
			value="添加">(提交快捷键: Ctrl + Enter)
	</s:form>
</body>
</html>