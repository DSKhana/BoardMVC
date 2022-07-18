function getContextPath() {
    var hostIndex = location.href.indexOf( location.host ) + location.host.length;
    return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
}
function autoHypenPhone(str){
	str = str.replace(/[^0-9]/g, '');
	var tmp = '';
	if( str.length < 4){
		return str;
	}else if(str.length < 7){
		tmp += str.substr(0, 3);
		tmp += '-';
		tmp += str.substr(3);
		return tmp;
	}else if(str.length < 11){
		tmp += str.substr(0, 3);
		tmp += '-';
		tmp += str.substr(3, 3);
        tmp += '-';
        tmp += str.substr(6);
        return tmp;
	}else{              
		tmp += str.substr(0, 3);
		tmp += '-';
        tmp += str.substr(3, 4);
        tmp += '-';
        tmp += str.substr(7);
        return tmp;
	}
	return str;
}
//phone form에서 키 입력이 됬을 때, 동작
function setPhoneForm(phone){
	var _val = phone.value.trim();
    phone.value = autoHypenPhone(_val) ;
}
// 주소 검색
function searchAddress(){
	 new daum.Postcode({
	        oncomplete: function(data) {
	        	var roadAddress = data.roadAddress
	        	document.getElementById('address').value = roadAddress
	        }
	    }).open();
}
// 아이디 중복 검사
function idDuplicateCheck(){
	var dupck = document.getElementById('dupck')
	var input = document.getElementById('userId')
	var idResult = document.getElementById('idResultValid')
	var idResult2 = document.getElementById('idResultInvalid')
	if(idValidCheck(input)){
		$.ajax({
			url:`${getContextPath()}/signup/dupCheck`,
			type:'POST',
			data:{userId: input.value},
			success: function(result){
				if(result == true){
					dupck.value = 1
					input.className = 'form-control is-valid'
					idResult.innerText = '사용 가능한 ID입니다.'
				}else{
					dupck.value = 0
					input.className = 'form-control is-invalid'
					idResult2.innerText = '이미 존재하는 ID입니다.'
				}
			}
		});
	}
}
// id 유효성 검증
function idValidCheck(input){
	var regex = /^[a-z][a-z0-9]{7,15}$/;
	var idcheckBtn = document.getElementById('idcheck')
	var dupck = document.getElementById('dupck')
	var idResult = document.getElementById('idResultValid')
	var idResult2 = document.getElementById('idResultInvalid')
	dupck.value = 0
	if(regex.test(input.value)){
		input.className = 'form-control is-valid'
		idcheckBtn.className = 'btn btn-dark btn-sm'
		idResult.innerText = '올바른 아이디입니다.'
		return true
	}else if(input.value.length == 0){
		input.className = 'form-control'
		idcheckBtn.className = 'btn btn-dark btn-sm disabled'
	}else{
		input.className = 'form-control is-invalid'
		idcheckBtn.className = 'btn btn-dark btn-sm disabled'
		idResult2.innerText = '잘못된 아이디입니다.'
	}
	return false
}
// 비밀번호 유효성 검증
function passwordValid(input){
	var password = document.getElementById('password')
	var regex = /^^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{12,20}$/;
	if(regex.test(input.value)){
		input.className = 'form-control is-valid'
		return true
	}else if(input.value.length == 0){
		input.className = 'form-control'
	}else{
		input.className = 'form-control is-invalid'
	}
	return false
}
// 비밀번호, 비밀번호 확인 검사
function passwordCheckValid(input){
	var password = document.getElementById('password')
	
	if(passwordValid(input)){
		if(password.value != input.value){
			input.className = 'form-control is-invalid'
		}else{
			input.className = 'form-control is-valid'
		}
	}else if(input.value.length == 0){
		input.className = 'form-control'
	}else{
		input.className = 'form-control is-invalid'
	}
}
function dupCheckStatus(dupck){
	if(dupck.value == '1') {
		return true
	}
	else {
		alert("ID 중복 검사를 수행해주세요.")
		return false
	}
}