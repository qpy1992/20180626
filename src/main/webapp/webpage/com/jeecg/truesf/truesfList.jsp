<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="truesfList" checkbox="false" pagination="true" fitColumns="true" title="实际收付" actionUrl="truesfController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="流水号"  field="fbillno"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="结算单位代码"  field="fsettle"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="结算单位"  field="fsettlename"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="金额"  field="famount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收付"  field="fshoufu"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="剩余金额"  field="fremain"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="结算方式"  field="fsettletype"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="银行账号"  field="fbank"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="凭证号"  field="fvoucher"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="凭证号数字"  field="fvoucherno"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="fnote"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="录入人"  field="createName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="录入日期"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人"  field="updateName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="凭证月"  field="fvoumonth"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="凭证月编号"  field="fmonthno"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="truesfController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="truesfController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="truesfController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="truesfController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <%--<t:dgToolBar title="查看" icon="icon-search" url="truesfController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/truesf/truesfList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'truesfController.do?upload', "truesfList");
}

//导出
function ExportXls() {
	JeecgExcelExport("truesfController.do?exportXls","truesfList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("truesfController.do?exportXlsByT","truesfList");
}

 </script>