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
                <td>Alumno</td>
                <td><c:out value="${alumno.nombreAlumno}"></c:out></td>
                </tr>
                <tr>
                    <td>Curso</td>
                    <td><c:out value="${alumno.curso}"></c:out></td>
                </tr>
                <tr>
                    <td>Turno</td>
                    <td><c:out value="${alumno.turno}"></c:out></td>
            </tr>
            <tr>
                    <td>Local</td>
                    <td><c:out value="${alumno.local}"></c:out></td>
            </tr>
             
            <tr>
                    <td>Forma Pago</td>
                    <td>
                    <c:forEach var="item"
                               items="${alumno.formaPago}" >
                        <c:out value="${item}"></c:out>
                    </c:forEach>
                </td>
            </tr>
            
            <tr>
                    <td>Total Pago</td>
                    <td><c:out value="${alumno.totalPago}"></c:out></td>
            </tr>

        </table>
        <p style="text-align:center">
            <a href="formulario.htm?accion=entrada">
                Volver</a>
        </p>
    </body>
</html>
