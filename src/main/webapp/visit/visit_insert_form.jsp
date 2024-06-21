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
    font-family: 'MabinogiClassicR';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2207-01@1.0/MabinogiClassicR.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
}

* {
    font-family: "MabinogiClassicR";
}

#title {
	text-align: center;
	font-size: 28px;
	
	margin-bottom: 60px
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
		
		// 입력값 검증
		let name = f.name.value.trim();
		let content = f.content.value.trim();
		let pwd = f.pwd.value.trim();
		
		if(name=='') {
			alert("작성자명을 입력하세요!")
			f.name.value = "";
			f.name.focus();
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
		
		f.method = "GET";
		f.action = "insert.do";// 전송대상(VisitInsertAction)
		f.submit();
	}

</script>

</head>
<body>
	<form>
		<div id="box">
			<h1 id="title">여러분의 방문을 환영합니다.</h1>
			<!-- Ctrl + Shift + F -->
			<div class="panel panel-primary">
				<div class="panel-heading"><h4>글쓰기</h4></div>
				<div class="panel-body">
					<table class="table">
						<tr>
							<th>작성자</th>
							<td><input class="form-control" name="name" required="required" autofocus></td>
						</tr>
						
						<tr>
							<th>내용</th>
							<td>
								<textarea class="form-control" rows="5" name="content" required="required"></textarea>
							</td>
						</tr>
						
						<tr>
							<th>비밀번호</th>
							<td><input class="form-control" type="password" name="pwd" required="required"></td>
						</tr>
						
						<tr>
							<td colspan="2" align="center">
								<input class="btn btn-success" type="button" value="목록보기"
									onclick="location.href='list.do'">
								<input class="btn btn-primary" type="button" value="글올리기"
									onclick="send(this.form)">
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</form>
</body>
</html>