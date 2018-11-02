<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<t:tabs id="tabsOne" iframe="true" heigth="650px" tabPosition="bottom" fit="false">
 <t:tab href="contianerController.do?list&cid=${cid}" icon="icon-box" title="箱货信息" id="tab1"></t:tab>
 <t:tab href="chargeController.do?list&cid=${cid}" icon="icon-money" title="费用" id="tab2"></t:tab>
</t:tabs>