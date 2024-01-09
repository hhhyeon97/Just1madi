
/*join.jsp 회원가입 공백 유효성 추가*/
function check() {
    if (m.username.value == 0) {
        alert("닉네임을 입력하세요!");
        m.username.focus();
        return false;
    } else if (m.password.value == 0) {
        alert("비밀번호를 입력하세요!");
        m.password.focus();
        return false;
    } else if ($("#idcheck").text() !== '사용 가능한 닉네임입니다.') {
        alert("닉네임 중복검사를 먼저 진행해주세요.");
        return false;
    } else {
        var isDuplicate = $("#idcheck").data("isDuplicate");
        if (isDuplicate) {
            alert("중복된 닉네임입니다. 다른 닉네임을 입력해주세요.");
            return false;
        } else {
            alert("회원가입에 성공하였습니다!");
            document.m.submit();
            return true;
        }
    }
}
function id_check() {
    $("#idcheck").hide();
    var username = $.trim($("#username").val());
    if (username.length < 4) {
        $("#idcheck").text("닉네임은 4자 이상이어야 합니다.").css("color", "red").show();
        $("#username").val('').focus();
        $("#idcheck").data("isDuplicate", true);
        return false;
    } else if (username.length > 12) {
        $("#idcheck").text("닉네임은 12자 이하이어야 합니다.").css("color", "red").show();
        $("#username").val('').focus();
        $("#idcheck").data("isDuplicate", true);
        return false;
    } else if (!(validate_userid(username))) {
        $("#idcheck").html("닉네임은 영문 소문자, 숫자, 한글,<br>밑줄(_) 조합만 가능합니다.").css("color", "red").show();
        $("#username").val('').focus();
        $("#idcheck").data("isDuplicate", true);
        return false;
    } else {
        $.ajax({
            type: "POST",
            url: "/idCheck",
            data: {"username": username},
            success: function(data) {
                if (data.result === "duplicate") {
                    $("#idcheck").text("중복된 닉네임입니다.").css("color", "red").data("isDuplicate", true);
                } else {
                    $("#idcheck").text("사용 가능한 닉네임입니다.").css("color", "blue").data("isDuplicate", false);
                }
            },
            error: function () {
                alert("서버 오류가 발생했습니다.");
            }
        });
    }
}

function validate_userid(username) {
	  var pattern = /^[a-z0-9_\uAC00-\uD7A3]+$/; // 영문 소문자, 숫자, 한글, 밑줄(_) 포함한 패턴
	  return pattern.test(username);
	}