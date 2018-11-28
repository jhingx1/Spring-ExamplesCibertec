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

        <script src="js/categorias.js" type="text/javascript"></script>
    </head>
    <body>
        <table class="parainfo" style="margin: auto;width: 300px">
            <thead>
                <tr>
                    <td>Categoría</td>
                    <th class="crud">
                        <a href="#" class="ins" onclick="categoriasIns();" 
                           title="Nuevo Registro"><span></span></a>
                    </th>
                    <th class="crud">
                        <a href="#" class="del" onclick="categoriasDel();" 
                           title="Retirar Registro"><span></span></a>
                    </th>
                    <th class="crud">
                        <a href="#" class="upd" onclick="categoriasUpd();" 
                           title="Actualizar Registro"><span></span></a>
                    </th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="list">
                    <tr>
                        <td colspan="2">
                            <s:property value="categoria"/>
                        </td>
                        <th>
                            <input type="checkbox" name="idcategoria_del" 
                                   value="${idcategoria}"/>
                        </th>
                        <th>
                            <input type="radio" name="idcategoria_upd" 
                                   value="${idcategoria}"/>
                        </th>
                    </tr>
                </s:iterator> 
            </tbody>
        </table>

        <%-- mensajes del servidor --%>
        <s:if test="#request.msg != null">
            <div class="msg_error ui-state-highlight ui-corner-all">${msg}</div>
        </s:if>

        <p style="text-align: center">
            <a class="parainfo" href="restaurantesQry">Home</a>
        </p>

        <%-- mensajes lado del cliente --%>
        <div style="display: none">
            <div id="dlg_message"><p id="message"></p></div>
        </div>
    </body>
</html>
