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
    <div class="forms crew-form">
        <form action="/create-crew" method="post" id="edit-form">
            <div class="inline-first">
                <label for="code">Код</label>
                <input class="inputs" type="text" id="code" value="${crew.code}" name="code" required/>
            </div>
            <div class="inline-second">
                <label for="status">Статус</label>
                <select class="inputs" id="status" name="status">
                    <c:forEach var="status" items="${statuses}">
                        <option selected="">${status.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="inline-first">
                <label for="pilot1">Пилот</label>
                <select class="inputs" id="pilot1" name="member">
                    <option></option>
                    <c:forEach var="tempMember" items="${allMembers}">
                        <c:if test="${tempMember.position eq 'PILOT'}">
                        <option>${tempMember.code} ${tempMember.name} ${tempMember.surname}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="inline-second">
                <label for="pilot2">Пилот</label>
                <select class="inputs" id="pilot2" name="member">
                    <option></option>
                    <c:forEach var="tempMember" items="${allMembers}">
                        <c:if test="${tempMember.position eq 'PILOT'}">
                        <option>${tempMember.code} ${tempMember.name} ${tempMember.surname}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="inline-first">
                <label for="navigator">Навигатор</label>
                <select class="inputs" id="navigator" name="member">
                    <option></option>
                    <c:forEach var="tempMember" items="${allMembers}">
                        <c:if test="${tempMember.position eq 'NAVIGATOR'}">
                        <option>${tempMember.code} ${tempMember.name} ${tempMember.surname}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="inline-second">
                <label for="operator">Оператор</label>
                <select class="inputs" id="operator" name="member">
                    <option></option>
                    <c:forEach var="tempMember" items="${allMembers}">
                        <c:if test="${tempMember.position eq 'OPERATOR'}">
                            <option>${tempMember.code} ${tempMember.name} ${tempMember.surname}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="inline-first">
                <label for="stewardess1">Стюардесса</label>
                <select class="inputs" id="stewardess1" name="member">
                    <option></option>
                    <c:forEach var="tempMember" items="${allMembers}">
                        <c:if test="${tempMember.position eq 'STEWARDESS'}">
                            <option>${tempMember.code} ${tempMember.name} ${tempMember.surname}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="inline-second">
                <label for="stewardess2">Стюардесса</label>
                <select class="inputs" id="stewardess2" name="member">
                    <option></option>
                    <c:forEach var="tempMember" items="${allMembers}">
                        <c:if test="${tempMember.position eq 'STEWARDESS'}">
                            <option>${tempMember.code} ${tempMember.name} ${tempMember.surname}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="inline-first">
                <label for="stewardess3">Стюардесса</label>
                <select class="inputs" id="stewardess3" name="member">
                    <option></option>
                    <c:forEach var="tempMember" items="${allMembers}">
                        <c:if test="${tempMember.position eq 'STEWARDESS'}">
                            <option>${tempMember.code} ${tempMember.name} ${tempMember.surname}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="inline-second">
                <label for="stewardess4">Стюардесса</label>
                <select class="inputs" id="stewardess4" name="member">
                    <option></option>
                    <c:forEach var="tempMember" items="${allMembers}">
                        <c:if test="${tempMember.position eq 'STEWARDESS'}">
                            <option>${tempMember.code} ${tempMember.name} ${tempMember.surname}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>

            <input type="hidden" value="${crew.id}" name="id" value="hiddenValue">
            <button type="submit" class="modal-buttons" id="save-button">Сохранить</button>
        </form>
        <c:if test="${not empty crew}"><a href="/delete-crew/${crew.id}">
            <button class="modal-buttons" id="delete-button">Удалить</button>
        </a></c:if>
        <a href='/crews'>
            <button class="modal-buttons" id="close-button">Отмена</button>
        </a>
    </div>
</div>
</body>
</html>