<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<t:tabs id="tabsOne" iframe="true" heigth="750px" tabPosition="left" fit="false">
 <t:tab href="chargeController.do?list1&pid=${id}" icon="icon-receive" title="应收" id="tab1"></t:tab>
 <t:tab href="chargeController.do?list2&pid=${id}" icon="icon-pay" title="应付" id="tab2"></t:tab>
</t:tabs>