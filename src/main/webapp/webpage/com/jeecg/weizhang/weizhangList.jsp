<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="weizhangList" checkbox="false" pagination="true" fitColumns="true" title="车辆违章管理" actionUrl="weizhangController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="制单人"  field="createName"  queryMode="single"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="制单日期"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"></t:dgCol>
   <t:dgCol title="流水编码"  field="fbillno"  queryMode="single"></t:dgCol>
   <t:dgCol title="审核人"  field="fchecker"  queryMode="single"></t:dgCol>
   <t:dgCol title="审核时间"  field="fcheckTime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="违章时间"  field="fwzTime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="车号"  field="fcarno"  queryMode="single"></t:dgCol>
   <t:dgCol title="驾驶员"  field="fname"  queryMode="single"></t:dgCol>
   <t:dgCol title="违章地点"  field="fwzaddress"  queryMode="single"></t:dgCol>
   <t:dgCol title="具体交通违法行为"  field="fbehavior"  queryMode="single"></t:dgCol>
   <t:dgCol title="处罚金额"  field="famount"  queryMode="single"></t:dgCol>
   <t:dgCol title="驾驶证扣分"  field="fkoufen"  queryMode="single"></t:dgCol>
   <t:dgCol title="通报单位"  field="ftongbao"  queryMode="single"></t:dgCol>
   <t:dgCol title="违章次数"  field="fwzqty"  queryMode="single"></t:dgCol>
   <t:dgCol title="处理违章时间"  field="fclwztime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="年度累计违章次数"  field="fyearqty"  queryMode="single"></t:dgCol>
   <t:dgCol title="年度违章扣6分次数"  field="fsix"  queryMode="single"></t:dgCol>
   <t:dgCol title="超速次数"  field="fchaosu"  queryMode="single"></t:dgCol>
   <t:dgCol title="年度累计扣分"  field="fyearkf"  queryMode="single"></t:dgCol>
   <t:dgCol title="年度超速次数"  field="fyearcs"  queryMode="single"></t:dgCol>
   <t:dgCol title="年度超速50%(高速20%)次数"  field="fyearfifty"  queryMode="single"></t:dgCol>
   <t:dgCol title="备注"  field="fnote"  queryMode="single"></t:dgCol>
   <t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgDelOpt title="删除" url="weizhangController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="weizhangController.do?goAdd" funname="add" width="830" height="580"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="weizhangController.do?goUpdate" funname="update" width="830" height="580"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="weizhangController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="weizhangController.do?goUpdate" funname="detail" width="830" height="580"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/weizhang/weizhangList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'weizhangController.do?upload', "weizhangList");
}

//导出
function ExportXls() {
	JeecgExcelExport("weizhangController.do?exportXls","weizhangList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("weizhangController.do?exportXlsByT","weizhangList");
}

 </script>