<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
<style type="text/css">
@font-face {
    font-family: 'Pretendard-Regular';
    src: url('https://fastly.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff');
    font-weight: 400;
    font-style: normal;
}

* {
    font-family: "Pretendard-Regular";
}

#title {
	text-align: center;
	font-size: 28px;
	
	margin-bottom: 60px;
}

#box {
	width: 600px;
	margin: auto;
	margin-top: 100px;
}

textarea {
	resize: none;
}

th {
	vertical-align: middle !important;
	width: 15%;
}

</style>

<script type="text/javascript">
	function send(f) {
		
		let name = f.name.value.trim();
		let title = f.title.value.trim();
		let content = f.content.value.trim();
		let pwd = f.pwd.value.trim();
		
		if(name=='') {
			alert("작성자명을 입력하세요!")
			f.name.value = "";
			f.name.focus();
			return;
		}
		
		if(title=='') {
			alert("제목을 입력하세요!")
			f.title.value = "";
			f.title.focus();
			return;
		}
		
		if(content=='') {
			alert("내용을 입력하세요!")
			f.content.value = "";
			f.content.focus();
			return;
		}
		
		if(pwd=='') {
			alert("비밀번호를 입력하세요!")
			f.pwd.value = "";
			f.pwd.focus();
			return;
		}
		
		f.method="POST";
		f.action="insert.do";
		f.submit();
	}
</script>
</head>
<body>
	<form>
		<div id="box">
			<h1 id="title">여러분의 방문을 환영합니다.</h1>
			<div class="panel panel-primary">
				<div class="panel-heading"><h4>글쓰기</h4></div>
				<div class="panel-body">
					<table class="table">
						<tr>
							<th>작성자</th>
							<td><input class="form-control" name="name" required="required" autofocus></td>
						</tr>
						<tr>
							<th>제목</th>
							<td><input class="form-control" name="title" required="required" autofocus></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea class="form-control" rows="5" name="content" required="required"></textarea></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input class="form-control" type="password" name="pwd" required="required"></td>
						</tr>
							<td colspan="2" align="center">
								<input class="btn btn-success" type="button" value="목록보기" onclick="location.href='list.do'">
								<input class="btn btn-primary" type="button" value="글올리기" onclick="send(this.form)">
							</td>
					</table>
				</div>
			</div>
		</div>
	</form>
</body>
</html>