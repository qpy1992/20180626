<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addCustomContactsBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delCustomContactsBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addCustomContactsBtn').bind('click', function(){   
 		 var tr =  $("#add_customContacts_table_template tr").clone();
	 	 $("#add_customContacts_table").append(tr);
	 	 resetTrNum('add_customContacts_table');
	 	 return false;
    });  
	$('#delCustomContactsBtn').bind('click', function(){   
      	$("#add_customContacts_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_customContacts_table'); 
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
	<a id="addCustomContactsBtn" href="#">添加</a> <a id="delCustomContactsBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="customContacts_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						联系人名
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
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						邮箱
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						职位
				  </td>
                  <td align="left" bgcolor="#EEEEEE" style="width: 226px;">
                        备注
                  </td>
	</tr>
	<tbody id="add_customContacts_table">
	<%--<c:if test="${fn:length(customContactsList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="customContactsList[0].id" type="hidden"/>
					<input name="customContactsList[0].fid" type="hidden"/>
				  <td align="left">
					  	<input name="customContactsList[0].fcontactsName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">联系人名</label>
					</td>
				  <td align="left">
					  	<input name="customContactsList[0].fgender" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">性别</label>
					</td>
				  <td align="left">
					  	<input name="customContactsList[0].fphone" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">电话</label>
					</td>
				  <td align="left">
					  	<input name="customContactsList[0].fmobile" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		datatype="m" ignore="ignore" >
					  <label class="Validform_label" style="display: none;">手机</label>
					</td>
				  <td align="left">
					  	<input name="customContactsList[0].fax" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">传真</label>
					</td>
				  <td align="left">
					  	<input name="customContactsList[0].femail" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		datatype="e" ignore="ignore" >
					  <label class="Validform_label" style="display: none;">邮箱</label>
					</td>
				  <td align="left">
					  	<input name="customContactsList[0].fnote" maxlength="255" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
				  <td align="left">
							<t:dictSelect field="customContactsList[0].fposition" type="list"   typeGroupCode="position"  defaultVal="${customContactsPage.fposition}" hasLabel="false"  title="职位"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">职位</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(customContactsList)  > 0 }">--%>
		<c:forEach items="${customContactsList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="customContactsList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="customContactsList[${stuts.index }].fid" type="hidden" value="${poVal.fid }"/>
				   <td align="left">
					  	<input name="customContactsList[${stuts.index }].fcontactsName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fcontactsName }"/>
					  <label class="Validform_label" style="display: none;">联系人名</label>
				   </td>
				   <td align="left">
					   <t:dictSelect field="customContactsList[${stuts.index }].fgender" hasLabel="false" typeGroupCode="sex" defaultVal="${poVal.fgender }"></t:dictSelect>
                       <label class="Validform_label" style="display: none;">性别</label>
				   </td>
				   <td align="left">
					  	<input name="customContactsList[${stuts.index }].fphone" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fphone }"/>
					  <label class="Validform_label" style="display: none;">电话</label>
				   </td>
				   <td align="left">
					  	<input name="customContactsList[${stuts.index }].fmobile" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		datatype="m" ignore="ignore"  value="${poVal.fmobile }"/>
					  <label class="Validform_label" style="display: none;">手机</label>
				   </td>
				   <td align="left">
					  	<input name="customContactsList[${stuts.index }].fax" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fax }"/>
					  <label class="Validform_label" style="display: none;">传真</label>
				   </td>
				   <td align="left">
					  	<input name="customContactsList[${stuts.index }].femail" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		datatype="e" ignore="ignore"  value="${poVal.femail }"/>
					  <label class="Validform_label" style="display: none;">邮箱</label>
				   </td>
				   <td align="left">
                       <t:dictSelect field="customContactsList[${stuts.index }].fposition" type="list"   typeGroupCode="position"  defaultVal="${poVal.fposition }" hasLabel="false"  title="职位"></t:dictSelect>
					  <label class="Validform_label" style="display: none;">职位</label>
				   </td>
                   <td align="left">
                        <input name="customContactsList[${stuts.index }].fnote" maxlength="255" type="text" class="inputxt"  style="width:220px;"  ignore="ignore"  value="${poVal.fnote }"/>
                        <label class="Validform_label" style="display: none;">备注</label>
                   </td>
   			</tr>
		</c:forEach>
	<%--</c:if>--%>
	</tbody>
</table>
