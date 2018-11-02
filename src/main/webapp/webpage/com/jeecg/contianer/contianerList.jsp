<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="contianerList" checkbox="true" fitColumns="true" title="集装箱" actionUrl="contianerController.do?datagrid3&cid=${cid}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"></t:dgCol>
  <t:dgCol title="操作" field="opt"></t:dgCol>
  <t:dgFunOpt title="箱货费用" funname="cost(id,fid,fbillno1,fweituo,fblno)"  urlclass="ace_button" urlfont="fa-rmb"></t:dgFunOpt>
   <t:dgCol title="审核"  field="fcheck"  dictionary="check" extendParams="styler:fmtype"  queryMode="single"></t:dgCol>
   <t:dgCol title="业务动态"  field="fbuss"  dictionary="buss"  queryMode="single"></t:dgCol>
   <t:dgCol title="委托单付编号"  field="fbillno1"  queryMode="single"></t:dgCol>
   <t:dgCol title="委托单位"  field="fweituo"  queryMode="single"></t:dgCol>
   <t:dgCol title="提单号"  field="fblno"  queryMode="single"></t:dgCol>
   <t:dgCol title="装货时间"  field="fzhtime" formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="提箱点"  field="fextract"  queryMode="single"></t:dgCol>
   <t:dgCol title="装货门点"  field="fzhdp"  queryMode="single"></t:dgCol>
   <t:dgCol title="卸货时间"  field="fxhtime" formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"></t:dgCol>
   <t:dgCol title="卸货门点"  field="fxhdp"  queryMode="single"></t:dgCol>
   <t:dgCol title="还箱点"  field="freturn"  queryMode="single"></t:dgCol>
   <%--<t:dgCol title="封号"  field="ftitle"  queryMode="single"></t:dgCol>--%>
   <t:dgCol title="箱型"  field="fboxtype"  queryMode="single"></t:dgCol>
   <t:dgCol title="箱类"  field="fmodel"  queryMode="single"></t:dgCol>
   <t:dgCol title="箱号"  field="fboxno"  queryMode="single"></t:dgCol>
   <%--<t:dgCol title="装船港"  field="floadport"  queryMode="single"></t:dgCol>
   <t:dgCol title="中转港"  field="ftransfer"  queryMode="single"></t:dgCol>
   <t:dgCol title="目的港"  field="ftarget"  queryMode="single"></t:dgCol>
   <t:dgCol title="航名"  field="fvoyage"  queryMode="single"></t:dgCol>
   <t:dgCol title="航次"  field="fvoyagenum"  queryMode="single"></t:dgCol> --%>
   <%--<t:dgCol title="危规页码"  field="fdrpagenum"  queryMode="single"></t:dgCol>
   <t:dgCol title="联合国编号"  field="funnumber"  queryMode="single"></t:dgCol>
   <t:dgCol title="闪点"  field="flashPoint"  queryMode="single"></t:dgCol>--%>
   <t:dgCol title="加热温度"  field="fhot"  queryMode="single"></t:dgCol>
   <t:dgCol title="冷藏温度"  field="fcolddegree"  queryMode="single"></t:dgCol>
   <t:dgCol title="等级"  field="fgrade"  queryMode="single"></t:dgCol>
   <%--<t:dgCol title="总件数"  field="ftotals"  queryMode="single"></t:dgCol>
   <t:dgCol title="总毛重"  field="fgrosses"  queryMode="single"></t:dgCol>
   <t:dgCol title="总体积"  field="fvolumes"  queryMode="single"></t:dgCol>
   <t:dgCol title="集装箱经营人"  field="foperator"  queryMode="single"></t:dgCol>--%>
   <t:dgCol title="主表主键"  field="fid"  hidden="true"  queryMode="single"></t:dgCol>
   <%--<t:dgCol title="门点地址"  field="fzhdpdz"  queryMode="single"></t:dgCol>
   <t:dgCol title="装货单位"  field="fzhunit"  queryMode="single"></t:dgCol>
   <t:dgCol title="联系人"  field="fzhcontact"  queryMode="single"></t:dgCol>
   <t:dgCol title="联系电话"  field="fzhmobile"  queryMode="single"></t:dgCol>
   <t:dgCol title="备注"  field="fnote"  queryMode="single"></t:dgCol>
   <t:dgCol title="特殊业务"  field="ftsyw"  queryMode="single"></t:dgCol>
   <t:dgCol title="门点地址"  field="fxhdpdz"  queryMode="single"></t:dgCol>
   <t:dgCol title="卸货时间"  field="fxhtime"  queryMode="single"></t:dgCol>
   <t:dgCol title="卸货单位"  field="fxhunit"  queryMode="single"></t:dgCol>
   <t:dgCol title="联系人"  field="fxhcontact"  queryMode="single"></t:dgCol>
   <t:dgCol title="联系电话"  field="fxhmobile"  queryMode="single"></t:dgCol>--%>
   <t:dgCol title="对应派车单号"  field="fbillno"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="暂落"  field="fzanluo"  hidden="true"  queryMode="single"></t:dgCol>
   <%--<t:dgDelOpt title="删除" url="contianerController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>--%>
   <t:dgToolBar title="录入" icon="icon-add" url="contianerController.do?goAdd&cid=${cid}" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="contianerController.do?goUpdate&cid=${cid}" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="contianerController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="contianerController.do?goUpdate&cid=${cid}" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="审核" icon="icon-check" url="contianerController.do?check" funname="check"></t:dgToolBar>
   <t:dgToolBar title="反审核" icon="icon-uncheck" url="contianerController.do?uncheck" funname="uncheck"></t:dgToolBar>
   <t:dgToolBar title="打印" icon="icon-print" url="contianerController.do?print" funname="print" width="1300" height="580"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/contianer/contianerList.js"></script>		
 <script type="text/javascript">
 function cost(id,fid,fbillno1,fweituo,fblno){
     addOneTab("箱货费用","contianerController.do?chargeList&cid="+fid+"&conid="+id+"&fbillno1="+fbillno1+"&fweituo="+fweituo+"&fblno="+fblno);
 }

 //导入
 function ImportXls() {
	 openuploadwin('Excel导入', 'contianerController.do?upload', "contianerList");
 }

 //导出
 function ExportXls() {
	JeecgExcelExport("contianerController.do?exportXls","contianerList");
}

//模板下载
function ExportXlsByT() {
	 JeecgExcelExport("contianerController.do?exportXlsByT","contianerList");
 }

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
    if(rowsData[0].fcheck == '0'){
        console.log("aaa");
        tip('集装箱没有审核，无法打印！');
        return;
    }
    url += '&load=detail&id='+rowsData[0].id;
    createdetailwindow(title,url,width,height);
}
</script>