<%--
  Created by IntelliJ IDEA.
  User: ShouYou
  Date: 24/08/2021
  Time: 12:07 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    <h2>Calculator</h2>
    <label for="firstNumber">FirstNumber</label>
    <input type="number" name="firstNumber" id="firstNumber" >
    <label for="secondNumber">SecondNumber</label>
    <input type="number" name="secondNumber" id="secondNumber">
    <label for="plus">Additional (+)</label>
    <input type="submit" name="action" id="plus" value="plus">
    <label for="except">Subtraction (-)</label>
    <input type="submit" name="action" id="except" value="except">
    <label for="multiple">Multiple (*)</label>
    <input type="submit" name="action" id="multiple" value="multiple">
    <label for="divide">Divide (/)</label>
    <input type="submit" name="action" id="divide" value="divide">
</form>
<h1>${result}</h1>

</body>
</html>
