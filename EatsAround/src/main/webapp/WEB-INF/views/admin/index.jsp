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

		<div class="col-md-10">
			<div class="container">
				<div class="row">
					<div class="col-md-12 my-4">
						<h2>관리자 정보</h2>
						<p>환영합니다, 관리자님.</p>

						<!-- Dashboard -->
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

						<!-- Activity Log -->
						<h3>최근 활동 내역</h3>

						<!-- Search Form -->
						<form action="${pageContext.request.contextPath}/admin/index"
							method="get" class="form-inline mb-3">
							<div class="form-group">
								<input type="text" name="search" class="form-control"
									placeholder="Search" value="${search}">
							</div>
							<button type="submit" class="btn btn-primary">Search</button>
						</form>

						<!-- Activity Table -->
						<div class="card mb-4">
							<div class="card-body">
								<table class="table table-striped">
									<thead>
										<tr>
											<th>User ID</th>
											<th>Activity Type</th>
											<th>Activity Time</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="activity" items="${activityHistory}">
											<tr>
												<td>${activity.userId}</td>
												<td>${activity.activityType}</td>
												<td>${activity.activityTime}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>

								<!-- Pagination -->
								<div class="d-flex justify-content-center my-4">
									<div class="btn-group">
										<!-- Previous Page Button -->
										<c:if test="${currentPage > 1}">
											<form action="${pageContext.request.contextPath}/admin/index"
												method="get" style="display: inline;">
												<input type="hidden" name="currentPage"
													value="${currentPage - 1}" /> <input type="hidden"
													name="search" value="${search}" />
												<button type="submit" class="btn btn-secondary">이전</button>
											</form>
										</c:if>

										<!-- Page Numbers with range limitation (5 pages display) -->
										<c:set var="startPage"
											value="${currentPage > 3 ? currentPage - 2 : 1}" />
										<c:set var="endPage" value="${startPage + 4}" />
										<c:if test="${endPage > totalPages}">
											<c:set var="endPage" value="${totalPages}" />
											<c:set var="startPage"
												value="${endPage - 4 > 0 ? endPage - 4 : 1}" />
										</c:if>

										<!-- First Page and Ellipsis if needed -->
										<c:if test="${startPage > 1}">
											<form action="${pageContext.request.contextPath}/admin/index"
												method="get" style="display: inline;">
												<input type="hidden" name="currentPage" value="1" /> <input
													type="hidden" name="search" value="${search}" />
												<button type="submit" class="btn btn-outline-primary">1</button>
											</form>
											<span class="btn btn-outline-secondary disabled">...</span>
										</c:if>

										<!-- Display the page numbers within the calculated range -->
										<c:forEach var="i" begin="${startPage}" end="${endPage}">
											<form action="${pageContext.request.contextPath}/admin/index"
												method="get" style="display: inline;">
												<input type="hidden" name="currentPage" value="${i}" /> <input
													type="hidden" name="search" value="${search}" />
												<button type="submit"
													class="btn ${i == currentPage ? 'btn-primary' : 'btn-outline-primary'}">${i}</button>
											</form>
										</c:forEach>

										<!-- Last Page and Ellipsis if needed -->
										<c:if test="${endPage < totalPages}">
											<span class="btn btn-outline-secondary disabled">...</span>
											<form action="${pageContext.request.contextPath}/admin/index"
												method="get" style="display: inline;">
												<input type="hidden" name="currentPage"
													value="${totalPages}" /> <input type="hidden"
													name="search" value="${search}" />
												<button type="submit" class="btn btn-outline-primary">${totalPages}</button>
											</form>
										</c:if>

										<!-- Next Page Button -->
										<c:if test="${currentPage < totalPages}">
											<form action="${pageContext.request.contextPath}/admin/index"
												method="get" style="display: inline;">
												<input type="hidden" name="currentPage"
													value="${currentPage + 1}" /> <input type="hidden"
													name="search" value="${search}" />
												<button type="submit" class="btn btn-secondary">다음</button>
											</form>
										</c:if>
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
