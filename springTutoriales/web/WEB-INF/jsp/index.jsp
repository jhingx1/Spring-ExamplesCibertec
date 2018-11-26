<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>parainformaticos.com</title>
        <link href="jq/redmond/jquery-ui-1.10.0.custom.css" type="text/css"
              rel="stylesheet"/>
        <link href="css/main.css" type="text/css" rel="stylesheet"/>
        <link href="jq/parainfo/crud.css" type="text/css" rel="stylesheet"/>

        <script src="jq/jquery-1.9.0.js" type="text/javascript"></script>
        <script src="jq/jquery-ui-1.10.0.custom.js" type="text/javascript">
        </script>
        <script src="jq/parainfo/crud.js" type="text/javascript"></script>
    </head>
    <body onload="pi_load()">
        <table class="parainfo" style="margin: auto;width: 540px">
            <thead>
                <tr>
                    <td>Producto</td>
                    <td>Precio</td>
                    <td>Tipo</td>
                    <th class="crud">
                        <a href="#" class="ins"><span></span></a>
                    </th>
                    <th class="crud">
                        <a href="#" class="del"><span></span></a>
                    </th>
                    <th class="crud">
                        <a href="#" class="upd"><span></span></a>
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="f" items="${prod_qry}">
                    <tr>
                        <td>${f.titulo}</td>
                        <td>${f.precio}</td>
                        <td colspan="2">${f.tipo}</td>
                        <th>
                            <input type="checkbox" name="_del" 
                                   value="${f.idtutorial}"/>
                        </th>
                        <th>
                            <input type="radio" name="_upd" 
                                   value="${f.idtutorial}"/>
                        </th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <%-- para mensajes  --%>
        <div id="error" class="ui-state-error ui-corner-all" 
             style="margin: auto;width: 500px;margin-top: 30px">
            <p style="text-align: center;font-weight: bold">${error}</p>
        </div>
        <c:choose>
            <c:when test="${error != null}">
                <script type="text/javascript">
                    $("#error").css("display", "block").fadeIn("slow")
                    .delay(3000).fadeOut("slow");;
                </script>
            </c:when>
            <c:otherwise>
                <script type="text/javascript">
                    $("#error").css("display", "none");
                </script>
            </c:otherwise>
        </c:choose>

        <%-- para INS  --%>
        <div style="display: none">
            <div id="dins" title="Nuevo registro">
                <form:form commandName="tutoriales" method="post"
                           action="tutoriales.htm?accion=INS">
                    <table>
                        <tr>
                            <td>Producto</td>
                            <td>
                                <form:input path="titulo" maxlength="200" 
                                            style="width:200px"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Tipo</td>
                            <td>
                                <form:select path="tipo" style="width:205px">
                                    <form:option value="Separata" 
                                                 label="Separata"/>
                                    <form:option value="Video" 
                                                 label="Video"/>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td>Precio</td>
                            <td>
                                <form:input 
                                    path="precio" maxlength="10" 
                                    style="width:60px;text-align:right"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">&nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="2" style="text-align: center">
                                <input type="submit" value="Enviar Datos"/>
                            </td>
                        </tr>
                    </table>
                </form:form>
            </div>
        </div>

        <%-- para UPD  --%>
        <div style="display: none">
            <div id="dupd" title="Actualizar datos de registro">
                <form:form commandName="tutoriales" method="post"
                           action="tutoriales.htm?accion=UPD">
                    <form:hidden path="idtutorial" id="idtutorial"/>

                    <table>
                        <tr>
                            <td>Producto</td>
                            <td>
                                <form:input 
                                    path="titulo" id="titulox" 
                                    maxlength="200" style="width:200px"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Tipo</td>
                            <td>
                                <form:select path="tipo" id="tipox" 
                                             style="width:205px">
                                    <form:option value="Separata" 
                                                 label="Separata"/>
                                    <form:option value="Video" 
                                                 label="Video"/>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td>Precio</td>
                            <td>
                                <form:input 
                                    path="precio" id="preciox" maxlength="10" 
                                    style="width:60px;text-align:right"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">&nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="2" style="text-align: center">
                                <input type="submit" value="Enviar Datos"/>
                            </td>
                        </tr>
                    </table>
                </form:form>
            </div>
        </div>
    </body>
</html>
