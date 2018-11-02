<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addCostdetailBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delCostdetailBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addCostdetailBtn').bind('click', function(){   
 		 var tr =  $("#add_costdetail_table_template tr").clone();
	 	 $("#add_costdetail_table").append(tr);
	 	 resetTrNum('add_costdetail_table');
	 	 return false;
    });  
	$('#delCostdetailBtn').bind('click', function(){   
      	$("#add_costdetail_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_costdetail_table'); 
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
	<a id="addCostdetailBtn" href="#">添加</a> <a id="delCostdetailBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="costdetail_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						费用代码
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						费用名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						应收应付
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						费用
				  </td>
	</tr>
	<tbody id="add_costdetail_table">
	<c:if test="${fn:length(costdetailList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="costdetailList[0].id" type="hidden"/>
					<input name="costdetailList[0].fid" type="hidden"/>
				  <td align="left">
					  	<input name="costdetailList[0].fcostcode"  placeholder="点击选择" onclick="popupClick(this,'fee_code,fname','fcostcode,fcost','fee')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">费用代码</label>
					</td>
				  <td align="left">
					  	<input name="costdetailList[0].fcost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">费用名称</label>
					</td>
				  <td align="left">
					  	<%--<input name="costdetailList[0].fyf" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >--%>
						<t:dictSelect field="costdetailList[0].fyf" hasLabel="false" typeGroupCode="shoufu"></t:dictSelect>
						<label class="Validform_label" style="display: none;">收/付</label>
					</td>
				  <td align="left">
					  	<input name="costdetailList[0].fee" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">费用</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(costdetailList)  > 0 }">
		<c:forEach items="${costdetailList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="costdetailList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="costdetailList[${stuts.index }].fid" type="hidden" value="${poVal.fid }"/>
				   <td align="left">
					  	<input name="costdetailList[${stuts.index }].fcostcode"  placeholder="点击选择" onclick="popupClick(this,'fee_code,fname','fcostcode,fcost','fee')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fcostcode }"/>
					  <label class="Validform_label" style="display: none;">费用代码</label>
				   </td>
				   <td align="left">
					  	<input name="costdetailList[${stuts.index }].fcost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fcost }"/>
					  <label class="Validform_label" style="display: none;">费用名称</label>
				   </td>
				   <td align="left">
					  	<%--<input name="costdetailList[${stuts.index }].fyf" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fyf }"/>--%>
						<t:dictSelect field="costdetailList[${stuts.index}].fyf" hasLabel="false" typeGroupCode="shoufu" defaultVal="${poVal.fyf }"></t:dictSelect>
						<label class="Validform_label" style="display: none;">收/付</label>
				   </td>
				   <td align="left">
					  	<input name="costdetailList[${stuts.index }].fee" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fee }"/>
					  <label class="Validform_label" style="display: none;">费用</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
