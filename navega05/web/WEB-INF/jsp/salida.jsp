<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3 style="text-align: center">Detalles de Usuario</h3>
        <table style="margin: auto">
            <tr>
                <td>Nombre</td>
                <td><c:out value="${usuario.nombre}"></c:out></td>
                </tr>
                <tr>
                    <td>Género</td>
                    <td><c:out value="${usuario.genero}"></c:out></td>
                </tr>
                <tr>
                    <td>País</td>
                    <td><c:out value="${usuario.pais}"></c:out></td>
                </tr>
                <tr>
                    <td>Comentario</td>
                    <td><c:out value="${usuario.comentario}"></c:out></td>
                </tr>
                <tr>
                    <td>Comunidad(s)</td>
                    <td>
                    <c:forEach var="item"
                               items="${usuario.comunidad}" >
                        <c:out value="${item}"></c:out>
                    </c:forEach>
                </td>
            </tr>
        </table>
        <p style="text-align:center">
            <a href="formulario.htm?accion=entrada">
                Volver</a>
        </p>
    </body>
</html>
