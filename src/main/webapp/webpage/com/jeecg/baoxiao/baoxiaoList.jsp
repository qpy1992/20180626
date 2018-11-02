<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="baoxiaoList" checkbox="true" fitColumns="true" title="报销单管理" actionUrl="baoxiaoController.do?datagrid" idField="id" fit="true" queryMode="group">
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
   <t:dgCol title="报销单号"  field="fbxno"  queryMode="single"></t:dgCol>
   <t:dgCol title="申请人"  field="fapplyer"  queryMode="single"></t:dgCol>
   <t:dgCol title="申请日期"  field="fapplydate"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="审核"  field="fcheck" dictionary="check" extendParams="styler:fmtype"  queryMode="single"></t:dgCol>
   <t:dgCol title="审核人"  field="fchecker"  queryMode="single"></t:dgCol>
   <t:dgCol title="审核日期"  field="fcheckdate"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="金额"  field="famount"  queryMode="single"></t:dgCol>
   <t:dgCol title="核销金额"  hidden="true"  field="fhxamount"  queryMode="single"></t:dgCol>
   <t:dgCol title="核销状态"  hidden="true"  field="fhxstatus" dictionary="hx"  queryMode="single"></t:dgCol>
   <t:dgCol title="报销人"  field="fbxman"  queryMode="single"></t:dgCol>
   <t:dgCol title="币种"  field="fcurrency" hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="备注"  field="fnote"  queryMode="single"></t:dgCol>
   <t:dgCol title="派车单号"  field="fpcno"  hidden="true"  queryMode="single"></t:dgCol>
   <%--<t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgDelOpt title="删除" url="baoxiaoController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>--%>
   <t:dgToolBar title="录入" icon="icon-add" url="baoxiaoController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="baoxiaoController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="baoxiaoController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="baoxiaoController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="审核" icon="icon-check" url="baoxiaoController.do?check" funname="check"></t:dgToolBar>
   <t:dgToolBar title="反审核" icon="icon-uncheck" url="baoxiaoController.do?uncheck" funname="uncheck"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/baoxiao/baoxiaoList.js"></script>		
<script type="text/javascript">
    /**
     * 审核
     * @param title
     * @param url
     * @param gname
     */
    function check(title,url,gname) {
        gridname=gname;
        var ids = [];
        var checks = [];
        var rows = $("#"+gname).datagrid('getSelections');
        if (rows.length == 0){
            tip("请选择需要审核的数据");
            return;
        }
        for(var i=0;i<rows.length;i++){
            checks.push(rows[i].fcheck);
        }
        if(checks.indexOf('1')!=-1) {
            tip("存在已经审核的记录，无需再审");
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
     * 反审核
     * @param title
     * @param url
     * @param gname
     */
    function uncheck(title,url,gname) {
        gridname=gname;
        var ids = [];
        var checks = [];
        var rows = $("#"+gname).datagrid('getSelections');
        if (rows.length == 0){
            tip("请选择需要反审核的数据");
            return;
        }
        for(var i=0;i<rows.length;i++){
            checks.push(rows[i].fcheck);
        }
        if(checks.indexOf('0')!=-1) {
            tip("存在未审核的记录，无需反审");
            return;
        }
        if (rows.length > 0) {
            $.dialog.setting.zIndex = getzIndex(true);
            $.dialog.confirm('确认反审核?', function(r) {
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
</script>