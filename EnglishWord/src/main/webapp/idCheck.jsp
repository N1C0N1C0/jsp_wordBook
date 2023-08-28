<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">계정 중복 확인</h2>
	<form action="idCheck.do" name="frm">
		계 정 : <input type="text" name="USER_ID" value="${ID}"/>
		<input type="submit" value="중복 검사"/><br/>
		<c:if test="${!empty DUP }">
			<script type="text/javascript">
				opener.document.frm.USER_ID.value="";	// (중복)입력된 계정 지우기
			</script>
			${DUP }는 이미 사용 중입니다.
		</c:if>
		<c:if test="${empty DUP }">
			${ID }는 사용 가능합니다.
			<input type="button" value="사용" onclick="idOk()"/>
		</c:if>
	</form>
	<script type="text/javascript">
		function idOk(){
			opener.document.frm.USER_ID.value=document.frm.USER_ID.value;
			opener.document.frm.idChecked.value = "OK";
			opener.document.frm.USER_ID.readOnly = true;
			self.close();
		}
	</script>
</body>
</html>