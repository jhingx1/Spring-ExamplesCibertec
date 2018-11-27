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
                    <td>Nombre</td>
                    <td>Correo</td>
                    <td>Telefono</td>
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
                        <td>${f.nombre}</td>
                        <td>${f.correo}</td>
                        <td colspan="2">${f.telefono}</td>
                        <th>
                            <input type="checkbox" name="_del" 
                                   value="${f.idalumno}"/>
                        </th>
                        <th>
                            <input type="radio" name="_upd" 
                                   value="${f.idalumno}"/>
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
                <form:form commandName="alumnos" method="post"
                           action="alumnos.htm?accion=INS">
                    <table>
                        <tr>
                            <td>Nombre</td>
                            <td>
                                <form:input path="nombre" maxlength="200" 
                                            style="width:200px"/>
                            </td>
                        </tr>
                        <tr>
                            <td>correo</td>
                            <td>
                                <form:input path="correo" maxlength="200" 
                                            style="width:200px"/>
                            </td>
                        </tr>
                        <tr>
                            <td>telefono</td>
                            <td>
                                <form:input 
                                    path="telefono" maxlength="10" 
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
                <form:form commandName="alumnos" method="post"
                           action="alumnos.htm?accion=UPD">
                    <form:hidden path="idalumno" id="idalumno"/>

                    <table>
                        <tr>
                            <td>nombre</td>
                            <td>
                                <form:input 
                                    path="nombre" id="nombrex" 
                                    maxlength="200" style="width:200px"/>
                            </td>
                        </tr>
                        <tr>
                            <td>correo</td>
                            <td>
                                <form:input 
                                    path="correo" id="correox" 
                                    maxlength="200" style="width:200px"/>
                            </td>
                        </tr>
                        <tr>
                            <td>telefono</td>
                            <td>
                                <form:input 
                                    path="telefono" id="telefonox" maxlength="10" 
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
