<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="fapiaoList" checkbox="false" pagination="true" fitColumns="true" title="运输发票" actionUrl="fapiaoController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="录入人"  field="createName"  queryMode="single"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="录入时间"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人"  field="updateName"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新时间"  field="updateDate"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"></t:dgCol>
   <t:dgCol title="发票号码"  field="fbillno"  queryMode="single"></t:dgCol>
   <t:dgCol title="结算单位代码"  field="fsettle"  queryMode="single"></t:dgCol>
   <t:dgCol title="发票抬头"  field="ftaitou"  queryMode="single"></t:dgCol>
   <t:dgCol title="签发日期"  field="fqfdate"  queryMode="single"></t:dgCol>
   <t:dgCol title="税号"  field="fshuihao"  queryMode="single"></t:dgCol>
   <t:dgCol title="作废"  field="fvoid" dictionary="sf_yn"  queryMode="single"></t:dgCol>
   <t:dgCol title="作废人"  field="fvoidman"  queryMode="single"></t:dgCol>
   <t:dgCol title="作废时间"  field="fvoidtime"  queryMode="single"></t:dgCol>
   <t:dgCol title="锁定"  field="flock" dictionary="sf_yn"  queryMode="single"></t:dgCol>
   <t:dgCol title="信用日期"  field="fxydate"  queryMode="single"></t:dgCol>
   <t:dgCol title="币种"  field="fbibie"  queryMode="single"></t:dgCol>
   <t:dgCol title="委托编号"  field="fweituo"  queryMode="single"></t:dgCol>
   <t:dgCol title="金额"  field="famount"  queryMode="single"></t:dgCol>
   <t:dgCol title="实际金额"  field="factualamount"  queryMode="single"></t:dgCol>
   <t:dgCol title="输出"  field="fputout"  queryMode="single"></t:dgCol>
   <t:dgCol title="锁定人"  field="flockman"  queryMode="single"></t:dgCol>
   <t:dgCol title="锁定时间"  field="flocktime"  queryMode="single"></t:dgCol>
   <t:dgCol title="领用日期"  field="flydate"  queryMode="single"></t:dgCol>
   <t:dgCol title="参考号"  field="fcankao"  queryMode="single"></t:dgCol>
   <t:dgCol title="委托单位"  field="fwtunit"  queryMode="single"></t:dgCol>
   <t:dgCol title="审核"  field="fcheck" dictionary="check"  queryMode="single"></t:dgCol>
   <t:dgCol title="提单号"  field="ftidan"  queryMode="single"></t:dgCol>
   <t:dgCol title="红冲"  field="fred"  queryMode="single"></t:dgCol>
   <t:dgCol title="红冲说明"  field="frednote"  queryMode="single"></t:dgCol>
   <t:dgCol title="附加说明"  field="ffujia"  queryMode="single"></t:dgCol>
   <%--<t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgDelOpt title="删除" url="fapiaoController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
   <t:dgToolBar title="新增" icon="icon-add" onclick="addfee()"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="fapiaoController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="fapiaoController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="fapiaoController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="审核" icon="icon-check" url="fapiaoController.do?check" funname="check"></t:dgToolBar>
   <t:dgToolBar title="作废" icon="icon-cancel" url="fapiaoController.do?doVoid" funname="doVoid"></t:dgToolBar>
   <t:dgToolBar title="锁定" icon="icon-lock" url="fapiaoController.do?lock" funname="lock"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/fapiao/fapiaoList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });

//导入
function ImportXls() {
	openuploadwin('Excel导入', 'fapiaoController.do?upload', "fapiaoList");
}

//导出
function ExportXls() {
	JeecgExcelExport("fapiaoController.do?exportXls","fapiaoList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("fapiaoController.do?exportXlsByT","fapiaoList");
}

 /**
  * 审核
  * @param title
  * @param url
  * @param gname
  */
 function check(title,url,gname) {
     gridname=gname;
     var ids = [];
     var rows = $("#"+gname).datagrid('getSelections');
     if (rows.length == 0){
         tip("请选择需要审核的数据");
         return;
     }
     if(rows[0].fcheck=='1') {
         tip("该记录已经审核");
         return;
     }
     if (rows.length > 0) {
         $.dialog.setting.zIndex = getzIndex(true);
         $.dialog.confirm('确认审核?', function(r) {
             if (r) {
                 for ( var i = 0; i < rows.length; i++) {
                     ids.push(rows[i].id);
                 }
                 $.ajax({
                     url : url,
                     type : 'post',
                     data : {
                         ids : ids.join(',')
                     },
                     cache : false,
                     success : function(data) {
                         var d = $.parseJSON(data);
                         if (d.success) {
                             var msg = d.msg;
                             tip(msg);
                             reloadTable();
                             $("#"+gname).datagrid('unselectAll');
                             ids='';
                         }
                     }
                 });
             }
         });
     }
 }


 /**
  * 锁定
  */
 function lock(title,url,gname) {
     gridname=gname;
     var ids = [];
     var rows = $("#"+gname).datagrid('getSelections');
     if (rows.length > 0) {
         $.dialog.setting.zIndex = getzIndex(true);
         $.dialog.confirm('确认锁定?', function(r) {
             if (r) {
                 for ( var i = 0; i < rows.length; i++) {
                     ids.push(rows[i].id);
                 }
                 $.ajax({
                     url : url,
                     type : 'post',
                     data : {
                         ids : ids.join(',')
                     },
                     cache : false,
                     success : function(data) {
                         var d = $.parseJSON(data);
                         if (d.success) {
                             var msg = d.msg;
                             tip(msg);
                             reloadTable();
                             $("#"+gname).datagrid('unselectAll');
                             ids='';
                         }
                     }
                 });
             }
         });
     } else {
         tip("请选择需要锁定的数据");
     }
 }


 var rows;
 function addfee(){
     $.dialog({
         content: 'url:chargeController.do?list6',
         lock : true,
         width:'1300px',
         height: '500px',
         parent:windowapi,
         title:'费用列表',
         opacity : 0.3,
         cache:false,
         button: [
             {
                 name: "确认",
                 callback: function(){
                     rows = window.localStorage.getItem("rows");
                     window.localStorage.removeItem("rows");
                     $.ajax({
                         type : "POST",
                         url : 'fapiaoController.do?fapiao',
                         crossDomain : true,
                         data: 'rows='+rows,
                         success : function(data) {
                             var d = $.parseJSON(data);
                             if (d.success) {
                                 var msg = d.msg;
                                 tip(msg);
                                 reloadTable();
                                 $("#"+gname).datagrid('unselectAll');
                                 rows='';
                             }
                         }
                     })
                 },
             },
             {
                 name: "关闭",
             }]
     }).zindex();
 }
 </script>