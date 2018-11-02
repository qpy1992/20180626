<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="customEntrustList" checkbox="true" pagination="true" fitColumns="true" title="客户委托" actionUrl="customEntrustController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"></t:dgCol>
 <%--   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"></t:dgCol> --%>
   <t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgFunOpt title="箱货信息" funname="xianghuo(id,fbillno)"  urlclass="ace_button"  urlStyle="background-color:#ec4758;" urlfont="fa-truck"></t:dgFunOpt>
   <t:dgFunOpt title="费用" funname="cost(id,fentrustunit,fbillno,fblno)"  urlclass="ace_button" urlfont="fa-rmb"></t:dgFunOpt>
   <t:dgCol title="审核"  field="fcheck"  queryMode="single" dictionary="check"  extendParams="styler:fmtype" query="true"></t:dgCol>
   <t:dgCol title="委托单位"  field="fentrustunit" query="true"></t:dgCol>
   <t:dgCol title="委托单号"  field="fbillno" query="true"  queryMode="single"></t:dgCol>
   <%--<t:dgDelOpt title="删除" url="customEntrustController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
   <t:dgCol title="委托时间"  field="foperatetime"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="客户编码"  field="fcuscode"  queryMode="single"></t:dgCol>
   <t:dgCol title="业务类型"  field="fbusstype"  queryMode="single"  dictionary="buss"></t:dgCol>
   <t:dgCol title="联系人"  field="fcontact"  queryMode="single" query="true"></t:dgCol>
   <t:dgCol title="联系电话"  field="fphone"  queryMode="single"></t:dgCol>
   <t:dgCol title="手机号"  field="fmobile"  queryMode="single"></t:dgCol>
   <t:dgCol title="船名"  field="fshipname"  queryMode="single"></t:dgCol>
   <t:dgCol title="航次"  field="fvoyageno"  queryMode="single"></t:dgCol>
   <t:dgCol title="提单号"  field="fblno"  queryMode="single" query="true"></t:dgCol>
   <t:dgCol title="开港时间"  field="fzytime"  formatter="yyyy-MM-dd HH:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="截港时间"  field="fcuttime"  formatter="yyyy-MM-dd HH:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="到港时间"  field="farrivetime"  formatter="yyyy-MM-dd HH:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="冷藏温度"  field="fcolddegree"  queryMode="single"></t:dgCol>
   <t:dgCol title="加热温度"  field="fhot"  queryMode="single"></t:dgCol>
   <t:dgCol title="等级"  field="fgrade"  queryMode="single"></t:dgCol>
   <%--<t:dgCol title="联系传真"  field="fax"  queryMode="single"></t:dgCol>--%>
   <%--<t:dgCol title="业务员"  field="fsalesman"  queryMode="single" query="true"></t:dgCol>--%>
   <%--<t:dgCol title="做箱类型"  field="fboxType"  queryMode="single"  dictionary="box"></t:dgCol>--%>

   <%--<t:dgCol title="装船港"  field="floadport"   queryMode="single"></t:dgCol>--%>
   <%--<t:dgCol title="中转港"  field="ftransport"  queryMode="single"></t:dgCol>--%>

   <%--<t:dgCol title="目的港"  field="ftargetport"  queryMode="single"></t:dgCol>--%>
   <%--<t:dgCol title="备注"  field="fnote"  queryMode="single"></t:dgCol>--%>
   <%--<t:dgCol title="委托类型"  field="fkinds"  queryMode="single"  dictionary="entrust"></t:dgCol>--%>
   <%--<t:dgCol title="船公司"  field="fshipcompany"  queryMode="single"></t:dgCol>
   <t:dgCol title="防箱公司"  field="fantibox"  queryMode="single"></t:dgCol>
   <t:dgCol title="作业时间"  field="fzytime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="到港时间"  field="farrivetime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="截港时间"  field="fcuttime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="分提单号"  field="fseprano"  queryMode="single"></t:dgCol>
   <t:dgCol title="品名"  field="fname"  queryMode="single"></t:dgCol>
   <t:dgCol title="件数"  field="fqty"  queryMode="single"></t:dgCol>
   <t:dgCol title="重量"  field="fweight"  queryMode="single"></t:dgCol>
   <t:dgCol title="体积"  field="fvolume"  queryMode="single"></t:dgCol>
   <t:dgCol title="提箱堆场"  field="ftxyard"  queryMode="single"></t:dgCol>
   <t:dgCol title="还箱堆场"  field="fhxyard"  queryMode="single"></t:dgCol>
   <t:dgCol title="货物属性"  field="fgoodsprop"  queryMode="single"></t:dgCol>
   <t:dgCol title="转关地址"  field="fzgaddress"  queryMode="single"></t:dgCol>
   <t:dgCol title="转关联系人"  field="fzgcontact"  queryMode="single"></t:dgCol>
   <t:dgCol title="转关联系电话"  field="fzgphone"  queryMode="single"></t:dgCol>--%>
   <%--<t:dgCol title="箱号"  field="fboxno"  queryMode="single"></t:dgCol>
   <t:dgCol title="封号"  field="ftitle"  queryMode="single"></t:dgCol>
   <t:dgCol title="箱型"  field="fboxtype"  queryMode="single"></t:dgCol>
   <t:dgCol title="箱类"  field="fmodel"  queryMode="single"></t:dgCol>
   <t:dgCol title="做箱时间"  field="fmakeboxtime"  queryMode="single" ></t:dgCol>
   <t:dgCol title="总件数"  field="ftotals"  queryMode="single"></t:dgCol>
   <t:dgCol title="总毛重"  field="fgrosses"  queryMode="single"></t:dgCol>
   <t:dgCol title="总体积"  field="fvolumes"  queryMode="single"></t:dgCol>
   <t:dgCol title="提箱点"  field="fextract"  queryMode="single"></t:dgCol>
   <t:dgCol title="还箱点"  field="freturn"  queryMode="single"></t:dgCol>
   <t:dgCol title="集装箱经营人"  field="foperator"  queryMode="single"></t:dgCol>
   <t:dgCol title="主表主键"  field="fid"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="装货门点"  field="fzhdp"  queryMode="single"></t:dgCol>
   <t:dgCol title="门点地址"  field="fzhdpdz"  queryMode="single"></t:dgCol>
   <t:dgCol title="装货单位"  field="fzhunit"  queryMode="single"></t:dgCol>
   <t:dgCol title="联系人"  field="fzhcontact"  queryMode="single"></t:dgCol>
   <t:dgCol title="联系电话"  field="fzhmobile"  queryMode="single"></t:dgCol>
   <t:dgCol title="备注"  field="fnote"  queryMode="single"></t:dgCol>
   <t:dgCol title="特殊业务"  field="ftsyw"  queryMode="single"></t:dgCol>
   <t:dgCol title="卸货门点"  field="fxhdp"  queryMode="single"></t:dgCol>
   <t:dgCol title="门点地址"  field="fxhdpdz"  queryMode="single"></t:dgCol>
   <t:dgCol title="卸货时间"  field="fxhtime"  queryMode="single"></t:dgCol>
   <t:dgCol title="卸货单位"  field="fxhunit"  queryMode="single"></t:dgCol>
   <t:dgCol title="联系人"  field="fxhcontact"  queryMode="single"></t:dgCol>
   <t:dgCol title="联系电话"  field="fxhmobile"  queryMode="single"></t:dgCol>
   <t:dgCol title="对应派车单号"  field="fbillno2"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="暂落"  field="fzanluo"  hidden="true"  queryMode="single"></t:dgCol>--%>
   <t:dgToolBar title="录入" icon="icon-add" url="customEntrustController.do?goAdd" funname="add" width="1600" height="400" operationCode="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="customEntrustController.do?goUpdate" funname="update" width="1600" height="400" operationCode="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="customEntrustController.do?doBatchDel" funname="deleteALLSelect" operationCode="doBatchDel"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="customEntrustController.do?goUpdate" funname="detail" width="1600" height="400" operationCode="detail"></t:dgToolBar>
   <t:dgToolBar title="审核" icon="icon-check" url="customEntrustController.do?check" funname="check" operationCode="check"></t:dgToolBar>
   <t:dgToolBar title="反审核" icon="icon-uncheck" url="customEntrustController.do?uncheck" funname="uncheck" operationCode="uncheck"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/customentrust/customEntrustList.js"></script>
<script type="text/javascript">
    //列表字段颜色 demo,逻辑判断函数
    function fmtype(val,row,index){
        //可添加更多CSS样式
        var s1 = 'background-color:#ff5151;color:#FFF;';
        var s2 = 'background-color:#53ff53;color:#FFF;';
        var s3 = 'background-color:#21B9BB;';
        if (val =='0') {
            return s1
        }
        if (val =='1') {
            return s2
        }
        return s3
    }

    function xianghuo(id,fbillno) {
        addOneTab(fbillno,"contianerController.do?list&cid="+id);
    }

    function cost(id,fentrustunit,fbillno,fblno){
        addOneTab("票费用","customEntrustController.do?chargeList&cid="+id+"&fentrustunit="+fentrustunit+"&fbillno="+fbillno+"&fblno="+fblno);
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