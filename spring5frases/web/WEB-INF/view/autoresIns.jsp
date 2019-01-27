<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:url value="/resources" var="urlRecursos" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>parainformaticos.com</title>

        <link href="${urlRecursos}/jquery/jquery-ui.min.css" type="text/css" rel="stylesheet"/>
        <link href="${urlRecursos}/parainfo/form.css" type="text/css" rel="stylesheet"/>
        <link href="${urlRecursos}/css/main.css" type="text/css" rel="stylesheet"/>

        <script src="${urlRecursos}/jquery/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="${urlRecursos}/jquery/jquery-ui.min.js" type="text/javascript"></script>
        <script src="${urlRecursos}/parainfo/form.js" type="text/javascript"></script>

        <script src="${urlRecursos}/js/autores.js" type="text/javascript"></script>

    </head>
    <body>
        <form:form modelAttribute="autores" method="post" cssStyle="margin: auto;display: table"
                   action="insdb" cssClass="parainfo">
            <fieldset>
                <legend>Nuevo Autor</legend>

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
                            <div style="margin: 10px 20px;color: #900">
                                <ul>
                                    <form:errors path="*" element="li" delimiter="</li><li>" />
                                </ul>
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
    </body>
</html>
