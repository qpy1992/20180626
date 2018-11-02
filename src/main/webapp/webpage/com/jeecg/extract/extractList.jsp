<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="extractList" checkbox="false" pagination="true" fitColumns="true" title="司机提成设置列表" actionUrl="extractController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="驳空箱"  field="fbkx"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单箱提成"  field="fdxtc"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="两小箱提成"  field="flxxtc"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="两大箱提成"  field="fldxtc"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="司机补贴"  field="fsjbt"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="每公里单箱提成"  field="fmgldxtc"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="两小箱每公里"  field="flxxmgl"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="两大箱每公里"  field="fldxmgl"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="两大箱比率"  field="fldxbl"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="第二箱司机提成"  field="fdesjtc"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="生效日期"  field="fstartdate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="截止日期"  field="fenddate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="extractController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="extractController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="extractController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="extractController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="extractController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/extract/extractList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'extractController.do?upload', "extractList");
}

//导出
function ExportXls() {
	JeecgExcelExport("extractController.do?exportXls","extractList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("extractController.do?exportXlsByT","extractList");
}

 </script>