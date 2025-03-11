$(document).ready(function() {
	setInterval(updateClock, 1000);
	updateClock();
//	$("#loadLogs").click(function () {
//	    $.ajax({
//			url: "http://localhost:8088/getAllLogs",
//			type: "GET",
//			dataType: "json",
//			success: function (data){
//				$("#logList").empty();
//				data.forEach(function (log) {
//				    $("#logList").append("<li>" + log.timestamp + " - " + log.message + "</li>");
//				});
//			},
//			error: function (error) {
//				console.log(error);
//			}
//		});
//	});
});

function updateClock() {
    let now = new Date();
    let hours = String(now.getHours()).padStart(2, '0');
    let minutes = String(now.getMinutes()).padStart(2, '0');
    let seconds = String(now.getSeconds()).padStart(2, '0');
	
//	let days = ["일", "월", "화", "수", "목", "금", "토"];
//	let day = days[now.getDay()];

    $("#clock").text(`${hours}:${minutes}:${seconds}`);
}
