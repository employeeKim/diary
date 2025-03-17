$(document).ready(function() {
});

function checkSession() {
	$(document).ready(function() {
	    $.ajax({
	        url: "/checkLogin",
	        type: "GET",
	        dataType: "json",
	        success: function(data) {
				console.log(data);
	            if (data.status === "success") {
	                $('#loginBoxBefore, .not-login-category').css("display", "none");
	                $("#loginBoxAfter, .login-category").css("display", "flex");
	            } else {
	                $("#loginBoxBefore, .not-login-category").css("display", "flex");
	                $("#loginBoxAfter, .login-category").css("display", "none");
	            }
	        },
	        error: function(error) {
	            console.log(error);
	        }
	    });
	});
}