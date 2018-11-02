<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addCustomSalesmanBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delCustomSalesmanBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addCustomSalesmanBtn').bind('click', function(){   
 		 var tr =  $("#add_customSalesman_table_template tr").clone();
	 	 $("#add_customSalesman_table").append(tr);
	 	 resetTrNum('add_customSalesman_table');
	 	 return false;
    });  
	$('#delCustomSalesmanBtn').bind('click', function(){   
      	$("#add_customSalesman_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_customSalesman_table'); 
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
	<a id="addCustomSalesmanBtn" href="#">添加</a> <a id="delCustomSalesmanBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="customSalesman_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						业务员名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						职务
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						电话
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						电子邮件
				  </td>
		          <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
					    提成
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 300px;">
						备注
				  </td>
	</tr>
	<tbody id="add_customSalesman_table">
	<%--<c:if test="${fn:length(customSalesmanList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="customSalesmanList[0].id" type="hidden"/>
					<input name="customSalesmanList[0].fid" type="hidden"/>
				  <td align="left">
					  	<input name="customSalesmanList[0].fname" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">业务员名称</label>
					</td>
				  <td align="left">
					  	<input name="customSalesmanList[0].fpost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">职务</label>
					</td>
				  <td align="left">
					  	<input name="customSalesmanList[0].fphone" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">电话</label>
					</td>
				  <td align="left">
					  	<input name="customSalesmanList[0].femail" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">电子邮件</label>
					</td>
				  <td align="left">
					  	<input name="customSalesmanList[0].fnote" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(customSalesmanList)  > 0 }">--%>
		<c:forEach items="${customSalesmanList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="customSalesmanList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="customSalesmanList[${stuts.index }].fid" type="hidden" value="${poVal.fid }"/>
				   <td align="left">
					  	<input name="customSalesmanList[${stuts.index }].fname" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fname }"/>
					  <label class="Validform_label" style="display: none;">业务员名称</label>
				   </td>
				   <td align="left">
					  	<input name="customSalesmanList[${stuts.index }].fpost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fpost }"/>
					  <label class="Validform_label" style="display: none;">职务</label>
				   </td>
				   <td align="left">
					  	<input name="customSalesmanList[${stuts.index }].fphone" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fphone }"/>
					  <label class="Validform_label" style="display: none;">电话</label>
				   </td>
				   <td align="left">
					  	<input name="customSalesmanList[${stuts.index }].femail" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.femail }"/>
					  <label class="Validform_label" style="display: none;">电子邮件</label>
				   </td>
				   <td align="left">
					    <input name="customSalesmanList[${stuts.index }].fticheng" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fticheng }"/>
					  <label class="Validform_label" style="display: none;">提成</label>
				   </td>
				   <td align="left">
					  	<input name="customSalesmanList[${stuts.index }].fnote" maxlength="255" type="text" class="inputxt"  style="width:300px;"  ignore="ignore"  value="${poVal.fnote }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
   			</tr>
		</c:forEach>
	<%--</c:if>	--%>
	</tbody>
</table>
