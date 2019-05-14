<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Airline</title>
    <link rel="stylesheet" type="text/css" href="../../../css/style.css">
</head>
<body class="main-page">
<jsp:include page="../include/menu.jsp"/>
<div id="div-flights">
    <table class="tables" id="flights">
        <thead>
        <tr>
            <th>Код</th>
            <th>Откуда</th>
            <th>Куда</th>
            <th>Туда</th>
            <th>Обратно</th>
            <th>Самолёт</th>
            <th>Экипаж</th>
            <th>Статус</th>
            <th></th>
            <c:if test="${role == 'ADMIN'}"><th></th></c:if>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="flight" items="${flights}">
            <tr>
                <td>${flight.code}</td>
                <td>${flight.fromAirport.name}</td>
                <td>${flight.toAirport.name}</td>
                <td>${flight.departureDateTime}</td>
                <td>${flight.arrivalDateTime}</td>
                <td>${flight.aircraft.tailNumber}</td>
                <td>${flight.crew.code}</td>
                <td>${flight.status.getName()}</td>
                <td><a href='/flight/${flight.id}'>Редактировать</a></td>
                <c:if test="${role == 'ADMIN'}"><td><a href='/delete-flight/${flight.id}'>Удалить</a></td></c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href='/flight'><button class="modal-buttons create-button">Создать рейс</button></a>
</div>
</body>
</html>