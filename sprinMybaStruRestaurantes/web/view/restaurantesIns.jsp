<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="s" uri="/struts-tags" %>
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

        <script src="js/restaurantes.js" type="text/javascript"></script>
    </head>
    <body>
        <s:form action="restaurantesIns2" theme="simple" method="post" 
                cssStyle="margin: auto;display: table" cssClass="parainfo">

            <fieldset>
                <legend>Registrar Nuevo Restaurante</legend>

                <table class="tabla">
                    <tr>
                        <td>Restaurante</td>
                        <td>
                            <s:textfield name="restaurantes.restaurante" 
                                         maxlength="200" 
                                         cssStyle="width:300px"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Categoría</td>
                        <td>
                            <s:select list="categorias" cssStyle="width:310px"
                                      name="restaurantes.idcategoria"
                                      listKey="idcategoria" listValue="categoria"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Dirección</td>
                        <td>
                            <s:textfield name="restaurantes.direccion" 
                                         maxlength="200" 
                                         cssStyle="width:300px"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Distrito</td>
                        <td>
                            <s:select list="distritos" cssStyle="width:310px"
                                      name="restaurantes.iddistrito"
                                      listKey="iddistrito" listValue="distrito"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center">
                            <s:submit value="Enviar Datos"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </s:form>

        <%-- para errores en INS --%>
        <s:if test="(#request.msg != null) || (fieldErrors.size() > 0)">
            <div class="msg_error ui-state-highlight ui-corner-all">
                ${msg} <%-- para errores por DAO --%>

                <ul> <%-- para errores por validacion --%>
                    <s:if test="fieldErrors.get('restaurantes.idcategoria').size() > 0">
                        <li>
                            <s:property value="fieldErrors.get('restaurantes.idcategoria').get(0)" />
                        </li>
                    </s:if>
                    <s:if test="fieldErrors.get('restaurantes.restaurante').size() > 0">
                        <li>
                            <s:property value="fieldErrors.get('restaurantes.restaurante').get(0)" />
                        </li>
                    </s:if>
                    <s:if test="fieldErrors.get('restaurantes.direccion').size() > 0">
                        <li>
                            <s:property value="fieldErrors.get('restaurantes.direccion').get(0)" />
                        </li>
                    </s:if>
                    <s:if test="fieldErrors.get('restaurantes.iddistrito').size() > 0">
                        <li>
                            <s:property value="fieldErrors.get('restaurantes.iddistrito').get(0)" />
                        </li>
                    </s:if>
                </ul>
            </div>
        </s:if>

        <p style="text-align: center">
            <a class="parainfo" href="restaurantesQry">Cancelar</a>
        </p>
    </body>
</html>
