<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="zZhengjianList" checkbox="false" pagination="true" fitColumns="true" title="从业证件" actionUrl="zZhengjianController.do?datagrid&pid=${pid }" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="从业证件名称"  field="fname"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="证件号码"  field="zhengjianNo"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发证机关"  field="issuingAuthority"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="颁发日期"  field="time"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="人员id"  field="pid"  queryMode="single"   hidden="true" width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="zZhengjianController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="zZhengjianController.do?goAdd&pid=${pid }" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zZhengjianController.do?goUpdate&pid=${pid }" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="zZhengjianController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zZhengjianController.do?goUpdate" funname="detail"></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/zzhengjian/zZhengjianList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zZhengjianController.do?upload', "zZhengjianList");
}

//导出
function ExportXls() {
	JeecgExcelExport("zZhengjianController.do?exportXls","zZhengjianList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("zZhengjianController.do?exportXlsByT","zZhengjianList");
}

 </script>