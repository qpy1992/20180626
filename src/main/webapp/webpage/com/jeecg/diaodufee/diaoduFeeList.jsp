<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="diaoduFeeList" checkbox="false" pagination="true" fitColumns="true" title="调度费用录入" actionUrl="diaoduFeeController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"></t:dgCol>
   <t:dgCol title="类型"  field="fkind"  queryMode="single"></t:dgCol>
   <t:dgCol title="费用种类"  field="ftype"  queryMode="single"></t:dgCol>
   <t:dgCol title="费用种类名称"  field="fname"  queryMode="single"></t:dgCol>
   <t:dgCol title="结算单位"  field="fsettle"  queryMode="single"></t:dgCol>
   <t:dgCol title="结算单位名称"  field="fsettleName"  queryMode="single"></t:dgCol>
   <t:dgCol title="单位"  field="funit"  queryMode="single"></t:dgCol>
   <t:dgCol title="单价"  field="funitprice"  queryMode="single"></t:dgCol>
   <t:dgCol title="数量"  field="fnumber"  queryMode="single"></t:dgCol>
   <t:dgCol title="收付金额"  field="famount"  queryMode="single"></t:dgCol>
   <t:dgCol title="金额"  field="famount1"  queryMode="single"></t:dgCol>
   <t:dgCol title="额定金额"  field="fratedamount"  queryMode="single"></t:dgCol>
   <t:dgCol title="实际金额"  field="frealamount"  queryMode="single"></t:dgCol>
   <t:dgCol title="代垫"  field="fcushion"  queryMode="single"></t:dgCol>
   <t:dgCol title="审核"  field="fcheck"  queryMode="single"></t:dgCol>
   <t:dgCol title="费用属性"  field="fattribute"  queryMode="single"></t:dgCol>
   <t:dgCol title="客户号"  field="fcustomno"  queryMode="single"></t:dgCol>
   <t:dgCol title="录入人"  field="createName"  queryMode="single"></t:dgCol>
   <t:dgCol title="录入日期"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="附加说明"  field="fnote"  queryMode="single"></t:dgCol>
   <t:dgCol title="箱号"  field="fboxno"  queryMode="single"></t:dgCol>
   <t:dgCol title="箱编号"  field="fboxnum"  queryMode="single"></t:dgCol>
   <t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgDelOpt title="删除" url="diaoduFeeController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="diaoduFeeController.do?goAdd" funname="add" width="730" height="450"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="diaoduFeeController.do?goUpdate" funname="update" width="730" height="450"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="diaoduFeeController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="diaoduFeeController.do?goUpdate" funname="detail" width="730" height="450"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/diaodufee/diaoduFeeList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'diaoduFeeController.do?upload', "diaoduFeeList");
}

//导出
function ExportXls() {
	JeecgExcelExport("diaoduFeeController.do?exportXls","diaoduFeeList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("diaoduFeeController.do?exportXlsByT","diaoduFeeList");
}

 </script>