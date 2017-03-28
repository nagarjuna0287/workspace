<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>fmt:timeZone Tag</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  
    <c:set var="str" value="<%=new java.util.Date()%>" />     
 Formatting:  
 <fmt:formatDate value="${str}" type="both" timeStyle="long" dateStyle="long" /><br/> 
 <c:set var="Amount" value="9850.14115" />
 ${Amount}<br/>
 Format1:<fmt:formatNumber value="${Amount}" type="currency"/><br/>
 Format2:<fmt:formatNumber value="${Amount}" type="number" maxIntegerDigits="2"/><br/>
 Format3:<fmt:formatNumber value="${Amount}" type="number" maxFractionDigits="3"/><br/>
 Format4:<fmt:formatNumber value="${Amount}" type="percent" maxIntegerDigits="4"/><br/>
 Format5:<fmt:formatNumber value="${Amount}" type="number" pattern="###.###$"/>
 	
        
</body>
</html>