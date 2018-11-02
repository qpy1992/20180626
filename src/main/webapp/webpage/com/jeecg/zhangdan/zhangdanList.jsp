<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addZhangdanBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delZhangdanBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	/*$('#addZhangdanBtn').bind('click', function(){
 		 var tr =  $("#add_zhangdan_table_template tr").clone();
	 	 $("#add_zhangdan_table").append(tr);
	 	 resetTrNum('add_zhangdan_table');
	 	 return false;
    });*/
	$('#delZhangdanBtn').bind('click', function(){   
      	$("#add_zhangdan_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_zhangdan_table'); 
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
	<a id="addZhangdanBtn" href="#" onclick="addfee()">添加</a> <a id="delZhangdanBtn" href="#">删除</a>
</div>
<table border="0" cellpadding="2" cellspacing="0" id="zhangdan_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 50px;">
						审核
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						委托单号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						费用种类名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						应收
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						结算单位
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						币种
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						单价
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						数量
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						单位
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						提单号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						航名
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						航次
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						作业时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 106px;">
						箱型
				  </td>
	</tr>
	<tbody id="add_zhangdan_table">
	<%--<c:if test="${fn:length(zhangdanList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="zhangdanList[0].id" type="hidden"/>
					<input name="zhangdanList[0].createName" type="hidden"/>
					<input name="zhangdanList[0].createBy" type="hidden"/>
					<input name="zhangdanList[0].createDate" type="hidden"/>
					<input name="zhangdanList[0].updateName" type="hidden"/>
					<input name="zhangdanList[0].updateBy" type="hidden"/>
					<input name="zhangdanList[0].updateDate" type="hidden"/>
					<input name="zhangdanList[0].sysOrgCode" type="hidden"/>
					<input name="zhangdanList[0].sysCompanyCode" type="hidden"/>
					<input name="zhangdanList[0].bpmStatus" type="hidden"/>
					<input name="zhangdanList[0].fid" type="hidden"/>
				  <td align="left">
					  	<input name="zhangdanList[0].fcheck" maxlength="32" type="text" class="inputxt"  style="width:100px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">审核</label>
					</td>
				  <td align="left">
					  	<input name="zhangdanList[0].fweituo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">委托单号</label>
					</td>
				  <td align="left">
					  	<input name="zhangdanList[0].fcost" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">费用种类名称</label>
					</td>
				  <td align="left">
					  	<input name="zhangdanList[0].frece" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">应收</label>
					</td>
				  <td align="left">
					  	<input name="zhangdanList[0].fsettle" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">结算单位</label>
					</td>
				  <td align="left">
					  	<input name="zhangdanList[0].fcurrency" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">币种</label>
					</td>
				  <td align="left">
					  	<input name="zhangdanList[0].fprice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">单价</label>
					</td>
				  <td align="left">
					  	<input name="zhangdanList[0].fqty" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">数量</label>
					</td>
				  <td align="left">
					  	<input name="zhangdanList[0].fjine" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">金额</label>
					</td>
				  <td align="left">
					  	<input name="zhangdanList[0].funit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">单位</label>
					</td>
				  <td align="left">
					  	<input name="zhangdanList[0].ftidan" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">提单号</label>
					</td>
				  <td align="left">
					  	<input name="zhangdanList[0].fshipname" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">航名</label>
					</td>
				  <td align="left">
					  	<input name="zhangdanList[0].fvoyageno" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">航次</label>
					</td>
				  <td align="left">
					  	<input name="zhangdanList[0].foperatetime" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">作业时间</label>
					</td>
				  <td align="left">
					  	<input name="zhangdanList[0].fboxtype" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">箱型</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(zhangdanList)  > 0 }">--%>
		<c:forEach items="${zhangdanList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="zhangdanList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="zhangdanList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="zhangdanList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="zhangdanList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="zhangdanList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="zhangdanList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="zhangdanList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="zhangdanList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="zhangdanList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="zhangdanList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
						<input name="zhangdanList[${stuts.index }].fid" type="hidden" value="${poVal.fid }"/>
						<input name="zhangdanList[${stuts.index }].costid" type="hidden" value="${poVal.costid }"/>
				   <td align="left">
					  	<input name="zhangdanList[${stuts.index }].fcheck" maxlength="32" type="text" class="inputxt"  style="width:50px;"  ignore="ignore"  value="${poVal.fcheck }"/>
					  <label class="Validform_label" style="display: none;">审核</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdanList[${stuts.index }].fweituo" maxlength="32" type="text" class="inputxt"  style="width:100px;"  ignore="ignore"  value="${poVal.fweituo }"/>
					  <label class="Validform_label" style="display: none;">委托单号</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdanList[${stuts.index }].fcost" maxlength="32" type="text" class="inputxt"  style="width:100px;"  ignore="ignore"  value="${poVal.fcost }"/>
					  <label class="Validform_label" style="display: none;">费用种类名称</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdanList[${stuts.index }].frece" maxlength="32" type="text" class="inputxt"  style="width:100px;"  ignore="ignore"  value="${poVal.frece }"/>
					  <label class="Validform_label" style="display: none;">应收</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdanList[${stuts.index }].fsettle" maxlength="32" type="text" class="inputxt"  style="width:100px;"  ignore="ignore"  value="${poVal.fsettle }"/>
					  <label class="Validform_label" style="display: none;">结算单位</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdanList[${stuts.index }].fcurrency" maxlength="32" type="text" class="inputxt"  style="width:100px;"  ignore="ignore"  value="${poVal.fcurrency }"/>
					  <label class="Validform_label" style="display: none;">币种</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdanList[${stuts.index }].fprice" maxlength="32" type="text" class="inputxt"  style="width:100px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.fprice }"/>
					  <label class="Validform_label" style="display: none;">单价</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdanList[${stuts.index }].fqty" maxlength="32" type="text" class="inputxt"  style="width:100px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.fqty }"/>
					  <label class="Validform_label" style="display: none;">数量</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdanList[${stuts.index }].fjine" maxlength="32" type="text" class="inputxt"  style="width:100px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.fjine }"/>
					  <label class="Validform_label" style="display: none;">金额</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdanList[${stuts.index }].funit" maxlength="32" type="text" class="inputxt"  style="width:100px;"  ignore="ignore"  value="${poVal.funit }"/>
					  <label class="Validform_label" style="display: none;">单位</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdanList[${stuts.index }].ftidan" maxlength="32" type="text" class="inputxt"  style="width:100px;"  ignore="ignore"  value="${poVal.ftidan }"/>
					  <label class="Validform_label" style="display: none;">提单号</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdanList[${stuts.index }].fshipname" maxlength="32" type="text" class="inputxt"  style="width:100px;"  ignore="ignore"  value="${poVal.fshipname }"/>
					  <label class="Validform_label" style="display: none;">航名</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdanList[${stuts.index }].fvoyageno" maxlength="32" type="text" class="inputxt"  style="width:100px;"  ignore="ignore"  value="${poVal.fvoyageno }"/>
					  <label class="Validform_label" style="display: none;">航次</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdanList[${stuts.index }].foperatetime" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.foperatetime }"/>
					  <label class="Validform_label" style="display: none;">作业时间</label>
				   </td>
				   <td align="left">
					  	<input name="zhangdanList[${stuts.index }].fboxtype" maxlength="32" type="text" class="inputxt"  style="width:100px;"  ignore="ignore"  value="${poVal.fboxtype }"/>
					  <label class="Validform_label" style="display: none;">箱型</label>
				   </td>
   			</tr>
		</c:forEach>
	<%--</c:if>--%>
	</tbody>
</table>
