<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>司机提成设置列表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="extractController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${extractPage.id }"/>
		<table style="width: 700px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="center" colspan="2">
							<label class="Validform_label" style="font-weight: bold;font-size: 16px">
								重箱里程小于100公里(市内)
							</label>
						</td>
						<td align="center" colspan="2">
							<label class="Validform_label" style="font-weight: bold;font-size: 16px">
								重箱里程大于100公里(市外)
							</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								驳空箱:
							</label>
						</td>
						<td class="value">
						    <input id="fbkx" name="fbkx" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${extractPage.fbkx}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">驳空箱</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								单箱提成:
							</label>
						</td>
						<td class="value">
						    <input id="fdxtc" name="fdxtc" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${extractPage.fdxtc}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单箱提成</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								两小箱提成:
							</label>
						</td>
						<td class="value">
						    <input id="flxxtc" name="flxxtc" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${extractPage.flxxtc}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">两小箱提成</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								两大箱提成:
							</label>
						</td>
						<td class="value">
						    <input id="fldxtc" name="fldxtc" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${extractPage.fldxtc}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">两大箱提成</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								司机补贴:
							</label>
						</td>
						<td class="value">
						    <input id="fsjbt" name="fsjbt" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${extractPage.fsjbt}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">司机补贴</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								每公里单箱提成:
							</label>
						</td>
						<td class="value">
						    <input id="fmgldxtc" name="fmgldxtc" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${extractPage.fmgldxtc}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">每公里单箱提成</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								两小箱每公里:
							</label>
						</td>
						<td class="value">
						    <input id="flxxmgl" name="flxxmgl" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${extractPage.flxxmgl}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">两小箱每公里</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								两大箱每公里:
							</label>
						</td>
						<td class="value">
						    <input id="fldxmgl" name="fldxmgl" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${extractPage.fldxmgl}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">两大箱每公里</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								两大箱比率:
							</label>
						</td>
						<td class="value">
						    <input id="fldxbl" name="fldxbl" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${extractPage.fldxbl}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">两大箱比率</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								第二箱司机提成:
							</label>
						</td>
						<td class="value">
						    <input id="fdesjtc" name="fdesjtc" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${extractPage.fdesjtc}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">第二箱司机提成</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								生效日期:
							</label>
						</td>
						<td class="value">
									  <input id="fstartdate" name="fstartdate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${extractPage.fstartdate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">生效日期</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								截止日期:
							</label>
						</td>
						<td class="value">
									  <input id="fenddate" name="fenddate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${extractPage.fenddate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">截止日期</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/extract/extract.js"></script>		
