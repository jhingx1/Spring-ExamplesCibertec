<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <script src="${urlResources}/js/frases.js" type="text/javascript"></script>
    </head>
    <body>
        <form:form modelAttribute="frases" method="post" cssClass="parainfo"
                   action="insdb" cssStyle="margin: auto;display: table">
            <fieldset>
                <legend>Nueva Frase</legend>

                <table class="tabla">
                    <tr>
                        <td>Autor</td>
                        <td>
                            <form:select path="idautor" cssStyle="width:322px">
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
                            <input type="button" value="Cancelar" onclick="frasesQry();"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form:form>
    </body>
</html>
