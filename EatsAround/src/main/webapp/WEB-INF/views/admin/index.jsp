<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/views/include/header.jsp" flush="false" />

<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
			<div class="py-3">
				<h4 class="text-center">관리자 메뉴</h4>
				<jsp:include page="/WEB-INF/views/admin/include/adminPage.jsp"
					flush="false" />
			</div>
		</div>

		<!-- メインコンテンツ -->
		<div class="col-md-10">
			<div class="container">
				<div class="row">
					<div class="col-md-12 my-4">
						<h2>관리자 정보</h2>
						<p>환영합니다, 관리자님.</p>

						<!-- dashboard 要素 -->
						<div class="row">
							<div class="col-md-4">
								<div class="card text-white bg-primary mb-3">
									<div class="card-body">
										<h5 class="card-title">회원 수</h5>
										<p class="card-text">현재 등록된 회원 수: ${memberCount}명</p>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="card text-white bg-success mb-3">
									<div class="card-body">
										<h5 class="card-title">게시판 수</h5>
										<p class="card-text">등록된 게시판 수: ${blogCount}개</p>
									</div>
								</div>
							</div>
						</div>

<div class="row">
    <div class="col-md-12">
        <h3>최근 로그인 내역</h3>
        <div class="card">
            <div class="card-body">
                <table class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>User ID</th>
                            <th>Activity Type</th>
                            <th>Activity Time</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="login" items="${loginHistory}">
                            <tr>
                                <td>${login.userId}</td>
                                <td>${login.activityType}</td>
                                <td>${login.activityTime}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-12">
        <h3>최근 로그아웃 내역</h3> <!-- タイトルを追加 -->
        <div class="card">
            <div class="card-body">
                <table class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>User ID</th>
                            <th>Activity Type</th>
                            <th>Activity Time</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="logout" items="${logoutHistory}"> <!-- ログアウト履歴のループ -->
                            <tr>
                                <td>${logout.userId}</td>
                                <td>${logout.activityType}</td>
                                <td>${logout.activityTime}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/views/include/footer.jsp" flush="false" />
