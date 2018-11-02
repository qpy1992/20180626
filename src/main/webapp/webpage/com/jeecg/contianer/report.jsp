<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>派车单</title>
    <script type="text/javascript" src="webpage/com/jeecg/paiche/CreateControl.js"></script>
    <script type="text/javascript" src="webpage/com/jeecg/paiche/GRInstall.js"></script>
    <script type="text/javascript" src="webpage/com/jeecg/paiche/GRUtility.js"></script>
    <style type="text/css">  
        html,body {  
            margin:0;  
            height:100%;  
        }  
    </style>  
    <script language="javascript" type="text/javascript">Install_InsertReport();</script>  
</head>  
<body>
  <script type="text/javascript">
    var Installed = Install_Detect();
    if ( Installed )
        CreateReport("Report");
  </script>
  <script type="text/javascript">
         CreatePrintViewerEx("100%", "100%", "webpage/com/jeecg/contianer/container.grf", "webpage/com/jeecg/contianer/data/jsonData.jsp?dataid=<%=request.getAttribute("dataid")%>", true, "");
   </script>
</body>
</html>