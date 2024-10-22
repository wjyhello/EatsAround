<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/include/header.jsp" flush="false" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
						<c:if test="${not empty alertMessage}">
							<script>
								alert('${alertMessage}');
							</script>
						</c:if>

						<c:if test="${not empty alertAdminMessage}">
							<div class="alert alert-danger" role="alert">
								${alertAdminMessage}</div>
						</c:if>


						<h2 class="mb-0">게시판 관리</h2>

						<div class="card-body">
							<table class="table table-striped table-hover">
								<thead class="thead-dark">
									<tr>
										<th>ID</th>
										<th>NAME</th>
										<th>E-mail</th>
										<th>Phone</th>
										<th>regDate</th>
										<th>DELETE</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="member" items="${memberList}">
										<tr>
											<td>${member.userId}</td>
											<td>${member.userName}</td>
											<td>${member.userEmail}</td>
											<td>${member.userPhone}</td>
											<td><fmt:formatDate value="${member.regDate}"
													pattern="yyyy-MM-dd" /></td>
											<td>
												<form action="${path}/admin/member/delete" method="post"
													onsubmit="return confirm('本当に削除しますか？');">
													<input type="hidden" name="userId" value="${member.userId}" />
													<button type="submit" class="btn btn-danger btn-sm">
														<i class="fas fa-trash-alt"></i> 삭제
													</button>
												</form>
											</td>
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

<jsp:include page="/WEB-INF/views/include/footer.jsp" flush="false" />