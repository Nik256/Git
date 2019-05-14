<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Airline</title>
    <link rel="stylesheet" type="text/css" href="../../../css/style.css">
    <script src="../../js/jquery-3.3.1.min.js"></script>
    <script src="../../js/actions.js"></script>
</head>
<body class="main-page">
<jsp:include page="../include/menu.jsp"/>
<div class="main-div">
    <div class="forms flight-form">
        <c:if test="${empty flight}"><form action="/create-flight" method="post" id="edit-form" onsubmit="return validateFlight()"></c:if>
        <c:if test="${not empty flight}"><form action="/edit-flight" method="post" id="edit-form" onsubmit="return validateFlight()"></c:if>
            <div class="inline-first">
                <label for="code">Код</label>
                <input class="inputs" type="text" id="code" value="${flight.code}" name="code" required/>
            </div>
            <div class="inline-second">
                <label for="aircraft">Самолёт</label>
                <select class="inputs" id="aircraft" name="aircraft">
                    <c:forEach var="aircraft" items="${aircrafts}">
                        <c:if test="${flight.aircraft.tailNumber != aircraft.tailNumber}"><option></c:if>
                        <c:if test="${flight.aircraft.tailNumber == aircraft.tailNumber}"><option selected="selected"></c:if>
                        <c:out value="${aircraft.tailNumber}"/></option>
                    </c:forEach>
                </select>
            </div>
            <div class="inline-first">
                <label for="from">Откуда</label>
                <select class="inputs" id="from" name="fromAirport">
                    <c:forEach var="airport" items="${airports}">
                        <c:if test="${flight.fromAirport.name != airport.name}"><option></c:if>
                        <c:if test="${flight.fromAirport.name == airport.name}"><option selected="selected"></c:if>
                        <c:out value="${airport.name}"/></option>
                    </c:forEach>
                </select>
            </div>
            <div class="inline-second">
                <label for="to">Куда</label>
                <select class="inputs" id="to" name="toAirport">
                    <c:forEach var="airport" items="${airports}">
                        <c:if test="${flight.toAirport.name != airport.name}"><option></c:if>
                        <c:if test="${flight.toAirport.name == airport.name}"><option selected="selected"></c:if>
                        <c:out value="${airport.name}"/></option>
                    </c:forEach>
                </select>
            </div>
            <div class="inline-first">
                <label for="departure">Дата/время взлёта</label>
                <input class="inputs" type="datetime-local" id="departure" value="${flight.departureDateTime}"
                       name="departureDateTime" required/>
            </div>
            <div class="inline-second">
                <label for="arrival">Дата/время посадки</label>
                <input class="inputs" type="datetime-local" id="arrival" value="${flight.arrivalDateTime}"
                       name="arrivalDateTime" required/>
            </div>
            <div class="inline-first">
                <label for="crew">Экипаж</label>
                <select class="inputs" id="crew" name="crew">
                    <c:forEach var="crew" items="${crews}">
                        <c:if test="${flight.crew.code != crew.code}"><option></c:if>
                        <c:if test="${flight.crew.code == crew.code}"><option selected="selected"></c:if>
                        <c:out value="${crew.code}"/></option>
                    </c:forEach>
                </select>
            </div>
            <div class="inline-second">
                <label for="status">Статус</label>
                <select class="inputs" id="status" name="status">
                    <c:if test="${role == 'ADMIN'}">
                    <c:if test="${flight.status != 'READY'}"><option></c:if>
                    <c:if test="${flight.status == 'READY'}"><option selected="selected"></c:if>
                        Готов</option>
                    <c:if test="${flight.status != 'WAITING_FOR_APPROVAL'}"><option></c:if>
                    <c:if test="${flight.status == 'WAITING_FOR_APPROVAL'}"><option selected="selected"></c:if>
                        Ожидает подтверждения</option></c:if>
                    <c:if test="${role != 'ADMIN' and flight ne null}"><option>${flight.status.getName()}</option></c:if>
                    <c:if test="${role != 'ADMIN' and flight eq null}"><option selected="selected">Ожидает подтверждения</option></c:if>
                </select>
            </div>
                <input type="hidden" value="${flight.id}" name="id" value="hiddenValue">
            <button type="submit" class="modal-buttons" id="save-button">Сохранить</button>
        </form>
            <c:if test="${role == 'ADMIN'}">
        <c:if test="${not empty flight}"><a href="/delete-flight/${flight.id}">
                <button class="modal-buttons" id="delete-button">Удалить</button></a></c:if></c:if>
        <a href='/flights'><button class="modal-buttons" id="close-button">Отмена</button></a>
            <div class="message" style="color:red"><p id="msg">${msg}</p></div>
    </div>
</div>
</body>
</html>