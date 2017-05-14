<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.edatagrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript">

	var url;
	
	//指该函数在文档载入完成后就执行
	 $(function(){
		//$.post("${pageContext.request.contextPath}/product/search.do",{warehouse:'${param.warehouse}',page:'${param.page}',rows:'${param.rows}'},function(result){
			 $("#ckno").val(${param.warehouse});
			 var temp=decodeURIComponent('${param.warehouseName}');
			 $("#name").val(temp);
			//	$("#ckno").val(result.rows[0].warehouse.id);
			//	$("#name").val(result.rows[0].warehouse.warehouseName);
			//},"json");
		 
		 $('#dg').edatagrid({
            url: '${pageContext.request.contextPath}/product/search.do?warehouse=${param.warehouse}&page=${param.page}&rows=${param.rows}',
            //saveUrl: '${pageContext.request.contextPath}/linkMan/save.do?customer.id=${param.cusId}',
            //updateUrl: '${pageContext.request.contextPath}/linkMan/save.do',
            //destroyUrl: '${pageContext.request.contextPath}/linkMan/delete.do'
        });
     });
	
	
	
</script>
</head>
<body style="margin:15px;">
<div id="p" class="easyui-panel" title="客户基本信息" style="width:700px;height:100px;padding:10px;">
		<table cellspacing="8px">
			<tr>
				<td>仓库编号：</td>
				<td><input type="text" id="ckno" name="ckno" readonly="readonly"/></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>仓库名称：</td>
				<td><input type="text" id="name" name="name" readonly="readonly"/></td>
			</tr>
		</table>
</div>
<br/>	
<table id="dg" title="在库商品" style="width:700px;height:250px"
        toolbar="#toolbar" idField="id"
        rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
        <tr>
            <th field="id" width="50" >编号</th>
            <th field="productName" width="100" editor="{type:'validatebox',options:{required:true}}">商品名称</th>
            <th field="model" width="100" editor="{type:'validatebox',options:{required:true}}">商品型号</th>
            <th field="store" width="100" editor="{type:'validatebox',options:{validType:'date'}}">数量</th>
            <th field="unit" width="50" editor="{type:'validatebox',options:{validType:'date'}}">规格</th>
            <th field="remark" width="100" editor="{type:'validatebox',options:{required:true}}">质量</th>
        </tr>
    </thead>
</table>
	    
<!--  <div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#dg').edatagrid('addRow')">添加</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:$('#dg').edatagrid('destroyRow')">删除</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:$('#dg').edatagrid('saveRow');$('#dg').edatagrid('reload')">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#dg').edatagrid('cancelRow')">撤销行</a>
</div>
-->
	
</body>
</html>
