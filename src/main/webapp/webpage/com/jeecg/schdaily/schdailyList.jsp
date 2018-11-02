<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="schdailyList" checkbox="false" pagination="true" fitColumns="true" title="调度日记" actionUrl="schdailyController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="托运单位"  field="ftuoyun"  queryMode="single"></t:dgCol>
   <t:dgCol title="派车单号"  field="fpaicheno"  queryMode="single"></t:dgCol>
   <t:dgCol title="提箱点"  field="ftxyard"  queryMode="single"></t:dgCol>
   <t:dgCol title="装货时间"  field="fzhtime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="装货门点"  field="fzhaddress"  queryMode="single"></t:dgCol>
   <t:dgCol title="卸货时间"  field="fxhtime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="卸货门点"  field="fxhaddress"  queryMode="single"></t:dgCol>
   <t:dgCol title="换箱点"  field="fhxyard"  queryMode="single"></t:dgCol>
   <t:dgCol title="箱量"  field="fboxamount"  queryMode="single"></t:dgCol>
   <t:dgCol title="箱号"  field="fboxno"  queryMode="single"></t:dgCol>
   <t:dgCol title="车号"  field="fcarno"  queryMode="single"></t:dgCol>
   <t:dgCol title="挂车号"  field="fguano"  queryMode="single"></t:dgCol>
   <t:dgCol title="司机"  field="fdriver"  queryMode="single"></t:dgCol>
   <t:dgCol title="额外费用"  field="fbudget"  queryMode="single"></t:dgCol>
   <t:dgCol title="备注"  field="fnote"  queryMode="single"></t:dgCol>
   <t:dgCol title="日期"  field="fdate"  formatter="yyyy-MM-dd"  query="true"  queryMode="single"></t:dgCol>
   <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="schdailyController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="schdailyController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="schdailyController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="schdailyController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="schdailyController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/schdaily/schdailyList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'schdailyController.do?upload', "schdailyList");
}

//导出
function ExportXls() {
	JeecgExcelExport("schdailyController.do?exportXls","schdailyList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("schdailyController.do?exportXlsByT","schdailyList");
}

 </script>