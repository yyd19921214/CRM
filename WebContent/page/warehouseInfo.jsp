<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">

    var url;
    
	function searchWarehouse(){
		$("#dg").datagrid('load',{
			"warehouseName":$("#s_warehouseName").val(),
			"location":$("#s_location").val(),
            "manager":$("#s_manager").val()	
		});
	}
	
	function deleteWarehouse(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].id);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("${pageContext.request.contextPath}/warehouse/delete.do",{ids:ids},function(result){
					if(result.success){
						$.messager.alert("系统提示","数据已成功删除！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert("系统提示","数据删除失败！");
					}
				},"json");
			}
		});
		
	}
	
	function openWarehouseAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加仓库信息");
		url="${pageContext.request.contextPath}/warehouse/save.do";
	}
	
	function saveWarehouse(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
				var result=eval('('+result+')');
				if(result.success){
					$.messager.alert("系统提示","保存成功");
					resetValue();
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}else{
					$.messager.alert("系统提示","保存失败");
					return;
				}
			}
		});
	}
	
	
	function closeWarehouseDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function resetValue(){
		$("#warehouseName").val("");
		$("#location").val("");
		$("#manager").val("");
		$("#lastChangeTime").val("");
	}
	
	function openWarehouseModifyDialog(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","编辑仓库信息");
		$('#fm').form('load',row);
		url="${pageContext.request.contextPath}/warehouse/save.do?id="+row.id;
	}
	
	function openProductOfWarehouse(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要管理的数据！");
			return;
		}
		window.parent.openTab('仓库存储商品','ProductOfWarehouse.jsp?warehouse='+selectedRows[0].id+'&warehouseName='+encodeURI(selectedRows[0].warehouseName)+'&page=1&rows=10','icon-lxr');
		//window.parent.openTab('仓库存储商品','ProductOfWarehouse.jsp?warehouse='+selectedRows[0].id+'&warehouseName=hello'+'&page=1&rows=10','icon-lxr');
	}
	
	
</script>
</head>
<body style="margin:1px;">
	<table id="dg" title="仓库信息查询" class="easyui-datagrid"
	 fitColumns="true" pagination="true" rownumbers="true"
	 url="${pageContext.request.contextPath}/warehouse/list.do" fit="true" toolbar="#tb">
	 <thead>
	 	<tr>
	 		<th field="cb" checkbox="true" align="center"></th>
	 		<th field="id" width="50" align="center">编号</th>
	 		<th field="warehouseName" width="200" align="center">仓库名称 </th>
	 		<th field="location" width="100" align="center">地理位置</th>
	 		<th field="manager" width="50" align="center">主管员</th>
	 		<th field="lastChangeTime" width="80" align="center">上次变动时间</th>
	 	</tr>
	 </thead>
	</table>
	<div id="tb">
		<div>
			<a href="javascript:openWarehouseAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">创建</a>
			<a href="javascript:openWarehouseModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deleteWarehouse()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
			<a href="javascript:openProductOfWarehouse()" class="easyui-linkbutton" iconCls="icon-lxr" plain="true">库存商品查看</a> 
		</div>
		<div>
			&nbsp;仓库名称：&nbsp;<input type="text" id="s_warehouseName" size="20" onkeydown="if(event.keyCode==13) searchWarehouse()" />
			&nbsp;仓库位置：&nbsp;<input type="text" id="s_location" size="20" onkeydown="if(event.keyCode==13) searchWarehouse()" />
			&nbsp;仓库管理员：&nbsp;<input type="text" id="s_manager" size="20" onkeydown="if(event.keyCode==13) searchWarehouse()" />
		<a href="javascript:searchWarehouse()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width: 700px;height:450px;padding: 10px 20px"
	  closed="true" buttons="#dlg-buttons">
	 	<form id="fm" method="post">
	 		<table cellspacing="8px">
	 			<tr>
	 				<td>仓库名称：</td>
	 				<td><input type="text" id="warehouseName" name="warehouseName" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
	 				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	 				<td>地区：</td>
	 				<td><input type="text" id="location" name="location" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
	 			</tr>
	 			<tr>
	 				<td>仓库管理人：</td>
	 				<td><input type="text" id="manager" name="manager" class="easyui-validatebox" required="false"/>&nbsp;</td>
	 				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	 				<td>创建时间：</td>
	 				<td><input type="text" id="lastChangeTime" name="lastChangeTime" class="easyui-datebox" editable="false"/>&nbsp;</td>
	 			</tr>
	 			
	 		</table>
	 	</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveWarehouse()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeWarehouseDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
	

</body>
</html>