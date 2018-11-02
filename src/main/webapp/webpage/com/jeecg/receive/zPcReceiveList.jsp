<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="zPcReceiveList" checkbox="false" pagination="true" fitColumns="true" title="" actionUrl="zPcReceiveController.do?datagrid&pid=${pid}" idField="id" fit="true" queryMode="group">
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
   <t:dgCol title="审核"  field="fcheck"  queryMode="single"></t:dgCol>
   <t:dgCol title="费用种类"  field="feetype"  queryMode="single"></t:dgCol>
   <t:dgCol title="费用种类名称"  field="feename"  queryMode="single"></t:dgCol>
   <t:dgCol title="结算单位"  field="fsettle"  queryMode="single"></t:dgCol>
   <t:dgCol title="结算单位名称"  field="fsettlename"  queryMode="single"></t:dgCol>
   <t:dgCol title="单位"  field="funit"  queryMode="single"></t:dgCol>
   <t:dgCol title="单价"  field="funitprice"  queryMode="single"></t:dgCol>
   <t:dgCol title="金额"  field="famount"  queryMode="single"></t:dgCol>
   <t:dgCol title="数量"  field="fqty"  queryMode="single"></t:dgCol>
   <t:dgCol title="分摊"  field="fentan"  queryMode="single"></t:dgCol>
   <t:dgCol title="车号"  field="fcarcode"  queryMode="single"></t:dgCol>
   <t:dgCol title="挂车标识"  field="fguache"  queryMode="single"></t:dgCol>
   <t:dgCol title="委托编号"  field="fweituo"  queryMode="single"></t:dgCol>
   <t:dgCol title="额定金额"  field="feding"  queryMode="single"></t:dgCol>
   <t:dgCol title="箱号"  field="fxianghao"  queryMode="single"></t:dgCol>
   <t:dgCol title="已开票金额"  field="fyikai"  queryMode="single"></t:dgCol>
   <t:dgCol title="客户号"  field="fcustomno"  queryMode="single"></t:dgCol>
   <t:dgCol title="纯代收代付"  field="fchun"  queryMode="single"></t:dgCol>
   <t:dgCol title="发票号"  field="fapiao"  queryMode="single"></t:dgCol>
   <t:dgCol title="审核人"  field="fchecker"  queryMode="single"></t:dgCol>
   <t:dgCol title="附加说明"  field="finstruction"  queryMode="single"></t:dgCol>
   <t:dgCol title="主表主键"  field="fid"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgDelOpt title="删除" url="zPcReceiveController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="zPcReceiveController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zPcReceiveController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="zPcReceiveController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zPcReceiveController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/receive/zPcReceiveList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zPcReceiveController.do?upload', "zPcReceiveList");
}

//导出
function ExportXls() {
	JeecgExcelExport("zPcReceiveController.do?exportXls","zPcReceiveList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("zPcReceiveController.do?exportXlsByT","zPcReceiveList");
}

 </script>