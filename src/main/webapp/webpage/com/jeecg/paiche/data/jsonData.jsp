﻿<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenJsonData.jsp" %>
<%
 String QuerySQL = "select a.fcarcode,a.fcarno,a.fbanci,a.fbillno,CONVERT(varchar(100), a.ftranstime, 23) ftranstime,CONVERT(varchar(100), GETDATE(), 120) fprinttime,a.fdriver,a.fdoorpoint fdp,c.fbillno fweituo,c.fblno,b.fboxno,b.ftitle,b.fxhdp,b.fxhdpdz,b.fxhcontact,b.fxhmobile,c.ftxyard,c.fhxyard,a.fcarcode from z_paiche a left join z_contianer b on b.id=a.fboxid left join z_custom_entrust c on c.id=b.fid where a.id='"+request.getParameter("dataid")+"'";
 JSON_GenOneRecordset(response, QuerySQL);
%> 
