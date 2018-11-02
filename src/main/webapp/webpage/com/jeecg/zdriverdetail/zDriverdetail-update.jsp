<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>驾驶人基本信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zDriverdetailController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${zDriverdetailPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								工号:
							</label>
						</td>
						<td class="value">
						    <input id="jobnumber" name="jobnumber" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zDriverdetailPage.jobnumber}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">工号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								工种:
							</label>
						</td>
						<td class="value">
						    <input id="job" name="job" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zDriverdetailPage.job}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">工种</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								入职日期:
							</label>
						</td>
						<td class="value">
						    <input id="entryDate" name="entryDate" type="text" style="width: 150px"  class="Wdate"  onClick="WdatePicker()"  ignore="ignore"  value='<fmt:formatDate value='${zDriverdetailPage.entryDate}' type="date" pattern="yyyy-MM-dd"/>'  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">入职日期</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								离职日期:
							</label>
						</td>
						<td class="value">
						    <input id="departureDate" name="departureDate" type="text" style="width: 150px"  class="Wdate"  onClick="WdatePicker()" ignore="ignore" value='<fmt:formatDate value='${zDriverdetailPage.departureDate}' type="date" pattern="yyyy-MM-dd"/>'  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">离职日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								姓名:
							</label>
						</td>
						<td class="value">
						    <input id="fname" name="fname" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zDriverdetailPage.fname}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								性别:
							</label>
						</td>
						<td class="value">
						    <%-- <input id="sex" name="sex" type="list" typeGroupCode="sex" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zDriverdetailPage.sex}'/> --%>
							<t:dictSelect field="sex" type="list" typeGroupCode="sex" hasLabel="false" title="性别" defaultVal="${zDriverdetailPage.sex}"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								出生年月:
							</label>
						</td>
						<td class="value">
						    <input id="birthDate" name="birthDate" type="text" style="width: 150px"  class="Wdate"  onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${zDriverdetailPage.birthDate}' type="date" pattern="yyyy-MM-dd"/>' />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">出生年月</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								学历:
							</label>
						</td>
						<td class="value">
						   <%--  <input id="education" name="education" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zDriverdetailPage.education}'/> --%>
								<t:dictSelect field="education" type="list" typeGroupCode="xueli" hasLabel="false" title="学历" defaultVal='${zDriverdetailPage.education}'></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学历</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								民族:
							</label>
						</td>
						<td class="value">
						    <input id="nation" name="nation" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zDriverdetailPage.nation}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">民族</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								籍贯:
							</label>
						</td>
						<td class="value">
						    <input id="birthplace" name="birthplace" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zDriverdetailPage.birthplace}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">籍贯</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								身份证号码:
							</label>
						</td>
						<td class="value">
						    <input id="idcard" name="idcard" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zDriverdetailPage.idcard}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">身份证号码</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								政治面貌:
							</label>
						</td>
						<td class="value">
						    <input id="political" name="political" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zDriverdetailPage.political}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">政治面貌</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								家庭住址:
							</label>
						</td>
						<td class="value">
						    <input id="address" name="address" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zDriverdetailPage.address}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">家庭住址</label>
						</td>
					
						
						<td align="right">
							<label class="Validform_label">
								实际联系地址:
							</label>
						</td>
						<td class="value">
						    <input id="residentialAddress" name="residentialAddress" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zDriverdetailPage.residentialAddress}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实际联系地址</label>
						</td>
					</tr>
					<tr>
							<td align="right">
							<label class="Validform_label">
								驾驶证初领日期:
							</label>
						</td>
						<td class="value">
						    <input id="initialDate" name="initialDate" type="text" style="width: 150px"  class="Wdate"  onClick="WdatePicker()"  ignore="ignore"  value='${zDriverdetailPage.initialDate}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">驾驶证初领日期</label>
						</td>
					
						<td align="right">
							<label class="Validform_label">
								有效日期:
							</label>
						</td>
						<td class="value">
						    <input id="effectiveDate" name="effectiveDate" type="text" style="width: 150px"  class="Wdate"  onClick="WdatePicker()"  ignore="ignore"  value='<fmt:formatDate value='${zDriverdetailPage.effectiveDate}' type="date" pattern="yyyy-MM-dd"/>' />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">有效日期</label>
						</td>
					</tr>
					
					<tr>
						<td align="right">
							<label class="Validform_label">
								是否沪籍:
							</label>
						</td>
						<td class="value">
						    <%-- <input id="sex" name="sex" type="list" typeGroupCode="sex" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zDriverdetailPage.sex}'/> --%>
							<t:dictSelect field="ishu" type="list" typeGroupCode="hutype" hasLabel="false" title="是否沪籍" defaultVal='${zDriverdetailPage.ishu}'></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否沪籍</label>
						</td>
					
						<td align="right">
							<label class="Validform_label">
								准驾车型:
							</label>
						</td>
						<td class="value">
						    <input id="carType" name="carType" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zDriverdetailPage.carType}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">准驾车型</label>
						</td>
					
					</tr>
					
					<tr>
						<td align="right">
							<label class="Validform_label">
								驾驶证登记地址:
							</label>
						</td>
						<td class="value">
						    <input id="registrationAddress" name="registrationAddress" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zDriverdetailPage.registrationAddress}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">驾驶证登记地址</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								驾驶证档案号:
							</label>
						</td>
						<td class="value">
						    <input id="licenseNo" name="licenseNo" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zDriverdetailPage.licenseNo}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">驾驶证档案号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								发证机关:
							</label>
						</td>
						<td class="value">
						    <input id="issuingAuthority" name="issuingAuthority" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zDriverdetailPage.issuingAuthority}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发证机关</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								联系电话:
							</label>
						</td>
						<td class="value">
						    <input id="phone" name="phone" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zDriverdetailPage.phone}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">联系电话</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								照片:
							</label>
						</td>
						<td class="value">
						  <%--   <input id="image" name="image" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${zDriverdetailPage.image}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">照片</label> --%>
							<t:webUploader name="image" auto="true" type="image" pathValues="${zDriverdetailPage.image}" fileNumLimit="1"></t:webUploader>
						<span class="Validform_checktip Validform_right" style="display: none;">文件已上传</span>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/zdriverdetail/zDriverdetail.js"></script>		
