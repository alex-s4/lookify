<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
    <h1>Songs by: <c:out value="${searchQuery}"/></h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="song" items="${songs}">
            <tr>
                <td><c:out value="${song.getSongTitle()}"/></td>
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
    <a href="/dashboard">back to Dashboard</a>
</body>
</html>