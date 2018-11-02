<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="zDriverillegalList" checkbox="true" pagination="true" fitColumns="true" title="驾驶人违法" actionUrl="zDriverillegalController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="驾驶人id"  field="driverId"  hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="驾驶人"  field="driverName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="驾驶证号"  field="cardNo"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="违法时间"  field="time"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="违法地点"  field="address"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="具体违法内容"  field="fcontent"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="处理情况"  field="dealsituation"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="zDriverillegalController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="zDriverillegalController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zDriverillegalController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="zDriverillegalController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zDriverillegalController.do?goUpdate" funname="detail"></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/zdriverillegal/zDriverillegalList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zDriverillegalController.do?upload', "zDriverillegalList");
}

//导出
function ExportXls() {
	JeecgExcelExport("zDriverillegalController.do?exportXls","zDriverillegalList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("zDriverillegalController.do?exportXlsByT","zDriverillegalList");
}

 </script>