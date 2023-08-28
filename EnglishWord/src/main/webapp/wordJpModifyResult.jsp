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
	<c:if test="${param.R == 'OK' }">
		<script type="text/javascript">
			setTimeout(()=>{
				alert("작업 성공!!");
				location.href="japaneseWord.do?page=1";
			},100);
		</script>
	</c:if>
	<c:if test="${param.R == 'NOK' }">
		<script type="text/javascript">
			setTimeout(()=>{
				alert("작업 실패!!");
				location.href="japaneseWord.do?page=1";
			},100);
		</script>
	</c:if>
</body>
</html>