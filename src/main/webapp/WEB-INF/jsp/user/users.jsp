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
<div id="div-dispatchers">
    <table class="tables">
        <thead>
        <tr>
            <th>Логин</th>
            <th>Пароль</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.login}"/></td>
                <td><c:out value="${user.password}"/></td>
                <td><c:out value="${user.firstName}"/></td>
                <td><c:out value="${user.lastName}"/></td>
                <td><a href='/user/${user.id}'>Редактировать</a></td>
                <td><a href='/delete-user/${user.id}'>Удалить</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href='/user'><button class="modal-buttons create-button">Создать пользователя</button></a>
</div>
</body>
</html>