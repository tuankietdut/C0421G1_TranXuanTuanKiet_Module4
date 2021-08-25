<%--
  Created by IntelliJ IDEA.
  User: ShouYou
  Date: 24/08/2021
  Time: 12:07 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="email" action="/login/edit" method="post">
    <table>
        <tr>
            <td>Languages</td>
            <td><form:select path="language" items="${language}"/>
            </td>
        </tr>
        <tr>
            <td>Page Size</td>
            <td>
                <form:select path="pageSize" items="${pageSize}"/>
                <span>email per page</span>
            </td>
        </tr>
        <tr>
            <td>Spam Filter</td>
            <td>
                <form:checkbox path="spamFilter" value="yes" label="Enable Spam filter"/>
            </td>
        </tr>
        <tr>
            <td>Signature</td>
            <td>
                <form:textarea path="signature" cols="18" rows="4"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Edit"></td>
            <td><input type="button" value="Cancel"></td>
        </tr>
    </table>

</form:form>


</body>
</html>
