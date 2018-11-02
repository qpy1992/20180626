$(document).ready(function(){
});



//导入
function ImportXls() {
    openuploadwin('Excel导入', 'mileageController.do?upload', "mileageList");
}

//导出
function ExportXls() {
    JeecgExcelExport("mileageController.do?exportXls","mileageList");
}

//模板下载
function ExportXlsByT() {
    JeecgExcelExport("mileageController.do?exportXlsByT","mileageList");
}