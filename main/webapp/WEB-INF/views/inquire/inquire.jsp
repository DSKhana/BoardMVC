<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page import="kg.groupc.project.util.DateTimeFormatUtil" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의하기</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.2.0/css/boostrap.min.css">

<%-- Main Style Sheet --%>

</head>
<body>
	<%-- Header --%>
	<div>
		<jsp:include page="../header.jsp"/>
	</div>
	
	<%-- Navigation --%>
	
	<%-- 상단 제목 --%>
	<div class="crew-topContainer" style="width: 1100px">
		<%-- 제목 --%>
		<div class="common-top_title" style="color: #FAAC58">
		문의하기
		</div>
	</div>

	<div class="inquire-topContainer" style="width: 1100px; top: 20px">
		<c:if test="${isJoinedMember}">
			<button id="inuire-btn-write" class="inquire-write"
				onclick="location.href='/inquire/inquireWriteForm'">
			</button>
		</c:if>
	</div>

	<%-- 검색바 --%>
	<div id="inquire_search" class="common-searchbar">
		<select name="search"> <%-- 검색조건 --%>
			<option value="0">제목</option>
			<option value="1">내용</option>
			<option value="2">작성자</option>	
		</select>
		<input type="text"> <%-- 검색어 입력 --%>
		<button class="search_button">  <%-- 검색 버튼 --%>
			<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="white" class="bi-search" 
			viewBox="0 0 16 16">			
			</svg>
		</button>
	</div>

	<%-- 글쓰기 버튼 --%>
	<div id="inquire-top-buttonbox">
		<button class="write-button" onclick="location.href='/inquire/write'">글쓰기</button>

	</div>

	<%-- 글 목록 --%>	
	<div id="inquire-list">
		<table class="table table-hover">
		  <thead>
		    <tr>
		      <th scope="col">글번호</th>
		      <th scope="col">카테고리</th>
		      <th scope="col">제목</th>
		      <th scope="col">등록일</th>
		      <th scope="col">작성자</th>
		      <th scope="col">답변상태</th>	      
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${reviewList.content}" var="reviewList" begin="0" end="40">
		  		<c:set var="dateYMD" value="${DateTimeFormatUtil.changeToYMD(reviewList.WDate)}"/>
		  		<tr class="list-item, status: ${items.getContent()}" scope="row" class="table-active">
		      
			      <td>th:text="${inquire.seq}"></td>
			      <td>${inquire.category}</td>
			      <td>${inquire.title}</td>
			      <td>${inquire.regDate}</td>
			      <td>${inquire.writer}</td>
			      <td>${inquire.status}</td>
			    </tr>		  	
		  	</c:forEach>		    
		  </tbody>
		</table>
	</div>
	
	<%--Page Nation --%>
	<div id="inquire-bottom_pagenation">
		<table class="pagenation">
			<tr>
				<!-- 첫 페이지로 이동 -->
				<td>
					<a href="/review?page=0"> << </a>
				</td>
				<!-- 이전 페이지로 이동 : 첫 페이지 제외 -->
                <c:if test="${startBlockPage ne 1}">
                    <td>
                        <a href="/review?page=${startBlockPage-2}">
                            < </a>
                    </td>
                </c:if>

                <!-- 페이징 블록 1 ~ 10 -->
                <c:forEach begin="${startBlockPage}" end="${endBlockPage}" var="idx">
                    <td>
                        <a href="/review?page=${idx-1}">${idx}</a>
                    </td>
                </c:forEach>

                <!-- 다음 페이지로 이동 : 마지막 페이지 제외 -->
                <c:if test="${endBlockPage ne reviewList.totalPages}">
                    <td>
                        <a href="/review?page=${endBlockPage}">
                            > </a>
                    </td>
                </c:if>

                <!-- 마지막 페이지로 이동 -->
                <td>
                    <a href="/review?page=${reviewList.totalPages-1}">
                        >> </a>
                </td>
            </tr>				
		</table>	
	</div>
	
	<%-- footer --%>
    <footer>
        <jsp:include page="../footer.jsp"/>
    </footer>	
</body>
</html>