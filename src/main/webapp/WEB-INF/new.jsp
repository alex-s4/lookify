<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Song</title>
</head>
<body>
	<h1>Add Song</h1>
	<form:form action="/songs/create" method="post" modelAttribute="newSong">
	
	<table>
	<tr>
		<td><form:label path="songTitle">Title</form:label></td>
		<td><form:input path="songTitle"/><form:errors path="songTitle"/></td>
	</tr>
	<tr>
		<td><form:label path="songArtist">Artist</form:label></td>
		<td><form:input path="songArtist"/><form:errors path="songArtist"/></td>
	</tr>
	<tr>
		<td><form:label path="songRating">Rating(1-10)</form:label></td>
		<td><form:input path="songRating" type="number" min="1" max="10"/><form:errors path="songRating"/></td>
	</tr>
	
	
	</table>
	
	<input type="submit" value="Add">
	</form:form>
	<a href="/dashboard">back to Dashboard</a>
</body>
</html>