<%--
  Created by IntelliJ IDEA.
  User: Rajiv
  Date: 7/18/2016
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
</head>
<body>
  <table>
    <tr>
      <td>First Name</td>
      <td>Last Name</td>
      <td>User Name</td>
    </tr>
    <c:forEach items="${users}" var="u">
      <tr>
        <td>
          ${u.firstName}
        </td>
        <td>
          ${u.lastName}
        </td>
        <td>
          ${u.userName}
        </td>
      </tr>
    </c:forEach>
      <tr>
          <td><a href="${pageContext.request.contextPath}/login/loginForm" >Go To Login Page</a></td>
      </tr>
  </table>
</body>
</html>
