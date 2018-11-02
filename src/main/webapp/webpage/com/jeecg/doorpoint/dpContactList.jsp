<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%--<t:base type="jquery,easyui,tools,DatePicker"></t:base>--%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dpContactList" checkbox="true" fitColumns="true" title="门点联系人" actionUrl="doorPointController.do?datagrid1&fid=${fid}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="联系人名"  field="fcontactName"  queryMode="single"></t:dgCol>
   <t:dgCol title="性别"  field="fgender" dictionary="sex"  queryMode="single"></t:dgCol>
   <t:dgCol title="电话"  field="fphone"  queryMode="single"></t:dgCol>
   <t:dgCol title="手机"  field="fmobile"  queryMode="single"></t:dgCol>
   <t:dgCol title="传真"  field="fax"  queryMode="single"></t:dgCol>
   <t:dgCol title="邮箱"  field="femail"  queryMode="single" ></t:dgCol>
   <t:dgToolBar title="录入" icon="icon-add" url="doorPointController.do?goAdd1&fid=${fid}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="doorPointController.do?goUpdate1" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="doorPointController.do?doBatchDel1" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="doorPointController.do?goUpdate1" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/doorpoint/doorPointList.js"></script>		
 <script type="text/javascript">
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'doorPointController.do?upload', "doorPointList");
}

//导出
function ExportXls() {
	JeecgExcelExport("doorPointController.do?exportXls","doorPointList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("doorPointController.do?exportXlsByT","doorPointList");
}
 </script>