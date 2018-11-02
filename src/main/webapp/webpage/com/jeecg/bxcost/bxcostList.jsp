<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBxcostBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBxcostBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	/*$('#addBxcostBtn').bind('click', function(){
 		 var tr =  $("#add_bxcost_table_template tr").clone();
	 	 $("#add_bxcost_table").append(tr);
	 	 resetTrNum('add_bxcost_table');
	 	 return false;
    });*/
	$('#delBxcostBtn').bind('click', function(){   
      	$("#add_bxcost_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_bxcost_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addBxcostBtn" href="#" onclick="addfee()">添加</a> <a id="delBxcostBtn" href="#">删除</a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="bxcost_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						委托单号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						提单号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						费用种类
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						结算单位代码
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						结算单位名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						派车单号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						箱号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						收付金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						代垫
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						附加说明
				  </td>
	</tr>
	<tbody id="add_bxcost_table">
	<%--<c:if test="${fn:length(bxcostList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="bxcostList[0].id" type="hidden"/>
					<input name="bxcostList[0].createName" type="hidden"/>
					<input name="bxcostList[0].createBy" type="hidden"/>
					<input name="bxcostList[0].createDate" type="hidden"/>
					<input name="bxcostList[0].updateName" type="hidden"/>
					<input name="bxcostList[0].updateBy" type="hidden"/>
					<input name="bxcostList[0].updateDate" type="hidden"/>
					<input name="bxcostList[0].sysOrgCode" type="hidden"/>
					<input name="bxcostList[0].sysCompanyCode" type="hidden"/>
					<input name="bxcostList[0].bpmStatus" type="hidden"/>
					<input name="bxcostList[0].fid" type="hidden"/>
				  <td align="left">
					  	<input name="bxcostList[0].fweituo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">委托单号</label>
					</td>
				  <td align="left">
					  	<input name="bxcostList[0].fbrno" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">提单号</label>
					</td>
				  <td align="left">
					  	<input name="bxcostList[0].fcost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">费用种类</label>
					</td>
				  <td align="left">
					  	<input name="bxcostList[0].fsettle" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">结算单位代码</label>
					</td>
				  <td align="left">
					  	<input name="bxcostList[0].fsettlename" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">结算单位名称</label>
					</td>
				  <td align="left">
					  	<input name="bxcostList[0].fpaiche" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">派车单号</label>
					</td>
				  <td align="left">
					  	<input name="bxcostList[0].fboxno" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">箱号</label>
					</td>
				  <td align="left">
					  	<input name="bxcostList[0].famount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">金额</label>
					</td>
				  <td align="left">
					  	<input name="bxcostList[0].fsfamount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">收付金额</label>
					</td>
				  <td align="left">
					  	<input name="bxcostList[0].fdaidian" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">代垫</label>
					</td>
				  <td align="left">
					  	<input name="bxcostList[0].finstruction" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">附加说明</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(bxcostList)  > 0 }">--%>
		<c:forEach items="${bxcostList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="bxcostList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="bxcostList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="bxcostList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="bxcostList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="bxcostList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="bxcostList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="bxcostList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="bxcostList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="bxcostList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="bxcostList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
						<input name="bxcostList[${stuts.index }].fid" type="hidden" value="${poVal.fid }"/>
						<input name="bxcostList[${stuts.index }].costid" type="hidden" value="${poVal.costid }"/>
				   <td align="left">
					  	<input name="bxcostList[${stuts.index }].fweituo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" readonly="readonly"  value="${poVal.fweituo }"/>
					  <label class="Validform_label" style="display: none;">委托单号</label>
				   </td>
				   <td align="left">
					  	<input name="bxcostList[${stuts.index }].fbrno" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" readonly="readonly"  value="${poVal.fbrno }"/>
					  <label class="Validform_label" style="display: none;">提单号</label>
				   </td>
				   <td align="left">
					  	<input name="bxcostList[${stuts.index }].fcost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" readonly="readonly"  value="${poVal.fcost }"/>
					  <label class="Validform_label" style="display: none;">费用种类</label>
				   </td>
				   <td align="left">
					  	<input name="bxcostList[${stuts.index }].fsettle" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" readonly="readonly"  value="${poVal.fsettle }"/>
					  <label class="Validform_label" style="display: none;">结算单位代码</label>
				   </td>
				   <td align="left">
					  	<input name="bxcostList[${stuts.index }].fsettlename" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" readonly="readonly"  value="${poVal.fsettlename }"/>
					  <label class="Validform_label" style="display: none;">结算单位名称</label>
				   </td>
				   <td align="left">
					  	<input name="bxcostList[${stuts.index }].fpaiche" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" readonly="readonly"  value="${poVal.fpaiche }"/>
					  <label class="Validform_label" style="display: none;">派车单号</label>
				   </td>
				   <td align="left">
					  	<input name="bxcostList[${stuts.index }].fboxno" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" readonly="readonly"  value="${poVal.fboxno }"/>
					  <label class="Validform_label" style="display: none;">箱号</label>
				   </td>
				   <td align="left">
					  	<input name="bxcostList[${stuts.index }].famount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" readonly="readonly"  value="${poVal.famount }"/>
					  <label class="Validform_label" style="display: none;">金额</label>
				   </td>
				   <td align="left">
					  	<input name="bxcostList[${stuts.index }].fsfamount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.fsfamount }"/>
					  <label class="Validform_label" style="display: none;">收付金额</label>
				   </td>
				   <td align="left">
                       <%--<t:dictSelect field="bxcostList[${stuts.index }].fdaidian" hasLabel="false" typeGroupCode="sf_yn" readonly="readonly" defaultVal="${poVal.fdaidian }"></t:dictSelect>--%>
                       <input name="bxcostList[${stuts.index }].fdaidain" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" readonly="readonly"  value="${poVal.fdaidian }"/>
                       <label class="Validform_label" style="display: none;">代垫</label>
				   </td>
				   <td align="left">
					  	<input name="bxcostList[${stuts.index }].finstruction" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" readonly="readonly"  value="${poVal.finstruction }"/>
					  <label class="Validform_label" style="display: none;">附加说明</label>
				   </td>
   			</tr>
		</c:forEach>
	<%--</c:if>--%>
	</tbody>
</table>

