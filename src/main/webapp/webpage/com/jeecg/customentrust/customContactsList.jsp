<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="customContactsList" checkbox="true" fitColumns="true" title="联系人" actionUrl="customEntrustController.do?datagrid2&cid=${cid}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"></t:dgCol>
   <t:dgCol title="联系人名"  field="fcontactsName"></t:dgCol>
   <t:dgCol title="性别" dictionary="sex"  field="fgender"></t:dgCol>
   <t:dgCol title="电话"  field="fphone"></t:dgCol>
   <t:dgCol title="手机"  field="fmobile"></t:dgCol>
   <t:dgCol title="传真"  field="fax"></t:dgCol>
  </t:datagrid>
  </div>
 </div>