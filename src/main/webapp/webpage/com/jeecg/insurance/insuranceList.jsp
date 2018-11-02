<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="insuranceList" checkbox="false" pagination="true" fitColumns="true" title="车辆保险" actionUrl="insuranceController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"></t:dgCol>
   <t:dgCol title="车号"  field="fbillno"  queryMode="single"></t:dgCol>
   <t:dgCol title="座位"  field="fseat"  queryMode="single"></t:dgCol>
   <t:dgCol title="车船险"  field="fcarInsu"  queryMode="single"></t:dgCol>
   <t:dgCol title="交强险"  field="fstrongInsu"  queryMode="single"></t:dgCol>
   <t:dgCol title="交强险优惠"  field="fdiscount"  queryMode="single"></t:dgCol>
   <t:dgCol title="交强险保单号"  field="fstrongno"  queryMode="single"></t:dgCol>
   <t:dgCol title="开始日期"  field="fstartdate"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="结束日期"  field="fenddate"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="承运险"  field="ftransrisk"  queryMode="single"></t:dgCol>
   <t:dgCol title="承运险优惠"  field="ftransdiscount"  queryMode="single"></t:dgCol>
   <t:dgCol title="承运险保单号"  field="ftransno"  queryMode="single"></t:dgCol>
   <t:dgCol title="开始日期2"  field="fstart2"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="结束日期2"  field="fend2"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="三者险"  field="fsan"  queryMode="single"></t:dgCol>
   <t:dgCol title="车损险"  field="fchesun"  queryMode="single"></t:dgCol>
   <t:dgCol title="玻璃险"  field="fboli"  queryMode="single"></t:dgCol>
   <t:dgCol title="不计免赔"  field="fmianpei"  queryMode="single"></t:dgCol>
   <t:dgCol title="商业险优惠"  field="fbussdiscount"  queryMode="single"></t:dgCol>
   <t:dgCol title="商业险保单号"  field="fbussno"  queryMode="single"></t:dgCol>
   <t:dgCol title="开始日期3"  field="fstart3"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="结束日期3"  field="fend3"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="保费合计"  field="ftotal"  queryMode="single"></t:dgCol>
   <t:dgCol title="承保公司"  field="fchengbao"  queryMode="single"></t:dgCol>
   <t:dgCol title="备注"  field="fnote"  queryMode="single"></t:dgCol>
   <t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgDelOpt title="删除" url="insuranceController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="insuranceController.do?goAdd" funname="add" width="900" height="580"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="insuranceController.do?goUpdate" funname="update" width="900" height="580"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="insuranceController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="insuranceController.do?goUpdate" funname="detail" width="900" height="580"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/insurance/insuranceList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'insuranceController.do?upload', "insuranceList");
}

//导出
function ExportXls() {
	JeecgExcelExport("insuranceController.do?exportXls","insuranceList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("insuranceController.do?exportXlsByT","insuranceList");
}

 </script>