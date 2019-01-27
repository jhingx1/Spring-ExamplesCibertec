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
        <link href="${urlResources}/parainfo/a.css" type="text/css" rel="stylesheet"/>
        <link href="${urlResources}/parainfo/table.css" type="text/css" rel="stylesheet"/>
        <link href="${urlResources}/parainfo/message.css" rel="stylesheet" type="text/css"/>

        <script src="${urlResources}/jq/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="${urlResources}/jq/jquery-ui.min.js" type="text/javascript"></script>
        <script src="${urlResources}/parainfo/table.js" type="text/javascript"></script>
        <script src="${urlResources}/parainfo/message.js" type="text/javascript"></script>

        <script src="${urlResources}/js/frases.js" type="text/javascript"></script>
    </head>
    <body>
        <table class="parainfo" style="margin: auto;width: 600px">
            <thead>
                <tr>
                    <th class="crud">
                        <a class="qry" href="#" onclick="autoresQry();"
                           title="Listas de Autores"><span></span></a>
                    </th>
                    <td>Autor</td>
                    <td>Frase</td>
                    <th class="crud">
                        <a class="ins" href="#" onclick="frasesIns();"
                           title="Nuevo Registro"><span></span></a>
                    </th>
                    <th class="crud">
                        <a class="del" href="#" onclick="frasesDel();"
                           title="Retirar Registros"><span></span></a>
                    </th>
                    <th class="crud">
                        <a class="upd" href="#" onclick="frasesUpd();"
                           title="Actualizar Registro"><span></span></a>
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="r" items="${list}">
                    <tr>
                        <td colspan="2">${r[1]}</td>
                        <td colspan="2">${r[2]}</td>
                        <th>
                            <input type="checkbox" name="idfrase_del" 
                                   value="${r[0]}"/>
                        </th>
                        <th>
                            <input type="radio" name="idfrase_upd" 
                                   value="${r[0]}"/>
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
