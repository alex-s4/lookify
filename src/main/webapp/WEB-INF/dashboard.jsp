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
	<h1>test</h1>
	<table>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="song" items="${songs}">
            <tr>
                <td><c:out value="${song.getSongTitle()}"/></td>
                <td><c:out value="${song.getSongArtist()}"/></td>
                <td><c:out value="${song.getSongRating()}"/></td>
            </tr>
        </c:forEach>
    </table>
	
</body>
</html>