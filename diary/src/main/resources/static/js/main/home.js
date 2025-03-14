$(document).ready(function() {
	/* 시계 */
	setInterval(updateClock, 1000);
	updateClock();
	/******/
	
	// 모달창이 닫혔을 때 초기화
	$("#signupModal").on("hidden.bs.modal", function () {
	    $("#signupForm")[0].reset(); // 입력값 초기화
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
	
});

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
	if($("#isMemberBtn").prop("disabled")) {
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
					console.log(data);
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

function updateClock() {
    let now = new Date();
    let hours = String(now.getHours()).padStart(2, '0');
    let minutes = String(now.getMinutes()).padStart(2, '0');
    let seconds = String(now.getSeconds()).padStart(2, '0');
	
    $("#clock").text(`${hours}:${minutes}:${seconds}`);
}
