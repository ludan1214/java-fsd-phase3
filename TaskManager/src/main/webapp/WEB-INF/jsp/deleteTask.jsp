<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Create a Task</title>
</head>
<body>
<ul>
  <li><a href="logout">Logout</a></li>
  <li><a href="displayTasks">Display Tasks</a></li>
  <li><a href="createTask">Add Task</a></li>
  <li><a href="updateTask">Update Task</a></li>
  <li><a href="deleteTask">Delete Task</a></li>
</ul>
<div class="user-form">
		<h1>Delete a Task</h1>
		<form action="/deleteTask" method="post"">
			<div style="color: #0000FF;">${successMessage}</div>
			<div style="color: #FF0000;">${errorMessage}</div>
			<input type="number" name="id" id="id" placeholder="Task id" required> 
			<input type="submit" value="Delete">
		</form>
		</div>
</body>
</html>