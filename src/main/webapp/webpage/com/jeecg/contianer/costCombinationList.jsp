<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="costCombinationList" checkbox="false" pagination="true" fitColumns="true" title="费用组合" actionUrl="customController.do?datagrid2&fid=${cid}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="提箱点"  field="ftxyard"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="装货门点"  field="fload"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="门点地址"  field="fzhdpdz" hidden="true"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="装送货单位"  field="fzhunit" hidden="true"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="联系人"  field="fzhcontact" hidden="true"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="手机号"  field="fzhmobile" hidden="true"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="卸货门点"  field="fdischarge"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="门点地址"  field="fxhdpdz" hidden="true"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="装送货单位"  field="fxhunit" hidden="true"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="联系人"  field="fxhcontact" hidden="true"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="手机号"  field="fxhmobile" hidden="true"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="还箱点"  field="fhxyard"  queryMode="single"  width="100"></t:dgCol>
   <%--<t:dgCol title="费用"  field="fcost"  queryMode="single"  width="100"></t:dgCol>--%>
   <t:dgCol title="费用"  field="fcost"  queryMode="single"  width="100"></t:dgCol>
   <%--<t:dgCol title="税率"  field="frate"  queryMode="single"  width="60"></t:dgCol>--%>
      <%--<t:dgCol title="开始时间"  field="fstart"  formatter="yyyy-MM-dd"  queryMode="single"  width="150"></t:dgCol>
      <t:dgCol title="备注"  field="fnote"  queryMode="single"  width="100"></t:dgCol>
      <t:dgCol title="主表id"  field="fid"  hidden="true"  queryMode="single"  width="100"></t:dgCol>--%>
   <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="customController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
   <%--<t:dgToolBar title="录入" icon="icon-add" url="customController.do?goAdd1&fid=${fid}" funname="add"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="编辑" icon="icon-edit" url="customController.do?goUpdate1" funname="update"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="customController.do?doBatchDel1" funname="deleteALLSelect"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="查看" icon="icon-search" url="customController.do?goUpdate1" funname="detail"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>