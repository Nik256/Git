<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Логин</title>
    <link rel="stylesheet" type="text/css" href="../../../css/login-reg.css">
</head>
<body class="login-body">
<div class="form">
    <form action="/login" method="post" id="login-form">
        <label><b>Логин</b></label>
        <input type="text" placeholder="Введите логин" id="login" name="login" required>

        <label><b>Пароль</b></label>
        <input type="password" placeholder="Введите пароль" id="password" name="password" required>
        <button type="submit" id="login-button">Вход</button>
        <div class="message" style="color:red">${msg}</div>
        <p class="message">Нет аккаунта? <a href="registration">Создать аккаунт</a></p>
    </form>
</div>
${role}
</body>
</html>