<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>parainformaticos.com</title>
    </head>
    <body>
        <form:form commandName="alumno" action="notas.htm?salida" method="post">
            <table style="margin: auto">
                <tr>
                    <td>Alumno</td>
                    <td>
                        <form:input path="nombre" maxlength="50"
                                    cssStyle="width:200px" />
                    </td>
                </tr>
                <tr>
                    <td>Notas</td>
                    <td>
                        <form:select path="nota1" cssStyle="width:65px">
                            <c:forEach var="n" begin="0" end="20">
                                <form:option value="${n}">${n}</form:option>
                            </c:forEach>
                        </form:select>
                        <form:select path="nota2" cssStyle="width:65px">
                            <c:forEach var="n" begin="0" end="20">
                                <form:option value="${n}">${n}</form:option>
                            </c:forEach>
                        </form:select>
                        <form:select path="nota3" cssStyle="width:65px">
                            <c:forEach var="n" begin="0" end="20">
                                <form:option value="${n}">${n}</form:option>
                            </c:forEach>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;">
                        <input type="submit" value="Enviar Datos" />
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
