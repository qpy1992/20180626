<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="currencyList" checkbox="false" pagination="true" fitColumns="true" title="币种维护" actionUrl="currencyController.do?datagrid" idField="id" fit="true" queryMode="group">
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
   <t:dgCol title="币种代码"  field="fcurrencyid"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="有效"  field="fyouxiao"  queryMode="single"  dictionary="sf_yn"  extendParams="styler:fmtype"  width="50"></t:dgCol>
   <t:dgCol title="本位币"  field="fbenwei"  queryMode="single"  dictionary="sf_yn"  extendParams="styler:fmtype"  width="50"></t:dgCol>
   <t:dgCol title="币种名称"  field="fname"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="符号"  field="fsymbol"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="国家代码"  field="fcountryCode"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="EDI代码"  field="fedi"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="EDI代码2"  field="fedi2"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="EDI代码3"  field="fedi3"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="附加说明"  field="finstruction"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="currencyController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="currencyController.do?goAdd" funname="add" width="730"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="currencyController.do?goUpdate" funname="update" width="730"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="currencyController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="currencyController.do?goUpdate" funname="detail" width="730"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/currency/currencyList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });

//导入
function ImportXls() {
	openuploadwin('Excel导入', 'currencyController.do?upload', "currencyList");
}

//导出
function ExportXls() {
	JeecgExcelExport("currencyController.do?exportXls","currencyList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("currencyController.do?exportXlsByT","currencyList");
}

 //列表字段颜色 demo,逻辑判断函数
 function fmtype(val,row,index){
     //可添加更多CSS样式
     var s1 = 'background-color:#ff5151;color:#FFF;';
     var s2 = 'background-color:#53ff53;color:#FFF;';
     var s3 = 'background-color:#21B9BB;';
     if (val =='N') {
         return s1
     }
     if (val =='Y') {
         return s2
     }
     return s3
 }
 </script>