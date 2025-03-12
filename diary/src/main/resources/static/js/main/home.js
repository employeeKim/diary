$(document).ready(function() {
	setInterval(updateClock, 1000);
	updateClock();
	
	$('#btnSign').click(function() {
		sign();
	});
	
});

function sign() {
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
			url: "",
			type: "POST",
			dataType: "",
			data: data,
			success: function(data) {
				console.log(data);
			},
			error: function(e) {
				console.log(e);
			}
		});
	}
}

function updateClock() {
    let now = new Date();
    let hours = String(now.getHours()).padStart(2, '0');
    let minutes = String(now.getMinutes()).padStart(2, '0');
    let seconds = String(now.getSeconds()).padStart(2, '0');
	
    $("#clock").text(`${hours}:${minutes}:${seconds}`);
}
