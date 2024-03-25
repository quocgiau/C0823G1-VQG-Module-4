<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1>SETTINGS</h1>
<table class="table tab-container">
  <form:form method="post" action="/addMailBox" modelAttribute="mailBox">
    <tr>
      <td>
        Name:
      </td>
      <td>
        <form:select path="languages" items="${languagesArray}"/>
      </td>
    </tr>
    <tr>
      <td>Page Size</td>
      <td>show <form:select path="pageSize" items="${pageSizeArray}"/> emails per page</td>
    </tr>
    <tr>
      <td>Spams filter:</td>
      <td><form:checkbox path="spam"/> Enable spams fillter
      </td>
    </tr>
    <tr>
      <td>
        Signature
      </td>
      <td>
        <form:input path="signature"/>
      </td>
    </tr>
    <tr>
      <td>
        <button class="btn btn-info">Update</button>
      </td>
      <td></td>
    </tr>
  </form:form>
</table>
</body>
</html>