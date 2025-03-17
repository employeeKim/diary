$(document).ready(function() {
	init();
});

function init() {
	/* 시계 */
	setInterval(updateClock, 1000);
	updateClock();
	/******/

	// 모달창이 닫혔을 때 초기화
	$("#signModal").on("hidden.bs.modal", function () {
	    $("#signForm")[0].reset(); // 입력값 초기화
	    $("#memberIdError, #pwError, #rePwError, #nameError, #phoneError, #emailError").text(""); // 오류 메시지 초기화
	    $("#isMemberBtn").prop("disabled", false).text("중복 확인"); // 버튼 활성화 및 텍스트 원래대로
	});

	// 아이디 중복체크 버튼
	$('#isMemberBtn').click(function () {
		isMemberCheck();
	});

	// 회원가입 버튼
	$('#btnSign').click(function() {
		sign();
	});

	$('#btnLogin').click(function() {
		login();
	});

	$('#btnLogout').click(function() {
		logout();
	});

	$('#btnCertification').click(function (){ 
		phoneCertification();
	});
	
	$("#id, #loginPw").keyup(function (event) {
	    if (event.key === "Enter" || event.keyCode === 13) {
	        $("#btnLogin").click(); // 로그인 버튼 클릭 이벤트 실행
	    }
	});
}

function isMemberCheck() {
	var memberId = $('#memberId').val().trim();

	if (!memberId) {
	    $('#memberIdError').text("아이디를 입력하세요.");
		$('#memberId').focus();
	} else if (memberId.length < 6) {
	    $('#memberIdError').text("아이디는 6~14자리여야 합니다.");
		$('#memberId').focus();
	} else {
	    // 조건을 만족하면 AJAX 요청 실행
	    $.ajax({
	        url: "/isMemberIdCheck",
	        type: "GET",
	        data: { memberId: memberId },
	        success: function (data) {
	            alert(data.message);
	            if (data.status !== 'fail') {
	                $("#isMemberBtn").prop("disabled", true).text("사용 가능"); // 버튼 비활성화 + 텍스트 변경
	            }
	        },
	        error: function () {
	            alert("서버 오류가 발생했습니다.");
	        }
	    });
	}

}

function sign() {
	if($("#isMemberBtn").prop("disabled") || $("#certificationBox").prop("disabled")) {
		if (signValidator()) {
			var data = JSON.stringify({
				memberId: $('#memberId').val(),
				pw: $('#pw').val(),
				name: $('#name').val(),
				phone: $('#phone').val(),
				birth: $('#birth').val(),
				email: $('#email').val()
			})
			$.ajax({
				url: "/join",
				type: "POST",
				contentType: "application/json",
				dataType: "json",
				data: data,
				success: function(data) {
					alert('회원가입 완료!');
					$('#btnClose').click();
				},
				error: function(e) {
					console.log(e);
				}
			});
		}
	} else {
		$('#memberIdError').text('아이디 중복을 체크해주세요.');
		$('#memberId').focus();
	}
}

function login() {
	if($('#id').val() == '') {
		alert('아이디를 입력해주세요.');
		$('#id').focus();
	} else if ($('#loginPw').val() == '') {
		alert('비밀번호를 입력해주세요.');
		$('#loginPw').focus();
	} else {
		var data = JSON.stringify({
			memberId: $('#id').val(),
			pw: $('#loginPw').val(),
		})
		$.ajax({
			url: "/login",
			type: "POST",
			contentType: "application/json",
			dataType: "json",
			data: data,
			success: function(data) {
				console.log(data);
				if (data.status == 'fail') {
					alert(data.message);
				} else {
					alert('로그인 완료!');
					location.reload();
				}
				
			},
			error: function(e) {
				console.log(e);
			}
		});
	}
}

function logout() {
	$.ajax({
		url: "/logout",
		type: "POST",
		success: function() {
			location.reload();
		},
		error: function(e) {
			console.log(e);
		}
	});
}

function phoneCertification() {
    let phone = $("#phone").val();

    if (phone === "") {
        $("#phoneError").text("휴대폰 번호를 입력하세요.");
        return;
    }
	
	$("#certificationBox").show();

	/* 인증 시 비용 발생으로 중단
    $.ajax({
        url: "/sendVerification",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({ phone: phone }),
        success: function (data) {
            if (data.status === "success") {
                alert("인증번호가 전송되었습니다.");
                $("#certificationBox").show();
            } else {
                $("#phoneError").text("인증번호 전송에 실패했습니다.");
            }
        },
        error: function (error) {
            console.log(error);
            $("#phoneError").text("서버 오류가 발생했습니다.");
        }
    });

	// 인증번호 검증
	$("#btnVerify").click(function () {
	    let phone = $("#phone").val();
	    let code = $("#certificationCode").val();

	    if (code === "") {
	        $("#certificationError").text("인증번호를 입력하세요.");
	        return;
	    }

	    $.ajax({
	        url: "/verifyCode",
	        type: "POST",
	        contentType: "application/json",
	        data: JSON.stringify({ phone: phone, code: code }),
	        success: function (response) {
	            if (response.status === "success") {
	                alert("휴대폰 인증이 완료되었습니다.");
	                $("#certificationBox").hide();
	            } else {
	                $("#certificationError").text("인증번호가 일치하지 않습니다.");
	            }
	        },
	        error: function (error) {
	            console.log(error);
	            $("#certificationError").text("서버 오류가 발생했습니다.");
	        }
	    });
	});
	/********************/
}

function updateClock() {
    let now = new Date();
    let hours = String(now.getHours()).padStart(2, '0');
    let minutes = String(now.getMinutes()).padStart(2, '0');
    let seconds = String(now.getSeconds()).padStart(2, '0');
	
    $("#clock").text(`${hours}:${minutes}:${seconds}`);
}
