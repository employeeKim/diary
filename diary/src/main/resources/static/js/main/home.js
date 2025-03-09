$(document).ready(function() {
	$("#loadLogs").click(function () {
	    $.ajax({
			url: "http://localhost:8088/getAllLogs",
			type: "GET",
			dataType: "json",
			success: function (data){
				$("#logList").empty();
				data.forEach(function (log) {
				    $("#logList").append("<li>" + log.timestamp + " - " + log.message + "</li>");
				});
			},
			error: function (error) {
				console.log(error);
			}
		});
	});
});
