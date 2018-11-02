<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>集装箱尺寸对照表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="containerSizeController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${containerSizePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								箱型:
							</label>
						</td>
						<td class="value">
						    <input id="ftype" name="ftype" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${containerSizePage.ftype}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">箱型</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								长度:
							</label>
						</td>
						<td class="value">
						    <input id="flength" name="flength" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${containerSizePage.flength}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">长度</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								宽度:
							</label>
						</td>
						<td class="value">
						    <input id="fwidth" name="fwidth" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${containerSizePage.fwidth}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">宽度</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								高度:
							</label>
						</td>
						<td class="value">
						    <input id="fheight" name="fheight" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${containerSizePage.fheight}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">高度</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								体积:
							</label>
						</td>
						<td class="value">
						    <input id="fvolum" name="fvolum" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${containerSizePage.fvolum}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">体积</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/containersize/containerSize.js"></script>		
