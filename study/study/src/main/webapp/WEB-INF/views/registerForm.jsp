<%@ page isELIgnored="false"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register form!</title>
</head>
<body>
  <form method="POST">
    first name:<input type="text" name="firstName"/><br>
    last  name:<input type="text" name="lastName"/><br>
    username:<input type="text" name="username"/><br>
    password:<input type="password" name="password"/><br>
    email:<input type="text" name="email"/><br>
    <input type="submit" value="Register"/>
  </form>
</body>
</html>