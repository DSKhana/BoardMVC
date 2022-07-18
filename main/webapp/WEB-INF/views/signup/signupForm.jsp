<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
		integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/signup.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<!-- Kakao daum postcode -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<style type="text/css">
		.signup-form{margin:auto; width:700px;}
		.submit-reset{float:right;}
		.error-msg{color:red;}
	</style>
</head>
<body onload="idDuplicateCheck()">
	<c:import url="${pageContext.request.contextPath}/nav"></c:import>
	
	<form class="signup-form" method="post" action="${pageContext.request.contextPath}/signup"
			onsubmit="return dupCheckStatus(this.dupck)">
	  <fieldset>
		<br><legend>Sign Up</legend>
			<div class="form-group">
				<input type="text" placeholder="Name" class="form-control" id="username" name="username" 
				value="${signupFormDto.username}">
				<c:if test="${valid_username ne null}">
					<small id="userId-error-msg" class="form-text error-msg">${valid_username}</small>
				</c:if>
			</div>
			<div class="form-group has-danger has-success">
				<label class="form-label mt-4" for="inputID">ID</label>
				<div class="input-group">
					<input type="text" placeholder="ID input" class="form-control" id="userId" name="userId" 
						oninput="idValidCheck(this)" value="${signupFormDto.userId}">
					<button type="button" class="btn btn-dark btn-sm disabled" name="idcheck" id="idcheck"
						onclick="idDuplicateCheck()" style="float:right;">중복 검사</button>
					<div class="invalid-feedback"><span id="idResultInvalid">잘못된 아이디입니다.</span></div>
					<div class="valid-feedback"><span id="idResultValid">올바른 아이디입니다.</span></div>
				</div>
				<small id="idHelp" class="form-text text-muted">
					ID는 8자부터 16자까지 영어소문자 및 숫자만 사용 가능합니다.</small>
				<c:if test="${valid_userId ne null}">
					<br><small id="userId-error-msg" class="form-text error-msg">${valid_userId}</small>
				</c:if>
				<input type="hidden" id="dupck" name="dupck" value="0"> 
			</div>
			<div class="form-group">
				<label for="password" class="form-label mt-4">Password</label>
				<input type="password" class="form-control" id="password" name="password" 
					placeholder="Password" oninput="passwordValid(this)" value="${signupFormDto.password}">
				<div class="invalid-feedback"><span id="idResultInValid">비밀번호가 취약합니다.</span></div>
				<div class="valid-feedback"><span id="idResultValid">비밀번호 이상 없습니다.</span></div>
				<small id="pwdHelp" class="form-text text-muted">
					비밀번호는 12자부터 20자까지 알파벳, 숫자, 특수문자만 사용 가능합니다.</small><br>
				<small id="pwdHelp2" class="form-text text-muted">
					적어도 각각 하나의 알파벳, 숫자, 특수문자가 입력되어야 합니다.</small>
				<c:if test="${valid_password ne null}">
					<br><small id="userId-error-msg" class="form-text error-msg">${valid_password}</small>
				</c:if>
			</div>
			<div class="form-group">
				<label for="passwordCheck" class="form-label mt-4">Password Check</label>
				<input type="password" class="form-control" id="passwordCheck" name="passwordCheck" 
						placeholder="Password Check" oninput="passwordCheckValid(this)" 
						value="${signupFormDto.passwordCheck}">
				<div class="invalid-feedback"><span id="idResultInValid">비밀번호 확인이 잘못되었습니다.</span></div>
				<div class="valid-feedback"><span id="idResultValid">비밀번호 확인 이상 없습니다.</span></div>
				<c:if test="${valid_passwordCheck ne null}">
					<small id="userId-error-msg" class="form-text error-msg">${valid_passwordCheck}</small>
				</c:if>
			</div>
			<div class="form-group">
				<label for="email" class="form-label mt-4">Email Address</label>
				<input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" 
					placeholder="Enter email" value="${signupFormDto.email}">
				<c:if test="${valid_email ne null}">
					<br><small id="userId-error-msg" class="form-text error-msg">${valid_email}</small>
				</c:if>
			</div>
			<div class="form-group">
				<label for="phone" class="form-label mt-4">Phone Number</label>
				<input type="text" class="form-control" id="phone" name="phone" placeholder="010-1234-5678" maxlength="13" 
					oninput="setPhoneForm(this)" value="${signupFormDto.phone}">
				<c:if test="${valid_phone ne null}">
					<small id="userId-error-msg" class="form-text error-msg">${valid_phone}</small>
				</c:if>
			</div>
			<div class="form-group">
				<label for="address" class="form-label mt-4">Address</label>
				<div class="input-group">
					<input type="text" class="form-control" id="address" name="address" placeholder="" 
						value="${signupFormDto.address}" readonly>
					<input type="button" class="btn btn-outline-dark" value="검색" onclick="searchAddress()">
				</div>
				<c:if test="${valid_address ne null}">
					<small id="userId-error-msg" class="form-text error-msg">${valid_address}</small>
				</c:if>
				<input type="text" class="form-control" id="addressDetail" name="addressDetail" 
					placeholder="상세 주소" value="${signupFormDto.addressDetail}">
				<c:if test="${valid_addressDetail ne null}">
					<small id="userId-error-msg" class="form-text error-msg">${valid_addressDetail}</small>
				</c:if>
			</div>
			<div class="form-group">
				<label for="birth" class="form-label mt-4">Birth</label>
				<input type="number" class="form-control" id="birth" name="birth" placeholder="ex) 20220101" 
					maxlength="8" value="${signupFormDto.birth}">
				<c:if test="${valid_birth ne null}">
					<small id="userId-error-msg" class="form-text error-msg">${valid_birth}</small>
				</c:if>
			</div>
			<br><div class="submit-reset">
				<button type="reset" class="btn btn-primary">Reset</button>
				<button type="submit" class="btn btn-primary">Sign up</button>
			</div>
			<br><br><br><br>
		</fieldset>
	</form>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" 
	crossorigin="anonymous"></script>

</body>
</html>