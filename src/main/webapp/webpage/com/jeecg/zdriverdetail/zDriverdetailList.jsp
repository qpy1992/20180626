<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="zDriverdetailList" checkbox="true" pagination="true" fitColumns="true" title="驾驶人基本信息" actionUrl="zDriverdetailController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="工号"  field="jobnumber"  hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="工种"  field="job" hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入职日期"  field="entryDate" hidden="true"  formatter="yyyy-MM-dd" queryMode="single"  width="120"></t:dgCol>
  <%--  <t:dgCol title="离职日期"  field="departureDate" formatter="yyyy-MM-dd" queryMode="single"  width="120"></t:dgCol> --%>
   <t:dgCol title="姓名"  field="fname"  queryMode="single" ></t:dgCol>
     <t:dgCol title="驾驶证号"  field="licenseNo"  queryMode="single"  ></t:dgCol>
   <t:dgCol title="性别"  field="sex"   hidden="true" queryMode="single" dictionary="sex" ></t:dgCol>
   <t:dgCol title="出生年月"  field="birthDate"  hidden="true" formatter="yyyy-MM-dd" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="学历"  field="education"  hidden="true" dictionary="xueli" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="民族"  field="nation"  hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="籍贯"  field="birthplace"  hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="身份证号码"  field="idcard"  hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="政治面貌"  field="political"  hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="家庭住址"  field="address"  hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="准驾车型"  field="carType"  queryMode="single"  ></t:dgCol>
    <t:dgCol title="是否沪籍"  field="ishu" dictionary="hutype" queryMode="single"  ></t:dgCol>
   <t:dgCol title="初领日期"  field="initialDate" formatter="yyyy-MM-dd" queryMode="single"  ></t:dgCol>
    <t:dgCol title="有效日期"  field="effectiveDate"   formatter="yyyy-MM-dd"  queryMode="single"  ></t:dgCol>
   
    <t:dgCol title="联系电话"  field="phone"  queryMode="single" ></t:dgCol>
    
   <t:dgCol title="实际联系地址"  field="residentialAddress"  queryMode="single"  ></t:dgCol>
   <t:dgCol title="离职日期"  field="departureDate" formatter="yyyy-MM-dd" queryMode="single"  ></t:dgCol>
   <t:dgCol title="驾驶证登记地址"  field="registrationAddress" hidden="true"  queryMode="single"  width="120"></t:dgCol>
<%--    <t:dgCol title="驾驶证档案号"  field="licenseNo"  queryMode="single"  width="120"></t:dgCol> --%>
   <t:dgCol title="发证机关"  field="issuingAuthority" hidden="true"  queryMode="single"  width="120"></t:dgCol>
  <%--  <t:dgCol title="联系电话"  field="phone"  queryMode="single"  width="120"></t:dgCol> --%>
   <t:dgCol title="照片"  field="image" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgDelOpt title="删除" url="zDriverdetailController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   
    <t:dgFunOpt title="证件" funname="zhengjian(id,fname)" urlclass="ace_button"  urlfont="fa-th-list"></t:dgFunOpt>
    <t:dgFunOpt title="奖罚" funname="jiangcheng(id,fname)" urlclass="ace_button"  urlfont="fa-th-list"></t:dgFunOpt>
    <t:dgFunOpt title="违法" funname="weifa(id,fname)" urlclass="ace_button"  urlfont="fa-th-list"></t:dgFunOpt>
   
   <t:dgToolBar title="录入" icon="icon-add" url="zDriverdetailController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zDriverdetailController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="zDriverdetailController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zDriverdetailController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 
  <div region="east" style="width:450px;" split="true"> 
	<div tools="#tt" class="easyui-panel" title='从业情况' style="padding: 10px;" fit="true" border="false" id="function-panel"></div>
 </div>
 
 <script src = "webpage/com/jeecg/zdriverdetail/zDriverdetailList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
 function zhengjian(id,fname) {
	 
		$("#function-panel").panel(
			{
				title :fname+ ':',
				href:"zZhengjianController.do?list&pid="+id
			}
		);
		 
	}
 
 function jiangcheng(id,fname) {
	 
		$("#function-panel").panel(
			{
				title :fname+ ':',
				href:"zJiangchengController.do?list&pid="+id
			}
		);
		 
	}
 
 
 function weifa(id,fname) {
	 
		$("#function-panel").panel(
			{
				title :fname+ ':',
				href:"zDriverillegalController.do?list2&pid="+id
			}
		);
		 
	}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zDriverdetailController.do?upload', "zDriverdetailList");
}

//导出
function ExportXls() {
	JeecgExcelExport("zDriverdetailController.do?exportXls","zDriverdetailList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("zDriverdetailController.do?exportXlsByT","zDriverdetailList");
}

 </script>