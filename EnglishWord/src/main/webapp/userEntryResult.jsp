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
				alert("축하합니다~ 가입되었습니다.");
			},100);
		</script>
	</c:if>
	<c:if test="${param.R == 'NOK' }">
		<script type="text/javascript">
			setTimeout(()=>{
				alert("가입을 실패하였습니다. 관리자에 문의바랍니다.");
			},100);
		</script>
	</c:if>
</body>
</html>