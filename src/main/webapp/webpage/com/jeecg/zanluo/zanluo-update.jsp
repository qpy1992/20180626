<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>暂落记录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zanluoController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${zanluoPage.id }"/>
		<table cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								箱号:
							</label>
						</td>
						<td class="value">
						    <input id="fboxno" name="fboxno" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zanluoPage.fboxno}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">箱号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								暂落时间:
							</label>
						</td>
						<td class="value">
									   <input id="fzanluo" name="fzanluo" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  value='<fmt:formatDate value='${zanluoPage.fzanluo}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">暂落时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								暂落堆场代码:
							</label>
						</td>
						<td class="value">
						    <input id="fyard" name="fyard" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zanluoPage.fyard}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">暂落堆场代码</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								暂落堆场:
							</label>
						</td>
						<td class="value">
						    <input id="fyardname" name="fyardname" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zanluoPage.fyardname}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">暂落堆场</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								下次提箱时间:
							</label>
						</td>
						<td class="value">
									   <input id="fnexttime" name="fnexttime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  value='<fmt:formatDate value='${zanluoPage.fnexttime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">下次提箱时间</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/zanluo/zanluo.js"></script>		
