<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <script src="${urlRecursos}/js/frases.js" type="text/javascript"></script>

    </head>
    <body>
        <form:form modelAttribute="frases" method="post" cssStyle="margin: auto;display: table"
                   action="upd" cssClass="parainfo">
            <form:hidden path="idfrase"/>
            
            <fieldset>
                <legend>Actualizar Frase</legend>

                <table class="tabla">
                    <tr>
                        <td>Autor</td>
                        <td>
                            <form:select path="autores.idautor" cssStyle="width:322px">
                                <c:forEach var="a" items="${list}">
                                    <form:option value="${a.idautor}" label="${a.autor}" />
                                </c:forEach>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td>Frase</td>
                        <td>
                            <form:textarea path="frase" cssStyle="width:300px;height:60px"/>
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
                            <input type="button" value="Cancelar" onclick="frasesQry();"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form:form>
    </body>
</html>
