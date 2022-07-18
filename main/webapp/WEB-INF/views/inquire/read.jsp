<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %> -->
<!-- <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> -->
<%@ page import="kg.groupc.project.util.DateTimeFormatUtil" %>
<c:set var="dateYMD" value="${DateTimeFormatUtil.changeToYMD(review.WDate)}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의상세</title>
<%-- 메인 스타일 sheet --%>

<%-- jQuery --%>


</head>
<body>
	<%-- 헤더 --%>
	<div>
		<jsp:include page="../header.jsp">
	</div>
	
	<%-- 메인 컨테이너 --%>
	<div class="inquire-container-main" style="height: auto;">
		<%-- 네비게이션 --%>
		<nav class="inquire-container_navi" style="height: 1200px">
		</nav>
	</div>
	
	<%-- 섹션 --%>
	<section id="inquireD-container">
		<div class="inquire-container-top">
			<%-- 제목 --%>
			<div class="common-top__title" style="color: #F6CECE;">
			문의하기		
			</div>
			<%-- 드릴타운 --%>
			<span class="common-top__drilldownbox">
				<a href="#" style="color: #F78181;">문의하기</a>
				<span> > </span>
				<a href="#">문의작성</a>
			</span>
		</div>
		
	<%-- 문의글 본문 --%>
		<table class="inquire-tableLayout">
			<tr>
				<td>글 번호</td>
				<td>
					<span id="in_cat">${inquire.seq}</span>
				</td>
				<td>작성일</td>
				<td>
					<span id="in_cat">${inquire.regDate}</span>
				</td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td>
					<span id="in_cat">${inquire.category}</span>
				</td>
				<td>
					<span id="in_cat">${inquire.hotelcode}</span>
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<span id="in_title">${inquire.title}</span>
				</td>
			</tr>
			<tr>
				<td>문의내용</td>
				<td>
					<p id="in_desc">
						${inquire.description}
					</p>
				</td>
			</tr>
		</table>
		
	</section>
	
	<%-- 풋터 --%>
	<footer>
		<jsp:include page="../footer.jsp"/>
	</footer>
</html>