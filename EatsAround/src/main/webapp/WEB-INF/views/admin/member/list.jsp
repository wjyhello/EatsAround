<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<div class="container my-4">
				<h2>회원 리스트</h2>

				<!-- 검색 폼 -->
				<form action="/admin/member/list" method="get" class="mb-3">
					<div class="input-group">
						<input type="text" name="search" class="form-control"
							placeholder="검색" value="${param.search}" />
						<button type="submit" class="btn btn-primary">검색</button>
					</div>
				</form>

				<!-- 회원 리스트 테이블 -->
				<table class="table table-striped table-bordered">
					<thead class="thead-dark">
						<tr>
							<th>Username</th>
							<th>Email</th>
							<th>Date</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="member" items="${memberList}">
							<tr>
								<td>${member.userName}</td>
								<td>${member.userEmail}</td>
								<td><fmt:formatDate value="${member.regDate}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td>
									<form
										action="${pageContext.request.contextPath}/admin/member/delete"
										method="post">
										<input type="hidden" name="userId" value="${member.userId}" />
										<button type="submit" class="btn btn-danger btn-sm">삭제</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<!-- 페이징 처리 -->
				<c:if test="${not empty memberList}">
					<div class="d-flex justify-content-center align-items-center my-4">
						<div>
							<!-- 이전 페이지 버튼 -->
							<c:if test="${currentPage > 1}">
								<form
									action="${pageContext.request.contextPath}/admin/member/list"
									method="get" style="display: inline;">
									<input type="hidden" name="currentPage"
										value="${currentPage - 1}" /> <input type="hidden"
										name="search" value="${param.search}" /> <input type="hidden"
										name="pageSize" value="${pageSize}" />
									<button type="submit" class="btn btn-secondary">이전</button>
								</form>
							</c:if>

							<!-- 페이지 번호 -->
							<c:forEach var="i" begin="1" end="${totalPages}">
								<c:if test="${i >= currentPage - 2 && i <= currentPage + 2}">
									<form
										action="${pageContext.request.contextPath}/admin/member/list"
										method="get" style="display: inline;">
										<input type="hidden" name="currentPage" value="${i}" /> <input
											type="hidden" name="search" value="${param.search}" /> <input
											type="hidden" name="pageSize" value="${pageSize}" />
										<button type="submit"
											class="btn ${i == currentPage ? 'btn-primary' : 'btn-outline-primary'}">${i}</button>
									</form>
								</c:if>
							</c:forEach>

							<!-- 다음 페이지 버튼 -->
							<c:if test="${currentPage < totalPages}">
								<form
									action="${pageContext.request.contextPath}/admin/member/list"
									method="get" style="display: inline;">
									<input type="hidden" name="currentPage"
										value="${currentPage + 1}" /> <input type="hidden"
										name="search" value="${param.search}" /> <input type="hidden"
										name="pageSize" value="${pageSize}" />
									<button type="submit" class="btn btn-secondary">다음</button>
								</form>
							</c:if>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/views/include/footer.jsp" flush="false" />
