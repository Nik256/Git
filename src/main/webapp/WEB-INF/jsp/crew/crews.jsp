<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Airline</title>
    <link rel="stylesheet" type="text/css" href="../../../css/style.css">
</head>
<body class="main-page">
<jsp:include page="../include/menu.jsp"/>
<div id="div-crews">
    <table class="tables">
        <thead>
        <tr>
            <th>Код</th>
            <th>Статус</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="crew" items="${crews}">
            <tr>
                <td><c:out value="${crew.code}"/></td>
                <td><c:out value="${crew.status.getName()}"/></td>
                <td><a href='/crew/${crew.id}'>Редактировать</a></td>
                <td><a href='/delete-crew/${crew.id}'>Удалить</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href='/crew'><button class="modal-buttons create-button">Создать экипаж</button></a>
</div>
</body>
</html>