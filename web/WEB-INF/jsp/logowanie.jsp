<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logowanie</title>
    </head>
    <body>
    <form:form id="loginForm" method="post" action="go" modelAttribute="klient">

        <form:label path="email">Email</form:label>
        <form:input id="email" name="email" path="email" /><br>
        <form:label path="haslo">Hasło</form:label>
        <form:password id="haslo" name="haslo" path="haslo" /><br>
        <input type="submit" value="Zaloguj się" />
        <br>
        ${message}

    </form:form>
</body>
</html>
