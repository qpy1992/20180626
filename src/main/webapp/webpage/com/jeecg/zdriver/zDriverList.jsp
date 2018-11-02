<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="zDriverList" checkbox="false" pagination="true" fitColumns="true" title="驾驶人" actionUrl="zDriverController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="驾驶人"  field="fname"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="驾驶证号"  field="licenseNumber"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="准驾车型"  field="carType"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否沪籍"  field="ishu"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="初领日期"  field="initialDate"  formatter="yyyy-MM-dd" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="有效日期"  field="effectiveDate"   formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="手机号"  field="phone"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="地址"  field="address"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="离职日期"  field="departureDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="信息维护员"  field="fpeople"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="zDriverController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="zDriverController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zDriverController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="zDriverController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zDriverController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/zdriver/zDriverList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zDriverController.do?upload', "zDriverList");
}

//导出
function ExportXls() {
	JeecgExcelExport("zDriverController.do?exportXls","zDriverList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("zDriverController.do?exportXlsByT","zDriverList");
}

 </script>