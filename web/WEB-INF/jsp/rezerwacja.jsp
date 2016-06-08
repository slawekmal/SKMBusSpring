<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
        <title>Rezerwacja</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
            <section>
            <form:form id="rezerwacjaForm" method="post" action="${kurs.id}/go" modelAttribute="kurs2">
                <spring:message text="Wybrałeś kurs: ${kurs}" />
                <form:label path="miejsca">Miejsca</form:label>
                <form:input id="miejsca" type="number" path="miejsca" /><br>
                <input type="submit" value="Rezerwuj" />
                <br>
                ${message}
            </form:form>
        </section>
    </body>
</html>
