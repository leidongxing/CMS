<%@ page isELIgnored="false"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>profile!</title>
</head>
<body>
  <c:out value="${spitter.username}"/><br>
  <c:out value="${spitter.firstName}"/><br>
  <c:out value="${spitter.lastName}"/><br>
</body>
</html>