<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>navigation</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm navbar-light">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Kingsman</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	
	    <div class="collapse navbar-collapse justify-content-between" id="navbarColor02">
<!-- 	      <ul class="navbar-nav container-fluid justify-content-around"> -->
	      <ul class="navbar-nav">
	        <li class="nav-item">
	          <a class="nav-link" href="${pageContext.request.contextPath}/">Home
	            <span class="visually-hidden">(current)</span>
	          </a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="${pageContext.request.contextPath}/hotel">Hotel</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="${pageContext.request.contextPath}/restaurant">Restaurant</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="${pageContext.request.contextPath}/inquire">Inquire</a>
	        </li>
	      </ul>
	      <div class="d-flex">
	      	<sec:authorize access="isAuthenticated()">
		        <div class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" 
		          	role="button" aria-haspopup="true" aria-expanded="false" style="min-width: 180px;">
		          	<sec:authentication property="principal.username"/>	님
		          </a>
		          <div class="dropdown-menu">
		            <a class="dropdown-item" href="${pageContext.request.contextPath}/mypage">마이 페이지</a>
		            <sec:authorize access="hasRole('ROLE_ADMIN')">
		            	<a class="dropdown-item" href="${pageContext.request.contextPath}/admin">관리자 페이지</a>
		            </sec:authorize>
		            <div class="dropdown-divider"></div>
		            	<a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Logout</a>
		          </div>
		        </div>
	        </sec:authorize>
	        <sec:authorize access="!isAuthenticated()">
	        	<div class="nav-item" style="margin: auto 0;">
		        	<a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
	        	</div>
	        	<div class="nav-item">
		        	<a class="nav-link" href="${pageContext.request.contextPath}/signup">
	        			<button class="btn btn-outline-info" type="button">SignUp</button>
	        		</a>
        		</div>
	        </sec:authorize>
	      </div>
	    </div>
	  </div>
	</nav>
</body>
</html>