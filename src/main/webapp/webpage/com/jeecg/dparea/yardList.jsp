<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="yardList" checkbox="true" pagination="true" fitColumns="true" title="堆场" actionUrl="yardController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="堆场代码"  field="fyardCode"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所在区域"  field="fareaCode"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="堆场名称"  field="fyardName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="港口代码"  field="fportCode"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="附加说明"  field="finstruction"  queryMode="single"  width="120"></t:dgCol>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/yard/yardList.js"></script>