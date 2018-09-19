<%@ page import="ru.job4j.cruid.logic.ValidateService" %>
<%@ page import="ru.job4j.cruid.dao.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Users</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/create" method="post">
        Login : <input type="text" name="login"> <br/>
        Email : <input type="text" name="email"> <br/>
        <input type="submit" value="Add user">
    </form>
    <br>
    <table border="1">
        <th>id</th>
        <th>login</th>
        <th>email</th>
        <th>editing</th>
        <col width="50">
        <col width="150">
        <col width="150">
        <col width="150">
        <% for (User user: ValidateService.getInstance().findAll()) { %>
        <tr>
            <td><%=user.getId()%></td>
            <td><%=user.getName()%></td>
            <td><%=user.getEmail()%></td>
            <td>
                <form action="<%=request.getContextPath()%>/edit.jsp" method="post">
                    <input type="hidden" name="id" value="<%=user.getId()%>">
                    <input type="submit" value="Edit"> <br/>
                </form>
                <form action="<%=request.getContextPath()%>/delete" method="post">
                    <input type="hidden" name="id" value="<%=user.getId()%>">
                    <input type="submit" value="Del">
                </form>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>
