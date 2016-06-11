<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Moje Konto</title>
        <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css">
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
            <section>
            <c:if test="${logowanie.jestZalogowany()}" >
                <input type="button" id="openDelDlg" value="Usuń konto" />
                <div id="delDlg" title="Usuwanie konta">
                    <p>Czy na pewno usunąć konto?</p>
                    <form id="deleteAcc" action="usunkonto">
                        <input type="submit" value="Tak" />
                    </form>
                    <form id="cancelDel">
                        <input type="button" id="cancel" value="Anuluj" />
                    </form>
                </div>
                <h3>Zarezerwowane miejsca</h3>
                <c:if test="${!empty kursy}">
                    <table class="tg">
                        <tr>
                            <th width="120">Data</th>
                            <th width="120">Godzina</th>
                            <th width="120">Kierunek</th>
                            <th width="60">Usuń</th>
                        </tr>
                        <c:forEach items="${kursy}" var="kurs">
                            <tr>
                                <td>${kurs.dzienString}</td>
                                <td>${kurs.godzina}</td>
                                <td>${kurs.kierunek}</td>
                                <td><a href="<c:url value='usun/${kurs.id}' />" >Usuń</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </c:if>
            <c:if test="${!logowanie.jestZalogowany()}" >
                <form>
                    <h2> Musisz się zalogować, żeby obejrzeć swoje konto </h2>
                </form>
            </c:if>
        </section>
        <script>
            $(function () {
                $("#delDlg").dialog({
                    autoOpen: false
                });
                $("#openDelDlg").click(function () {
                    $("#delDlg").dialog("open");
                });
                $("#cancel").click(function () {
                    $("#delDlg").dialog("close");
                });
            });
        </script>
    </body>
</html>
