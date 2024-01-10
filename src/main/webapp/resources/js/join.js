
/*join.jsp 회원가입 검증 */
 
function join_check(){
	if($.trim($("#username").val())==""){
		alert("닉네임을 입력하세요!");
		$("#username").val("").focus();
		return false;
	}
	$password=$.trim($("#password").val());
	if($password == ""){
		alert("비밀번호를 입력하세요!");
		$("#password").val("").focus();
		return false;
	}
	
	 // 중복 닉네임 검사가 성공적으로 이루어졌을 때만 폼을 제출
    var idCheckText = $("#idcheck").text();
    if (idCheckText === '사용 가능한 닉네임 입니다.') {
        alert("회원가입을 축하합니다!");
        return true;  // 폼 제출을 허용
    } else if (idCheckText === '중복 닉네임 입니다.') {
        alert("이미 존재하는 닉네임 입니다.");
        $("#username").val("").focus();
        return false;  // 폼 제출을 허용하지 않음
    } else {
        alert("닉네임 체크를 하지 않았거나 사용할 수 없는 닉네임입니다!");
        $("#username").val("").focus();
        return false;  // 폼 제출을 허용하지 않음
    }
		
	
}

//닉네임 유효성 체크 + 중복닉네임 검색
function id_check(){
	$("#idcheck").hide();
	$username=$.trim($("#username").val());
	if($username.length < 4){
		$newtext='<font color="red" size="3"><b>아이디는 4자 이상이어야 합니다.</b></font>';
		$("#idcheck").text('');
		$("#idcheck").show();
		$("#idcheck").append($newtext);
		$("#username").val('').focus();
		return false;
	};
	if($username.length > 12){
		$newtext='<font color="red" size="3"><b>아이디는12자 이하이어야 합니다.</b></font>';
		$("#idcheck").text('');
		$("#idcheck").show();
		$("#idcheck").append($newtext);
		$("#username").val('').focus();
		return false;
	};
	if(!(validate_username($username))){
		$newtext='<font color="red" size="3"><b>아이디는  영문 소문자, 숫자,<br>한글, 밑줄(_) 조합만 가능합니다.</b></font>';
		$("#idcheck").text('');
		$("#idcheck").show();
		$("#idcheck").append($newtext);
		$("#username").val('').focus();
		return false;
	};
    $.ajax({
        type:"POST",   
        url:"idCheck", 
        data: {"username":$username},
        datatype:"int",
        success: function (data) {
      	  if(data==1){//중복 닉네임이 있다면
      		$newtext='<font color="red" size="3"><b>중복 닉네임 입니다.</b></font>';
      		$("#idcheck").text('');
        	$("#idcheck").show();
        	$("#idcheck").append($newtext);          		
          	$("#username").val('').focus();
          	 console.log("중복 닉네임 입니다!");
          	return false;
      	  }else{//중복 닉네임이 아니면
      		$newtext='<font color="blue" size="3"><b>사용 가능한 닉네임 입니다.</b></font>';
      		$("#idcheck").text('');
      		$("#idcheck").show();
      		$("#idcheck").append($newtext);
      		$("#password").focus();
      		console.log("중복 닉네임이 아닙니다!");
      	  }  	    	  
        },
    	  error:function(){
    		  alert("data error");
    	  }
      });
}


// 닉네임 패턴 정의
function validate_username(username) {
	  var pattern = /^[a-z0-9_\uAC00-\uD7A3]+$/; // 영문 소문자, 숫자, 한글, 밑줄(_) 포함한 패턴
	  return pattern.test(username);
	}