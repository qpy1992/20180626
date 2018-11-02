<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="doorPointList" checkbox="true" fitColumns="true" title="门点" actionUrl="doorPointController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="门点代码"  field="fdpCode"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目组"  field="fprojectTeam"  queryMode="single"  dictionary="team"  width="120"></t:dgCol>
   <t:dgCol title="作废"  field="fvoid"  queryMode="single"  dictionary="sf_yn" extendParams="styler:fmtype"  width="80"></t:dgCol>
   <t:dgCol title="门点名称"  field="fdpName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="门点区域"  field="fareaCode"  queryMode="single"  dictionary="dparea"  width="120"></t:dgCol>
   <t:dgCol title="装送货单位"  field="fdeliverUnit"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="附加说明"  field="finstruction"  queryMode="single"  width="200"></t:dgCol>
  </t:datagrid>
  </div>
 </div>
<input id="ids" type="hidden"/>
 <script src = "webpage/com/jeecg/doorpoint/doorPointList.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
     var ids = [];
     var rows = $('#doorPointList').datagrid('getSelections');
     if (rows.length > 0) {
         for (var i = 0; i < rows.length; i++) {
             ids.push(rows[i].id);
         }
     }
     $("#ids").val(ids);
 })
</script>