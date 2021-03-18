<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-2.0.3.min.js"></script>   <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Phase 3 Project 3</title>
</head>
<body>
<div class="user-form">
		<h1>Welcome!</h1>
		<form action="login" method="POST">
			<div style="color: #0000FF;">${successMessage}</div>
			<div style="color: #FF0000;">${errorMessage}</div>
			Username: <input type="text" name="username" id="username"> 
			Message: <input type="text" name="password" id="password"> 
			<input type="submit" value="Login">
		</form>
	</div>
</body>
</html>