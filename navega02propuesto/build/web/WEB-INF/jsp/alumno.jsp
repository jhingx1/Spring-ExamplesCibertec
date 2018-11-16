<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form:form commandName="alumno" action="nota.htm?fin" cssStyle="text-aling-center">
            Alumno <form:input path="nombre"/><br/>
            Notas <form:input path="nota1"/>
            <form:input path="nota2"/>
            <form:input path="nota3"/>
            <input type="submit" value="Enviar Datos">
        </form:form>
    </body>
</html>
