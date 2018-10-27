<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Tickets</title>
</head>
<body>
<div>
    <center>
        <h2>Список заявок</h2>
        <table class="tg">
            <tr>
                <th>ID заявки</th>
                <th>Дата</th>
                <th>Описание</th>
                <th>Сайт заявки</th>
            </tr>
            <c:forEach items="${tickets}" var="ticket">
                <tr>
                    <td>${ticket.id}</td>
                    <td>${ticket.dateTime}</td>
                    <td>${ticket.description}</td>
                    <td>${ticket.site}</td>
                </tr>
            </c:forEach>
        </table>
    </center>
</div>
</body>
</html>
