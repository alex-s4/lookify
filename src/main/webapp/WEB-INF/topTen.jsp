<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>        

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Top Songs</title>
    </head>
    <body>
        <h1>Top Songs</h1>
        <ol>
            <c:forEach var="song" items="${topSongs}">
                <li>
                    <strong><c:out value="${song.getSongRating()}"/> - <a href="/songs/${song.getId()}"><c:out value="${song.getSongTitle()}"/></a> - <c:out value="${song.getSongArtist()}"/></strong>
                </li>    
                
            </c:forEach>
        </ol>
        

        <a href="/dashboard">back to Dashboard</a>
    </body>
</html>