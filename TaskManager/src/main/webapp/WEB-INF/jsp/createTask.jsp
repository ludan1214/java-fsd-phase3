<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<ul>
  <li><a href="logout">Logout</a></li>
  <li><a href="createTask">Add Task</a></li>
</ul>
<div class="user-form">
		<h1>Add a new Task</h1>
		<form action="/addTask" method="post"">
			<div style="color: #0000FF;">${successMessage}</div>
			<div style="color: #FF0000;">${errorMessage}</div>
			<select name="severity" id="severity">
			  <option value="" disabled selected>Severity Level</option>
			  <option value="low">low</option>
 			  <option value="medium">medium</option>
  			  <option value="high">high</option>
			</select>
			<input type="text" name="name" id="name" placeholder="Task Name" required> 
			<input type="text" name="email" id="email" placeholder="Email" required>
			<input type="Date" name="startDate" id="startDate" placeholder="Start Date" required> 
			<input type="Date" name="endDate" id="endDate" placeholder="End Date" required> 
			<input type="text" name="description" id="description" placeholder="Description (250 characters Max)" required>
			<input type="submit" value="Add">
		</form>
		</div>
</body>
</html>