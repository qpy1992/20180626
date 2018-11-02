<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="customEntrustList" fitColumns="true" pagination="false" title="委托信息" actionUrl="paicheController.do?entrust&fboxid=${fboxid}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgFunOpt title="暂落" funname="zanluo(fboxno)" urlclass="ace_button"  urlStyle="background-color:#ec4758;" urlfont="fa-laptop" exp="fzanluo#eq#N"></t:dgFunOpt>
   <t:dgFunOpt title="暂落详情" funname="zldetail(fboxno)" urlclass="ace_button" urlfont="fa-th-large" exp="fzanluo#eq#Y"></t:dgFunOpt>
   <t:dgCol title="主键"  field="id"  hidden="true"></t:dgCol>
   <t:dgCol title="委托号"  field="fweituo"></t:dgCol>
   <t:dgCol title="船名"  field="fshipname"></t:dgCol>
   <t:dgCol title="航次"  field="fvoyageno"></t:dgCol>
   <t:dgCol title="提单号"  field="fblno"></t:dgCol>
   <t:dgCol title="箱号"  field="fboxno"></t:dgCol>
   <t:dgCol title="封号"  field="ftitle"></t:dgCol>
   <t:dgCol title="箱型"  field="fboxtype"></t:dgCol>
   <t:dgCol title="运输时间"  field="ftranstime" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="提箱堆场"  field="ftxyard"></t:dgCol>
   <t:dgCol title="收货单位"  field="fxhunit"></t:dgCol>
   <t:dgCol title="详细地址"  field="fxhdpdz"></t:dgCol>
   <t:dgCol title="门点联系人"  field="fxhcontact"></t:dgCol>
   <t:dgCol title="门点联系电话"  field="fxhmobile"></t:dgCol>
   <t:dgCol title="还箱堆场"  field="fhxyard"></t:dgCol>
   <t:dgCol title="取消运输"  field="fquxiao" dictionary="sf_yn"></t:dgCol>
   <t:dgCol title="驳箱"  field="fboxiang" dictionary="sf_yn"></t:dgCol>
   <t:dgCol title="先到"  field="fxiandao" dictionary="sf_yn"></t:dgCol>
   <t:dgCol title="放在前面"  field="fup" dictionary="sf_yn"></t:dgCol>
   <t:dgCol title="预提"  field="fyuti" dictionary="sf_yn"></t:dgCol>
   <t:dgCol title="签收日期"  field="fqsdate" formatter="yyyy-MM-dd"></t:dgCol>
   <t:dgCol title="客户联系人"  field="fcontact"></t:dgCol>
   <t:dgCol title="进出口类型"  field="fieport" dictionary="ieport"></t:dgCol>
   <t:dgCol title="带货"  field="fdaihuo" dictionary="sf_yn"></t:dgCol>
   <t:dgCol title="暂落" field="fzanluo" hidden="true"></t:dgCol>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
     function zanluo(fboxno){
         createwindow('暂落','zanluoController.do?goAdd&fboxno='+fboxno,350,250);
     }
     function zldetail(fboxno) {
         createdetailwindow('暂落','zanluoController.do?goUpdate1&fboxno='+fboxno,350,250);
     }
 </script>