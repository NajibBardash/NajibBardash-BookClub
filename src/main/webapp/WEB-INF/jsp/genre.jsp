<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%-- This page shows a list of genres if no parameters are entered.
    You can click on a genre to be redirected to the page with books by that genre.
    If a parameter is entered, a book-list of the chosen genre is presented --%>
<html>
<head>
    <title>Book list by genre</title>
</head>
<body>
<c:choose>
    <c:when test="${genre!=null}">
        <h1>Book list by ${genre}</h1>
        <ol>
            <c:forEach var="b" items="${bookListByGenre}">
                <li>${b}</li>
            </c:forEach>
        </ol>
    </c:when>
    <c:otherwise>
        <h1>List of genres</h1>
        <ol>
            <c:forEach var="g" items="${genreList}">
                <li><a href="http://localhost:8080/genre?genre=${fn:toLowerCase(g)}">${g}</a></li>
            </c:forEach>
        </ol>
    </c:otherwise>
</c:choose>

</body>
</html>
