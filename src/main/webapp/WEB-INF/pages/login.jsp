<%--
  Created by IntelliJ IDEA.
  User: Rajiv
  Date: 7/16/2016
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title></title>
</head>
<body>

<form:form  commandName="submitLogin" action="${pageContext.request.contextPath}/submitLogin" method="post">
    <table>
        <thead>
        <th colspan="2">
            Login Form
        </th>
        </thead>
        <tr>
            <td>User Name: </td>
            <td><input type="text" name="uname"/></td>
        </tr>
        <tr>
            <td>Password: </td>
            <td><input type="password" name="pass"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
