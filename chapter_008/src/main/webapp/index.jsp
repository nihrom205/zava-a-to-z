<%@ page import="ru.job4j.cruid.logic.ValidateService" %>
<%@ page import="ru.job4j.cruid.dao.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Users</title>
    <style>
        h2 {
            color: black;
        }
        input.add {
            margin: 5px;
        }
        div {
            margin: 5px;
            float: left;
            padding: 0px;
        }
        div form {
            margin: 0px;
            padding:  0px;
        }
        th {
            background: darkgrey;
        }
    </style>
</head>
<body>
    <h2>List Users</h2>
    <form action="<%=request.getContextPath()%>/create" method="post">
        Login : <input class="add" type="text" name="login"> <br/>
        Email : <input class="add" type="text" name="email"> <br/>
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
        <col width="110">
        <% for (User user: ValidateService.getInstance().findAll()) { %>
            <tr>
                <td><%=user.getId()%></td>
                <td><%=user.getName()%></td>
                <td><%=user.getEmail()%></td>
                <td>
                    <div>
                        <form action="<%=request.getContextPath()%>/edit.jsp" method="post">
                            <input class="edit" type="hidden" name="id" value="<%=user.getId()%>">
                            <input class="edit" type="submit" value="Edit"> <br/>
                        </form>
                    </div>
                    <div>
                        <form action="<%=request.getContextPath()%>/delete" method="post">
                            <input class="edit" type="hidden" name="id" value="<%=user.getId()%>">
                            <input class="edit" type="submit" value="Del">
                        </form>
                    </div>
                </td>
            </tr>
        <% } %>
    </table>
</body>
</html>
