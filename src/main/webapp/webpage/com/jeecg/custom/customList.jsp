<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div id="custom" class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="customList" checkbox="true" fitColumns="true" title="客户资料维护" actionUrl="customController.do?datagrid" idField="id" fit="true" queryMode="group" onLoadSuccess="loadSuccess">
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
   <t:dgCol title="公司类型"  field="fcompanyType"  queryMode="single"  dictionary="comtype"></t:dgCol>
   <t:dgCol title="客户代码"  field="fcustomCode"  queryMode="single"></t:dgCol>
   <t:dgCol title="简称"  field="fabbr"  queryMode="single"></t:dgCol>
   <t:dgCol title="税号"  field="fdutyPara"  queryMode="single"></t:dgCol>
   <t:dgCol title="中文名称"  field="fcnName"  queryMode="single"></t:dgCol>
   <t:dgCol title="英文名称"  field="fenName"  queryMode="single"></t:dgCol>
   <t:dgCol title="财务编码"  field="financeCode"  queryMode="single"></t:dgCol>
   <t:dgCol title="信用等级"  field="fcreditRate"  queryMode="single"  dictionary="grade"></t:dgCol>
   <t:dgCol title="合同期起"  field="fcontractStart"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="合同期止"  field="fcontractEnd"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <%--<t:dgCol title="项目组"  field="fprojectTeam"  queryMode="single"  dictionary="team"></t:dgCol>
   <t:dgCol title="国家城市"  field="fcountry"  queryMode="single"></t:dgCol>
   <t:dgCol title="地址"  field="faddress"  queryMode="single"></t:dgCol>
   <t:dgCol title="邮编"  field="fzipcode"  queryMode="single"></t:dgCol>
   <t:dgCol title="联系电话"  field="fmobile"  queryMode="single"></t:dgCol>
   <t:dgCol title="联系传真"  field="fax"  queryMode="single"></t:dgCol>
   <t:dgCol title="关键字"  field="fkeyword"  queryMode="single"></t:dgCol>
   <t:dgCol title="公司网址"  field="fcompanyWebsite"  queryMode="single"></t:dgCol>
   <t:dgCol title="电子邮件"  field="femail"  queryMode="single"></t:dgCol>
   <t:dgCol title="开票税率"  field="fticketRate"  queryMode="single"></t:dgCol>
   <t:dgCol title="附加说明"  field="finstruction"  queryMode="single"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt"></t:dgCol>
   <%--<t:dgDelOpt title="删除" url="customController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>--%>
   <t:dgFunOpt title="费用组合" funname="combination(id,fcnName)" urlclass="ace_button" urlfont="fa-list-ul"></t:dgFunOpt>
   <t:dgToolBar title="录入" icon="icon-add" url="customController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="customController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="customController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="customController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
<div data-options="region:'east',
	title:'mytitle',
	collapsed:true,
	split:true,
	border:false,
	onExpand : function(){
		li_east = 1;
	},
	onCollapse : function() {
	    li_east = 0;
	}"
     style="width: 800px; overflow: hidden;" id="eastPanel">
    <div class="easyui-panel" style="padding:0px;border:0px" fit="true" border="false" id="userListpanel"></div>
</div>

<script type="text/javascript">
    $(function() {
        var li_east = 0;
    });

    function combination(id, fcnName){
        var title = '客户: ' + fcnName;
        if(li_east == 0){
            $('#custom').layout('expand','east');
        }
        $('#custom').layout('panel','east').panel('setTitle', title);
        $('#userListpanel').panel("refresh", "costCombinationController.do?list&fid=" + id);
    }
    function loadSuccess() {
        $('#custom').layout('panel','east').panel('setTitle', "");
        $('#custom').layout('collapse','east');
        $('#userListpanel').empty();
    }
</script>
 <script src = "webpage/com/jeecg/custom/customList.js"></script>