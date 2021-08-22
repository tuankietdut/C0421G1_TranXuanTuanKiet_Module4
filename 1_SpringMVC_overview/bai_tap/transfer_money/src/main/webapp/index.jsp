<%--
  Created by IntelliJ IDEA.
  User: ShouYou
  Date: 22/08/2021
  Time: 1:20 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/transfer">
    <label for="usa" >Input your money USA</label>
    <input type="number" name="usa" id="usa">

    <label for="rate">Rate to transfer VND</label>
    <input type="number" name="rate" id="rate">

    <input type="submit" value="Check">
  </form>
  </body>
</html>
