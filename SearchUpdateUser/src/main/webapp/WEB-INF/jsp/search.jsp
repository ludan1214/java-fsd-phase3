<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link rel="stylesheet" href="style.css">
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<input type="hidden" id="user" value='${user}'/>
	<div class="user-form"">
		<div style="color: #0000FF;">${updateMessage}</div>
		<h1>Selected User:</h1>
		<table id="user_table">
			<tr>
				<th>ID</th>
				<th>Username</th>
				<th>First Name</th>
				<th>Last Name</th>
			</tr>
			<tr id="${count.index}">
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.firstname}</td>
				<td>${user.lastname}</td>
			</tr>
		</table>

		<br>
		<br>

		<h1>Update a User</h1>
		<hr>
		<br>
		</form>
		<form action="/update" method="GET">
			Current Id<input type="text" name="id"> 
			New Username<input type="text" name="username"> 
			New First Name<input type="text" name="firstname"> 
			New Last Name<input type="text" name="lastname"> 
			<input type="submit" value="Update">
		</form>

		</form>
		<form action="/search" method="GET">
			<div style="color: #FF0000;">${errorMessage}</div>
			<h1>Search a different User ID</h1>
			<input type="text" name="id"> <input type="submit"
				value="Search">
		</form>
	</div>
</body>
</html>
