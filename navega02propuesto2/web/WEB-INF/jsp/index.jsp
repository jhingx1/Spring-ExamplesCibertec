<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>parainformaticos.com</title>
        <script type="text/javascript">
            function procesa(operacion) {
                document.getElementById("forma").action = "forma.htm?" + operacion;
                document.forms["forma"].submit();
            }
        </script>
    </head>
    <body>
        <form:form id="forma" commandName="index" method="post">
            <table style="margin: auto">
                <tr>
                    <td>Valor 1</td>
                    <td><form:input path="valor1" /></td>
                </tr>
                <tr>
                    <td>Valor 2</td>
                    <td><form:input path="valor2" /></td>
                </tr>
                <tr>
                    <td colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;">
                        <input type="button" value="+" onclick="procesa('suma');"/>
                        <input type="button" value="-" onclick="procesa('resta');"/>
                        <input type="button" value="*" onclick="procesa('multiplica');"/>
                        <input type="button" value="/" onclick="procesa('divide');"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
