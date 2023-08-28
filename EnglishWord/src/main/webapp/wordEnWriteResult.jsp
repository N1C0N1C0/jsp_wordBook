<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${param.R == 'OK' }">
		<script type="text/javascript">
			setTimeout(()=>{
				alert("단어가 등록되었습니다.");
				location.href="englishWord.do?page=1";
			},100);
		</script>
	</c:if>
	<c:if test="${param.R == 'NOK' }">
		<script type="text/javascript">
			setTimeout(()=>{
				alert("단어가 등록되지 않았습니다. 관리자에게 문의하세요.");
				location.href="englishWord.do?page=1";
			},100);
		</script>
	</c:if>
</body>
</html>