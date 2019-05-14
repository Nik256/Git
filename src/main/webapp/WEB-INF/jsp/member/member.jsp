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
    <div class="forms member-form">
        <c:if test="${empty member}"><form action="/create-member" method="post" id="edit-form"></c:if>
        <c:if test="${not empty member}"><form action="/edit-member" method="post" id="edit-form"></c:if>
                <div>
                    <label for="code">Код</label>
                    <input class="inputs" type="text" id="code" value="${member.code}" name="code" required/>
                </div>
                <div>
                    <label for="position">Должность</label>
                    <select class="inputs" id="position" name="position">
                        <c:forEach var="position" items="${positions}">
                            <c:if test="${position != member.position}"><option></c:if>
                            <c:if test="${position == member.position}"><option selected="selected"></c:if>
                            <c:out value="${position.getName()}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <label for="name">Имя</label>
                    <input class="inputs" type="text" id="name" value="${member.name}" name="name" required/>
                </div>
                <div>
                    <label for="surname">Фамилия</label>
                    <input class="inputs" type="text" id="surname" value="${member.surname}" name="surname" required/>
                </div>
                <div>
                    <label for="crew">Экипаж</label>
                    <select class="inputs" id="crew" name="crew">
                        <option></option>
                        <c:forEach var="crew" items="${crews}">
                            <c:if test="${crew.id != member.crew or member eq null}"><option></c:if>
                            <c:if test="${crew.id == member.crew}"><option selected="selected"></c:if>
                            <c:out value="${crew.code}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <input type="hidden" value="${member.id}" name="id" value="hiddenValue">
                <button type="submit" class="modal-buttons" id="save-button">Сохранить</button>
            </form>
            <c:if test="${not empty member}"><a href="/delete-member/${member.id}">
                <button class="modal-buttons" id="delete-button">Удалить</button>
            </a></c:if>
            <a href='/members'>
                <button class="modal-buttons" id="close-button">Отмена</button>
            </a>
    </div>
</div>
</body>
</html>