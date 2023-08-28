<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib  uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 100%;
    border-top: 1px solid var(--color-white);
    border-collapse: collapse;
    table-layout: fixed;
}

th, td {
	border-bottom: 1px solid var(--color-white);
    border-left: 1px solid var(--color-white);
    padding: 10px;
    height: auto;
    
}

th:first-child, td:first-child {
    border-left: none;
}

.title{
	background-color: var(--color-grey);
}

.btn__word {
	background-color: transparent;
	color: var(--color-white);
	border: none;
    outline: none;
    cursor: pointer;
    padding: 4px;
    font-family:"맑은 고딕";
    font-size: 16px;
}

.btn__word:hover {
	background-color: var(--color-white);
	color: var(--color-black);
	border-radius: var(--size-border-radius);
	padding: 4px;
}

.selector__none {
	pointer-events : none;
	text-decoration-line : underline;
	text-decoration-style: double;
}

.page__num {
	margin: 0px 4px;
	padding: 0px 8px;
	font-size: 18px;
}

.page__num:hover {
	background-color: var(--color-white);
	color: var(--color-black);
	border-radius: 50%;
}

</style>
</head>
<body>
	<div align="center" style="margin-top: -60px;">
		<c:choose>
		<c:when test="${empty sessionScope.USER }">
			<h2>로그인 이후 사용가능합니다.</h2>
		</c:when>
		<c:otherwise>
			<c:if test="${empty LIST}">
				<h2>등록된 게시글이 존재하지 않습니다.</h2>
				<a href="index.jsp?BODY=wordJpWrite.jsp">글 등록</a>
			</c:if>
			<c:if test="${!empty LIST}">
				<h2>일본어 단어</h2><br/>
				<table class="table__table">
					<tr class="title">
						<th>단 어</th>
						<th>의 미</th>
						<th>발 음</th>
						<th>한글 발음</th>
					</tr>
					<c:forEach items="${LIST}" var="jp">
						<tr>
							<td><a href="wordJpRead.do?SEQNO=${jp.seqno}" class="btn__word">${jp.word }</a></td>
							<td>${jp.mean }</td>
							<td>${jp.pronunciation }</td>
							<td>${jp.k_pronunciation }</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="3" align="center">
						<c:if test="${PREV}">
							<a href="japaneseWord.do?page=${START-5}" class="page__num">이전</a>
						</c:if>
							<c:forEach begin="${START }" end="${END}" var="page"> 
								<c:choose>
									<c:when test="${PAGE==page}">
										<a href="japaneseWord.do?page=${page}" class="selector__none page__num">${page}</a>
									</c:when>
									<c:otherwise>
										<a href="japaneseWord.do?page=${page}" class="page__num">${page}</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${NEXT}">
								<a href="japaneseWord.do?page=${END +1}" class="page__num">다음</a>
							</c:if>
						</td>
						<td colspan="1" align="center"><input type="button" class="btn__word" value="단어 추가" onclick="btn_click()"></td>
					</tr>
				</table>
				
			</c:if>
		</c:otherwise>
		</c:choose>
	</div>
	<script type="text/javascript">
		function btn_click(){
			location.replace('index.jsp?BODY=wordJpWrite.jsp');
		}
	</script>
</body>
</html>