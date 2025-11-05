<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- This is the page that shows a list of book recommendations --%>
<html>
<head>
    <title>Book recommendation list</title>
</head>
<body>
<h1>Book recommendation list</h1>
<ol>
    <c:forEach var="b" items="${bookList}">
        <li>${b}</li>
    </c:forEach>
</ol>
</body>
</html>
