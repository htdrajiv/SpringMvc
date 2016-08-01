<%--
  Created by IntelliJ IDEA.
  User: Rajiv
  Date: 7/18/2016
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form name="addUserForm" onsubmit="return checkPassword();" action="${pageContext.request.contextPath}/admin/saveUser">
    <table>
        <tr>
            <td>Add New User</td>
        </tr>
        <tr>
            <td> First Name: </td>
            <td> <input type="text" name="firstName" required="required"/></td>
        </tr>
        <tr>
            <td> Last Name: </td>
            <td> <input type="text" name="lastName" required="required"/></td>
        </tr>
        <tr>
            <td> Username: </td>
            <td> <input type="text" name="userName" required="required"/></td>
        </tr>
        <tr>
            <td> Password: </td>
            <td> <input type="password" id="password" name="password" required="required"/> </td>
        </tr>
        <tr>
            <td> Retype Password: </td>
            <td> <input type="password" id="matchPassword" name="matchPassword" required="required"/> </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="submit" />
            </td>
        </tr>
        <tr>
            <td colspan="2"><a href="${pageContext.request.contextPath}/login/loginForm" >Go To Login Page</a></td>
        </tr>
    </table>
</form>
</body>
<script type="text/javascript">
    function checkPassword(){
        var firstInput = document.getElementById("password").value;
        var secondInput = document.getElementById("matchPassword").value;
        if(firstInput!=secondInput) {
            alert("Password doesn't match!!");
            return false;
        }
        return true;
    }
</script>
</html>
