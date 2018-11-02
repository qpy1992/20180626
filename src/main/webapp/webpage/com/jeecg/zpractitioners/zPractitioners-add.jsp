<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>从业人员变动</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zPractitionersController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${zPractitionersPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							月份:
						</label>
					</td>
					<td class="value">
					     	 <input id="month" name="month" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">月份</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							工种岗位:
						</label>
					</td>
					<td class="value">
					     	 <input id="job" name="job" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">工种岗位</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							月初数:
						</label>
					</td>
					<td class="value">
					     	 <input id="beginNumber" name="beginNumber" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">月初数</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							本月增加:
						</label>
					</td>
					<td class="value">
					     	 <input id="increase" name="increase" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本月增加</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							本月减少:
						</label>
					</td>
					<td class="value">
					     	 <input id="decrease" name="decrease" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本月减少</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							月末数:
						</label>
					</td>
					<td class="value">
					     	 <input id="endNumber" name="endNumber" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">月末数</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="note" name="note" type="text" style="width: 450px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/zpractitioners/zPractitioners.js"></script>		
