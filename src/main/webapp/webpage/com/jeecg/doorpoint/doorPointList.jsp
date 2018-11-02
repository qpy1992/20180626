<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div id="doorpoint" class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="doorPointList" checkbox="true" fitColumns="true" title="门点" actionUrl="doorPointController.do?datagrid" idField="id" fit="true" queryMode="group" onLoadSuccess="loadSuccess">
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
   <t:dgCol title="门点代码"  field="fdpCode"  query="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="项目组"  field="fprojectTeam"  queryMode="single"  dictionary="team"></t:dgCol>
   <t:dgCol title="作废"  field="fvoid"  queryMode="single"  dictionary="sf_yn" extendParams="styler:fmtype"></t:dgCol>
   <t:dgCol title="门点简称"  field="fdpName"  query="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="门点名称"  field="fdeliverUnit"  query="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="门点地址"  field="faddress"  queryMode="single"></t:dgCol>
   <t:dgCol title="附加说明"  field="finstruction"  extendParams="formatter:format"  queryMode="single"></t:dgCol>
   <t:dgCol title="操作" field="opt"></t:dgCol>
   <%--<t:dgDelOpt title="删除" url="doorPointController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>--%>
   <t:dgFunOpt title="联系人"  funname="contact(id,fdpName)"  urlclass="ace_button" urlfont="fa-user" urlStyle="background-color:#ec4758;"/>
   <t:dgToolBar title="录入" icon="icon-add" url="doorPointController.do?goAdd" funname="add" width="1000" height="360"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="doorPointController.do?goUpdate" funname="update" width="1000" height="380"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="doorPointController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="doorPointController.do?goUpdate" funname="detail" width="1000" height="380"></t:dgToolBar>
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
     style="width: 550px; overflow: hidden;" id="eastPanel">
    <div class="easyui-panel" style="padding:0px;border:0px" fit="true" border="false" id="userListpanel"></div>
</div>

<script type="text/javascript">
    $(function() {
        var li_east = 0;
    });

    function contact(id, fdpName){
        var title = '门点: ' + fdpName;
        if(li_east == 0){
            $('#doorpoint').layout('expand','east');
        }
        $('#doorpoint').layout('panel','east').panel('setTitle', title);
        $('#userListpanel').panel("refresh", "doorPointController.do?goContact&fid=" + id);
    }
    function loadSuccess() {
        $('#doorpoint').layout('panel','east').panel('setTitle', "");
        $('#doorpoint').layout('collapse','east');
        $('#userListpanel').empty();
    }

    //导入
    function ImportXls() {
        openuploadwin('Excel导入', 'doorPointController.do?upload', "doorPointList");
    }

    //导出
    function ExportXls() {
        JeecgExcelExport("doorPointController.do?exportXls","doorPointList");
    }

    //模板下载
    function ExportXlsByT() {
        JeecgExcelExport("doorPointController.do?exportXlsByT","doorPointList");
    }

    //格式化单元格提示信息
    function format(value,row,index){
        return "<span title='" + value + "'>" + value + "</span>";
    }
</script>
 <script src = "webpage/com/jeecg/doorpoint/doorPointList.js"></script>