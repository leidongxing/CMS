<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome!</title>
</head>
<body>
  <c:forEach itmes="${spittleList}" var="spittle">
     <c:out value="${spittle.message}"/>
     <c:out value="${spittle.latitude}"/>
     <c:out value="${spittle.longitude}"/>  
  </c:forEach>
</body>
</html>