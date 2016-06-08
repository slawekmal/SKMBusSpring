<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        
       <jsp:include page="menu.jsp"></jsp:include>

    <section>
        <h1>WITAJ NA STRONIE SKM Bus!</h1>
        <p>Wychodząc na przeciw oczekiwaniom naszych klientów, oferujemy możliwość rezerwacji miejsc
            na przejazdy busami naszej firmy na trasie Hrubieszów-Lublin/Lublin-Hrubieszów !
            Nie czekaj, załóż konto i skorzystaj z usług SKM Bus!</p>
    </section>

</html>
