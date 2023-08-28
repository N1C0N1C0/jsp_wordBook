<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
      href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&display=swap"
      rel="stylesheet"
    />
<link rel="stylesheet" href="style.css"/>
</head>
<body>
	<nav id="navbar">
      <div class="navbar__logo">
        <i class="fab fa-diaspora"></i>
        <a href="index.jsp">WORD BOOK</a>
      </div>
        <ul class="navbar__menu">
        	<c:if test="${empty sessionScope.MASTER}">
          		<li class="navbar__menu__item"><a href="englishWord.do?page=1">영어</a></li>
          	</c:if>
          	<c:if test="${empty sessionScope.MASTER}">
          		<li class="navbar__menu__item"><a href="japaneseWord.do?page=1">일본어</a></li>
          	</c:if>
          
          	<c:if test="${sessionScope.MASTER != null}">
				<li class="navbar__menu__item"><a href="masterWord.do">전체 단어</a></li>
			</c:if>
		
        </ul>
        <c:choose>
			<c:when test="${empty sessionScope.USER && empty sessionScope.MASTER}">
				<a href="index.jsp?BODY=login.jsp" class="navbar__menu__item">로그인</a>
			</c:when>
			<c:otherwise>
				<a href="logout.do" class="navbar__menu__item">로그아웃</a>
			</c:otherwise>
		</c:choose>	
    </nav>
    <section id="home">
    	<div class="section">
   	
		<c:set var="content" value="${param.BODY}"/>
		<c:choose>
			<c:when test="${not empty content}">
				<jsp:include page="${content}"/>
			</c:when>
			<c:otherwise>
			<div style="width: 50%; margin:auto;">
				<div style="border: 1px solid var(--color-white);">
					<h1 style="color: var(--color-white);" >
						Word Book <br/>＆<br/> 
						&nbsp;&nbsp;&nbsp;&nbsp;単語帳 　
					</h1>
				</div>
				<br/>
				<h2>안녕하세요.</h2>
				<br/>
				<h2>Hello</h2>
				<br/>
				<h2>ようこそ</h2>
			</div>
			</c:otherwise>
		</c:choose>
    	</div>
    </section>
    <footer id="footer">
     
    </footer>
</body>
</html>