<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>박정환 Story</title>
<%-- 현재 컨텍스트 경로 : ${ pageContext.request.contextPath } --%>
<link rel="stylesheet" href="../css/visit.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
<script type="text/javascript">
	function del(f) {
		
		let pwd = f.pwd.value; // 게시물 생성 당시에 지정한 비밀번호
		let c_pwd = f.c_pwd.value.trim(); // 내가 입력한 비밀번호
		
		if(pwd != c_pwd) {
			alert("비밀번호가 일치하지 않습니다.");
			f.c_pwd.value="";
			f.c_pwd.focus();
			return;
		}
		// 데이터가 삭제될 때는 정말 삭제하시겠냐고 한 번더 물어보는 문구가 필요하다.
		// 삭제확인 : 확인(true) 취소(false)
		if(confirm("정말 삭제하시겠습니까?")==false) {
			retutn;
		}
		
		// 삭제요청하는 경로로 보내기
		// f.action="delete.do";
		// 삭제할 게시물 idx를 보내야 한다.
		// f.submit(); 폼submit을 하면 form안에 있는 모든 값이 넘어간다.
		
		// 방법2 : location 전송(선택적으로 parameter 전송하는 방법)
		location.href = "delete.do?idx=" + f.idx.value + "&no=" + f.no.value;
		
	}
	
	function modify_form(f) {
		
		let pwd = f.pwd.value;
		let c_pwd = f.c_pwd.value.trim();
		
		if(pwd != c_pwd) {
			alert("수정할 게시물의 비밀번호가 일치하지 않습니다.");
			f.c_pwd.value="";
			f.c_pwd.focus();
			return;
		}
		
		if(confirm("정말 수정하시겠습니까?")==false) {
			return;
		}
		
		// 수정폼 띄우기(요청)
		location.href = "modify_form.do?idx=" + f.idx.value + "&no=" + f.no.value;
	}
</script>
</head>
<body>
	<div id="box">
		<h1 id="title">여러분의 방문을 환영합니다.</h1>

		<div style="margin-bottom: 10px">
			<input class="btn btn-primary" type="button" value="글쓰기"
			onclick="location.href='insert_form.do'">
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
			<!-- 화면상에 안보임(새로 배운 내용) 보안에 가장 취약한 방법 -->		
			<input type="hidden" name="pwd" value="${ vo.pwd }">
			<!-- 삭제해야할 idx 게시물 번호도 hidden으로 보낸다 (임시방편) -->
			<input type="hidden" name="idx" value="${ vo.idx }">
			<!-- 현페이지에서 다른페이지에서 정보를 넘겨줄때 정보를 유지하는 기술 -->
			<input type="hidden" name="no"  value="${ vo.no }">
			
			<div class="panel panel-primary" id="p_${ vo.no }">
				<div class="panel-heading">
					<h4><b>${ vo.name }</b>님의 글 : ${ vo.ip }</h4>
				</div>
				<div class="panel-body">
					<div class="mycommon content">${ vo.content }</div>
					<div class="mycommon regdate"><b>작성일자 : </b>${ fn:substring(vo.regdate,0,16) }</div>
					<div class="mycommon pwd">비밀번호${ vo.pwd } : 
						<!-- c_pwd 수정 -->		
						<input class="form-control" type = "password" id="c_pwd">
						<input class="btn btn-info" type = "button" value="수정" onclick="modify_form(this.form)">
						<!-- delete onclick 추가 -->		
						<input class="btn btn-danger" type = "button" value="삭제" onclick="del(this.form);">
					</div>
				</div>
			</div>
		</form>
		</c:forEach>
	</div>

</body>
</html>