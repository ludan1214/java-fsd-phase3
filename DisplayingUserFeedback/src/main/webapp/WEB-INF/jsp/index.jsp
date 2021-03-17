<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-2.0.3.min.js"></script>   <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Phase 3 Project 2</title>
<script>
	function createFeedback() {
		$.ajax({
			url : "http://localhost:8080/feedback",
			type : "post",
			contentType:"application/json",
			data : JSON.stringify({
				"username" : $("#username").val(),
				message : $("#message").val()
			})
		});
	}
</script>
</head>
<body>
<div class="user-form">
		<h1>Welcome!</h1>
		<form onsubmit="createFeedback()" id="feedbackForm">
			<div style="color: #0000FF;">${successMessage}</div>
			<div style="color: #FF0000;">${errorMessage}</div>
			Username: <input type="text" name="username" id="username"> 
			Message: <input type="text" name="message" id="message"> 
			<input type="submit" value="Post Feedback">
		</form>
		<hr>
		
		<h1>Feedback table</h1>
		<table class = "feedbackTable" id="feedbackTable" name="feedbackTable">
			<tr>
				<th>Id</th>
				<th>User</th>
				<th>Message</th>
			</tr>
		</table>
	</div>
	
</body>

<script>
	$(function() {
		var xmlhttp = new XMLHttpRequest();
		var url = "feedback";

		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var feedbackArr = JSON.parse(xmlhttp.responseText)._embedded.feedbackList;
				 updateFeedback(feedbackArr);
			}
		}

		xmlhttp.open("GET", url, true);
		xmlhttp.send();
	});
	
	function updateFeedback(feedbackArr){
		var t = document.getElementById('feedbackTable');
		var i;
		for (i = 0; i < feedbackArr.length; i++) {
			var row = t.insertRow(-1);
			row.insertCell(0).innerHTML = feedbackArr[i].id;
			row.insertCell(1).innerHTML = feedbackArr[i].username;
			row.insertCell(2).innerHTML = feedbackArr[i].message;
		}
	}
	
</script>
</html>