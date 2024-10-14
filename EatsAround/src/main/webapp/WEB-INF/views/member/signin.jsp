<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file='../include/header.jsp'%>
<html>
<head>
    <meta charset="utf-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400,700">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/signin.css"> 
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"> 
</head>
<body>
    <div id="login">
        <form name="form-login" action="${pageContext.request.contextPath}/login" method="post">
            <span class="fontawesome-user"><i class="fas fa-user"></i></span>
            <input type="text" id="user" name="user" placeholder="User ID" required>

            <span class="fontawesome-lock"><i class="fas fa-lock"></i></span>
            <input type="password" id="pass" name="password" placeholder="Password" required>

            <input type="submit" value="Login">
        </form>
        
        <a href="#" class="login-forgot-pass">forgot password?</a>
    </div>
<%@ include file='../include/footer.jsp'%>
</body>
</html>
