
$(document).ready(function(){
});

//导入
function ImportXls() {
    openuploadwin('Excel导入', 'paibanController.do?upload', "paibanList");
}

//导出
function ExportXls() {
    JeecgExcelExport("paibanController.do?exportXls","paibanList");
}

//模板下载
function ExportXlsByT() {
    JeecgExcelExport("paibanController.do?exportXlsByT","paibanList");
}

function paiban(title,url, id,width,height,isRestful){
    gridname=id;
    var rowsData = $('#'+id).datagrid('getSelections');
    if (!rowsData || rowsData.length==0) {
        tip('请选择排班车辆');
        return;
    }
    if (rowsData.length>1) {
        tip('请选择一辆车再排班');
        return;
    }
    if(rowsData[0].fbillno5 != ''){
        tip('今日班次已排满！')
        return;
    }
    if(isRestful!='undefined'&&isRestful){
        url += '/'+rowsData[0].id;
    }else{
        url += '&qid='+rowsData[0].id;
    }
    width = width?width:700;
    height = height?height:400;
    if(width=="100%" || height=="100%"){
        width = window.top.document.body.offsetWidth;
        height =window.top.document.body.offsetHeight-100;
    }
    if(typeof(windowapi) == 'undefined'){
        $.dialog({
            content: 'url:'+url,
            zIndex: getzIndex(),
            lock : true,
            width:width,
            height: height,
            title:title,
            opacity : 0.3,
            cache:false,
            cancelVal: '关闭',
            cancel: function () {
                reloadTable()
            } /*为true等价于function(){}*/
        });
    }
}
