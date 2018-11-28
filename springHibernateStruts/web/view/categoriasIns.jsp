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

        <script src="js/categorias.js" type="text/javascript"></script>
    </head>
    <body>
        <s:form action="categoriasIns2" theme="simple" method="post" 
                cssStyle="margin: auto;display: table" cssClass="parainfo">

            <fieldset>
                <legend>Nueva Categoría</legend>

                <table class="tabla">
                    <tr>
                        <td>Categoría</td>
                        <td>
                            <s:textfield name="categorias.categoria" 
                                         maxlength="200" 
                                         cssStyle="width:300px"/>
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
                    <s:if test="fieldErrors.get('categorias.categoria').size() > 0">
                        <li><s:property value="fieldErrors.get('categorias.categoria').get(0)" /></li>
                        </s:if>
                </ul>
            </div>
        </s:if>

        <p style="text-align: center">
            <a class="parainfo" href="categoriasQry">Cancelar</a>
        </p>
    </body>
</html>
