<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="zFyglList" checkbox="false" pagination="true" fitColumns="true" title="费用管理" actionUrl="zFyglController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="关联工作号"  field="fglgzh"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="委托编号"  field="fwtbh"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户号"  field="fkhh"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="客户名称"  field="fkhname"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="双拖"  field="fst"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="套箱"  field="ftx"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="暂落"  field="fzl"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="甩挂"  field="fsg"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="驳箱"  field="fbx"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="外委"  field="fww"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="预提"  field="fyt"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="门点地址"  field="fmddz"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="销售订单号"  field="fxsddh"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="箱型箱量"  field="xxxl"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户采购订单号"  field="khcgddh"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="封号"  field="fh"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="应付锁定"  field="yfsd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="应收锁定"  field="yssd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="zFyglController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="zFyglController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zFyglController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="zFyglController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zFyglController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/zfygl/zFyglList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zFyglController.do?upload', "zFyglList");
}

//导出
function ExportXls() {
	JeecgExcelExport("zFyglController.do?exportXls","zFyglList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("zFyglController.do?exportXlsByT","zFyglList");
}

 </script>