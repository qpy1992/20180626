<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="hexiaoList" checkbox="false" pagination="true" fitColumns="true" title="费用核销" actionUrl="hexiaoController.do?datagrid1&type=${type}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  dictionary="bpm_status"></t:dgCol>
   <t:dgCol title="核销状态" field="fhx" dictionary="sf_yn" rowspan="2"></t:dgCol>
   <t:dgCol title="本次核销" colspan="3"></t:dgCol>
   <t:dgCol title="费用原信息" colspan="8"></t:dgCol>
   <t:dgCol title="业务信息" colspan="5" newColumn="true"></t:dgCol>
   <t:dgCol title="核销金额"  field="fhxamount" extendParams="editor:'numberbox'"></t:dgCol>
   <t:dgCol title="本次余额"  field="fbcamount" extendParams="editor:'numberbox'"></t:dgCol>
   <t:dgCol title="实际收付金额"  field="factualamount" extendParams="editor:'numberbox'"></t:dgCol>
   <t:dgCol title="结算单位"  field="fsettlename" query="true"></t:dgCol>
   <t:dgCol title="费用种类"  field="fcostname"></t:dgCol>
   <t:dgCol title="金额"  field="famount"></t:dgCol>
   <t:dgCol title="实际金额"  field="fsfamount"></t:dgCol>
   <t:dgCol title="代垫"  field="fdd" dictionary="sf_yn"></t:dgCol>
   <%--<t:dgCol title="约号"  field="fyuehao"></t:dgCol>--%>
   <t:dgCol title="备注"  field="fnote"></t:dgCol>
   <t:dgCol title="发票号"  field="ffapiao" query="true"></t:dgCol>
   <t:dgCol title="审核"  field="fcheck" dictionary="check"></t:dgCol>
   <%--<t:dgCol title="额定金额"  field="feding"></t:dgCol>--%>
   <t:dgCol title="委托号"  field="fweituo"></t:dgCol>
   <t:dgCol title="委托单位"  field="entrust" query="true"></t:dgCol>
   <t:dgCol title="派车单号"  field="fpaiche" query="true"></t:dgCol>
   <t:dgCol title="司机"  field="fdriver" query="true" hidden="true"></t:dgCol>
   <t:dgCol title="提单号"  field="fblno" query="true"></t:dgCol>
   <t:dgCol title="箱号"  field="fboxno" query="true"></t:dgCol>
   <t:dgToolBar operationCode="edit" title="编辑" icon="icon-edit" onclick="editRow()"></t:dgToolBar>
   <t:dgToolBar operationCode="save" title="保存" icon="icon-save" url="hexiaoController.do?saveRows" funname="saveData"></t:dgToolBar>
   <t:dgToolBar operationCode="undo" title="取消编辑" icon="icon-undo" funname="reject"></t:dgToolBar>
   <%--<t:dgToolBar title="录入" icon="icon-add" url="hexiaoController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="hexiaoController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="hexiaoController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="hexiaoController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/hexiao/hexiaoList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });

//导入
function ImportXls() {
	openuploadwin('Excel导入', 'hexiaoController.do?upload', "hexiaoList");
}

//导出
function ExportXls() {
	JeecgExcelExport("hexiaoController.do?exportXls","hexiaoList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("hexiaoController.do?exportXlsByT","hexiaoList");
}

 //保存数据
 function saveData(title,addurl,gname){
     if(!endEdit(gname))
         return false;
     // var rows=$('#'+gname).datagrid("getChanges","inserted");
     var uprows=$('#'+gname).datagrid("getChanges","updated");
     // rows=rows.concat(uprows);
     if(uprows.length<=0){
         tip("没有需要保存的数据！")
         return false;
     }
     var result=[];
     for(var i=0;i<uprows.length;i++){
         var id = uprows[i].id;
         var hx = uprows[i].fhxamount;
         var ye = uprows[i].fbcamount;
         var sj = uprows[i].factualamount;
         result.push(id+'/'+hx+'/'+ye+'/'+sj);
     }
     $.ajax({
         url:"<%=basePath%>/"+addurl,
         type:"post",
         data:'result='+result,
         dataType:"json",
         success:function(data){
             tip(data.msg);
             if(data.success){
                 reloadTable();
             }
         }
     })
 }
 //结束编辑
 function endEdit(gname){
     var  editIndex = $('#'+gname).datagrid('getRows').length-1;
     for(var i=0;i<=editIndex;i++){
         if($('#'+gname).datagrid('validateRow', i)){
             $('#'+gname).datagrid('endEdit', i);
         }else{

             tip("请选择必填项(带有红色三角形状的字段)!");

             return false;
         }
     }
     return true;
 }
 //编辑行
 function editRow(){
     var rows=$('#hexiaoList').datagrid("getChecked");
     if(rows.length==0){
         tip("请选择条目");
         return false;
     }
     for(var i=0;i<rows.length;i++){
         var index= $('#hexiaoList').datagrid('getRowIndex', rows[i]);
         $('#hexiaoList').datagrid('beginEdit', index);
     }
 }

 //取消编辑
 function reject(title,addurl,gname){
     $('#'+gname).datagrid('clearChecked');
     $('#'+gname).datagrid('rejectChanges');

 }
 </script>