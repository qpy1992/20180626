<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addContactBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delContactBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addContactBtn').bind('click', function(){   
 		 var tr =  $("#add_contact_table_template tr").clone();
	 	 $("#add_contact_table").append(tr);
	 	 resetTrNum('add_contact_table');
	 	 return false;
    });  
	$('#delContactBtn').bind('click', function(){   
      	$("#add_contact_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_contact_table'); 
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
	<a id="addContactBtn" href="#">添加</a> <a id="delContactBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="contact_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						联系人名
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						默认
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						性别
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						电话
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						手机
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						传真
				  </td>
	</tr>
	<tbody id="add_contact_table">
	<c:if test="${fn:length(contactList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="contactList[0].id" type="hidden"/>
					<input name="contactList[0].fid" type="hidden"/>
				  <td align="left">
					  	<input name="contactList[0].fcontactName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">联系人名</label>
					</td>
				  <td align="left">
					  	<input name="contactList[0].fdefault" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">默认</label>
					</td>
				  <td align="left">
					  	<input name="contactList[0].fgender" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">性别</label>
					</td>
				  <td align="left">
					  	<input name="contactList[0].fphone" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">电话</label>
					</td>
				  <td align="left">
					  	<input name="contactList[0].fmobile" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">手机</label>
					</td>
				  <td align="left">
					  	<input name="contactList[0].fax" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">传真</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(contactList)  > 0 }">
		<c:forEach items="${contactList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="contactList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="contactList[${stuts.index }].fid" type="hidden" value="${poVal.fid }"/>
				   <td align="left">
					  	<input name="contactList[${stuts.index }].fcontactName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fcontactName }"/>
					  <label class="Validform_label" style="display: none;">联系人名</label>
				   </td>
				   <td align="left">
					  	<input name="contactList[${stuts.index }].fdefault" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fdefault }"/>
					  <label class="Validform_label" style="display: none;">默认</label>
				   </td>
				   <td align="left">
					  	<input name="contactList[${stuts.index }].fgender" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fgender }"/>
					  <label class="Validform_label" style="display: none;">性别</label>
				   </td>
				   <td align="left">
					  	<input name="contactList[${stuts.index }].fphone" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fphone }"/>
					  <label class="Validform_label" style="display: none;">电话</label>
				   </td>
				   <td align="left">
					  	<input name="contactList[${stuts.index }].fmobile" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fmobile }"/>
					  <label class="Validform_label" style="display: none;">手机</label>
				   </td>
				   <td align="left">
					  	<input name="contactList[${stuts.index }].fax" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fax }"/>
					  <label class="Validform_label" style="display: none;">传真</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>
	</tbody>
</table>
