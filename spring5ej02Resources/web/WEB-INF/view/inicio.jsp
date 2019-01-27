<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/resources" var="urlPublic" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%-- agregado --%>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>parainformaticos.com</title>
        
        <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="${urlPublic}/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <p style="text-align: center;margin-top: 50px">
            <img src="${urlPublic}/images/logo.png" alt="">
        </p>
        
        <p style="text-align: center">
            <a href="get">Probar método GET</a>
        </p>
        
        <form action="post" method="post" style="text-align: center">
            <input type="submit" value="Probar método POST"/>
        </form>
        
        <script src="${urlPublic}/jquery/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="${urlPublic}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
