<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="trafficAccidentList" checkbox="false" pagination="true" fitColumns="true" title="交通事故处理" actionUrl="trafficAccidentController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="制单人"  field="createName"  queryMode="single"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="制单日期"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"></t:dgCol>
   <t:dgCol title="流水编码"  field="fbillno"  queryMode="single"></t:dgCol>
   <t:dgCol title="审核人"  field="fchecker"  queryMode="single"></t:dgCol>
   <t:dgCol title="审核时间"  field="fcheckTime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="路段等级"  field="fgrade" dictionary="grades"  queryMode="single"></t:dgCol>
   <t:dgCol title="车号"  field="fcarno"  queryMode="single"></t:dgCol>
   <t:dgCol title="出险类别"  field="fcxtype" dictionary="chuxian"  queryMode="single"></t:dgCol>
   <t:dgCol title="驾驶员"  field="fname"  queryMode="single"></t:dgCol>
   <t:dgCol title="责任划分"  field="frespon" dictionary="zeren" queryMode="single"></t:dgCol>
   <t:dgCol title="出险时间"  field="fchuxianTime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="事故级别"  field="fsggrade" dictionary="shigu"  queryMode="single"></t:dgCol>
   <t:dgCol title="出险地点"  field="faddress"  queryMode="single"></t:dgCol>
   <t:dgCol title="备注"  field="fnote"  queryMode="single"></t:dgCol>
   <t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgDelOpt title="删除" url="trafficAccidentController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="trafficAccidentController.do?goAdd" funname="add" width="730" height="300"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="trafficAccidentController.do?goUpdate" funname="update" width="730" height="300"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="trafficAccidentController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="trafficAccidentController.do?goUpdate" funname="detail" width="730" height="300"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/trafficaccident/trafficAccidentList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'trafficAccidentController.do?upload', "trafficAccidentList");
}

//导出
function ExportXls() {
	JeecgExcelExport("trafficAccidentController.do?exportXls","trafficAccidentList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("trafficAccidentController.do?exportXlsByT","trafficAccidentList");
}

 </script>