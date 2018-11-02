<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="customSalesmanList" checkbox="true" fitColumns="true" title="业务员" actionUrl="customEntrustController.do?datagrid3&did=${cid}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"></t:dgCol>
   <t:dgCol title="业务员名称"  field="fname"></t:dgCol>
   <t:dgCol title="职务"  field="fpost"></t:dgCol>
   <t:dgCol title="电话"  field="fphone"></t:dgCol>
   <t:dgCol title="电子邮件"  field="femail"></t:dgCol>
   <t:dgCol title="备注"  field="fnote"></t:dgCol>
  </t:datagrid>
  </div>
 </div>