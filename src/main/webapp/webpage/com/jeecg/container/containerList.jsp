<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="containerList" title="集装箱" actionUrl="containerController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="箱号" field="fboxno"   width="120"></t:dgCol>
   <t:dgCol title="封号" field="ftitle"   width="120"></t:dgCol>
   <t:dgCol title="箱型" field="fboxtype"   width="120"></t:dgCol>
   <t:dgCol title="装船港" field="floadport"   width="120"></t:dgCol>
   <t:dgCol title="中转港" field="ftransfer"   width="120"></t:dgCol>
   <t:dgCol title="目的港" field="ftarget"   width="120"></t:dgCol>
   <t:dgCol title="航名" field="fvoyage"   width="120"></t:dgCol>
   <t:dgCol title="航次" field="fvoyagenum"   width="120"></t:dgCol>
   <t:dgCol title="型号" field="fmodel"   width="120"></t:dgCol>
   <t:dgCol title="做箱时间" field="fmakeboxtime" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="等级" field="fgrade"   width="120"></t:dgCol>
   <t:dgCol title="危规页码" field="fdrpagenum"   width="120"></t:dgCol>
   <t:dgCol title="联合国编号" field="funnumber"   width="120"></t:dgCol>
   <t:dgCol title="闪点" field="flashPoint"   width="120"></t:dgCol>
   <t:dgCol title="冷藏温度" field="fcolddegree"   width="120"></t:dgCol>
   <t:dgCol title="总件数" field="ftotals"   width="120"></t:dgCol>
   <t:dgCol title="总毛重" field="fgrosses"   width="120"></t:dgCol>
   <t:dgCol title="总体积" field="fvolumes"   width="120"></t:dgCol>
   <t:dgCol title="提箱点" field="fextract"   width="120"></t:dgCol>
   <t:dgCol title="还箱点" field="freturn"   width="120"></t:dgCol>
   <t:dgCol title="集装箱经营人" field="foperator"   width="120"></t:dgCol>
   <t:dgCol title="主表主键" field="fid"   width="120"></t:dgCol>
   <t:dgCol title="装货门点" field="fzhdp"   width="120"></t:dgCol>
   <t:dgCol title="门点地址" field="fzhdpdz"   width="120"></t:dgCol>
   <t:dgCol title="装货单位" field="fzhunit"   width="120"></t:dgCol>
   <t:dgCol title="联系人" field="fzhcontact"   width="120"></t:dgCol>
   <t:dgCol title="联系电话" field="fzhmobile"   width="120"></t:dgCol>
   <t:dgCol title="备注" field="fnote"   width="120"></t:dgCol>
   <t:dgCol title="特殊业务" field="ftsyw"   width="120"></t:dgCol>
   <t:dgCol title="卸货门点" field="fxhdp"   width="120"></t:dgCol>
   <t:dgCol title="门点地址" field="fxhdpdz"   width="120"></t:dgCol>
   <t:dgCol title="卸货时间" field="fxhtime" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="卸货单位" field="fxhunit"   width="120"></t:dgCol>
   <t:dgCol title="联系人" field="fxhcontact"   width="120"></t:dgCol>
   <t:dgCol title="联系电话" field="fxhmobile"   width="120"></t:dgCol>
   <t:dgCol title="对应派车单号" field="fbillno"   width="120"></t:dgCol>
   <t:dgCol title="暂落" field="fzanluo"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="containerController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="containerController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="containerController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="containerController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>