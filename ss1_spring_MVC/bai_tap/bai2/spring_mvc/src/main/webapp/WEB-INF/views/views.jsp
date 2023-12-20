<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Tra cứu từ điển</h2>
<form action="/convert" method="post">
  <h4>Nhập từ cần tra cứu</h4>
  <input type="text" name="vocabulary">
  <input type="submit" value="Tra cứu">
</form>
Kết quả : ${result}
</body>
</html>
