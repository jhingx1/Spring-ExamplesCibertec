<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>parainformaticos.com</title>
        <link href="jq/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <link href="parainfo/table.css" rel="stylesheet" type="text/css"/>
        <link href="parainfo/message.css" rel="stylesheet" type="text/css"/>
        <link href="parainfo/a.css" rel="stylesheet" type="text/css"/>
        
        <script src="jq/jquery-2.1.4.min.js" type="text/javascript"></script>
        <script src="jq/jquery-ui.min.js" type="text/javascript"></script>
        <script src="parainfo/table.js" type="text/javascript"></script>
        <script src="parainfo/message.js" type="text/javascript"></script>
        
        <script src="js/restaurantes.js" type="text/javascript"></script>
    </head>
    <body>
        <table class="parainfo" style="margin: auto;width: 540px">
            <thead>
                <tr>
                    <th class="crud">
                        <a href="#" class="qry" onclick="categoriasQry();" 
                           title="Ver Categorías"><span></span></a>
                    </th>
                    <td>Restaurante</td>
                    <td>Categoría</td>
                    <td>Distrito</td>
                    <td>Dirección</td>
                    <th class="crud">
                        <a href="#" class="ins" onclick="restaurantesIns();" 
                           title="Nuevo Registro"><span></span></a>
                    </th>
                    <th class="crud">
                        <a href="#" class="del" onclick="restaurantesDel();" 
                           title="Retirar Registro"><span></span></a>
                    </th>
                    <th class="crud">
                        <a href="#" class="upd" onclick="restaurantesUpd();" 
                           title="Actualizar Registro"><span></span></a>
                    </th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="list" var="r">
                    <tr>
                        <td colspan="2">
                            <s:property value="#r[1]"/>
                        </td>
                        <td>
                            <s:property value="#r[2]"/>
                        </td>
                        <td>
                            <s:property value="#r[3]"/>
                        </td>
                        <td colspan="2">
                            <s:property value="#r[4]"/>
                        </td>
                        <th>
                            <input type="checkbox" name="idrestaurante_del" 
                                   value="${r[0]}"/>
                        </th>
                        <th>
                            <input type="radio" name="idrestaurante_upd" 
                                   value="${r[0]}"/>
                        </th>
                    </tr>
                </s:iterator> 
            </tbody>
        </table>
        
        <%-- mensajes del servidor --%>
        <s:if test="#request.msg != null">
            <div class="msg_error ui-state-highlight ui-corner-all">${msg}</div>
        </s:if>
        
        <%-- mensajes lado del cliente --%>
        <div style="display: none">
            <div id="dlg_message"><p id="message"></p></div>
        </div>
    </body>
</html>

