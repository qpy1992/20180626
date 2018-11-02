<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="vehicleList" checkbox="false" pagination="true" fitColumns="true" title="车辆资料" actionUrl="vehicleController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="car_status"></t:dgCol>
   <t:dgCol title="操作" field="opt" rowspan="2"></t:dgCol>
   <t:dgFunOpt title="绑定情况" funname="binding(id,fcode)"  urlclass="ace_button"  urlStyle="background-color:#ec4758;" urlfont="fa-truck"></t:dgFunOpt>
   <t:dgCol title="代码"  field="fitemid" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="车号"  field="fcarno" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="机动车所有人"  field="fowner" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="登记日期"  field="fregdate" rowspan="2"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="车辆类型"  field="fcartype" rowspan="2"  queryMode="single"  dictionary="cartype"></t:dgCol>
   <t:dgCol title="车辆品牌"  field="fbrand" rowspan="2"  queryMode="single"  dictionary="brand"></t:dgCol>
   <t:dgCol title="车辆型号"  field="fmodel" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="车身颜色"  field="fcolor" rowspan="2"  queryMode="single"  dictionary="color"></t:dgCol>
   <t:dgCol title="车辆识别代号"  field="fidcode" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="国产进口"  field="fimex" rowspan="2"  queryMode="single"  dictionary="imex"></t:dgCol>
   <t:dgCol title="发动机号"  field="fengin" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="发动机型号"  field="fengintype" rowspan="2" queryMode="single"></t:dgCol>
   <t:dgCol title="燃料种类"  field="fuel" rowspan="2"  queryMode="single"  dictionary="fuel"></t:dgCol>
   <t:dgCol title="排量(ml)"  field="fdisplace" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="功率(kw)"  field="fwatt" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="制造厂名称"  field="fmade" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="转向形式"  field="fzhuan" rowspan="2"  queryMode="single"  dictionary="zhuan"></t:dgCol>
   <t:dgCol title="轮距(mm)" colspan="2"></t:dgCol>
   <t:dgCol title="轮胎数"  field="ftyrenum" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="轮胎规格"  field="ftyremodel" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="钢板弹簧片数"  field="ffbthnum" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="轴距(mm)"  field="faxis" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="轴数"  field="faxisnum" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="外廓尺寸(mm)" colspan="3"></t:dgCol>
   <t:dgCol title="总重量(kg)"  field="fweight" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="实际重量(kg)"  field="ftrueweight" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="准牵引质量(kg)"  field="fperweight" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="使用性质"  field="fnature" rowspan="2"  queryMode="single"  dictionary="nature"></t:dgCol>
   <t:dgCol title="运输证号"  field="flog" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="经营范围"  field="fjinying" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="运输证发证日期"  field="fazhengdate" rowspan="2"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="运输证有效日期"  field="fyouxiaodate" rowspan="2"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="整备质量"  field="fzbweight" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="强制报废日期"  field="forcebf" rowspan="2"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="检验有效期"  field="fjydate" rowspan="2"  formatter="yyyy-MM-dd"  queryMode="single"></t:dgCol>
   <t:dgCol title="登记证书"  field="fdjzs" rowspan="2"  queryMode="single"  image="true" imageSize="50,50"></t:dgCol>
   <t:dgCol title="行驶证"  field="fxsz" rowspan="2"  queryMode="single"  image="true" imageSize="50,50"></t:dgCol>
   <t:dgCol title="营运证"  field="fyyz" rowspan="2"  queryMode="single"  image="true" imageSize="50,50"></t:dgCol>
   <t:dgCol title="交强险"  field="fjqx" rowspan="2"  queryMode="single"  image="true" imageSize="50,50"></t:dgCol>
   <t:dgCol title="商业险"  field="fsyx" rowspan="2"  queryMode="single"  image="true" imageSize="50,50"></t:dgCol>
   <t:dgCol title="货物险"  field="fhwx" rowspan="2"  queryMode="single"  image="true" imageSize="50,50"></t:dgCol>
   <t:dgCol title="备注"  field="fnote" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新人"  field="updateName" rowspan="2"  queryMode="single"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" rowspan="2"  formatter="yyyy-MM-dd"  queryMode="single" newColumn="true"></t:dgCol>
   <t:dgCol title="前"  field="flunju1"  queryMode="single"></t:dgCol>
   <t:dgCol title="后"  field="flunju2"  queryMode="single"></t:dgCol>
   <t:dgCol title="长"  field="flength"  queryMode="single"></t:dgCol>
   <t:dgCol title="宽"  field="fwidth"  queryMode="single"></t:dgCol>
   <t:dgCol title="高"  field="fheight"  queryMode="single"></t:dgCol>
   <%--
   <t:dgDelOpt title="删除" url="vehicleController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
   <t:dgToolBar title="录入" icon="icon-add" url="vehicleController.do?goAdd" funname="add" width="900" height="580"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="vehicleController.do?goUpdate" funname="update" width="900" height="580"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="vehicleController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="vehicleController.do?goUpdate" funname="detail" width="900" height="580"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/vehicle/vehicleList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
function binding(id){
    createwindow("绑定情况","vehicleController.do?list1&id="+id,300,200);
}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'vehicleController.do?upload', "vehicleList");
}

//导出
function ExportXls() {
	JeecgExcelExport("vehicleController.do?exportXls","vehicleList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("vehicleController.do?exportXlsByT","vehicleList");
}

 </script>