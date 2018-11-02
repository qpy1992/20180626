<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addCostCombinationBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delCostCombinationBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addCostCombinationBtn').bind('click', function(){   
 		 var tr =  $("#add_costCombination_table_template tr").clone();
	 	 $("#add_costCombination_table").append(tr);
	 	 resetTrNum('add_costCombination_table');
	 	 return false;
    });  
	$('#delCostCombinationBtn').bind('click', function(){   
      	$("#add_costCombination_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_costCombination_table'); 
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
	<a id="addCostCombinationBtn" href="#">添加</a> <a id="delCostCombinationBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="costCombination_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						提箱点
				  </td>
				  <%--<td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						进口码头
				  </td>--%>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						装货门点
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						卸货门点
				  </td>
				  <%--<td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						出口码头
				  </td>--%>
                  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
                        还箱点
                  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						费用
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						含税费用
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						税率
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						开始时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 226px;">
						备注
				  </td>
	</tr>
	<tbody id="add_costCombination_table">
	<%--<c:if test="${fn:length(costCombinationList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="costCombinationList[0].id" type="hidden"/>
					<input name="costCombinationList[0].fid" type="hidden"/>
				  <td align="left">
					  	<input name="costCombinationList[0].ftxyard" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">提箱堆场</label>
					</td>
				  <td align="left">
					  	<input name="costCombinationList[0].fimport" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">进口码头</label>
					</td>
				  <td align="left">
					  	<input name="costCombinationList[0].fload" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">装货门点</label>
					</td>
				  <td align="left">
					  	<input name="costCombinationList[0].fdischarge" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">卸货门点</label>
					</td>
				  <td align="left">
					  	<input name="costCombinationList[0].fexport" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">出口码头</label>
					</td>
				  <td align="left">
					  	<input name="costCombinationList[0].fcost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">费用</label>
					</td>
				  <td align="left">
					  	<input name="costCombinationList[0].fhscost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">含税费用</label>
					</td>
				  <td align="left">
					  	<input name="costCombinationList[0].frate" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">税率</label>
					</td>
				  <td align="left">
					  	<input name="costCombinationList[0].fstart" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">开始时间</label>
					</td>
				  <td align="left">
					  	<input name="costCombinationList[0].fnote" maxlength="255" type="text" class="inputxt"  style="width:220px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(costCombinationList)  > 0 }">--%>
		<c:forEach items="${costCombinationList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="costCombinationList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="costCombinationList[${stuts.index }].fid" type="hidden" value="${poVal.fid }"/>
				   <td align="left">
                       <input name="costCombinationList[${stuts.index }].ftxyard" onclick="popupClick(this,'fyard_name,id','ftxyard,ftxid','yard')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.ftxyard }"/>
                       <input name="costCombinationList[${stuts.index }].ftxid" hidden="hidden" maxlength="32" type="text" class="inputxt"  style="width:120px;display: none"  ignore="ignore"  value="${poVal.ftxid }"/>
					  <label class="Validform_label" style="display: none;">提箱点</label>
				   </td>
				   <%--<td align="left">
                       <input name="costCombinationList[${stuts.index }].fimport" onclick="popupClick(this,'fyard_name,id','fimport,fimportid','quay')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fimport }"/>
                       <input name="costCombinationList[${stuts.index }].fimportid" hidden="hidden" maxlength="32" type="text" class="inputxt"  style="width:120px;display: none"  ignore="ignore"  value="${poVal.fimportid }"/>
					  <label class="Validform_label" style="display: none;">进口码头</label>
				   </td>--%>
				   <td align="left">
                       <input name="costCombinationList[${stuts.index }].fload" onclick="popupClick(this,'fname,id','fload,floadid','dp_select')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fload }"/>
                       <input name="costCombinationList[${stuts.index }].floadid" hidden="hidden" maxlength="32" type="text" class="inputxt"  style="width:120px;display: none"  ignore="ignore"  value="${poVal.floadid }"/>
					  <label class="Validform_label" style="display: none;">装货门点</label>
				   </td>
				   <td align="left">
                       <input name="costCombinationList[${stuts.index }].fdischarge" onclick="popupClick(this,'fname,id','fdischarge,fdischargeid','dp_select')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fdischarge }"/>
                       <input name="costCombinationList[${stuts.index }].fdischargeid" hidden="hidden" maxlength="32" type="text" class="inputxt"  style="width:120px;display: none"  ignore="ignore"  value="${poVal.fdischargeid }"/>
					  <label class="Validform_label" style="display: none;">卸货门点</label>
				   </td>
				   <%--<td align="left">
                       <input name="costCombinationList[${stuts.index }].fexport" onclick="popupClick(this,'fyard_name,id','fexport,fexportid','quay')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fexport }"/>
                       <input name="costCombinationList[${stuts.index }].fexportid" hidden="hidden" maxlength="32" type="text" class="inputxt"  style="width:120px;display: none"  ignore="ignore"  value="${poVal.fexportid }"/>
					  <label class="Validform_label" style="display: none;">出口码头</label>
				   </td>--%>
                   <td align="left">
                        <input name="costCombinationList[${stuts.index }].fhxyard" onclick="popupClick(this,'fyard_name,id','fhxyard,fhxid','yard')" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fhxyard }"/>
                        <input name="costCombinationList[${stuts.index }].fhxid" hidden="hidden" maxlength="32" type="text" class="inputxt"  style="width:120px;display: none"  ignore="ignore"  value="${poVal.fhxid }"/>
                        <label class="Validform_label" style="display: none;">还箱点</label>
                   </td>
				   <td align="left">
					  	<input name="costCombinationList[${stuts.index }].fcost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.fcost }"/>
					  <label class="Validform_label" style="display: none;">费用</label>
				   </td>
				   <td align="left">
                       <input name="costCombinationList[${stuts.index }].fhscost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.fhscost }"/>
					  <label class="Validform_label" style="display: none;">含税费用</label>
				   </td>
				   <td align="left">
                       <input name="costCombinationList[${stuts.index }].frate" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.frate }"/>
					  <label class="Validform_label" style="display: none;">税率</label>
				   </td>
				   <td align="left">
                       <input name="costCombinationList[${stuts.index }].fstart" maxlength="32" type="text" class="Wdate"  onClick="WdatePicker()"  style="width:120px;"  ignore="ignore"  value='<fmt:formatDate value='${poVal.fstart }' type="date" pattern="yyyy-MM-dd"/>'/>
					  <label class="Validform_label" style="display: none;">开始时间</label>
				   </td>
				   <td align="left">
                       <input name="costCombinationList[${stuts.index }].fnote" maxlength="255" type="text" class="inputxt"  style="width:220px;"  ignore="ignore"  value="${poVal.fnote }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
   			</tr>
		</c:forEach>
	<%--</c:if>--%>
	</tbody>
</table>
