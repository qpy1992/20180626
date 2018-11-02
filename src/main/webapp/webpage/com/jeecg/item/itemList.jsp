<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="itemList" checkbox="false" pagination="true" fitColumns="true" title="货物信息" actionUrl="itemController.do?datagrid" idField="id" fit="true" queryMode="group">
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
   <t:dgCol title="货物名称"  field="fname"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="分拆"  field="fsplit"  queryMode="single"  dictionary="sf_yn"  width="120"></t:dgCol>
   <t:dgCol title="唛头"  field="fmark"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="商品简称"  field="fabbr"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="商品编号"  field="fnumber"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户分类"  field="fcusClass"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="厂商编号"  field="fmanuNumber"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="运输条件"  field="ftransCondition"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="保存条件"  field="fpreseCondition"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="运输备注"  field="ftransNote"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="毛重"  field="fgross"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="净重"  field="fnet"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单价"  field="fprice"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="包装类型"  field="fpackType" hidden="true"  queryMode="single"  dictionary="bag"  width="120"></t:dgCol>
   <t:dgCol title="卸货时间"  field="funloadTime" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="长度"  field="flength" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="宽度"  field="fwidth" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="高度"  field="fheight" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="体积"  field="fvolume" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="下级数量"  field="flowerNumber" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="下级单位"  field="flowerUnit" hidden="true"  queryMode="single"  dictionary="unit"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="fnote" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="itemController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="itemController.do?goAdd" funname="add" width="730" height="600"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="itemController.do?goUpdate" funname="update" width="730" height="600"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="itemController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="itemController.do?goUpdate" funname="detail" width="730" height="600"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/item/itemList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'itemController.do?upload', "itemList");
}

//导出
function ExportXls() {
	JeecgExcelExport("itemController.do?exportXls","itemList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("itemController.do?exportXlsByT","itemList");
}

 </script>