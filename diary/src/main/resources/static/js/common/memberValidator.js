$(document).ready(function () {
	
	// 인풋 유효성검사
    function restrictInput(selector, regex, errorSelector, errorMessage) {
        $(selector).on("input", function () {
            var value = $(this).val();
            var filteredValue = value.replace(regex, "");

            if (value !== filteredValue) {
                $(this).val(filteredValue);
                $(errorSelector).text(errorMessage);
            } else {
                $(errorSelector).text("");
            }
        });
    }

    restrictInput("#memberId", /[^a-zA-Z0-9]/g, "#memberIdError", "영어 소문자와 숫자만 입력해주세요.");
    restrictInput("#name", /[^ㄱ-힣]/g, "#nameError", "한글만 입력해주세요.");
    restrictInput("#phone", /[^0-9]/g, "#phoneError", "숫자만 입력해주세요.");
    restrictInput("#email", /[^a-zA-Z0-9@.]/g, "#emailError", "이메일 형식이 잘못되었습니다.");

    $("#birth").on("keydown paste", function (event) {
        event.preventDefault();
    });
});

// null체크
function validateField(selector, errorSelector, errorMessage) {
    var value = $.trim($(selector).val());

    if (value === "") {
        $(errorSelector).text(errorMessage);
        return false;
    }

    $(errorSelector).text("");
    return true;
}

function signValidator() {
    var flag = true;

    // 필드별 유효성 검사
    flag &= validateField("#memberId", "#memberIdError", "아이디를 입력해주세요.");
    flag &= validateField("#name", "#nameError", "이름을 입력해주세요.");
    flag &= validateField("#phone", "#phoneError", "전화번호를 입력해주세요.");
    flag &= validateField("#birth", "#birthError", "이메일을 입력해주세요.");

    // 비밀번호 체크
    var pw = $.trim($("#pw").val());
    var rePw = $.trim($("#rePw").val());

    if (pw === "" || rePw === "") {
        $("#pwError").text("비밀번호를 입력해주세요.");
        flag = false;
    } else if (pw !== rePw) {
        $("#pwError").text("비밀번호가 일치하지 않습니다.");
        $("#pw, #rePw").val("");
        flag = false;
    } else {
        $("#pwError").text("");
    }

    return flag;
}
