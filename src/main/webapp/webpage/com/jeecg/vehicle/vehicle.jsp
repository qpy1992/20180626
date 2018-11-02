<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>预计回程时间</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="vehicleController.do?bind" >
	  	<input id="id" name="id" type="hidden" value="${vtsPage.id}"/>
	  	<input id="vehId" name="vehId" type="hidden" value="${vehId}"/>
		<table style="width: 300px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							挂车号:
						</label>
					</td>
					<td class="value">
						<input id="trailer" name="trailer" placeholder="点击选择" onclick="popupClick(this,'fname,id','trailer,traId','trailer')" class="inputxt" type="text" style="width: 150px"  ignore="ignore" value="${trailer}"/>
						<input id="traId" name="traId" class="inputxt" type="hidden" style="width: 150px"  ignore="ignore" value="${vtsPage.traId}"/>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							司机姓名:
						</label>
					</td>
					<td class="value">
						<input id="siji" name="siji" placeholder="点击选择" onclick="popupClick(this,'fname,id','siji,sijiId','siji')" class="inputxt" type="text" style="width: 150px"  ignore="ignore" value="${siji}"/>
						<input id="sijiId" name="sijiId" class="inputxt" type="hidden" style="width: 150px"  ignore="ignore" value="${vtsPage.sijiId}"/>
					</td>
			</tr>
			</table>
		</t:formvalid>
 </body>
 <script type="text/javascript">
     $(function(){
         $("#trailer").bind('input porpertychange',function(){
            var trailer = $("#trailer").val();
            if(trailer==''){
                $("#traId").val('');
			}
         });
         $("#siji").bind('input porpertychange',function(){
             var siji = $("#siji").val();
             if(siji==''){
                 $("#sijiId").val('');
             }
         });
     })
 </script>
