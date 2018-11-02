<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="yunjiaList" checkbox="false" pagination="true" fitColumns="true" title="补充运价确认单" actionUrl="yunjiaController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="确认单号"  field="fbillno"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="状态"  field="fstatus"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人"  field="createName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="确认人"  field="fconfirmName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="确认时间"  field="fconfirmTime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="fnote"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="委托单位"  field="fentrustUnit"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="金额"  field="famount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="yunjiaController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="yunjiaController.do?goAdd" funname="add" height="250"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="yunjiaController.do?goUpdate" funname="update" height="250"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="yunjiaController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="yunjiaController.do?goUpdate" funname="detail" height="250"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/yunjia/yunjiaList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'yunjiaController.do?upload', "yunjiaList");
}

//导出
function ExportXls() {
	JeecgExcelExport("yunjiaController.do?exportXls","yunjiaList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("yunjiaController.do?exportXlsByT","yunjiaList");
}

 </script>