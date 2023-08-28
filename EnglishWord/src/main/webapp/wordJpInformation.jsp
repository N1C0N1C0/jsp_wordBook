<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
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
    margin: 0px 15px;
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
	<c:if test="${empty DTO}">
			<h2>존재하지 않는 게시글입니다.</h2>
		</c:if>
		<c:if test="${!empty DTO}">
			<h2>단어 정보</h2>
			<form action="wordJpModify.do" method="post" onsubmit="return check()">
			<input type="hidden" name="SEQNO" value="${DTO.seqno}"/> 
				<table>
					<tr>
						<th class="th__space__ten">단 어</th>
						<td>
							&nbsp;&nbsp;<input type="text" name="WORD" value="${DTO.word}">
						</td>
					</tr>
					<tr>
						<th class="th__space__ten">의 미</th>
						<td>
							&nbsp;&nbsp;<input type="text" name="MEAN" value="${DTO.mean}">
						</td>
					</tr>
					<tr>
						<th class="th__space__ten">발 음</th>
						<td>
							&nbsp;&nbsp;<input type="text" name="PRONUCTIATION" value="${DTO.pronunciation}">
						</td>
					</tr>
					<tr>
						<th class="th__space__two">한 글 발 음</th>
						<td>
							&nbsp;&nbsp;<input type="text" name="K_PRONUCTIATION" value="${DTO.k_pronunciation}">
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<br/>
						<hr width="250px;"/>
							<input class="btn__word" type="submit" value="수정" name="BTN"/>
							<input class="btn__word" type="submit" value="삭제" name="BTN"/>
							<input class="btn__word" type="button" value="뒤로" name="BACK" onclick="back()">
						<hr width="250px;"/>
						</td>
					</tr>
			</table>
			</form>
		</c:if>
		</div>
		<script type="text/javascript">
			function check(){
				if(!confirm("계속 진행하시겠습니까?")) return false; 
			}
			
			function back(){
				history.back();
			}
		</script>
</body>
</html>