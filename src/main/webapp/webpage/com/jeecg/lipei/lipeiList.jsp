<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="lipeiList" checkbox="false" pagination="true" fitColumns="true" title="车辆保险理赔" actionUrl="lipeiController.do?datagrid" idField="id" fit="true" queryMode="group">
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
   <t:dgCol title="交通事故处理单号"  field="fjiaotong"  queryMode="single"></t:dgCol>
   <t:dgCol title="车号"  field="fcarno"  queryMode="single"></t:dgCol>
   <t:dgCol title="驾驶员"  field="fname"  queryMode="single"></t:dgCol>
   <t:dgCol title="出险时间"  field="fchuxianTime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="责任划分"  field="fzeren"  queryMode="single"></t:dgCol>
   <t:dgCol title="行程"  field="fxingcheng"  queryMode="single"></t:dgCol>
   <t:dgCol title="损失处理方式"  field="fsschuli"  queryMode="single"  dictionary="sunshi"></t:dgCol>
   <t:dgCol title="内部定级"  field="fdingji"  queryMode="single"  dictionary="dingji"></t:dgCol>
   <t:dgCol title="停运天数"  field="ftyday"  queryMode="single"></t:dgCol>
   <t:dgCol title="司机扣款"  field="fkoukuan"  queryMode="single"></t:dgCol>
   <t:dgCol title="事故总金额"  field="famount"  queryMode="single"></t:dgCol>
   <t:dgCol title="保险赔付"  field="fbaoxian"  queryMode="single"></t:dgCol>
   <t:dgCol title="自身损失"  field="fzssunshi"  queryMode="single"></t:dgCol>
   <t:dgCol title="保险结算单号"  field="fbxjiesuan"  queryMode="single"></t:dgCol>
   <t:dgCol title="其他损失"  field="fother"  queryMode="single"></t:dgCol>
   <t:dgCol title="保险结案时间"  field="fjatime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="第三者损失"  field="fdisan"  queryMode="single"></t:dgCol>
   <t:dgCol title="交理赔材料时间"  field="fjcltime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="公司预付"  field="fyufu"  queryMode="single"></t:dgCol>
   <t:dgCol title="赔付时间"  field="fpeifutime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="交警结案时间"  field="fpolice"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="公司结案时间"  field="fgsjatime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="备注"  field="fnote"  queryMode="single"></t:dgCol>
   <t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgDelOpt title="删除" url="lipeiController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="lipeiController.do?goAdd" funname="add" width="800" height="600"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="lipeiController.do?goUpdate" funname="update" width="800" height="600"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="lipeiController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="lipeiController.do?goUpdate" funname="detail" width="800" height="600"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/lipei/lipeiList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'lipeiController.do?upload', "lipeiList");
}

//导出
function ExportXls() {
	JeecgExcelExport("lipeiController.do?exportXls","lipeiList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("lipeiController.do?exportXlsByT","lipeiList");
}

 </script>