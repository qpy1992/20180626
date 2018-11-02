<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<t:tabs id="tabsOne" iframe="true" heigth="650px" tabPosition="bottom" fit="false">
 <t:tab href="paicheController.do?weituo&fboxid=${fboxid}" icon="icon-user-comment" title="委托信息" id="tab1"></t:tab>
 <t:tab href="paicheController.do?chuche&id=${pid}" icon="icon-car" title="出车标准" id="tab2"></t:tab>
 <t:tab href="mileageController.do?list&id=${pid}" icon="icon-flag-grey" title="里程数" id="tab3"></t:tab>
 <t:tab href="paicheController.do?huidan&id=${pid}" icon="icon-laptop-disk" title="单证回收" id="tab4"></t:tab>
 <t:tab href="paicheController.do?fee&id=${pid}" icon="icon-money" title="费用明细" id="tab5"></t:tab>
 <%--<t:tab href="baoxiaoController.do?list&fpcno=${fbillno}" icon="icon-layout-key" title="报销单" id="tab6"></t:tab>--%>
</t:tabs>