<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="zPractitionersList" checkbox="false" pagination="true" fitColumns="true" title="从业人员变动" actionUrl="zPractitionersController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="月份"  field="month"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="工种岗位"  field="job"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="月初数"  field="beginNumber"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="本月增加"  field="increase"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="本月减少"  field="decrease"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="月末数"  field="endNumber"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="note"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="zPractitionersController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="zPractitionersController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zPractitionersController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="zPractitionersController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zPractitionersController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/zpractitioners/zPractitionersList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zPractitionersController.do?upload', "zPractitionersList");
}

//导出
function ExportXls() {
	JeecgExcelExport("zPractitionersController.do?exportXls","zPractitionersList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("zPractitionersController.do?exportXlsByT","zPractitionersList");
}

 </script>