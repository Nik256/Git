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
<div id="div-members">
    <table class="tables">
        <thead>
        <tr>
            <th>Код</th>
            <th>Должность</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="member" items="${members}">
            <tr>
                <td><c:out value="${member.code}"/></td>
                <td><c:out value="${member.position.getName()}"/></td>
                <td><c:out value="${member.name}"/></td>
                <td><c:out value="${member.surname}"/></td>
                <td><a href='/member/${member.id}'>Редактировать</a></td>
                <td><a href='/delete-member/${member.id}'>Удалить</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href='/member'><button class="modal-buttons create-button">Создать сотрудника</button></a>
</div>
</body>
</html>