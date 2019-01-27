<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/resources" var="urlRecursos" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>parainformaticos.com</title>
        
        <link href="${urlRecursos}/jquery/jquery-ui.min.css" type="text/css" rel="stylesheet"/>
        <link href="${urlRecursos}/parainfo/table.css" type="text/css" rel="stylesheet"/>
        <link href="${urlRecursos}/parainfo/message.css" type="text/css" rel="stylesheet"/>
        <link href="${urlRecursos}/css/main.css" type="text/css" rel="stylesheet"/>
        
        <script src="${urlRecursos}/jquery/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="${urlRecursos}/jquery/jquery-ui.min.js" type="text/javascript"></script>
        <script src="${urlRecursos}/parainfo/table.js" type="text/javascript"></script>
        <script src="${urlRecursos}/parainfo/message.js" type="text/javascript"></script>
        <script src="${urlRecursos}/js/frases.js" type="text/javascript"></script>
        
    </head>
    <body>
        <table class="parainfo" style="margin: auto;width: 600px">
            <thead>
                <tr>
                    <th class="crud">
                        <a class="qry" href="#" onclick="autoresQry();"
                           title="Lista de Autores"><span></span></a>
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
                <c:forEach var="f" items="${list}">
                    <tr>
                        <td colspan="2">${f.autores.autor}</td>
                        <td colspan="2">${f.frase}</td>
                        <th>
                            <input type="checkbox" name="idfrase_del" 
                                   value="${f.idfrase}"/>
                        </th>
                        <th>
                            <input type="radio" name="idfrase_upd" 
                                   value="${f.idfrase}"/>
                        </th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
                  
        <%-- mensajes del servidor --%>
        <div style="margin: auto;width: 400px;margin-top: 20px;padding:8px 16px">${msg}</div>

        <%-- mensajes lado del cliente --%>
        <div style="display: none">
            <div id="dlg_message"><p id="message"></p></div>
        </div>
    </body>
</html>
