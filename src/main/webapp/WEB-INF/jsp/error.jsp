<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../css/style.css">
    <title>Произошла ошибка</title>
</head>
<body class="main-page">
<div class="forms div-error">
    <p>Произошла ошибка:</p>
    <p style="color:red">${error}</p>
    <a href="/index">На главную</a>
</div>
</body>
</html>