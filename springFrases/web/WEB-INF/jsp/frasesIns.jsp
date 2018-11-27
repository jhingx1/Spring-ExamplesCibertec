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

        <script src="js/frases.js" type="text/javascript"></script>
    </head>
    <body>
        <form:form commandName="frases" method="post"
                   cssStyle="margin: auto;display: table"
                   action="frases.htm?INS_DB" cssClass="parainfo">
            <fieldset>
                <legend>Nueva Frase Célebre</legend>

                <table class="tabla">
                    <tr>
                        <td>Autor</td>
                        <td>
                            <form:select path="idautor" cssStyle="width:310px">
                                <c:forEach var="a" items="${list}">
                                    <form:option value="${a[0]}" label="${a[1]}" />
                                </c:forEach>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td>Frase</td>
                        <td>
                            <form:textarea path="frase" 
                                           cssStyle="width:300px;height:60px"/>
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
                            <input type="button" value="Cancelar" onclick="frasesQry();"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form:form>

        <%-- para errores en INS  --%>
        <div class="msg_error ui-state-highlight ui-corner-all">${msg}</div>
    </body>
</html>
