<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="baoxiaoList" checkbox="false" pagination="true" fitColumns="true" title="报销单管理" actionUrl="baoxiaoController.do?datagrid&fpcno=${fpcno}" idField="id" fit="true" queryMode="group">
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
   <t:dgCol title="报销单号"  field="fbxno"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="申请人"  field="fapplyer"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="申请日期"  field="fapplydate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核"  field="fcheck"  queryMode="single"  replace="未审_0,已审_1"  extendParams="styler:fmtype"  width="120"></t:dgCol>
   <t:dgCol title="审核人"  field="fchecker"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核日期"  field="fcheckdate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="金额"  field="famount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="核销金额"  field="fhxamount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="核销状态"  field="fhxstatus"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="报销人"  field="fbxman"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="币种"  field="fcurrency"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="fnote"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="派车单号"  field="fpcno"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="baoxiaoController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="baoxiaoController.do?goAdd&fpcno=${fpcno}" funname="add" width="700" height="250"></t:dgToolBar>
   <%--<t:dgToolBar title="编辑" icon="icon-edit" url="baoxiaoController.do?goUpdate" funname="update"></t:dgToolBar>--%>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="baoxiaoController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="baoxiaoController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/baoxiao/baoxiaoList.js"></script>