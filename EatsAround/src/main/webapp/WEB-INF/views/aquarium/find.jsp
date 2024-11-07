<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" flush="false"/>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1 class="my-5">Aquarium Locations</h1>
            <ul class="breadcrumb mb-3">
                <li class="breadcrumb-item"><a href="/list">HOME</a></li>
                <li class="breadcrumb-item active">Location</li>
            </ul>
            <button id="find-me">내 위치 보기</button><br />
            <button id="find-aquarium">수족관 찾기</button><br />
            <p id="status"></p>
            <div id="map" style="width:50%;height:400px;"></div>

            <!-- 검색 결과 표시 영역 -->
            <h2>Search Results</h2>
            <div id="results">
                <c:forEach var="item" items="${items}">
                    <div class="result-item">
                        <h3>${item["title"]}</h3>
                        <p>${item["address"]}</p>
                        <p>${item["telephone"]}</p>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../include/footer.jsp" flush="false"/>

<!-- 외부 JS 파일 로드 -->
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=clientId"></script>

