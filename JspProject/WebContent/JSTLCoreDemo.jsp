<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
Out:<c:out value="${'Welcome to javaTpoint'}"/> 
<c:catch var ="catchtheException">  
   <% int x = 2/0;%>  
</c:catch>  
  
<c:if test = "${catchtheException != null}"> <br/> 
	<p>The type of exception is : ${catchtheException} <br />  
Catch: There is an exception: ${catchtheException.message}</p>  
</c:if> 
<c:set var="income" value="${4000*4}"/> 
Set:<c:out value="${income}"/><br/>
<c:if test="${income>8000}">
My income is :${income}
</c:if>
<p>Before Remove Value is: <c:out value="${income}"/></p>  
<c:remove var="income"/>  
Remove:<p>After Remove Value is: <c:out value="${income}"/></p> 
forEach:<c:forEach var="i" begin="1" end="4"><br/>
Item<c:out value="${i}"/><br/>
</c:forEach>
forTokens:<c:forTokens var="name" items="Rakul*preet*singh" delims="*"><br/>
<c:out value="${name}"/><br/>
</c:forTokens>
<c:url value="/SampleJsp.jsp"/>  
<c:import var="data" url="https://www.w3schools.com/"/>
${data}
</body>
</html>