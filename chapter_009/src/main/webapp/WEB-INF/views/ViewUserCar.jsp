<%--
Created by IntelliJ IDEA.
User: alexey
Date: 12.01.19
Time: 16:06
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <title>Аккаунт пользователя</title>
</head>
    <body>
    <h2>Список машин пользователя</h2>
    <label id="login" hidden>${login}</label>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <h3 class="text-center">
                    Список объявлений
                </h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8">
            </div>
            <div class="col-md-4">
                <span class="badge badge-default">Label</span>
            </div>
        </div>
        <div class="row">
            <div class="col-md-9">
                <!--<table border="1">-->
                <!---->
                <!--<c:forEach items="${cars}" var="car">-->
                <!--<tr>-->
                <!--<td>номер: <c:out value="${car.id}"></c:out></td>-->
                <!--<td>Марка: <c:out value="${car.marka}"></c:out></td>-->
                <!--<td>Модель: <c:out value="${car.model}"></c:out></td>-->
                <!--<td>Мощность: <c:out value="${car.power}"></c:out></td>-->
                <!--</tr>-->
                <!---->
                <!--</c:forEach>-->
                <!--</table>-->
            </div>
        </div>
    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script>

        (function() {
            var div = $('<div>').addClass('container');
            var table = $('<table>').addClass('table table-hover').attr('id', 'table');

            table.append($('<thead><tr><th>фото</th><th>Наименование</th></thead>'));
            table.append($('<tbody>'));
            div.append(table);
            $('body').append(div);
        }());

        function addRow() {
            var user = $('#login').text();
            $.ajax('/salescar/jsonAutoriz', {
                method : 'post',
                data: user,
                dateType : "json",
                complete : function(data) {
                    var rezult = "";
                    var cars = JSON.parse(data.responseText);
                    for (let i = 0; i < cars.length; i++) {
                        rezult += '<tr><td>' + '<img src="img/nofoto.png" alt="фото" height="100" width="100">' + '</td><td>' + cars[i].marka + " " + cars[i].model + " " + cars[i].power + " " + cars[i].litres + '</td></tr>';
                    }
                    $('#table tbody').append(rezult);
                }
            });
        }
        addRow();
    </script>

    </body>
</html>