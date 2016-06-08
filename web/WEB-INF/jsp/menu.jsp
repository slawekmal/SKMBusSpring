<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <nav>
            <ul>
                <li><a href="/SKMBusSpring/"> Strona główna </a></li>
                <li><a href="/SKMBusSpring/rozklad/"> Rozkład </a></li>
                <li><a href="/SKMBusSpring/konto/"> Moje Konto </a></li>
            </ul>
        </nav>
        <header>
            <div id="logreg">
                <form id="regbtn" action="/SKMBusSpring/rejestracja/">
                    <input type="submit" value="Zarejestruj" />
                </form>
                <form id="logbtn" action="/SKMBusSpring/login/">
                    <input type="submit" value="Zaloguj" />
                </form>
            </div>
        </header>
    </body>
</html>
