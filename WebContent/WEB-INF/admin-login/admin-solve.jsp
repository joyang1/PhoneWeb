<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- <%@ taglib prefix="s" uri="/struts-tags"%> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="EasyUI/themes/icon.css" rel="stylesheet" />
<link href="EasyUI/themes/default/easyui.css" rel="stylesheet" />
<link href="css/common.css" rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-theme.min.css" />
<script src="EasyUI/jquery.min.js"></script>
<script src="EasyUI/jquery.easyui.min.js"></script>
<script src="EasyUI/locale/easyui-lang-zh_CN.js"></script>
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
#addadmin {
	margin-top: 30px;
	width: 400px;
	margin: 0 auto;
}

#sm {
	margin-left: 160px;
}

#dep {
	margin-left: 160px;
	width: 318px;
	height: 30px;
	margin-top: -90px;
}

#labletype {
	margin-top: 15px;
}
</style>
</head>
<body>
	<table id="dg">
	</table>
	<div id="win">
			<div id="addadmin">
				<div class="input-group">
					<span class="input-group-addon">管理员名</span> <input type="text"
						id="adminname" class="form-control" placeholder="输入管理员名">
				</div>
				<div class="input-group">
					<span class="input-group-addon">姓&nbsp;&nbsp;名</span> <input
						type="text" id="name" class="form-control" placeholder="输入姓名">
				</div>

				<div>
					<label id="labletype">选择类别</label> <select class="combobox"
						id="type">
						<option>--请选择--</option>
						<option value="1">1</option>
						<option value="2">2</option>
					</select>
				</div>
				<br /> <input id="sm" class="btn btn-success btn-lg" type="button"
					        style="align: center" />
			</div>
	</div>

</body>
</html>
<script type="text/javascript">
	var type; //编辑还是添加
	$('#dg').datagrid({
		loadMsg : "数据加载中...",
		fit : true,
		singleSelect : true,
		fitColumns : true,
		url : 'admin-dosolve',
		onSelect : function() {
			$('#btn_edit').linkbutton('enable');
			$('#btn_remove').linkbutton('enable');
			$('#btn_reload').linkbutton('enable');
		},
		onUnselect : function() {
			$('#btn_edit').linkbutton('disable');
			$('#btn_remove').linkbutton('disable');
			$('#btn_reload').linkbutton('disable');
		},
		columns : [ [ {
			field : 'aname',
			title : '用户名',
			width : 30
		}, {
			field : 'name',
			title : '姓名',
			width : 30
		}, {
			field : 'atype',
			title : '类型',
			width : 40,
			align : 'right'
		} ] ],
		toolbar : [ {
			iconCls : 'icon-add',
			id : 'btn-add',
			text : '添加',
			handler : function() {
				type = 0;
				
				$("#win").window({
					title : "添加管理员",
					width : 600,
					height : 400,
					collapsible : false,
					minimizable : false,
					maximizable : false,
					draggable : false,
					modal : true
				});
				$('#adminname').attr({readonly:false});
				$('#adminname').val("");
				$('#name').val("");
				$('#type').val("--请选择--");
				$('#sm').val("添加");
			}
		}, '-', {
			iconCls : 'icon-edit',
			id : 'btn_edit',
			text : '编辑',
			disabled : true,
			handler : function() {
				type = 1;
				var row = $('#dg').datagrid('getSelected');
				$("#win").window({
					title : "编辑",
					width : 600,
					height : 400,
					collapsible : false,
					minimizable : false,
					maximizable : false,
					draggable : false,
					modal : true
				});
				$('#sm').val("确认编辑");
				$('#adminname').val(row.aname);
				$('#name').val(row.name);
				$('#type').val(row.atype);
				$('#adminname').attr({readonly:true});
			}
		}, '-', {
			iconCls : 'icon-remove',
			id : 'btn_remove',
			text : '删除',
			disabled : true,
			handler : function() {
				var row = $('#dg').datagrid('getSelected');
				$.messager.confirm('提示', '您确定要删除吗？', function(r){
					if (r){
						$.ajax({
							url : "admin-deladmin",
							type : "post",
							dataType : "json",
							async : false,
							//传送请求数据
							data : {
								"admin.adminname" : row.aname,
							},
							//根据返回值进行状态显示
							success : function(data) {
								if (data == "1") {
									$.messager.alert('我的消息', '删除成功!', '提示');
									$('#dg').datagrid('reload',null);
								} else {
									$.messager.alert('我的消息', '删除失败!', '提示');
									$('#dg').datagrid('reload',null);
									
								}
							}

						}); 
					}
				});
			}
		}, '-', {
			iconCls : 'icon-reload',
			id : 'btn_reload',
			text : '重置密码',
			disabled : true,
			handler : function() {
				var row = $('#dg').datagrid('getSelected');
				$.messager.confirm('提示', '您确定要重置吗？', function(r){
					if (r){
						$.ajax({
							url : "admin-reloadpasswd",
							type : "post",
							dataType : "json",
							async : false,
							//传送请求数据
							data : {
								"admin.adminname" : row.aname,
							},
							//根据返回值进行状态显示
							success : function(data) {
								if (data == "1") {
									$.messager.alert('我的消息', '重置成功!', '提示');
									$('#dg').datagrid('reload',null);
								} else {
									$.messager.alert('我的消息', '重置失败!', '提示');
									$('#dg').datagrid('reload',null);				
								}
							}

						}); 
					}
				});
			}
		} ]
		
	});

	$('#dg').datagrid('loading');
	
	$('#sm').click(function() {
	    if($('#adminname').val() == ""){
			$.messager.alert('我的消息', '管理员名不能为空!', '提示');
			return false;
		}else if($('#name').val() == ""){
			$.messager.alert('我的消息', '真实姓名不能为空!', '提示');
			return false;
		}else if($('#type').val()=="--请选择--"){
			$.messager.alert('我的消息', '请选择类别!', '提示');
			return false;
		}else{
			//开始发送数据
			$.ajax({
				//请求添加处理页
				url : "admin-addadmin",
				type : "post",
				dataType : "json",
				async : false,
				//传送请求数据
				data : {
					"admin.adminname" : $("#adminname").val(),
					"admin.name" : $("#name").val(),
					"admin.type" : $("#type").val(),
					"type":type
				},
				//根据返回值进行状态显示
				success : function(data) {
					//alert(data);
					if (data == "1") {
						$.messager.alert('我的消息', '添加成功!', '提示');
						$('#win').window('close');
						$('#dg').datagrid('reload',null);
					} else if(data == "3"){
						$.messager.alert('我的消息', '编辑成功!', '提示');
						$('#win').window('close');
						$('#dg').datagrid('reload',null);
					}else{
						$.messager.alert('我的消息', '添加失败!,用户名存在和其它原因！', '提示');
						$('#dg').datagrid('reload',null);
						
					}
				}
			});
		}	
	});
	
</script>