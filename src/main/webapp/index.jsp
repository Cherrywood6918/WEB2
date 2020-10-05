<%@ page import="beanComponents.TableData" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Locale" %>
<jsp:useBean id="tableDataBean" scope="session" class="beanComponents.TableDataStatefulBean"/>
<%--


  Created by IntelliJ IDEA.
  User: ACER
  Date: 24.09.2020
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>WEB 2</title>
    <link rel="stylesheet" type='text/css' href="style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script src="validator.js"></script>
    <script src="sender.js"></script>
    <script src="svg_image.js"></script>
</head>
<body>
<header>
    <div class="authors">
        АРСЕНИЙ НАЗАРЕНКО <br>
        ПОПОВА ПОЛИНА <br>
        P3232 2831
    </div>
</header>
<div class="content">
    <div class="img">
        <canvas id='area' height='300' width='300' onclick="show_coords(event)"></canvas>
        <script>
            let canvas = document.getElementById('area');
            let context = canvas.getContext('2d');
            context.fillStyle = "bisque";
            context.fillRect(0, 0, canvas.width, canvas.height);
            //Прямоугольник
            context.fillStyle = "cadetblue";
            context.fillRect(50, 150, 100, 100);
            //Треугольник
            context.beginPath();
            context.moveTo(150, 150);
            context.lineTo(200, 150);
            context.lineTo(150, 200);
            context.closePath();
            context.fill();
            //Сектор
            context.beginPath();
            context.moveTo(150, 150);
            context.lineTo(100, 150);
            context.arc(150, 150, 50, Math.PI, -Math.PI / 2, false);
            context.closePath();
            context.fill();

            context.beginPath();
            context.moveTo(0, 150);
            context.lineTo(300, 150);
            context.moveTo(150, 0);
            context.lineTo(150, 300);
            context.moveTo(150, 0);
            context.lineTo(145, 15);
            context.moveTo(150, 0);
            context.lineTo(155, 15);
            context.moveTo(300, 150);
            context.lineTo(285, 145);
            context.moveTo(300, 150);
            context.lineTo(285, 155);

            context.moveTo(145, 50);
            context.lineTo(155, 50);
            context.moveTo(145, 100);
            context.lineTo(155, 100);
            context.moveTo(145, 200);
            context.lineTo(155, 200);
            context.moveTo(145, 250);
            context.lineTo(155, 250);
            context.moveTo(50, 145);
            context.lineTo(50, 155);
            context.moveTo(100, 145);
            context.lineTo(100, 155);
            context.moveTo(200, 145);
            context.lineTo(200, 155);
            context.moveTo(250, 145);
            context.lineTo(250, 155);
            context.stroke();
            //Текст
            context.fillStyle = "black";
            context.font = "10pt Arial";
            context.fillText("Y", 160, 15);
            context.fillText("R", 160, 55);
            context.fillText("R/2", 160, 105);
            context.fillText("-R/2", 160, 205);
            context.fillText("-R", 160, 255);
            context.fillText("X", 285, 140);
            context.fillText("R/2", 195, 140);
            context.fillText("R", 245, 140);
            context.fillText("-R", 45, 140);
            context.fillText("-R/2", 95, 140);
        </script>
    </div>
    <div class="form-content">
        <form id="form" action="/web2-1.0-SNAPSHOT/controller" method="GET">
            <label for="field_X">X: </label>
            <select id="field_X" name="coordinateX">
                <option>-5</option>
                <option>-4</option>
                <option>-3</option>
                <option>-2</option>
                <option>-1</option>
                <option selected>0</option>
                <option>1</option>
                <option>2</option>
                <option>3</option>
            </select>
            <br>
            <label for="field_Y">Y: </label>
            <input type="text" id="field_Y" name="coordinateY"
                   placeholder="[-3;5]" oninput="validateY()"><br>
            <label for="field_R">R: </label>
            <input type="text" id="field_R" name="radius" placeholder="[2;5]" oninput="validateR()"><br>
            <button id="button_submit" type="submit">ОТПРАВИТЬ</button>
        </form>
    </div>
    <div class="table-content">
        <table class="table-data">
            <thead>
            <tr>
                <th>X</th>
                <th>Y</th>
                <th>R</th>
                <th>Текущее время</th>
                <th>Результат</th>
            </tr>
            </thead>
            <tbody>
            <% List<TableData> tableData = tableDataBean.getResults();
                for(TableData data: tableData) {%>
            <tr>
                <td><%= data.getX()%></td>
                <td><%= data.getY()%></td>
                <td><%= data.getR()%></td>
                <td><%= new SimpleDateFormat("HH:mm:ss").format(data.getDate())%></td>
                <td><%= data.isRes()%></td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>