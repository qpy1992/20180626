<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="paicheList" fitColumns="true" title="派车单管理" actionUrl="paicheController.do?datagrid1" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"></t:dgCol>
   <t:dgCol title="审核"  field="fcheck" extendParams="styler:fmtype"  queryMode="single"  dictionary="check"></t:dgCol>
   <t:dgCol title="箱编号"  field="fbillno1"  queryMode="single"></t:dgCol>
   <t:dgCol title="派车单号"  field="fbillno"  queryMode="single"></t:dgCol>
   <t:dgCol title="车牌号"  field="fcarno"  queryMode="single"></t:dgCol>
   <t:dgCol title="司机"  field="fdriver"  queryMode="single"></t:dgCol>
   <t:dgCol title="提单号"  field="fblno"  queryMode="single"></t:dgCol>
   <t:dgCol title="箱号"  field="fboxno"  queryMode="single"></t:dgCol>
   <t:dgCol title="提箱点"  field="fextract"  queryMode="single"></t:dgCol>
   <t:dgCol title="装货时间"  field="fzhtime"  queryMode="single"></t:dgCol>
   <t:dgCol title="装货门点"  field="fzhdp"  queryMode="single"></t:dgCol>
   <t:dgCol title="卸货时间"  field="fxhtime"  queryMode="single"></t:dgCol>
   <t:dgCol title="卸货门点"  field="fxhdp"  queryMode="single"></t:dgCol>
   <t:dgCol title="还箱点"  field="freturn"  queryMode="single"></t:dgCol>
   <t:dgCol title="状态"  field="fstatus"  queryMode="single"></t:dgCol>
   <%--<t:dgCol title="运输时间"  field="ftranstime"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="录入日期"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="类型"  field="ftype"  queryMode="single"></t:dgCol>
   <t:dgCol title="已报销"  field="fbaoxiao"  queryMode="single"></t:dgCol>

   <t:dgCol title="双拖"  field="ftype2" dictionary="sf_yn"  queryMode="single"></t:dgCol>
   <t:dgCol title="套箱"  field="ftaoxiang" dictionary="sf_yn"  queryMode="single"></t:dgCol>
   <t:dgCol title="直装"  field="fzhizhuang" dictionary="sf_yn"  queryMode="single"></t:dgCol>
   <t:dgCol title="副司机"  field="fdriver2"  queryMode="single"></t:dgCol>
   <t:dgCol title="状态"  field="fstatus"  queryMode="single"></t:dgCol>
   <t:dgCol title="门点"  field="fdoorpoint"  queryMode="single"></t:dgCol>
   <t:dgCol title="运输方式"  field="ftranstype"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="货重"  field="fweight"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="皮重"  field="fweight2"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="出场路码"  field="fcccode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="进场路码"  field="fjccode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="起始地"  field="fstart"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="终止地"  field="fend"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="运输要求"  field="frequire"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="路桥费"  field="fluqiao"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="打单费"  field="fdadan"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="上下车费"  field="fshangxia"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="封子费"  field="ffengzi"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="调箱门费"  field="fdiaoxiang"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="预录费"  field="fyulu"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="总油耗"  field="fyouhao"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="油价"  field="fyoujia"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="油耗"  field="fyoufei"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="正司机提成"  field="fdriver3"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="市内补贴"  field="fshinei"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="副司机提成"  field="fdriver4"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="回单时间"  field="fhdtime"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="设备交接单"  field="fshebei"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="签收单"  field="fqianshou"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="预录单"  field="fyuluno"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="装箱单"  field="fzhaungxiang"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="白卡"  field="fbaika"  hidden="true"  queryMode="single"></t:dgCol>--%>
   <t:dgCol title="箱子id"  field="fboxid" hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="操作" field="opt"></t:dgCol>
   <%--<t:dgDelOpt title="删除" url="paicheController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>--%>
   <t:dgFunOpt title="派车详情" funname="xiangqing(id,fboxid,fbillno)"  urlclass="ace_button"  urlStyle="background-color:#ec4758;" urlfont="fa-th-list"></t:dgFunOpt>
   <t:dgToolBar title="编辑" icon="icon-edit" url="paicheController.do?goUpdate" funname="update" width="1010" height="320"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="paicheController.do?goUpdate" funname="detail" width="1010" height="320"></t:dgToolBar>
   <t:dgToolBar title="暂落记录" icon="icon-bricks" url="zanluoController.do?list" funname="zanluo"></t:dgToolBar>
   <t:dgToolBar title="审核" icon="icon-check" url="paicheController.do?check" funname="check"></t:dgToolBar>
   <t:dgToolBar title="反审核" icon="icon-uncheck" url="paicheController.do?uncheck" funname="uncheck"></t:dgToolBar>
   <t:dgToolBar title="打印" icon="icon-print" url="paicheController.do?print" funname="print" width="1300" height="580"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/paiche/paicheList.js"></script>
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

    function xiangqing(id,fboxid,fbillno) {
        addOneTab(fbillno,"paicheController.do?paichedetail&pid="+id+"&fboxid="+fboxid);
    }

    function zanluo(title,url) {
        addOneTab(title,url);
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

    function print(title,url, id,width,height) {
        var rowsData = $('#'+id).datagrid('getSelections');
        if (!rowsData || rowsData.length == 0) {
            tip('请选择打印项目！');
            return;
        }
        if (rowsData.length > 1) {
            tip('请选择一条记录再打印！');
            return;
        }
        if(rowsData[0].status == '0'){
            console.log("aaa");
            tip('派车单没有审核，无法打印！');
            return;
        }
        url += '&load=detail&id='+rowsData[0].id;
        createdetailwindow(title,url,width,height);
    }
</script>