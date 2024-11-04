<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 수정</title>
</head>
<body>
<form method="post" action="/reply/modify">
	<div class="input-group">
		<label class="form-label">
		댓글 작성자 : ${reply.writer}
		</label>
		<input type="hidden" name="writer" class="form-control" readonly="readonly" value="${reply.writer}"/>
		</div>
		<div class="input-group">
			<textarea class="form-control" name="content"> ${reply.content}</textarea>
		</div>
		<input type="hidden" name="blogContSeq" value="${blogContSeq}"/>
		<input type="hidden" name="rno" value="${reply.rno}"/>
		<div class="d-flex justify-content-end">
		<input type="submit" class="btn btn-success" value="댓글수정"/>
		</div>
</form>
</body>
</html>