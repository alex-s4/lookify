<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
	<h1>Song Details</h1>

	<p>Title: <c:out value="${songToShow.getSongTitle()}"/></p>
	<p>Artist: <c:out value="${songToShow.getSongArtist()}"/></p>
	<p>Rating: <c:out value="${songToShow.getSongRating()}"/></p>
	




	<a href="/dashboard">back to Dashboard</a>
</body>
</html>