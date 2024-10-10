<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>EatsAround</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">EatsAround</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="mynavbar">
      <ul class="navbar-nav me-auto">
            
        <li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown">게시판</a>
			<ul class="dropdown-menu">
			<li><a class="dropdown-item" href="/list">list</a></li>
			<li><a class="dropdown-item" href="/create">create</a></li>
			</ul>
        </li>

      </ul>
      <form class="d-flex ms-auto">
        <input class="form-control me-2" type="text" placeholder="Search">
        <button class="btn btn-primary" type="button">Search</button>
      </form>
      
      
       <ul class="navbar-nav ms-auto"> 
           <li class="nav-item">
               <a class="nav-link" href="/member/signin">signin</a>
           </li>
           <li class="nav-item">
               <a class="nav-link" href="/member/signup">회원가입</a>
           </li>
       </ul>
    </div>
  </div>
</nav>














