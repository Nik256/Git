<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" %>

<ul>
    <li><a href="/flights">Рейсы</a></li>
    <li><a href="/crews">Экипажи</a></li>
    <li><a href="/members">Сотрудники</a></li>
    <c:if test="${role == 'ADMIN'}">
        <li><a href="/users">Пользователи</a></li>
    </c:if>
    <li style="float:right"><a class="active" href="logout">Выход</a></li>
</ul>