<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addDpRateBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delDpRateBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addDpRateBtn').bind('click', function(){   
 		 var tr =  $("#add_dpRate_table_template tr").clone();
	 	 $("#add_dpRate_table").append(tr);
	 	 resetTrNum('add_dpRate_table');
	 	 return false;
    });  
	$('#delDpRateBtn').bind('click', function(){   
      	$("#add_dpRate_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_dpRate_table'); 
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
	<a id="addDpRateBtn" href="#">添加</a> <a id="delDpRateBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="dpRate_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						费用种类
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						费用种类名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						箱型
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						费率
				  </td>
	</tr>
	<tbody id="add_dpRate_table">
	<%--<c:if test="${fn:length(dpRateList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="dpRateList[0].id" type="hidden"/>
					<input name="dpRateList[0].fid" type="hidden"/>
				  <td align="left">
					  	<input name="dpRateList[0].feeType" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">费用种类</label>
					</td>
				  <td align="left">
					  	<input name="dpRateList[0].feeTypeName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">费用种类名称</label>
					</td>
				  <td align="left">
					  	<input name="dpRateList[0].fboxType" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">箱型</label>
					</td>
				  <td align="left">
					  	<input name="dpRateList[0].frate" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">费率</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(dpRateList)  > 0 }">--%>
		<c:forEach items="${dpRateList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="dpRateList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="dpRateList[${stuts.index }].fid" type="hidden" value="${poVal.fid }"/>
				   <td align="left">
					  	<input name="dpRateList[${stuts.index }].feeType" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.feeType }"/>
					  <label class="Validform_label" style="display: none;">费用种类</label>
				   </td>
				   <td align="left">
					  	<input name="dpRateList[${stuts.index }].feeTypeName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.feeTypeName }"/>
					  <label class="Validform_label" style="display: none;">费用种类名称</label>
				   </td>
				   <td align="left">
					  	<input name="dpRateList[${stuts.index }].fboxType" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fboxType }"/>
					  <label class="Validform_label" style="display: none;">箱型</label>
				   </td>
				   <td align="left">
					  	<input name="dpRateList[${stuts.index }].frate" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.frate }"/>
					  <label class="Validform_label" style="display: none;">费率</label>
				   </td>
   			</tr>
		</c:forEach>
	<%--</c:if>--%>
    </tbody>
</table>
