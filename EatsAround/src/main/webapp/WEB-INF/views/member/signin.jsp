<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" flush="false" />
<html>
<head>
<title>로그인 페이지</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container my-5">
		<h2 class="text-center">로그인</h2>
		<form action="${pageContext.request.contextPath}/member/signin"
			method="post" class="my-4">
			<div class="mb-3">
				<label for="username" class="form-label">USER ID:</label> <input
					type="text" id="username" name="username" class="form-control"
					required>
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">PASSWORD:</label> <input
					type="password" id="password" name="password" class="form-control"
					required>
			</div>
			<div class="d-flex justify-content-end my-5">
				<div class="btn-group">
					<button type="submit" class="btn btn-primary">LOGIN</button>
				</div>
			</div>

		</form>
	</div>
	<jsp:include page="../include/footer.jsp" flush="false" />