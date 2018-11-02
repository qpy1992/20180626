<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>驾驶人违法</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zDriverillegalController.do?doAdd2&pid=${pid }" >
					<input id="id" name="id" type="hidden" value="${zDriverillegalPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<!-- <tr>
					<td align="right">
						<label class="Validform_label">
							驾驶人id:
						</label>
					</td>
					<td class="value">
					     	 <input id="driverId" name="driverId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">驾驶人id</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							驾驶人:
						</label>
					</td>
					<td class="value">
					     	 <input id="driverName" name="driverName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">驾驶人</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							驾驶证号:
						</label>
					</td>
					<td class="value">
					     	 <input id="cardNo" name="cardNo" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">驾驶证号</label>
						</td>
				</tr> -->
				<tr>
					<td align="right">
						<label class="Validform_label">
							违法时间:
						</label>
					</td>
					<td class="value">
							   <input id="time" name="time" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
								
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">违法时间</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							违法地点:
						</label>
					</td>
					<td class="value">
					     	 <input id="address" name="address" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">违法地点</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							具体违法内容:
						</label>
					</td>
					<td class="value">
					     	 <input id="fcontent" name="fcontent" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">具体违法内容</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							处理情况:
						</label>
					</td>
					<td class="value">
					     	 <input id="dealsituation" name="dealsituation" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">处理情况</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/zdriverillegal/zDriverillegal.js"></script>		
