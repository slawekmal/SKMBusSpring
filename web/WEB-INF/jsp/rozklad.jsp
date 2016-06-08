<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rozkład</title>
        <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
            <section>
                <h3>Rozkład</h3>
            <c:if test="${!empty kursy}">
                <table class="tg">
                    <tr>
                        <th width="120">Data</th>
                        <th width="120">Godzina</th>
                        <th width="120">Kierunek</th>
                        <th width="60">Miejsca</th>
                        <th width="60">Rezerwuj</th>
                    </tr>
                    <c:forEach items="${kursy}" var="kurs">
                        <tr>
                            <td>${kurs.dzienString}</td>
                            <td>${kurs.godzina}</td>
                            <td>${kurs.kierunek}</td>
                            <td>${kurs.miejsca}</td>
                            <td><a href="<c:url value='rezerwuj/${kurs.id}' />" >Rezerwuj</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </section>
    </body>
</html>
