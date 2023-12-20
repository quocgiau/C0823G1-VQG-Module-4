<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h2>List of selected spices:</h2>
<c:forEach items="${sort}" var="spice">
    <h3>${spice}</h3>
    <br>
</c:forEach>
</body>
</html>
