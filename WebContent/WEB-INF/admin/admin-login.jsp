<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="EasyUI/themes/icon.css" rel="stylesheet" />
<link href="EasyUI/themes/default/easyui.css" rel="stylesheet" />
<link href="css/common.css" rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script src="EasyUI/jquery.min.js"></script>
<script src="EasyUI/jquery.easyui.min.js"></script>
<script src="EasyUI/locale/easyui-lang-zh_CN.js"></script>
<style type="text/css">
#fr {
	text-align: center;
	margin-top: 50px;
	marin-left: 100px;
}

#loginform {
	width: 400px;
	margin: auto;
}

.input-group {
	width: 400px;
}
</style>
<title>管理员登陆界面</title>
</head>
<body>
	<div id="win">
		<s:form id="fr" action="admin-dologin" method="post">
			<div id="loginform">
				<div class="input-group">
					<span class="input-group-addon">用户名</span> <input type="text"
						id="adminname" name="admin.adminname" class="form-control" placeholder="输入用户名">
				</div>
				<br />
				<div class="input-group">
					<span class="input-group-addon">密&nbsp;码</span> <input
						id="passwd" type="password" name="admin.passwd"
						class="form-control" placeholder="输入密码">
				</div>
				<font class="errorfont"><s:fielderror>
						<s:param>admin.passwd</s:param>
					</s:fielderror></font> <br /> <img id="img" border=0 src="code.jsp"
					onclick="getCode(this)">看不清?点击验证码刷新 <br />
				<div class="input-group">
					<span class="input-group-addon">验证码</span> <input type="text"
						id="code" name="code" class="form-control" placeholder="输入验证码">
				</div>
				<font class="errorfont"><s:fielderror>
						<s:param>code</s:param>
					</s:fielderror></font> <br /> <input id="sm" class="btn btn-success btn-lg"
					type="submit" value="登陆" style="align: center" />
			</div>
		</s:form>
	</div>

</body>
</html>

<script type="text/javascript">
	$('#win').window({
		title : "管理员登陆",
		width : 600,
		height : 400,
		collapsible : false,
		minimizable : false,
		maximizable : false,
		closable : false,
		draggable : false,
		modal : true
	});
	$(function() {
		$('#sm').click(function() {
			var adminid = $('#adminname').val();
			var passwd = $('#passwd').val();
			var code = $('#code').val();
			//var r_code =
<%--=session.getAttribute("rand")--%>
	if (adminid == "") {
				$('#w1').empty();
				$('#adminname').after("<p id='w1' style='color:red'>用户名不能为空!</p>");
				return false;
			} else if (passwd == "") {
				$('#w1').empty();
				$('#w2').empty();
				$('#passwd').after("<p id='w2' style='color:red'>密码不能为空!</p>");
				return false;
			} else if (code == "") {
				$('#w1').empty();
				$('#w2').empty();
				$('#w3').empty();
				$('#code').after("<p id='w3' style='color:red'>验证码不能为空!</p>");
				return false;
			}
			//else if(code != r_code){
			//alert(code+":"+r_code);
			//alert("验证码错误!");
			//$('#code').append("<b style='color:red'>验证码错误!</b>");
			//return false;
			//}
			else {
				$('#sm').val("登陆中...");
				return true;
			}
		});
	});

	function getCode(t) {
		t.src = "code.jsp?a=" + Math.random() + 10;
	}

	
</script>