<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addHetong2Btn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delHetong2Btn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addHetong2Btn').bind('click', function(){   
 		 var tr =  $("#add_hetong2_table_template tr").clone();
	 	 $("#add_hetong2_table").append(tr);
	 	 resetTrNum('add_hetong2_table');
	 	 return false;
    });  
	$('#delHetong2Btn').bind('click', function(){   
      	$("#add_hetong2_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_hetong2_table'); 
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
	<a id="addHetong2Btn" href="#">添加</a> <a id="delHetong2Btn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="hetong2_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						业务类型
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						费用代码
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						费用种类名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						单位
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						单价
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						最小金额
				  </td>
	</tr>
	<tbody id="add_hetong2_table">
	<%--<c:if test="${fn:length(hetong2List)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="hetong2List[0].id" type="hidden"/>
					<input name="hetong2List[0].fid" type="hidden"/>
				  <td align="left">
					  	&lt;%&ndash;<input name="hetong2List[0].ftype" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >&ndash;%&gt;
					  <t:dictSelect field="hetong2List[0].ftype" hasLabel="false" typeGroupCode="buss"></t:dictSelect>
                      <label class="Validform_label" style="display: none;">业务类型</label>
					</td>
				  <td align="left">
					  	<input name="hetong2List[0].fnumber" placeholder="点击选择" onclick="popupClick(this,'fee_code,fname,funit,fdefault_price','fnumber,feeType,funit,fprice','costtype')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">费用代码</label>
					</td>
				  <td align="left">
					  	<input name="hetong2List[0].feeType" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">费用种类名称</label>
					</td>
				  <td align="left">
					  	<input name="hetong2List[0].funit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">单位</label>
					</td>
				  <td align="left">
					  	<input name="hetong2List[0].fprice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">单价</label>
					</td>
				  <td align="left">
					  	<input name="hetong2List[0].fminAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">最小金额</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(hetong2List)  > 0 }">--%>
		<c:forEach items="${hetong2List}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="hetong2List[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="hetong2List[${stuts.index }].fid" type="hidden" value="${poVal.fid }"/>
				   <td align="left">
					  	<%--<input name="hetong2List[${stuts.index }].ftype" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.ftype }"/>--%>
                       <t:dictSelect field="hetong2List[${stuts.index }].ftype" hasLabel="false" typeGroupCode="buss" defaultVal="${poVal.ftype }"></t:dictSelect>
                       <label class="Validform_label" style="display: none;">业务类型</label>
				   </td>
				   <td align="left">
					  	<input name="hetong2List[${stuts.index }].fnumber" placeholder="点击选择" onclick="popupClick(this,'fee_code,fname,funit,fdefault_price','fnumber,feeType,funit,fprice','costtype')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fnumber }"/>
					  <label class="Validform_label" style="display: none;">费用代码</label>
				   </td>
				   <td align="left">
					  	<input name="hetong2List[${stuts.index }].feeType" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.feeType }"/>
					  <label class="Validform_label" style="display: none;">费用种类名称</label>
				   </td>
				   <td align="left">
					  	<input name="hetong2List[${stuts.index }].funit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.funit }"/>
					  <label class="Validform_label" style="display: none;">单位</label>
				   </td>
				   <td align="left">
					  	<input name="hetong2List[${stuts.index }].fprice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.fprice }"/>
					  <label class="Validform_label" style="display: none;">单价</label>
				   </td>
				   <td align="left">
					  	<input name="hetong2List[${stuts.index }].fminAmount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.fminAmount }"/>
					  <label class="Validform_label" style="display: none;">最小金额</label>
				   </td>
   			</tr>
		</c:forEach>
	<%--</c:if>--%>
	</tbody>
</table>
