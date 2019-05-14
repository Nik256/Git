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
<div class="main-div">
    <div class="forms user-form">
        <c:if test="${empty user}">
        <form action="/create-user" method="post" id="edit-form"></c:if>
            <c:if test="${not empty user}">
            <form action="/edit-user" method="post" id="edit-form"></c:if>
                <div>
                    <label for="login">Логин</label>
                    <input class="inputs" type="text" id="login" value="${user.login}" name="login" required/>
                </div>
                <div>
                    <label for="password">Пароль</label>
                    <input class="inputs" type="text" id="password" value="${user.password}" name="password" required/>
                </div>
                <div>
                    <label for="firstName">Имя</label>
                    <input class="inputs" type="text" id="firstName" value="${user.firstName}" name="firstName" required/>
                </div>
                <div>
                    <label for="lastName">Фамилия</label>
                    <input class="inputs" type="text" id="lastName" value="${user.lastName}" name="lastName" required/>
                </div>
                <c:if test="${not empty user}"><input type="hidden" value="${user.id}" name="id" value="hiddenValue"></c:if>
                <button type="submit" class="modal-buttons" id="save-button">Сохранить</button>
            </form>
            <c:if test="${not empty user}"><a href="/delete-user/${user.id}">
                <button class="modal-buttons" id="delete-button">Удалить</button>
            </a></c:if>
            <a href='/users'>
                <button class="modal-buttons" id="close-button">Отмена</button>
            </a>
    </div>
</div>
</body>
</html>