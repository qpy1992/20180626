<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="containerSizeList" checkbox="false" pagination="true" fitColumns="true" title="集装箱尺寸对照表" actionUrl="containerSizeController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="箱型"  field="ftype"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="长度"  field="flength"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="宽度"  field="fwidth"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="高度"  field="fheight"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="体积"  field="fvolum"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="containerSizeController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="containerSizeController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="containerSizeController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="containerSizeController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="containerSizeController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/containersize/containerSizeList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'containerSizeController.do?upload', "containerSizeList");
}

//导出
function ExportXls() {
	JeecgExcelExport("containerSizeController.do?exportXls","containerSizeList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("containerSizeController.do?exportXlsByT","containerSizeList");
}

 </script>