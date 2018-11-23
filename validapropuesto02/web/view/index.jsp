<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>
    <body>
        <form:form commandName="ventas" action="ventas.htm" method="post">
            <table style="margin: auto">
                
                <tr>
                    <td>Color</td>
                    <td>
                        <form:select path="color" cssStyle="width:200px">
                            <form:option value="" label="seleccione" />
                            <form:option value="Amarrillo" label="Amarrillo" />
                            <form:option value="Verde" label="Verde" />
                            <form:option value="Azul" label="Azul" />
                        </form:select>
                    </td>
                    <td>
                        <form:errors path="color" cssStyle="color:red"/>
                    </td>
                </tr>
                
                 <tr>
                    <td>Cuello</td>
                    <td>
                        <form:radiobutton path="cuello" value="Redondo" label="Redondo"/>
                        <form:radiobutton path="cuello" value="V" label="V" />
                        <form:radiobutton path="cuello" value="Ojal" label="Ojal" />
                        <form:radiobutton path="cuello" value="Pestaña" label="Pestaña" />
                    </td>
                    <td>
                        <form:errors path="cuello" cssStyle="color:red"/>
                    </td>
                </tr>
                
                <tr>
                    <td>Mangas</td>
                    <td>
                        <form:radiobutton path="mangas" value="Cero" label="Cero"/>
                        <form:radiobutton path="mangas" value="Corta" label="Corta" />
                        <form:radiobutton path="mangas" value="3/4" label="3/4" />
                        <form:radiobutton path="mangas" value="Larga" label="Larga" />
                    </td>
                    <td>
                        <form:errors path="mangas" cssStyle="color:red"/>
                    </td>
                </tr>
                


                <tr>
                    <td>Tela</td>
                    <td>
                        <form:checkbox path="tela" value="Algodon"
                                       label="Algodon" />
                        <form:checkbox path="tela" value="Polyester"
                                       label="Polyester" />
                    </td>
                    <td>
                        <form:errors path="tela" cssStyle="color:red"/>
                    </td>
                </tr>
                
                <tr>
                    <td>Cliente</td>
                    <td>
                        <form:input path="cliente" cssStyle="width:200px"/>
                    </td>
                    <td>
                        <form:errors path="cliente" cssStyle="color:red"/>
                    </td>
                </tr>
                
                <tr>
                    <td>Pago</td>
                    <td>
                        <form:input path="pago" cssStyle="width:200px"/>
                    </td>
                    <td>
                        <form:errors path="pago" cssStyle="color:red"/>
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
    </body>
</html>