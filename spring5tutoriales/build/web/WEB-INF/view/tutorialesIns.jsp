<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources" var="urlResources" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>parainformaticos.com</title>
        <link href="${urlResources}/jq/jquery-ui.min.css" type="text/css" rel="stylesheet"/>
        <link href="${urlResources}/css/main.css" type="text/css" rel="stylesheet"/>
        <link href="${urlResources}/parainfo/a.css" type="text/css" rel="stylesheet"/>
        <link href="${urlResources}/parainfo/form.css" type="text/css" rel="stylesheet"/>

        <script src="${urlResources}/jq/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="${urlResources}/jq/jquery-ui.min.js" type="text/javascript"></script>
        <script src="${urlResources}/parainfo/form.js" type="text/javascript"></script>

        <script src="js/tutoriales.js" type="text/javascript"></script>
    </head>
    <body>
        <form:form modelAttribute="tutoriales" method="post" cssClass="parainfo"
                   action="insdb" cssStyle="margin: auto;display: table">
            <fieldset>
                <legend>Nuevo Tutorial</legend>

                <table class="tabla">
                    <tr>
                        <td>Tutorial</td>
                        <td>
                            <form:input path="titulo" maxlength="200" 
                                        style="width: 300px"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Tipo</td>
                        <td>
                            <form:select path="tipo" style="width: 320px">
                                <form:option value="Separata" 
                                             label="Separata"/>
                                <form:option value="Video" 
                                             label="Video"/>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td>Precio&nbsp;S/.</td>
                        <td>
                            <form:input 
                                path="precio" maxlength="6"
                                cssStyle="width: 100px;text-align: right"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div class="ui-state-error ui-corner-all"
                                 style="margin: 10px 20px;padding: 5px 10px;display: ${msg == null ? 'none': 'block'}">
                                <ul>
                                    <form:errors path="*" element="li" delimiter="</li><li>" />
                                </ul>

                                ${msg} <%-- también imprime mensajes del DAO si hubiese --%>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center">
                            <input type="submit" value="Enviar Datos" style="margin-right: 40px"/>
                            <input type="button" value="Cancelar" onclick="tutorialesQry();"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form:form>
    </body>
</html>
