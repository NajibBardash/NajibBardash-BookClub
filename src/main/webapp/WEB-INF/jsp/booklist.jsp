<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Book list</title>
</head>
<body>
<h1>Book list</h1>
<ol>
    <c:forEach var="b" items="${bookList}">
        <li>${b}</li>
    </c:forEach>
</ol>
</body>
</html>
