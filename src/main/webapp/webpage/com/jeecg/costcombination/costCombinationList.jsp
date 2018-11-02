<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%--<t:base type="jquery,easyui,tools,DatePicker"></t:base>--%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="costCombinationList" checkbox="true" fitColumns="true" title="费用组合" actionUrl="costCombinationController.do?datagrid&fid=${fid}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="提箱点"  field="ftxyard"  queryMode="single"></t:dgCol>
   <t:dgCol title="装货门点"  field="fload"  queryMode="single"></t:dgCol>
   <t:dgCol title="卸货门点"  field="fdischarge"  queryMode="single"></t:dgCol>
   <t:dgCol title="还箱点"  field="fhxyard"  queryMode="single"></t:dgCol>
   <t:dgCol title="费用"  field="fcost"  queryMode="single"></t:dgCol>
   <t:dgCol title="预派车天数"  field="fday"  queryMode="single"></t:dgCol>
   <t:dgCol title="开始时间"  field="fstart" formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="备注"  field="fnote"  queryMode="single"></t:dgCol>
   <t:dgCol title="主表id"  field="fid"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="提箱点id"  field="ftxid"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="装货点id"  field="fzhid"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="卸货点id"  field="fxhid"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="还箱点id"  field="fhxid"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgDelOpt title="删除" url="costCombinationController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="costCombinationController.do?goAdd&fid=${fid}" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="costCombinationController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="costCombinationController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="costCombinationController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/costcombination/costCombinationList.js"></script>		
 <script type="text/javascript">
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'costCombinationController.do?upload', "costCombinationList");
}

//导出
function ExportXls() {
	JeecgExcelExport("costCombinationController.do?exportXls","costCombinationList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("costCombinationController.do?exportXlsByT","costCombinationList");
}
 </script>