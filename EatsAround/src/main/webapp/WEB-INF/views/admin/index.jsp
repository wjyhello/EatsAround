<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/include/header.jsp" flush="false" />



<div class="container-fluid">
    <div class="row">
        
        <div class="col-md-2">
            <div class="py-3">
                <h4 class="text-center">관리자 메뉴</h4>
                <jsp:include page="/WEB-INF/views/admin/include/adminPage.jsp" flush="false" />
            </div>
        </div>

        <!-- メインコンテンツ -->
        <div class="col-md-10">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 my-4">
                        <h2>관리자 정보</h2>
                        <p>환영합니다, 관리자님.</p>

                        <!-- dashboard 요소 -->
                        <div class="row">
                            <div class="col-md-4">
                                <div class="card text-white bg-primary mb-3">
                                    <div class="card-body">
                                        <h5 class="card-title">회원 수</h5>
                                        <p class="card-text">현재 등록된 회원 수: xxx명</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="card text-white bg-success mb-3">
                                    <div class="card-body">
                                        <h5 class="card-title">게시판 수</h5>
                                        <p class="card-text">등록된 게시판 수: xxx개</p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- 追加機能の領域など -->
                        <div class="row">
                            <div class="col-md-12">
                                <h3>최근 활동 내역</h3>
                                <ul class="list-group">
                                    <li class="list-group-item">회원 'xxx'이 회원가입을 탈퇴했습니다.</li>
                                    <li class="list-group-item">회원 'xxx'이 회원가입을 완료했습니다.</li>
                                    <li class="list-group-item">관리자 페이지가 업데이트되었습니다.</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/include/footer.jsp" flush="false" />
