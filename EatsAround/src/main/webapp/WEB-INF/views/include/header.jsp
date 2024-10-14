<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


<title>EatsAround</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="${path}/">EatsAround</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="mynavbar">
      <ul class="navbar-nav me-auto">
         <c:if test="${member==null}">  
        <li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown">게시판</a>
			<ul class="dropdown-menu">
			 
			<li><a class="dropdown-item" href="${path}/list">list</a></li>
			<li><a class="dropdown-item" href="${path}/create">create</a></li>
			</c:if>
			</ul>
        
        
		
		<c:if test ="${member != null }">
						<c:if test ="${member.verify == 9}">
						<div class="d-flex align-items-center">
						<li class="nav-item">
							<a class="nav-link" href="${path}/admin/index">관리자 화면</a>
						</li>
						</c:if>
						<li class="nav-item">
						<span class="fw-bold">${member.userName}&nbsp;님 환영합니다</span>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="${path}/member/signout">logout</a>
						</li>
						</div>
					</c:if>		
		
      </ul>
      <form class="d-flex ms-auto">
        <input class="form-control me-2" type="text" placeholder="Search">
        <button class="btn btn-primary" type="button">Search</button>
      </form>
      
      
       <ul class="navbar-nav ms-auto"> 
       <c:if test="${member==null}">
           <li class="nav-item">
               <a class="nav-link" href="${path}/member/signin">signin</a>
           </li>
           <li class="nav-item">
               <a class="nav-link" href="${path}/member/signup">회원가입</a>
           </li>
           </c:if>
       </ul>
    </div>
  </div>
</nav>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="${path}/resources/js/js.js"></script>
<script src="${path}/resources/js/daum.js"></script>
<script src="${path}/resources/js/util.js"></script>
<script src="${path}/resources/js/register.js"></script>
<script src="${path}/resources/js/member.js"></script>















