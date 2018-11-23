<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>
    <body>
        <form:form commandName="usuarios" action="usuarios.htm" method="post">
            <table style="margin: auto">
                <tr>
                    <td>Nombre</td>
                    <td>
                        <form:input path="nombre" cssStyle="width:200px"/>
                    </td>
                    <td>
                        <form:errors path="nombre" cssStyle="color:red"/>
                    </td>
                </tr>
                <tr>
                    <td>Género</td>
                    <td>
                        <form:radiobutton path="genero" value="M" label="M" />
                        <form:radiobutton path="genero" value="F" label="F" />
                    </td>
                    <td>
                        <form:errors path="genero" cssStyle="color:red"/>
                    </td>
                </tr>
                <tr>
                    <td>País</td>
                    <td>
                        <form:select path="pais" cssStyle="width:200px">
                            <form:option value="" label="seleccione" />
                            <form:option value="Perú" label="Perú" />
                            <form:option value="Bolivia" label="Bolivia" />
                            <form:option value="Ecuador" label="Ecuador" />
                        </form:select>
                    </td>
                    <td>
                        <form:errors path="pais" cssStyle="color:red"/>
                    </td>
                </tr>
                <tr>
                    <td>Acerca de Ud.</td>
                    <td>
                        <form:textarea
                            path="acerca"
                            cssStyle="width:200px;height:40px;resize:none" />
                    </td>
                    <td>
                        <form:errors path="acerca" cssStyle="color:red"/>
                    </td>
                </tr>
                <tr>
                    <td>Comunidades</td>
                    <td>
                        <form:checkbox path="comunidad" value="Spring"
                                       label="Spring" />
                        <form:checkbox path="comunidad" value="Hibernate"
                                       label="Hibernate" />
                        <form:checkbox path="comunidad" value="Struts"
                                       label="Struts" />
                    </td>
                    <td>
                        <form:errors path="comunidad" cssStyle="color:red"/>
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
