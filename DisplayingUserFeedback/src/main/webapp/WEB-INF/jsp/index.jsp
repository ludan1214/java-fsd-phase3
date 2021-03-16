<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Phase 3 Project 1</title>
</head>
<body>
<div class="user-form">
		<h1>Welcome!</h1>
		</form>
			<form action="/search" method="GET">
			<div style="color: #0000FF;">${updateMessage}</div>
			<div style="color: #FF0000;">${errorMessage}</div>
			Id to Search: <input type="text" name="id">
			<input type="submit" value="Search">
		</form>
		
	</div>
</body>
</html>