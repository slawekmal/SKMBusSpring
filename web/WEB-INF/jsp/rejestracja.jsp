<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rejestracja</title>
    </head>
    <body>
        <form:form action="zarejestruj" commandName="klient">
            <table>
                <tr>
                    <td>
                        <form:label path="imie">
                            <spring:message text="Imię"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="imie" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="nazwisko">
                            <spring:message text="Nazwisko"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="nazwisko" />
                    </td>
                </tr>

                <tr>
                    <td>
                        <form:label path="email">
                            <spring:message text="Email"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="email" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="haslo">
                            <spring:message text="Haslo"/>
                        </form:label>
                    </td>
                    <td>
                        <form:password path="haslo" />
                    </td>
                </tr>

                <tr>
                    <td colspan="2">
                        <input type="submit"
                               value="<spring:message text="Zarejestruj"/>" />
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
