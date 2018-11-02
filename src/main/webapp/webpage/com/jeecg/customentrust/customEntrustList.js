$(document).ready(function(){
});



//导入
function ImportXls() {
    openuploadwin('Excel导入', 'customEntrustController.do?upload', "customEntrustList");
}

//导出
function ExportXls() {
    JeecgExcelExport("customEntrustController.do?exportXls","customEntrustList");
}

//模板下载
function ExportXlsByT() {
    JeecgExcelExport("customEntrustController.do?exportXlsByT","customEntrustList");
}
