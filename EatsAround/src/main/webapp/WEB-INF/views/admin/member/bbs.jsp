<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp" flush="false"/>

<div class="container">
    <div class="row">
        <div class="col-md-12">

            <h2 class="my-4">掲示板</h2>

            <!-- 検索フォーム -->
            <form class="my-5" method="get" action="${pageContext.request.contextPath}/list">
                <div class="input-group">
                    <input type="text" 
                           class="form-control" 
                           placeholder="検索" 
                           name="search" 
                           value="${blogListRequestVO.search}"/>
                    <input 
                           type="submit" 
                           name="search_button" 
                           value="検索"
                           class="btn btn-outline-success"/>
                </div>
            </form>

            <c:if test="${not empty blogListResponseVOList}">
                <table class="table table-hover">
                    <colgroup>
                        <col style="width:5%"/>
                        <col style="width:70%"/>
                        <col style="width:15%"/>
                        <col style="width:10%"/>
                    </colgroup>
                    <thead>
                        <tr>
                            <th class="text-center">番号</th>
                            <th class="text-center">タイトル</th>
                            <th class="text-center">投稿日</th>
                            <th class="text-center">編集</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="blogListResponseVO" items="${blogListResponseVOList}">
                            <tr>
                                <td>${blogListResponseVO.blgContSeq}</td>
                                <td><a href="${pageContext.request.contextPath}/read/${blogListResponseVO.blgContSeq}" class="a-link">${blogListResponseVO.title}</a></td>
                                <td>${blogListResponseVO.insertDtFormat}</td>
                                <td class="text-center">
                                    <a href="${pageContext.request.contextPath}/edit/${blogListResponseVO.blgContSeq}" class="a-link">編集</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div class="d-flex justify-content-end my-5">
                    <div class="btn-group">
                        <a href="${pageContext.request.contextPath}/create" class="btn btn-outline-primary px-4">新規作成</a>
                    </div>
                </div>
            </c:if>

            <c:if test="${empty blogListResponseVOList}">
                <strong>결과 없음</strong>
            </c:if>

        </div>
    </div>
</div>

<jsp:include page="../include/footer.jsp" flush="false"/>
