<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>
    <body>
        <!-- commandName="alumnos" debe ser alumnos de AlumnosValidator -->
    <form:form commandName="alumnos" action="alumnos.htm" method="post">
        <table style="margin: auto">
            <tr>
                <td colspan="2" style="color: red">
            <form:errors path="nombre" /><br/>
            <form:errors path="nota" />
            </td>
            </tr>
            <tr>
                <td>Alumno</td>
                <td>
            <form:input path="nombre" cssStyle="width:200px"/>
            </td>
            </tr>
            <tr>
                <td>Nota</td>
                <td>
            <form:input path="nota" cssStyle="width:50px"/>
            </td>
            </tr>
            <tr>
                <td colspan="2">&nbsp;</td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center">
                    <input type="submit" value="Enviar Datos"/>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
