<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addDpBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delDpBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	// $('#addDpBtn').bind('click', function(){
 	// 	 var tr =  $("#add_dp_table_template tr").clone();
	//  	 $("#add_dp_table").append(tr);
	//  	 resetTrNum('add_dp_table');
	//  	 return false;
    // });
	$('#delDpBtn').bind('click', function(){   
      	$("#add_dp_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_dp_table'); 
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
	<a id="addDpBtn" href="#" onclick="fun_tevl(this)">添加</a> <a id="delDpBtn" href="#">删除</a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="dp_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						门点代码
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						门点名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						联系人
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						电话
				  </td>
	</tr>
	<tbody id="add_dp_table">
	<%--<c:if test="${fn:length(dpList) <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="dpList[0].id" type="hidden"/>
					<input name="dpList[0].fid" type="hidden"/>
				  <td align="left">
							 <input  id="dpList[0].fitemid" name="dpList[0].fitemid" type="text" style="width: 150px" class="searchbox-inputtext"  value="${poVal.fitemid }"   ignore="ignore" /> 			 
					  <label class="Validform_label" style="display: none;">门点代码</label>
					</td>
				  <td align="left">
					  	<input name="dpList[0].fname" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">门点名称</label>
					</td>
				  <td align="left">
					  	<input name="dpList[0].fcontact" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">联系人</label>
					</td>
				  <td align="left">
					  	<input name="dpList[0].fphone" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">电话</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(dpList)  > 0 }">--%>
		<c:forEach items="${dpList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="dpList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="dpList[${stuts.index }].fid" type="hidden" value="${poVal.fid }"/>
				   <td align="left">
							 <input  id="dpList[${stuts.index }].fitemid" name="dpList[${stuts.index }].fitemid"  type="text" style="width: 150px" class="searchbox-inputtext"   ignore="ignore"     value="${poVal.fitemid }" /> 			 
					  <label class="Validform_label" style="display: none;">门点代码</label>
				   </td>
				   <td align="left">
					  	<input name="dpList[${stuts.index }].fname" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fname }"/>
					  <label class="Validform_label" style="display: none;">门点名称</label>
				   </td>
				   <td align="left">
					  	<input name="dpList[${stuts.index }].fcontact" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fcontact }"/>
					  <label class="Validform_label" style="display: none;">联系人</label>
				   </td>
				   <td align="left">
					  	<input name="dpList[${stuts.index }].fphone" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fphone }"/>
					  <label class="Validform_label" style="display: none;">电话</label>
				   </td>
   			</tr>
		</c:forEach>
	<%--</c:if>--%>
	</tbody>
</table>
