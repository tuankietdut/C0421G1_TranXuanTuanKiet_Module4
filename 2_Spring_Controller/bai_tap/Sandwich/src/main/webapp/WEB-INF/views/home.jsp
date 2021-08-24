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
<form action="/sandwich" method="post">
    <h2>Sandwich Condiments</h2>
    <label for="checkboxOne">Lettuce</label>
    <input type="checkbox" name="lettuce" id="checkboxOne" value="lettuce">
    <label for="checkboxTwo">Tomato</label>
    <input type="checkbox" name="tomato" id="checkboxTwo" value="tomato">
    <label for="checkboxThree">Mustard</label>
    <input type="checkbox" name="mustard" id="checkboxThree" value="mustard">
    <label for="checkboxFour">Sprouts</label>
    <input type="checkbox" name="sprouts" id="checkboxFour" value="sprouts">
    <hr>
    <input type="submit" value="Save">
</form>



</body>
</html>
