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