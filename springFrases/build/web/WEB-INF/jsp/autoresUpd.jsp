<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>parainformaticos.com</title>
        <link href="jq/jquery-ui.min.css" type="text/css" rel="stylesheet"/>
        <link href="css/main.css" type="text/css" rel="stylesheet"/>
        <link href="parainfo/a.css" type="text/css" rel="stylesheet"/>
        <link href="parainfo/form.css" type="text/css" rel="stylesheet"/>

        <script src="jq/jquery-2.1.4.min.js" type="text/javascript"></script>
        <script src="jq/jquery-ui.min.js" type="text/javascript"></script>
        <script src="parainfo/form.js" type="text/javascript"></script>

        <script src="js/autores.js" type="text/javascript"></script>
    </head>
    <body>
        <form:form commandName="autores" method="post"
                   cssStyle="margin: auto;display: table"
                   action="autores.htm?UPD" cssClass="parainfo">
            <form:hidden path="idautor"/>
            
            <fieldset>
                <legend>Actualizar Autor</legend>

                <table class="tabla">
                    <tr>
                        <td>Autor</td>
                        <td>
                            <form:input path="autor" maxlength="200" 
                                        style="width: 300px"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div class="msg_error ui-state-highlight ui-corner-all">
                                <form:errors path="*" element="li" delimiter="</li><li>" />
                                <c:set var="error_valida">
                                    <ul>
                                        <form:errors path="*" element="li" delimiter="</li><li>" />
                                    </ul>
                                </c:set>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center">
                            <input type="submit" value="Enviar Datos" style="margin-right: 40px"/>
                            <input type="button" value="Cancelar" onclick="autoresQry();"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form:form>

        <%-- para errores en INS  --%>
        <div class="msg_error ui-state-highlight ui-corner-all">${msg}</div>

        <p style="text-align: center">
            <a class="parainfo" href="autores.htm?QRY">home</a>
        </p>
    </body>
</html>
