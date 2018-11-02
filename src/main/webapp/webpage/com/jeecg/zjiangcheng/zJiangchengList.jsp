<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%-- <t:base type="jquery,easyui,tools,DatePicker"></t:base> --%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="zJiangchengList" checkbox="true" pagination="true" fitColumns="true" title="奖惩" actionUrl="zJiangchengController.do?datagrid&pid=${pid }" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  ></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single" ></t:dgCol>
   <t:dgCol title="日期"  field="time"  queryMode="single"  ></t:dgCol>
   <t:dgCol title="奖惩原因"  field="reason"  queryMode="single"  ></t:dgCol>
   <t:dgCol title="奖惩记录"  field="record"  queryMode="single" ></t:dgCol>
   <t:dgCol title="奖惩部门"  field="department"  queryMode="single"  ></t:dgCol>
   <t:dgCol title="操作" field="opt" ></t:dgCol>
   <t:dgDelOpt title="删除" url="zJiangchengController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="zJiangchengController.do?goAdd&pid=${pid }" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zJiangchengController.do?goUpdate&pid=${pid }" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="zJiangchengController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zJiangchengController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%-- <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/zjiangcheng/zJiangchengList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zJiangchengController.do?upload', "zJiangchengList");
}

//导出
function ExportXls() {
	JeecgExcelExport("zJiangchengController.do?exportXls","zJiangchengList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("zJiangchengController.do?exportXlsByT","zJiangchengList");
}

 </script>