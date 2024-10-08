<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% pageContext.setAttribute("CRLF", "\r\n"); %>
<jsp:include page="../include/header.jsp" flush="false"/>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1 class="mt-5 mb-2">Detail</h1>
            <ul class="breadcrumb mb-3">
                <li class="breadcrumb-item"><a href="/list">HOME</a></li>
                <li class="breadcrumb-item active">detail</li>
            </ul>
            <table class="table">
                <colgroup>
                    <col style="width:7%"/>
                    <col style="width:93%"/>
                </colgroup>
                <tr>
                    <th>글번호 : </th><td>${blogCont.BLG_CONT_SEQ}</td>
                </tr>
                <tr>
                    <th>제목 :</th><td>${blogCont.TITLE}</td>
                </tr>
                <tr>
                    <th></th><td>${fn:replace(blogCont.CONT_BDY, CRLF, '<br/>') }</td>
                </tr>
                <tr>
                    <th>입력일</th>
                    <td><fmt:formatDate value="${blogCont.INSERT_DT}" pattern="yyyy.MM.dd HH:mm:ss"/></td>
                </tr>
            </table>

            <form method="post" action="/delete">
                <div class="d-flex justify-content-end my-5">
                    <input type="hidden" name="_method" value="delete"/>
                    <input type="hidden" name="blogContSeq" value="${blogCont.BLG_CONT_SEQ}"/>
                    <a href="/list" class="btn btn-outline-secondary">list</a>
                    <input type="submit" name="delete_button" value="삭제" class="btn btn-outline-danger"/>
                </div>
            </form>

            <div class="p-2">
                <div class="mt-2">
                    <input type="text" id="cmtBdy" class="form-control"/>
                </div>
                <div class="mt-2">
                    <input type="password" id="tmpPw" class="form-control"/>
                </div>
                <div class="w-100 my-2">
                    <input type="button" id="btn_comment_add" value="댓글쓰기" class="btn btn-success"/>
                </div>
                <div id="comment_list">
                </div>
            </div>

            <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
            <script type="text/javascript">
                $("#btn_comment_add").click(function(){
                    let blgContSeq = ${blogCont.BLG_CONT_SEQ};
                    let cmtBdy = $("#cmtBdy").val();
                    let tmpPw = $("#tmpPw").val();
                    let send_data = {};

                    if(tmpPw == ""){
                        send_data = {
                            "blgContSeq": blgContSeq,
                            "cmtBdy": cmtBdy    
                        };
                    } else {
                        send_data = {
                            "blgContSeq": blgContSeq,
                            "cmtBdy": cmtBdy,
                            "tmpPw": tmpPw,
                        };
                    }

                    $.post("/comment/add", send_data)
                        .done(function(data){
                            if (data && data.cmtBdy && data.seqBlgCmt) {
                                render_comment(data.cmtBdy, data.seqBlgCmt);
                            } else {
                                alert("서버에서 받은 응답이 유효하지 않습니다.");
                            }
                        })
                        .fail(function(jqXHR, textStatus, errorThrown){
                            alert("댓글 추가에 실패했습니다. 상태: " + textStatus + " - 오류: " + errorThrown);
                        });
                });

                function render_comment(cmtBdy, seqBlgCmt){
                    // HTML 이스케이프는 해야 하지만, 여기서는 샘플로 그대로 사용
                    let append_val = '<p><a href="/comment/delete/{seqBlgCmt}">{cmtBdy}</a></p>'
                        .replace("{seqBlgCmt}", seqBlgCmt)
                        .replace("{cmtBdy}", cmtBdy);

                    $("#comment_list").append(append_val);
                }

                function init_comment(){
                    $.get("/comment/list/${blogCont.BLG_CONT_SEQ}", function(data){
                        if (Array.isArray(data)) {
                            for (let comment of data){
                                render_comment(comment.cmtBdy, comment.seqBlgCmt);
                            }
                        } else {
                            alert("서버에서 댓글 목록을 가져오는 데 실패했습니다.");
                        }
                    });
                }

                $(document).ready(function(){
                    init_comment();
                });
            </script>

        </div>
    </div>
</div>

<jsp:include page="../include/footer.jsp" flush="false"/>
