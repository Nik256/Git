<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="../../../css/login-reg.css">
    <script src="../../js/jquery-3.3.1.min.js"></script>
    <script src="../../js/actions.js"></script>
    <title>Регистрация</title>
</head>
<body class="login-body">
<div class="form" id="reg">
    <form action="/registration" method="post" id="registration-form" onsubmit="return validateForm()">
        <label><b>Логин</b></label>
        <input type="text" placeholder="Введите логин" class="input" name="login" required>

        <label><b>Пароль</b></label>
        <input type="password" id="password" placeholder="Введите пароль" class="input" name="password" required>

        <label><b>Пароль еще раз</b></label>
        <input type="password" id="confirm-password" placeholder="Введите пароль" class="input" name="confirm-password" required>

        <label><b>Имя</b></label>
        <input type="text" placeholder="Введите имя" class="input" name="firstName" required>

        <label><b>Фамилия</b></label>
        <input type="text" placeholder="Введите фамилию" class="input" name="lastName" required>

        <button type="submit" id="login-button">Регистрация</button>

        <div class="message" style="color:red"><p id="msg">${msg}</p></div>

        <p class="message">Уже есть аккаунт? <a href="/login">Войти</a></p>
    </form>
</div>
</body>
</html>