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
    
    $(function(){
    	var data,json;
		data = [];
		data.push({"text":"请选择产品","id":"0"});
		
		warehouse=[];
		warehouse.push({"text":"请选择仓库","id":"0"});
		
		$.post("${pageContext.request.contextPath}/product/list.do?page=1&rows=10",function(result){
			if(result.success){
				for(var i=0;i<result.rows.length;i++){
					var text=result.rows[i].productName;
					var id=result.rows[i].id;
					data.push({"text":text,"id":id});
					$("#productName").combobox("loadData", data);
				}
			}else{
				$.messager.alert("系统提示","数据获取失败！");
			}
		},"json");
		
		$.post("${pageContext.request.contextPath}/warehouse/list.do?page=1&rows=10",function(result){
			if(result.success){
				//alert(result.rows.length);
				for(var i=0;i<result.rows.length;i++){
					var text=result.rows[i].warehouseName;
					var id=result.rows[i].id;
					warehouse.push({"text":text,"id":id});
					$("#warehouseName").combobox("loadData", warehouse);
				}
			}else{
				$.messager.alert("系统提示","数据获取失败！");
			}
		},"json");
    	
    });
    
	function searchRecipt(){
		$("#dg").datagrid('load',{
			"warehouseName":$("#s_warehouseName").val(),
			"productName":$("#s_productName").val(),
		});
	}
	
	function openReciptAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加单据信息");
		url="${pageContext.request.contextPath}/recipt/save.do";
		
		
		
	}
	
	function saveRecipt(){
		var productId=$(".combo-value[name=productName]").attr("value");
		var warehouseId=$(".combo-value[name=warehouseName]").attr("value");
		if(url.indexOf("?")!=-1){//这里的url是对某条记录修改用的，因此本身已包含该记录的Id
			url=url+"&product.id="+productId+"&warehouse.id="+warehouseId;
		}else{
			//这里的url是新增加某条记录用的，因此本身不包含该记录的Id
			url=url+"?product.id="+productId+"&warehouse.id="+warehouseId;
		}
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
	
	function closeReciptDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function openReciptModifyDialog(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","编辑仓库信息");
		$('#fm').form('load',row);
		url="${pageContext.request.contextPath}/recipt/save.do?id="+row.id;
	}
	
	function deleteRecipt(){
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
				$.post("${pageContext.request.contextPath}/recipt/delete.do",{ids:ids},function(result){
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
	
	function resetValue(){
		$("#changeType").val("");
		$("#person").val("");
		$("#changeTime").val("");
		$("#count").val("");
	}
	
	function formatChangeType(val,row){
		if(val==1){
			return "入库";
		}else if(val==2){
			return "出库";
		}else if(val==3){
			return "开发成功";
		}else if(val==4){
			return "开发失败";
		}
	} 
	
	
</script>
</head>
<body style="margin:1px;">
	<table id="dg" title="单据信息查询" class="easyui-datagrid"
	 fitColumns="true" pagination="true" rownumbers="true"
	 url="${pageContext.request.contextPath}/recipt/list.do" fit="true" toolbar="#tb">
	 <thead>
	 	<tr>
	 		<th field="cb" checkbox="true" align="center"></th>
	 		<th field="id" width="50" align="center">编号</th>
	 		<th field="product.productName" width="80" align="center">产品名称</th>
	 		<th field="changeType" width="50" align="center" formatter="formatChangeType">单据类型 </th>
	 		<th field="person" width="50" align="center">经手人</th>
	 		<th field="count" width="50" align="center">数量</th>
	 		<th field="changeTime" width="80" align="center">发生时间</th>
	 		<th field="warehouse.warehouseName" width="80" align="center">关联仓库</th>
	 		
	 	</tr>
	 </thead>
	</table>
	<div id="tb">
		<div>
			<a href="javascript:openReciptAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">创建</a>
			<a href="javascript:openReciptModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deleteRecipt()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		<!--<a href="javascript:openProductOfWarehouse()" class="easyui-linkbutton" iconCls="icon-lxr" plain="true">库存商品查看</a>--> 
		</div>
		<div>
			&nbsp;仓库名称：&nbsp;<input type="text" id="s_warehouseName" size="20" onkeydown="if(event.keyCode==13) searchRecipt()" />
			&nbsp;产品名称：&nbsp;<input type="text" id="s_productName" size="20" onkeydown="if(event.keyCode==13) searchRecipt()" />
		   <a href="javascript:searchRecipt()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width: 700px;height:450px;padding: 10px 20px"
	  closed="true" buttons="#dlg-buttons">
	 	<form id="fm" method="post">
	 		<table cellspacing="8px">
	 			<tr>
	 				<td>单据类型：</td>
	 				<td><input type="text" id="changeType" name="changeType" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
	 				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	 				<td>经手人：</td>
	 				<td><input type="text" id="person" name="person" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
	 			</tr>
	 			<tr>
	 				<td>发生时间：</td>
	 				<td><input type="text" id="changeTime" name="changeTime" class="easyui-validatebox easyui-datebox" required="false" editable="false"/>&nbsp;</td>
	 				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	 				<td>数量：</td>
	 				<td><input type="text" id="count" name="count" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
	 			</tr>
				<tr>
				    <td>商品名称：</td>
					<td><select class="easyui-combobox" id="productName" name="productName" 
						style="width: 154px;" data-options="valueField:'id', textField:'text'" panelHeight="auto">
					</select>&nbsp;<font color="red">*</font></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>仓库名称：</td>
					<td><select class="easyui-combobox" id="warehouseName" name="warehouseName"
						style="width: 154px;" data-options="valueField:'id', textField:'text'" panelHeight="auto">
					</select>&nbsp;<font color="red">*</font></td>
				</tr>
			</table>
	 	</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveRecipt()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeReciptDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
	

</body>
</html>
