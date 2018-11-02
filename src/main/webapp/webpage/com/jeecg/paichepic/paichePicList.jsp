<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="paichePicList" checkbox="false" pagination="true" fitColumns="true" title="派车单图片" actionUrl="paichePicController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="图片"  field="fpic"  queryMode="single"  image="true" imageSize="50,50"  width="120"></t:dgCol>
   <t:dgCol title="微信名称"  field="fwxname"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="微信头像"  field="fwxpic"  queryMode="single"  image="true" imageSize="50,50"  width="120"></t:dgCol>
   <t:dgCol title="派车单id"  field="fid"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="司机"  field="fdriver"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="上传时间"  field="ftime"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="上传地点"  field="flocation"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="paichePicController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="paichePicController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="paichePicController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="paichePicController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="paichePicController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/paichepic/paichePicList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'paichePicController.do?upload', "paichePicList");
}

//导出
function ExportXls() {
	JeecgExcelExport("paichePicController.do?exportXls","paichePicList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("paichePicController.do?exportXlsByT","paichePicList");
}

 </script>