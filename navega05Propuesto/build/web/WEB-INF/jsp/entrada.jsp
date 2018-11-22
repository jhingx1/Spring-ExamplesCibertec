<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>
    <body>
        <h3 style="text-align: center">Ingreso de Datos</h3>
        <form:form modelAttribute="alumno" action="formulario.htm?accion=salida">
            <table style="margin: auto">
                <tr>
                    <td>Alumno: </td>
                    <td><form:input path="nombreAlumno" /></td>
                </tr>
                <tr>
                    <td>Curso:</td>
                    <td>
                        <form:select path="curso">
                            <form:option value="0"
                                         label="- seleccione -" />
                            <form:options items="${cursosList}"
                                          itemValue="cursoId"
                                          itemLabel="curso" />
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td>Turno</td>
                    <td>
                        <form:radiobutton path="turno" value="M" label="Mañana" />
                        <form:radiobutton path="turno" value="T" label="Tarde" />
                        <form:radiobutton path="turno" value="N" label="Noche" />
                    </td>
                </tr>
                <tr>
                    <td>Local:</td>
                    <td>
                        <form:select path="local">
                            <form:option value="0"
                                         label="- seleccione -" />
                            <form:options items="${localList}"
                                          itemValue="localId"
                                          itemLabel="local" />
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td>Forma de Pago</td>
                    <td>
                        <form:checkboxes path="formaPago"
                                         items="${pagosList}"
                                         itemValue="pagoId"
                                         itemLabel="pago" />
                    </td>
                </tr>
                <tr>
                    <td>Total Pago </td>
                    <td><form:input path="totalPago" /></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center">
                        <input type="submit" value="Enviar Datos">
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>