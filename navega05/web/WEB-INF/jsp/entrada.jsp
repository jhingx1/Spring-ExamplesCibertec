<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>
    <body>
        <h3 style="text-align: center">Ingreso de Datos</h3>
        <form:form modelAttribute="usuario" action="formulario.htm?accion=salida">
            <table style="margin: auto">
                <tr>
                    <td>Nombre</td>
                    <td><form:input path="nombre" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><form:password path="password" /></td>
                </tr>
                <tr>
                    <td>Género</td>
                    <td>
                        <form:radiobutton path="genero" value="M"
                                          label="M" />
                        <form:radiobutton path="genero" value="F"
                                          label="F" />
                    </td>
                </tr>
                <tr>
                    <td>País</td>
                    <td>
                        <form:select path="pais">
                            <form:option value="0"
                                         label="- seleccione -" />
                            <form:options items="${paisList}"
                                          itemValue="paisId"
                                          itemLabel="paisName" />
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td>Comentario</td>
                    <td><form:textarea path="comentario"
                                   cssStyle="resize:none"/></td>
                </tr>
                <tr>
                    <td>Comunidad</td>
                    <td>
                        <form:checkboxes path="comunidad"
                                         items="${comunidadList}"
                                         itemValue="comunidadId"
                                         itemLabel="comunidadName" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center">
                        <input type="submit" value="Enviar Datos">
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>