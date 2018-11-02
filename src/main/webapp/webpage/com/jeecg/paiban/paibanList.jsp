<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="paibanList" checkbox="false" pagination="true" fitColumns="true" title="计划排班" actionUrl="paibanController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="作业日期"  field="fdate" formatter="yyyy-MM-dd" hidden="true" query="true"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"></t:dgCol>
   <t:dgCol title="车辆" colspan="4"></t:dgCol>
   <t:dgCol title="头班" colspan="3"></t:dgCol>
   <t:dgCol title="二班" colspan="3"></t:dgCol>
   <t:dgCol title="三班" colspan="3"></t:dgCol>
   <t:dgCol title="四班" colspan="3"></t:dgCol>
   <t:dgCol title="五班" colspan="3"></t:dgCol>
   <t:dgCol title="操作" field="opt" rowspan="2" newColumn="true"></t:dgCol>
   <t:dgFunOpt title="取消" funname="quxiao(id,fbillno1)"  urlclass="ace_button" urlfont="fa-trash-o"></t:dgFunOpt>
   <t:dgCol title="车辆代码"  field="fcarcode"  queryMode="single"></t:dgCol>
   <t:dgCol title="车号"  field="fcarno"  queryMode="single"></t:dgCol>
   <t:dgCol title="外部车"  field="foutercar"  queryMode="single"></t:dgCol>
   <t:dgCol title="车主"  field="fdriver"  queryMode="single"></t:dgCol>
   <t:dgCol title="派车单号"  field="fbillno1"  queryMode="single"></t:dgCol>
   <t:dgCol title="详细地址"  field="faddress1"  queryMode="single"></t:dgCol>
   <t:dgCol title="预计返回时间"  field="fbackTime1"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="派车单号"  field="fbillno2"  queryMode="single"></t:dgCol>
   <t:dgCol title="详细地址"  field="faddress2"  queryMode="single"></t:dgCol>
   <t:dgCol title="预计返回时间"  field="fbackTime2"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="派车单号"  field="fbillno3"  queryMode="single"></t:dgCol>
   <t:dgCol title="详细地址"  field="faddress3"  queryMode="single"></t:dgCol>
   <t:dgCol title="预计返回时间"  field="fbackTime3"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="派车单号"  field="fbillno4"  queryMode="single"></t:dgCol>
   <t:dgCol title="详细地址"  field="faddress4"  queryMode="single"></t:dgCol>
   <t:dgCol title="预计返回时间"  field="fbackTime4"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="派车单号"  field="fbillno5"  queryMode="single"></t:dgCol>
   <t:dgCol title="详细地址"  field="faddress5"  queryMode="single"></t:dgCol>
   <t:dgCol title="预计返回时间"  field="fbackTime5"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <%--<t:dgToolBar title="排班" icon="icon-add" url="contianerController.do?container" funname="paiban" width="1330" height="580"></t:dgToolBar>--%>
   <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="paibanController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="paibanController.do?goAdd" funname="add"></t:dgToolBar>--%>
   <t:dgToolBar title="查看" icon="icon-search" url="paibanController.do?goUpdate" funname="detail" width="720" height="450"></t:dgToolBar>
   <%--<t:dgToolBar title="编辑" icon="icon-edit" url="paibanController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="paibanController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/paiban/paibanList.js"></script>
<script type="text/javascript">
 function quxiao(id,fbillno1) {
     if(fbillno1==''){
         tip('尚未排班！');
     }else {
         createwindow('取消', 'paibanController.do?quxiao&id=' + id, 300, 200);
     }
 }
</script>