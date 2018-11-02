<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="vehicleList1" checkbox="false" pagination="true" fitColumns="true" title="车辆资料" actionUrl="vehicleController.do?datagrid1"
              idField="id" fit="true" queryMode="group" onDblClick="yuji">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="car_status"  width="120"></t:dgCol>
   <t:dgCol title="代码"  field="fitemid"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="车牌号"  field="fcarno"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="车头重量"  field="fweight"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="司机"  field="fdriver"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="挂车号"  field="ftrailer"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="挂车重量"  field="fweight1"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="总重量"  field="ftotal"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="预计回程时间"  field="fbacktime"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt"></t:dgCol>
   <t:dgFunOpt title="修改绑定" funname="bind(id)"  urlclass="ace_button" urlfont="fa-edit"></t:dgFunOpt>
   <%--<t:dgFunOpt title="派车" funname="yuji"  urlclass="ace_button"  urlStyle="background-color:#ec4758;" urlfont="fa-truck"></t:dgFunOpt>--%>
  </t:datagrid>
  </div>
 </div>
<script type="text/javascript">

    Date.prototype.Format = function(fmt)
    { //author: meizz   
        var o = {
            "M+" : this.getMonth()+1,                 //月份   
            "d+" : this.getDate(),                    //日   
            "h+" : this.getHours(),                   //小时   
            "m+" : this.getMinutes(),                 //分   
            "s+" : this.getSeconds(),                 //秒   
            "q+" : Math.floor((this.getMonth()+3)/3), //季度   
            "S"  : this.getMilliseconds()             //毫秒   
        };
        if(/(y+)/.test(fmt))
            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
        for(var k in o)
            if(new RegExp("("+ k +")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        return fmt;
    }

 function yuji() {
     var vehId = $('#vehicleList1').datagrid('getSelected').id;
     var d = new Date().Format("yyyy-MM-dd hh:mm:ss");
     var fdriver = $('#vehicleList1').datagrid('getSelected').fdriver;
     var ftrailer = $('#vehicleList1').datagrid('getSelected').ftrailer;
     var fbacktime = $('#vehicleList1').datagrid('getSelected').fbacktime;
     if(fdriver==null){
         tip('未指派司机，无法排班！');
         return;
     }
     if(ftrailer==null){
         tip('未绑定挂车，无法排班！');
         return;
     }
     if(fbacktime!=null) {
         fbacktime = fbacktime.substr(0, fbacktime.length - 2);
         if (fbacktime > d) {
             tip('车辆还未回程，无法排班');
             return;
         }
     }
     createwindow('预计回程时间','paibanController.do?paiban1&contianerId=${contianerId}&entrustId=${entrustId}&vehId='+vehId,300,200);
 }

 function bind(id) {
     createwindow("绑定情况","vehicleController.do?list1&id="+id,300,200);
 }
</script>