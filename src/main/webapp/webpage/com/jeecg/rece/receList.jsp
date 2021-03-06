<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="receList" checkbox="false" pagination="true" fitColumns="true" title="应收账单"
              actionUrl="receController.do?datagrid&fid=${fid}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="对账单号"  field="fbillno"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="对账单位代码"  field="funitcode"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="对账单位名称"  field="funit"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="币别"  field="fbibie"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="金额"  field="famount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="fnote"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="制单人"  field="createName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="对账日期起"  field="fstartdate"  formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="对账日期止"  field="fenddate"  formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="对账范围"  field="frange"  queryMode="single" hidden="true"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="150"></t:dgCol>
   <t:dgDelOpt title="删除" url="receController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgFunOpt title="费用详情" funname="cost(id)" urlclass="ace_button"  urlStyle="background-color:#0080ff;" urlfont="fa-th-list"></t:dgFunOpt>
   <t:dgToolBar title="录入" icon="icon-add" url="receController.do?goAdd" funname="add" height="250"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="receController.do?goUpdate" funname="update" height="300"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="receController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="receController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/rece/receList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'receController.do?upload', "receList");
}

//导出
function ExportXls() {
	JeecgExcelExport("receController.do?exportXls","receList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("receController.do?exportXlsByT","receList");
}


 function cost(id) {
     addOneTab('费用详情','zhangdanController.do?list&fid='+id);
 }
 </script>