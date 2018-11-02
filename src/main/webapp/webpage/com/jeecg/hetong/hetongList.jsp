<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="hetongList" checkbox="true" fitColumns="true" title="合同维护" actionUrl="hetongController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="合同号"  field="fbillno"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合同类型"  field="ftype" dictionary="htype"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收付类型"  field="fkind" dictionary="shoufu"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="结算单位"  field="fsettle"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="结算单位名称"  field="fsettleName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费方式"  field="fchargetype" dictionary="jifei"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="生效日期"  field="fstartDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="失效日期"  field="fenddate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="附加说明"  field="fnote"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="委托编号"  field="fbrno"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="hetongController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="hetongController.do?goAdd" funname="add" width="840" height="500"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hetongController.do?goUpdate" funname="update" width="840" height="500"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="hetongController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hetongController.do?goUpdate" funname="detail" width="840" height="500"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/hetong/hetongList.js"></script>		
 <script type="text/javascript">
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'hetongController.do?upload', "hetongList");
}

//导出
function ExportXls() {
	JeecgExcelExport("hetongController.do?exportXls","hetongList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("hetongController.do?exportXlsByT","hetongList");
}
 </script>