<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lookify</title>
</head>
<body>
	<h1>Lookify Premium</h1>
	<a href="/songs/new">Add Song</a>
    <a href="/songs/top-ten">Top Songs</a>
    <form action="/search" method="post">
        <input type="text" name="searchArtist" id="search">
        <input type="submit" value="Search">
    </form>
	<table>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="song" items="${songs}">
            <tr>
                <td><a href="/songs/${song.getId()}"><c:out value="${song.getSongTitle()}"/></a></td>
                <td><c:out value="${song.getSongRating()}"/></td>
                <td>
                    <form action="/songs/${song.getId()}" method="post" class="delete-btn">
                        <input type="hidden" name="_method" value="delete">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
	
</body>
</html>