//导入
function ImportXls() {
    openuploadwin('Excel导入', 'dpareaController.do?upload', "dpareaList");
}

//导出
function ExportXls() {
    JeecgExcelExport("dpareaController.do?exportXls","dpareaList");
}

//模板下载
function ExportXlsByT() {
    JeecgExcelExport("dpareaController.do?exportXlsByT","dpareaList");
}

//列表字段颜色 demo,逻辑判断函数
function fmtype(val,row,index){
    //可添加更多CSS样式
    var s1 = 'background-color:#ff5151;color:#FFF;';
    var s2 = 'background-color:#53ff53;color:#FFF;';
    var s3 = 'background-color:#21B9BB;';
    if (val =='Y') {
        return s1
    }
    if (val =='N') {
        return s2
    }
    return s3
}


$(document).ready(function(){

});