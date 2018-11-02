<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="zBreaklawList" checkbox="true" pagination="true" fitColumns="true" title="交通违法排查督办" actionUrl="zBreaklawController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="日期"  field="time"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="驾驶人总数"  field="driverNumber"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="违反次数"  field="number"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="违法率"  field="rate"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="违法分类"  field="ftype"   queryMode="single"  dictionary="law"  width="120"></t:dgCol>
   <t:dgCol title="累计违法次数"  field="allratenumber"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="当月已处理次数"  field="dealnumber"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="累计已处理次数"  field="alldealnumber"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="note"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="zBreaklawController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="zBreaklawController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zBreaklawController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="zBreaklawController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zBreaklawController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/zbreaklaw/zBreaklawList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zBreaklawController.do?upload', "zBreaklawList");
}

//导出
function ExportXls() {
	JeecgExcelExport("zBreaklawController.do?exportXls","zBreaklawList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("zBreaklawController.do?exportXlsByT","zBreaklawList");
}

 </script>