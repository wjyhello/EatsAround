<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" flush="false" />
<html>
<head>
    <title>회원가입 페이지</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
    <div class="container my-5">
        <h2 class="text-center">회원가입</h2>
        <form action="${pageContext.request.contextPath}/signup" method="post" class="my-4">
            <div class="mb-3">
                <label for="userid" class="form-label">USER ID:</label>
                <input type="text" id="userid" name="userid" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="userpass" class="form-label">PASSWORD:</label>
                <input type="password" id="userpass" name="userPass" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="userpassre" class="form-label">PASSWORD RECONFIRM:</label>
                <input type="password" id="userpassre" name="userPassRe" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="username" class="form-label">USERNAME:</label>
                <input type="text" id="username" name="username" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="userphone" class="form-label">USER PHONE:</label>
                <input type="tel" id="userphone" name="userPhone" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="useremail" class="form-label">USER EMAIL:</label>
                <input type="email" id="useremail" name="userEmail" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="usergender" class="form-label">USER GENDER:</label>
                <select id="usergender" name="userGender" class="form-select" required>
                    <option value="">Select Gender</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Other">Other</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="useradd1" class="form-label">ADDRESS LINE 1:</label>
                <input type="text" id="useradd1" name="userAdd1" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="useradd2" class="form-label">ADDRESS LINE 2:</label>
                <input type="text" id="useradd2" name="userAdd2" class="form-control">
            </div>
            <div class="mb-3">
                <label for="useradd3" class="form-label">ADDRESS LINE 3:</label>
                <input type="text" id="useradd3" name="userAdd3" class="form-control">
            </div>
            <div class="mb-3">
                <label for="verify" class="form-label">VERIFICATION CODE:</label>
                <input type="text" id="verify" name="verify" class="form-control">
            </div>
            <div class="d-flex justify-content-end my-5">
                <div class="btn-group">
                    <button type="submit" class="btn btn-primary">회원가입</button>
                </div>
            </div>
        </form>
    </div>
    <jsp:include page="../include/footer.jsp" flush="false" />
</body>
</html>
