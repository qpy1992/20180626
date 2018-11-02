<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="chargeList" checkbox="true" pagination="true" fitColumns="true" title="委托单位:${fweituo} 提单号:${fblno} 箱编号:${fbillno1}" actionUrl="contianerController.do?datagrid2&conid=${conid}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"></t:dgCol>
   <t:dgCol title="审核"  field="fcheck"  queryMode="single"  dictionary="check"  extendParams="styler:fmtype"></t:dgCol>
   <%--<t:dgCol title="委托单位"  field="fweituo"  queryMode="single"></t:dgCol>
   <t:dgCol title="委托单号"  field="fbillno"  queryMode="single"></t:dgCol>
   <t:dgCol title="提单号"  field="fblno"  queryMode="single"></t:dgCol>
   <t:dgCol title="箱编号"  field="fbillno1"  queryMode="single"></t:dgCol>--%>
   <t:dgCol title="收付"  field="fshoufu"  hidden="true"  queryMode="single"  dictionary="shoufu"></t:dgCol>
   <t:dgCol title="费用种类"  field="fcost"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="费用名称"  field="fcostname"  queryMode="single"></t:dgCol>
   <t:dgCol title="单价"  field="fprice"  queryMode="single"></t:dgCol>
   <t:dgCol title="数量"  field="fqty"  queryMode="single"></t:dgCol>
   <t:dgCol title="金额"  field="famount"  queryMode="single"></t:dgCol>
   <t:dgCol title="结算单位"  field="fsettle"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="结算单位名称"  field="fsettlename"  queryMode="single"></t:dgCol>
   <t:dgCol title="收付金额"  field="fsfamount"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="代垫"  field="fdd" dictionary="sf_yn"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="录入人"  field="createName"  queryMode="single"></t:dgCol>
   <t:dgCol title="录入日期"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人"  field="updateName"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="审核人"  field="fchecker"  queryMode="single"></t:dgCol>
   <t:dgCol title="审核日期"  field="fcheckdate"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="主表主键"  field="fid"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="来源"  field="forigin"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="开票"  field="fkp"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="已开金额"  field="fykamount"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="报销"  field="fbx"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="对账"  field="fdz"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="核销"  field="fhx"  hidden="true"  queryMode="single"></t:dgCol>
   <%--<t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgDelOpt title="删除" url="chargeController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
   <t:dgToolBar title="录入" icon="icon-add" url="chargeController.do?goAdd&cid=${cid}&ly=0&conid=${conid}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="chargeController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="chargeController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="chargeController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="审核" icon="icon-check" url="chargeController.do?check" funname="check"></t:dgToolBar>
   <t:dgToolBar title="反审核" icon="icon-uncheck" url="chargeController.do?uncheck" funname="uncheck"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/charge/chargeList.js"></script>