<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form:form commandName="data" action="navega.htm?duplica" 
                   cssStyle="text-align:center">            
            Valor: <form:input path="valor"/>            
            <input type="submit" value="Enviar Datos"/>            
        </form:form>
    </body>
</html>
