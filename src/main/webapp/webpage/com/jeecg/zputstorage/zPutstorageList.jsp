<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="zPutstorageList" checkbox="true" fitColumns="true" title="入库" actionUrl="zPutstorageController.do?datagrid2" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流水编码"  field="code"  queryMode="single"  ></t:dgCol>
   <t:dgCol title="制单日期"  field="makedate"  formatter="yyyy-MM-dd" queryMode="single" ></t:dgCol>
   <t:dgCol title="制单人"  field="makepeople"  queryMode="single" ></t:dgCol>
   <t:dgCol title="审核人"  field="checkpeople"  queryMode="single"  ></t:dgCol>
   <t:dgCol title="审核日期"  field="checkdate"  formatter="yyyy-MM-dd" queryMode="single"  ></t:dgCol>
<%--    <t:dgCol title="备注"  field="note"  queryMode="single"  width="120"></t:dgCol> --%>
  
  <t:dgCol title="物料代码"  field="wuliocode"  ></t:dgCol>
  <t:dgCol title="物料名称"  field="wulioname"  ></t:dgCol>
  <t:dgCol title="规格型号"  field="specifications"  ></t:dgCol>
  <t:dgCol title="单位"  field="unit"  ></t:dgCol>
  <t:dgCol title="入库数量"  field="rknumber"  ></t:dgCol>
  <t:dgCol title="进价"  field="purchaseprice"  ></t:dgCol>
  <t:dgCol title="进价合计"  field="purchasetotal"  ></t:dgCol>
  <t:dgCol title="售价"  field="saleprice"  ></t:dgCol>
  <t:dgCol title="售价合计"  field="saletotal"  ></t:dgCol>
  <t:dgCol title="采购日期"  field="purchasedate"  ></t:dgCol>
     <t:dgCol title="备注"  field="note"  queryMode="single" ></t:dgCol>
  
  
   <t:dgCol title="操作" field="opt" ></t:dgCol>
   <t:dgDelOpt title="删除" url="zPutstorageController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="zPutstorageController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zPutstorageController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="zPutstorageController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zPutstorageController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
 <%--   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/zputstorage/zPutstorageList.js"></script>		
 <script type="text/javascript">
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zPutstorageController.do?upload', "zPutstorageList");
}

//导出
function ExportXls() {
	JeecgExcelExport("zPutstorageController.do?exportXls","zPutstorageList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("zPutstorageController.do?exportXlsByT","zPutstorageList");
}
 </script>