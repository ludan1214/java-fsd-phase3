<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>View Tasks</title>
</head>
<ul>
  <li><a href="logout">Logout</a></li>
  <li><a href="displayTasks">Display Tasks</a></li>
  <li><a href="createTask">Add Task</a></li>
  <li><a href="updateTask">Update Task</a></li>
  <li><a href="deleteTask">Delete Task</a></li>
</ul>
<body>
	<h1>List of Tasks</h1>
	<table class="taskTable">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Severity</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Description</th>
		</tr>
		<c:forEach items="${taskList}" var="item">
			
			<tr>
				<td><c:out value="${item.id}" /></td>
				<td><c:out value="${item.name}" /></td>
				<td><c:out value="${item.email}" /></td>
				<td><c:out value="${item.severity}" /></td>
				<td><c:out value="${item.startDate}" /></td>
				<td><c:out value="${item.endDate}" /></td>
				<td><c:out value="${item.description}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>

<input type="hidden" id="user" value='${taskList}'/>
