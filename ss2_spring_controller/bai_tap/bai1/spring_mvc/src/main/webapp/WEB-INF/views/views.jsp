<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spice</title>
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
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="checkbox"] {
            margin-right: 10px;
        }

        hr {
            border: none;
            border-top: 1px solid #ccc;
            margin: 20px 0;
        }

        button[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<form method="post" action="/condiments">
    <h1>Sandwich Condiments</h1>
    <input type="checkbox" id="checkbox1" name="sort" value="Lettuce">
    <label for="checkbox1">Lettuce</label>
    <input type="checkbox" id="checkbox2" name="sort" value="Tomato">
    <label for="checkbox2">Tomato</label>
    <input type="checkbox" id="checkbox3" name="sort" value="Mustard">
    <label for="checkbox3">Mustard</label>
    <input type="checkbox" id="checkbox4" name="sort" value="Sprouts">
    <label for="checkbox4">Sprouts</label>
    <hr>
    <button type="submit">
        Save
    </button>
</form>
</body>
</html>
