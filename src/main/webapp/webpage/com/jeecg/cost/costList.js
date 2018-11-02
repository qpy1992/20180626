$(document).ready(function(){
});



//导入
function ImportXls() {
    openuploadwin('Excel导入', 'costController.do?upload', "costList");
}

//导出
function ExportXls() {
    JeecgExcelExport("costController.do?exportXls","costList");
}

//模板下载
function ExportXlsByT() {
    JeecgExcelExport("costController.do?exportXlsByT","costList");
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