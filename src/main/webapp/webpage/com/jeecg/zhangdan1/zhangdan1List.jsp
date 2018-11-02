<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addZhangdan1Btn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delZhangdan1Btn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	/*$('#addZhangdan1Btn').bind('click', function(){
 		 var tr =  $("#add_zhangdan1_table_template tr").clone();
	 	 $("#add_zhangdan1_table").append(tr);
	 	 resetTrNum('add_zhangdan1_table');
	 	 return false;
    });*/
	$('#delZhangdan1Btn').bind('click', function(){   
      	$("#add_zhangdan1_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_zhangdan1_table'); 
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
	<a id="addZhangdan1Btn" href="#" onclick="addfee()">添加</a> <a id="delZhangdan1Btn" href="#">删除</a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="zhangdan1_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 100px;">
						审核
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						委托单号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						费用种类名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						应收
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						结算单位
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						币种
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						单价
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						数量
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						单位
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						提单号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						航名
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						航次
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						作业时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						箱型
				  </td>
	</tr>
	<tbody id="add_zhangdan1_table">
	<%--<c:if test="${fn:length(zhangdan1List)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="zhangdan1List[0].id" type="hidden"/>
					<input name="zhangdan1List[0].createName" type="hidden"/>
					<input name="zhangdan1List[0].createBy" type="hidden"/>
					<input name="zhangdan1List[0].createDate" type="hidden"/>
					<input name="zhangdan1List[0].updateName" type="hidden"/>
					<input name="zhangdan1List[0].updateBy" type="hidden"/>
					<input name="zhangdan1List[0].updateDate" type="hidden"/>
					<input name="zhangdan1List[0].sysOrgCode" type="hidden"/>
					<input name="zhangdan1List[0].sysCompanyCode" type="hidden"/>
					<input name="zhangdan1List[0].bpmStatus" type="hidden"/>
					<input name="zhangdan1List[0].fid" type="hidden"/>
				  <td align="left">
					  	<input name="zhangdan1List[0].fcheck" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">审核</label>
					</td>
				  <td align="left">
					  	<input name="zhangdan1List[0].fweituo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">委托单号</label>
					</td>
				  <td align="left">
					  	<input name="zhangdan1List[0].fcost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">费用种类名称</label>
					</td>
				  <td align="left">
					  	<input name="zhangdan1List[0].frece" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">应收</label>
					</td>
				  <td align="left">
					  	<input name="zhangdan1List[0].fsettle" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">结算单位</label>
					</td>
				  <td align="left">
					  	<input name="zhangdan1List[0].fcurrency" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">币种</label>
					</td>
				  <td align="left">
					  	<input name="zhangdan1List[0].fprice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">单价</label>
					</td>
				  <td align="left">
					  	<input name="zhangdan1List[0].fqty" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">数量</label>
					</td>
				  <td align="left">
					  	<input name="zhangdan1List[0].fjine" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">金额</label>
					</td>
				  <td align="left">
					  	<input name="zhangdan1List[0].funit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">单位</label>
					</td>
				  <td align="left">
					  	<input name="zhangdan1List[0].ftidan" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">提单号</label>
					</td>
				  <td align="left">
					  	<input name="zhangdan1List[0].fshipname" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">航名</label>
					</td>
				  <td align="left">
					  	<input name="zhangdan1List[0].fvoyageno" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">航次</label>
					</td>
				  <td align="left">
					  	<input name="zhangdan1List[0].foperatetime" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">作业时间</label>
					</td>
				  <td align="left">
					  	<input name="zhangdan1List[0].fboxtype" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">箱型</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(zhangdan1List)  > 0 }">--%>
		<c:forEach items="${zhangdan1List}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="zhangdan1List[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="zhangdan1List[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="zhangdan1List[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="zhangdan1List[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="zhangdan1List[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="zhangdan1List[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="zhangdan1List[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="zhangdan1List[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="zhangdan1List[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="zhangdan1List[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
						<input name="zhangdan1List[${stuts.index }].fid" type="hidden" value="${poVal.fid }"/>
						<input name="zhangdan1List[${stuts.index }].costid" type="hidden" value="${poVal.costid }"/>
				   <td align="left">
					  	<input name="zhangdan1List[${stuts.index }].fcheck" maxlength="32" type="text" class="inputxt"  style="width:100px;"  ignore="ignore"  value="${poVal.fcheck }"/>
					  <label class="Validform_label" style="display: none;">审核</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdan1List[${stuts.index }].fweituo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fweituo }"/>
					  <label class="Validform_label" style="display: none;">委托单号</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdan1List[${stuts.index }].fcost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fcost }"/>
					  <label class="Validform_label" style="display: none;">费用种类名称</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdan1List[${stuts.index }].frece" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.frece }"/>
					  <label class="Validform_label" style="display: none;">应收</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdan1List[${stuts.index }].fsettle" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fsettle }"/>
					  <label class="Validform_label" style="display: none;">结算单位</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdan1List[${stuts.index }].fcurrency" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fcurrency }"/>
					  <label class="Validform_label" style="display: none;">币种</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdan1List[${stuts.index }].fprice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.fprice }"/>
					  <label class="Validform_label" style="display: none;">单价</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdan1List[${stuts.index }].fqty" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.fqty }"/>
					  <label class="Validform_label" style="display: none;">数量</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdan1List[${stuts.index }].fjine" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.fjine }"/>
					  <label class="Validform_label" style="display: none;">金额</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdan1List[${stuts.index }].funit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.funit }"/>
					  <label class="Validform_label" style="display: none;">单位</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdan1List[${stuts.index }].ftidan" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.ftidan }"/>
					  <label class="Validform_label" style="display: none;">提单号</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdan1List[${stuts.index }].fshipname" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fshipname }"/>
					  <label class="Validform_label" style="display: none;">航名</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdan1List[${stuts.index }].fvoyageno" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fvoyageno }"/>
					  <label class="Validform_label" style="display: none;">航次</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdan1List[${stuts.index }].foperatetime" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.foperatetime }"/>
					  <label class="Validform_label" style="display: none;">作业时间</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdan1List[${stuts.index }].fboxtype" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.fboxtype }"/>
					  <label class="Validform_label" style="display: none;">箱型</label>
				   </td>
   			</tr>
		</c:forEach>
	<%--</c:if>--%>
	</tbody>
</table>
