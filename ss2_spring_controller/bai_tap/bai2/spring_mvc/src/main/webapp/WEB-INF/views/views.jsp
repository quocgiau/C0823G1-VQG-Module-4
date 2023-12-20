<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        form {
            background-color: #fff;
            border-radius: 5px;
            padding: 20px;
            text-align: center;
        }

        input {
            padding: 10px;
            margin-bottom: 10px;
            width: 200px;
        }

        button {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            margin: 10px;
        }

        button:hover {
            background-color: #45a049;
        }
        h3{
            text-align: center;
        }
    </style>
</head>
<body>
<form action="calculate" method="post">
    <h1>Calculator</h1>
    <input type="number" name="before">
    <input type="number" name="after">
    <br>
    <br>
    <button type="submit" value="add" name="subtend">Addition(+)</button>
    <button type="submit" value="sub" name="subtend">Subtraction(-)</button>
    <button type="submit" value="core" name="subtend">Multiplication(x)</button>
    <button type="submit" value="divide" name="subtend">Division(/)</button>
</form>
<h3>Result Division: ${result}</h3>
</body>
</html>
