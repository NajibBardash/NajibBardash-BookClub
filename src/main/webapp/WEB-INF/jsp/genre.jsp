<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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
                <li>${g}</li>
            </c:forEach>
        </ol>
    </c:otherwise>
</c:choose>

</body>
</html>
