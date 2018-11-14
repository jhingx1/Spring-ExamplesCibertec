<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <form:form commandName="data" action="formulario.htm?accion=SAL">
            <table style="margin: auto">
                <tr>
                    <td>Apellidos</td>
                    <td>
                        <form:input path="apellidos"/>
                    </td>
                </tr>
                <tr>
                    <td>Nombres</td>
                    <td>
                        <form:input path="nombres"/>
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
