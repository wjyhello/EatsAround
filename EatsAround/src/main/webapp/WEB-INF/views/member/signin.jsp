<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file='../include/header.jsp'%>

<link rel="stylesheet" href="${path}/resources/css/signin.css"/>
<div class="container-fluid bg-gradient-primary">
    <div class="row justify-content-center">
        <div class="col-xl-10 col-lg-12 col-md-9">
            <!-- 大型デバイスでは10, デスクトップでは12, タブレットでは9 -->
            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <div class="row">
                        <!-- 背景画像 -->
                        <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                        <!-- 入力フォーム -->
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">
                                        로그인
                                    </h1>
                                </div>
                                <form method="post" autocomplete="off">
                                    <div class="form-group mb-3">
                                        <input type="text" 
                                            class="form-control form-control-user ci" 
                                            placeholder="아이디" 
                                            name="userId" 
                                            maxlength="20" 
                                            required="required" />
                                    </div>
                                    <div class="form-group mb-3">
                                        <input type="password" 
                                            class="form-control form-control-user ci" 
                                            placeholder="비밀번호" 
                                            name="userPass" 
                                            maxlength="20" 
                                            required="required" />
                                    </div>
                                    <div class="form-group mb-3">
                                        <div class="custom-control custom-checkbox small">
                                            <input type="checkbox" 
                                                class="custom-control-input" 
                                                id="customCheck" />
                                            <label class="custom-control-label" for="customCheck">
                                                Remember Me
                                            </label>
                                        </div>
                                    </div>
                                    <p class="mb-3">
                                        <input type="submit" 
                                            class="btn btn-primary btn-user btn-block" 
                                            value="로그인" 
                                            id="signin_btn" 
                                            name="signin_btn" />
                                    </p>
                                    <c:if test="${msg == false }">
                                        <p class="text-danger">로그인에 실패했습니다</p>
                                    </c:if>
                                    <hr>
                                    <p class="mb-3">
                                        <a href="${path}/google.jsp" class="btn btn-google btn-user btn-block">
                                            <i class="fab fa-google fa-fw w-100">
                                                &nbsp;Login with Google
                                            </i>
                                        </a>
                                    </p>
                                    <p class="mb-3">
                                    <a href="${path}/face.jsp" class="btn btn-facebook btn-user btn-block">
                                        <i class="fab fa-facebook-f fa-fw w-100">
                                            &nbsp;Login with Facebook
                                        </i>
                                    </a>
                                    </p>
                                    <p class="mb-3">
                                    <a href="${path}/kakao.jsp" class="btn btn-kakaotalk btn-user btn-block">
                                        <i class="fab fa-kakaotalk fa-fw w-100">
                                            &nbsp;Login with Kakaotalk
                                        </i>
                                    </a>
                                    </p>                                    
                                </form>
                                <hr>
                                <div class="text-center mb-3">
                                    <a class="small" href="${path}/forgot">
                                        Forgot Password?
                                    </a>
                                </div>
                                <div class="text-center mb-3">
                                    <a class="small" href="${path}/join">
                                        회원가입
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file='../include/footer.jsp'%>
