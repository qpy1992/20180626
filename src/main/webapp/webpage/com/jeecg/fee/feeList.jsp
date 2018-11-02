<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="feeList" checkbox="false" pagination="true" fitColumns="true" title="费用种类" actionUrl="feeController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"></t:dgCol>
   <t:dgCol title="费用代码"  field="feeCode"  queryMode="single"></t:dgCol>
   <t:dgCol title="作废"  field="fvoid"  queryMode="single"  dictionary="sf_yn" extendParams="styler:fmtype"></t:dgCol>
   <t:dgCol title="费用组"  field="feeTeam" dictionary="fyz"  queryMode="single"></t:dgCol>
   <t:dgCol title="中文名称"  field="fcnName"  queryMode="single"></t:dgCol>
   <t:dgCol title="费用名称"  field="fname"  queryMode="single"></t:dgCol>
   <t:dgCol title="默认币种"  field="fdefaultCurrency"  queryMode="single"></t:dgCol>
   <t:dgCol title="默认价格"  field="fdefaultPrice"  queryMode="single"></t:dgCol>
   <t:dgCol title="对应单位"  field="funit"  queryMode="single"  dictionary="unit"></t:dgCol>
   <t:dgCol title="选项1"  field="fdc1"  queryMode="single"  dictionary="fdc"></t:dgCol>
   <t:dgCol title="选项2"  field="fdp1"  queryMode="single"  dictionary="fdp"></t:dgCol>
   <t:dgCol title="选项3"  field="fcp1"  queryMode="single"  dictionary="fcp"></t:dgCol>
   <t:dgCol title="约价"  field="fcontractPrice"  queryMode="single"></t:dgCol>
   <t:dgCol title="附加说明"  field="finstruction"  queryMode="single"></t:dgCol>
   <t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgDelOpt title="删除" url="feeController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="feeController.do?goAdd" funname="add" width="730"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="feeController.do?goUpdate" funname="update" width="730"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="feeController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="feeController.do?goUpdate" funname="detail" width="730"></t:dgToolBar>
   <t:dgToolBar title="作废" icon="icon-cancel" url="feeController.do?doVoid" funname="doVoid"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/fee/feeList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });

 //列表字段颜色 demo,逻辑判断函数
 function fmtype(val,row,index){
     //可添加更多CSS样式
     var s1 = 'background-color:#ff5151;color:#FFF;';
     var s2 = 'background-color:#53ff53;color:#FFF;';
     var s3 = 'background-color:#21B9BB;';
     if (val =='Y') {
         return s1
     }
     if (val =='N') {
         return s2
     }
     return s3
 }
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'feeController.do?upload', "feeList");
}

//导出
function ExportXls() {
	JeecgExcelExport("feeController.do?exportXls","feeList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("feeController.do?exportXlsByT","feeList");
}

 </script>