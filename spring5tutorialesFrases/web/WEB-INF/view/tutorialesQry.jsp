<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources" var="urlResources" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>parainformaticos.com</title>

        <link href="${urlResources}/jq/jquery-ui.min.css" type="text/css" rel="stylesheet"/>
        <link href="${urlResources}/css/main.css" type="text/css" rel="stylesheet"/>
        <link href="${urlResources}/parainfo/table.css" type="text/css" rel="stylesheet"/>
        <link href="${urlResources}/parainfo/message.css" rel="stylesheet" type="text/css"/>

        <script src="${urlResources}/jq/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="${urlResources}/jq/jquery-ui.min.js" type="text/javascript"></script>
        <script src="${urlResources}/parainfo/table.js" type="text/javascript"></script>
        <script src="${urlResources}/parainfo/message.js" type="text/javascript"></script>

        <script src="${urlResources}/js/tutoriales.js" type="text/javascript"></script>
    </head>

    <body>
        <table class="parainfo" style="margin: auto;width: 500px">
            <thead>
                <tr>
                    <td>Título</td>
                    <td>Precio&nbsp;S/.</td>
                    <td>Tipo</td>
                    <th class="crud">
                        <a class="ins" href="#" onclick="tutorialesIns();"
                           title="Nuevo Registro"><span></span></a>
                    </th>
                    <th class="crud">
                        <a class="del" href="#" onclick="tutorialesDel();"
                           title="Retirar Registros"><span></span></a>
                    </th>
                    <th class="crud">
                        <a class="upd" href="#" onclick="tutorialesUpd();"
                           title="Actualizar Registro"><span></span></a>
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="f" items="${list}">
                    <tr>
                        <td>${f.titulo}</td>
                        <td style="text-align: right">${f.precio}</td>
                        <td colspan="2">${f.tipo}</td>
                        <th>
                            <input type="checkbox" name="idtutorial_del" 
                                   value="${f.idtutorial}"/>
                        </th>
                        <th>
                            <input type="radio" name="idtutorial_upd" 
                                   value="${f.idtutorial}"/>
                        </th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <%-- mensajes del servidor --%>
        <div class="ui-state-error ui-corner-all"
             style="margin: 10px 20px;padding: 20px 40px;display: ${msg == null ? 'none': 'block'}">
            ${msg}
        </div>

        <%-- mensajes lado del cliente --%>
        <div style="display: none">
            <div id="dlg_message"><p id="message"></p></div>
        </div>
    </body>
</html>

