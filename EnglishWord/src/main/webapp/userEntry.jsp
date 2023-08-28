<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
th,td{
	padding: 10px 0px;
}

.th__space__ten {
	word-spacing:40px;
}

.th__space__five {
	word-spacing:10px;
}

.th__space__two {
	letter-spacing:1px;
}

.btn__word {
	background-color: transparent;
	color: var(--color-white);
	border: none;
    outline: none;
    cursor: pointer;
    padding: 8px;
    margin: 0px 30px;
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
	<div align="center">
		<h2 class="th__space__five">회 원 가 입</h2>
		<form action="register.do" method="post" name="frm" onsubmit="return check(this)">
			<input type="hidden" name="idChecked"/>
			
			<table style="margin-left: 30px;">
				<tr>
					<th class="th__space__ten">이 름 </th>
					<td><input type="text" name="NAME" size="20"/></td>
				</tr>
				<tr>
					<th class="th__space__ten">계 정  </th>
					<td><input type="text" name="USER_ID" size="20"/></td>
					<td><input class="btn__word" type="button" value="중복 검사" onclick="idCheck()" style="margin: 0px; padding: 0px 8px;"/></td>
				</tr>
				<tr>
					<th class="th__space__ten">암 호 </th>
					<td><input type="password" name="USER_PWD" size="20"/></td>
				</tr>
				<tr>
					<th class="th__space__two">암 호 확 인 </th>
					<td><input type="password" name="CONFIRM" size="20"/></td>
				</tr>
				<tr>
					<th class="th__space__five">연 락 처 </th>
					<td><input type="text" name="PHONE" size="20"/></td>
				</tr>
				<tr>
					<th class="th__space__five">이 메 일 </th>
					<td><input type="text" name="EMAIL" size="20"/></td>
				</tr>
			</table>
			<br>
			<hr width="250px;"/>
			<input class="btn__word" type="submit" value="회원 가입"/>
			<input class="btn__word" type="button" value="취 소" onclick="location.href='index.jsp?BODY=login.jsp'"/>
			<hr width="250px;"/>
		</form>
	</div>
	<script type="text/javascript">
		function idCheck(){
			if(document.frm.USER_ID.value ==''){
				alert("아이디를 입력하세요.");
				document.frm.USER_ID.focus();
				return;
			}
			var url = "idCheck.do?USER_ID="+document.frm.USER_ID.value;
			window.open(url,"_blank_","width=650,height=200");
		}
	
		function check(frm){
			if(frm.NAME.value==''){
				alert("이름을 입력하세요.");
				frm.NAME.focus();
				return false;
			}
			if(frm.idChecked.value==''){
				alert("아이디 중복을 확인해주세요.");
				return false;
			}
			if(frm.USER_ID.value==''){
				alert("아이디를 입력하세요.");
				frm.USER_ID.focus();
				return false;
			}
			if(frm.PHONE.value==''){
				alert("연락처를 입력하세요.");
				frm.PHONE.focus();
				return false;
			}
			if(frm.USER_PWD.value==''){
				alert("비밀번호를 입력하세요.");
				frm.USER_PWD.focus();
				return false;
			}
			if(frm.USER_PWD.value != frm.CONFIRM.value){
				alert("암호가 일치하지 않습니다.");
				frm.CONFIRM.focus();
				return false;
			}
			
			if(!confirm("입력한 내용이 맞습니까?")) return false;
		}
	</script>
</body>
</html>