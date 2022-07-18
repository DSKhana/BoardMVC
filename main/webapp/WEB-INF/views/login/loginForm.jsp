<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Title</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<style type="text/css">
		.login-form{margin:auto; width:700px}
	</style>
</head>
<body>
	<c:import url="${pageContext.request.contextPath}/nav"></c:import>
	
	<form class="login-form" method="post" action="${pageContext.request.contextPath}/login/loginProc">
		<fieldset>
			<legend>Login</legend>
			<div class="form-group has-danger has-success">
				<label class="form-label mt-4" for="inputID">ID</label>
				<div class="input-group">
					<input type="text" placeholder="ID input" class="form-control" id="userId" name="userId">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="form-label mt-4">Password</label>
				<input type="password" class="form-control" id="password" name="password" placeholder="Password">
			</div>
			<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
				<div>
					<p class="error" style="color:red; font-weight:bold;">${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
					<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session" />
				</div>
			</c:if>
			<div class="d-grid gap-2">
			  <br><button class="btn btn-lg btn-primary" type="submit">로그인</button>
			</div>
		</fieldset>
	</form>	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>