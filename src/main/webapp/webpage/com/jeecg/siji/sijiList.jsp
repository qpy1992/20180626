<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="sijiList" checkbox="true" pagination="true" fitColumns="true" title="司机资料" actionUrl="sijiController.do?datagrid" idField="id" fit="true" queryMode="group" sortName="fcode" sortOrder="asc">
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
   <t:dgCol title="代码"  field="fcode"  queryMode="single"></t:dgCol>
   <t:dgCol title="姓名"  field="fname"  queryMode="single"></t:dgCol>
   <t:dgCol title="性别"  field="fsex"  queryMode="single"  dictionary="sex"></t:dgCol>
   <t:dgCol title="民族"  field="fregion"  queryMode="single"></t:dgCol>
   <t:dgCol title="出生日期"  field="fbirthday"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="户籍住址"  field="faddress"  queryMode="single"></t:dgCol>
   <t:dgCol title="身份证号"  field="fidnum"  queryMode="single"></t:dgCol>
   <t:dgCol title="手机号"  field="fmobile"  queryMode="single"></t:dgCol>
   <t:dgCol title="紧急联系人"  field="femergen"  queryMode="single"></t:dgCol>
   <t:dgCol title="手机号"  field="femobile"  queryMode="single"></t:dgCol>
   <t:dgCol title="签发机关"  field="fjiguan"  queryMode="single"></t:dgCol>
   <t:dgCol title="有效期限起"  field="fqixian1"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="有效期限止"  field="fqixian2"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="从业资格号"  field="fcongye"  queryMode="single"></t:dgCol>
   <t:dgCol title="从业资格类别"  field="fcytype"  queryMode="single"  dictionary="congye"></t:dgCol>
   <t:dgCol title="初次发证时间"  field="fazhengtime"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="发证时间"  field="fazheng"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="有效期至"  field="fyouxiao"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="驾驶证号"  field="fjiashi"  queryMode="single"></t:dgCol>
   <t:dgCol title="初次领证日期"  field="fchuci"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="准驾车型"  field="fzhunjia"  queryMode="single"  dictionary="zhunjia"></t:dgCol>
   <t:dgCol title="有效起始日期"  field="fyouxiao1"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="有效期限"  field="fyxqixian"  queryMode="single"></t:dgCol>
   <t:dgCol title="档案编号"  field="fdangan"  queryMode="single"></t:dgCol>
   <t:dgCol title="记录"  field="frecord"  queryMode="single"></t:dgCol>
   <t:dgCol title="入职时间"  field="fruzhi"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="离职时间"  field="flizhi"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="驾驶证"  field="fjsz"  queryMode="single"  image="true" imageSize="50,50"></t:dgCol>
   <t:dgCol title="身份证"  field="fsfz"  queryMode="single"  image="true" imageSize="50,50"></t:dgCol>
   <t:dgCol title="上岗证"  field="fsgz"  queryMode="single"  image="true" imageSize="50,50"></t:dgCol>
   <t:dgCol title="体检报告"  field="ftjbg"  queryMode="single"  image="true" imageSize="50,50"></t:dgCol>
   <t:dgCol title="培训证书"  field="fpxzs"  queryMode="single"  image="true" imageSize="50,50"></t:dgCol>
   <t:dgCol title="意外险"  field="fywx"  queryMode="single"  image="true" imageSize="50,50"></t:dgCol>
   <%--<t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgDelOpt title="删除" url="sijiController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
   <t:dgToolBar title="录入" icon="icon-add" url="sijiController.do?goAdd" funname="add" width="900" height="580"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="sijiController.do?goUpdate" funname="update" width="900" height="580"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="sijiController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="sijiController.do?goUpdate" funname="detail" width="900" height="580"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/siji/sijiList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'sijiController.do?upload', "sijiList");
}

//导出
function ExportXls() {
	JeecgExcelExport("sijiController.do?exportXls","sijiList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("sijiController.do?exportXlsByT","sijiList");
}

 </script>