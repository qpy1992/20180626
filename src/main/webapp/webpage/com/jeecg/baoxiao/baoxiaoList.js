
    //导入
    function ImportXls() {
        openuploadwin('Excel导入', 'baoxiaoController.do?upload', "baoxiaoList");
    }

//导出
function ExportXls() {
    JeecgExcelExport("baoxiaoController.do?exportXls","baoxiaoList");
}

//模板下载
function ExportXlsByT() {
    JeecgExcelExport("baoxiaoController.do?exportXlsByT","baoxiaoList");
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
