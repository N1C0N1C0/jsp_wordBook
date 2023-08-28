<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" />
<style type="text/css">
.th__space__ten {
	word-spacing:40px;
}
.btn__word {
	background-color: transparent;
	color: var(--color-white);
	border: none;
    outline: none;
    cursor: pointer;
    padding: 8px;
    margin: 0px 20px;
    font-family:"맑은 고딕";
    font-size: 16px;
}

.btn__word:hover {
	background-color: var(--color-white);
	color: var(--color-black);
	border-radius: var(--size-border-radius);
	padding: 8px;
}

</style>
</head>
<body>
	<div>
		<h2>로 그 인</h2>	
		<br/>
		<form action="login.do" method="post" onsubmit="return check(this)">
			<span class="th__space__ten">계 정</span>&nbsp;&nbsp;<input type="text" name="ID" size="15"/><br/><br/>
			<span class="th__space__ten">암 호</span>&nbsp;&nbsp;<input type="password" name="PWD" size="15"/><br/>
			<br/>
			<hr width="200px;"/>
			<input class="btn__word" type="submit" value="로그인"/>
			<input class="btn__word" type="button" value="취 소" onclick="location.href='index.jsp'"/>
			<hr width="200px;"/>
		</form><br/>
		<a href="index.jsp?BODY=userEntry.jsp" class="navbar__menu__item">가입하기</a>
	</div>
	
	<script type="text/javascript">
		function check(frm){
			if(frm.ID.value ==''){
				alert("아이디를 입력하세요.");
				frm.ID.focus();
				return false;
			}
			if(frm.PWD.value ==''){
				alert("비밀번호를 입력하세요.");
				frm.PWD.focus();
				return false;
			}
		}
	</script>
</body>
</html>