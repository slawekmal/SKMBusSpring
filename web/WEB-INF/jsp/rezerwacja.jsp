<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css">
        <title>Rezerwacja</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
            <section>
            <form:form id="rezerwacjaForm" method="post" action="${kurs.id}/go" modelAttribute="pomocnik">
                <table>
                    <tr>
                        <td>
                            <spring:message text="Wybrałeś kurs: ${kurs}. Cena jednego biletu to 17 zł.
                                            Opłata za przejazd uiszczana jest podczas faktycznego zakupu biletu
                                            u kierowcy." />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="miejsca">Miejsca</form:label>
                            </td>
                            <td>
                            <form:input id="miejsca" path="miejsca"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Rezerwuj" />
                        </td>
                    </tr>
                </table>
            </form:form>
        </section>
        <script>
            $(function () {
                $("#miejsca").spinner({
                    spin: function (event, ui) {
                        if (ui.value > ${kurs.miejsca}) {
                            $(this).spinner("value", 1);
                            return false;
                        } else if (ui.value < 1) {
                            $(this).spinner("value", ${kurs.miejsca});
                            return false;
                        }
                    }
                });
            });
        </script>
    </body>
</html>
