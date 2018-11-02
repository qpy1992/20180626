<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="yardList" checkbox="true" pagination="true" fitColumns="true" title="堆场码头" actionUrl="yardController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="客户名称"  field="fportCode"  queryMode="single"></t:dgCol>
   <t:dgCol title="类型"  field="ftype" dictionary="yard"  queryMode="single"></t:dgCol>
   <t:dgCol title="代码"  field="fyardCode"   query="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="名称"  field="fyardName"   query="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="联系人"  field="fcontact"   query="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="联系电话"  field="fphone"   query="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="地址"  field="faddress"   query="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="附加说明"  field="finstruction"  queryMode="single"></t:dgCol>
   <t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgDelOpt title="删除" url="yardController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="yardController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="yardController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="yardController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="yardController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/yard/yardList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'yardController.do?upload', "yardList");
}

//导出
function ExportXls() {
	JeecgExcelExport("yardController.do?exportXls","yardList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("yardController.do?exportXlsByT","yardList");
}

 </script>