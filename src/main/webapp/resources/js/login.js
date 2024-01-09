


/*index.jsp 로그인 공백 유효성 추가*/
function login_check(){
	 if(m.username.value==""){
		   alert("닉네임을 입력하세요!");
	      	m.username.focus();
	       return false;
	 }
	 else if(m.password.value==""){
		   alert("비밀번호를 입력하세요!");
	      	m.password.focus();
	       return false;
	 }
}