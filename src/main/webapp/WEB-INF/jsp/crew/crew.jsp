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
        <c:if test="${empty crew}"><form action="/create-crew" method="post" id="edit-form"></c:if>
        <c:if test="${not empty crew}"><form action="/edit-crew" method="post" id="edit-form"></c:if>
            <div>
                <div class="inline-first">
                    <label for="code">Код</label>
                    <input class="inputs" type="text" id="code" value="${crew.code}" name="code" required/>
                </div>
                <div class="inline-second">
                    <label for="status">Статус</label>
                    <select class="inputs" id="status" name="status">
                        <c:forEach var="status" items="${statuses}">
                            <c:if test="${status ne crew.status}"><option></c:if>
                            <c:if test="${status eq crew.status}"><option selected="selected"></c:if>
                            ${status.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="inline-first">
                    <label for="pilot1">Пилот</label>
                    <select class="inputs" id="pilot1" name="member">
                        <option></option>
                        <c:if test="${pilot[0] ne null}"><option selected="selected">
                            ${pilot[0].code} ${pilot[0].name} ${pilot[0].surname}</option></c:if>
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
                        <c:if test="${pilot[1] ne null}"><option selected="selected">
                                ${pilot[1].code} ${pilot[1].name} ${pilot[1].surname}</option></c:if>
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
                        <c:if test="${navigator[0] ne null}"><option selected="selected">
                                ${navigator[0].code} ${navigator[0].name} ${navigator[0].surname}</option></c:if>
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
                        <c:if test="${operator[0] ne null}"><option selected="selected">
                        ${operator[0].code} ${operator[0].name} ${operator[0].surname}</option></c:if>
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
                        <c:if test="${stewardess[0] ne null}"><option selected="selected">
                                ${stewardess[0].code} ${stewardess[0].name} ${stewardess[0].surname}</option></c:if>
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
                        <c:if test="${stewardess[1] ne null}"><option selected="selected">
                                ${stewardess[1].code} ${stewardess[1].name} ${stewardess[1].surname}</option></c:if>
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
                        <c:if test="${stewardess[2] ne null}"><option selected="selected">
                                ${stewardess[2].code} ${stewardess[2].name} ${stewardess[2].surname}</option></c:if>
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
                        <c:if test="${stewardess[3] ne null}"><option selected="selected">
                                ${stewardess[3].code} ${stewardess[3].name} ${stewardess[3].surname}</option></c:if>
                        <c:forEach var="tempMember" items="${allMembers}">
                            <c:if test="${tempMember.position eq 'STEWARDESS'}">
                                <option>${tempMember.code} ${tempMember.name} ${tempMember.surname}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>

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