<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디아블로2 게임 게시판</title>
<link rel="stylesheet" href="../css/visit.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="box">
		<img id="logo" src="https://blz-contentstack-images.akamaized.net/v3/assets/blt0e00eb71333df64e/blt6155ccd3890cd3be/65bb1649ab020734fa56c5bd/logo.webp">
		<h1 id="title">여러분의 방문을 환영합니다.</h1>
		<h3 id="title">디아블로2 레저렉션 대표 커뮤니티</h3>
		
		<div style="margin-bottom: 10px">
			<input class="btn btn-primary" type="button" value="글쓰기" onclick="location.href='insert_form.do'">
		</div>
		<!-- 내용이 없을 경우 -->
		<c:if test="${ empty requestScope.list }">
			<div id="empty_msg">등록된 게시물이 없습니다.</div>
		</c:if>
		
		<!-- 내용 -->
		<!-- for(VisitVo vo : list) 동일 -->
		<!-- 글자 자동정렬 Ctrl + Shift + F -->
		
		<c:forEach var="vo" items="${ requestScope.list }">
		<form class="form-inline">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4><b>${ vo.name }</b>님의 글:</h4>
				</div>
				<div class="panel-body">
					<div class="mycommon title"><b>제목 : </b>${ vo.title }</div>
					<div class="mycommon content">${ vo.content }</div>
					<div class="mycommon regdate"><b>작성일자 : </b>${ fn:substring(vo.regdate,0,16) }</div>
					<div class="mycommon pwd">비밀번호 :
						<input class="form-control" type="password" id="pwd">
						<input class="btn btn-info" type="button" value="수정">
						<input class="btn btn-danger" type="button" value="삭제">
					</div>
				</div>
			</div>
		</form>
		</c:forEach>
	</div>
</body>
</html>