<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="costList" checkbox="false" pagination="true" fitColumns="true" title="费用" actionUrl="costController.do?datagrid&cid=${cid}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核"  field="fcheck"  queryMode="single"  dictionary="check"  extendParams="styler:fmtype"  width="120"></t:dgCol>
   <t:dgCol title="收付"  field="frecePay"  queryMode="single"  dictionary="shoufu"  width="120"></t:dgCol>
   <t:dgCol title="费用种类"  field="fcostType"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="费用种类名称"  field="fcostname"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="结算单位"  field="fsettleUnit"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="结算单位名称"  field="fsettlename"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单位"  field="funit"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单价"  field="fprice"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="数量"  field="fqty"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收付金额"  field="frpamount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="金额"  field="famount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="本位币金额"  field="fratedAmount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="实际金额"  field="factualAmount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="代垫"  field="fcushion"   dictionary="sf_yn"  queryMode="single"  width="120"></t:dgCol>
   <%--<t:dgCol title="费用属性"  field="fcostProp"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户号"  field="fcusNum"  queryMode="single"  width="120"></t:dgCol>--%>
   <t:dgCol title="录入人"  field="finputPerson"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="录入时间"  field="finputTime"  queryMode="single"  width="200"></t:dgCol>
   <t:dgCol title="主表主键"  field="fid"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="costController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="新增" icon="icon-add" url="costController.do?goAdd&cid=${cid}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="costController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="costController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="costController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="审核" icon="icon-check" url="costController.do?check" funname="check"></t:dgToolBar>
   <%--<t:dgToolBar title="生成运费" icon="icon-delivery" url="" funname=""></t:dgToolBar>
   <t:dgToolBar title="锁定费用" icon="icon-lock" url="" funname=""></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/cost/costList.js"></script>