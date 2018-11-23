<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p style="width: 200px;margin: auto">
            ingresos
        </p>
        <hr style="width: 200px;margin: auto"/>
        <p style="width: 200px;margin: auto">
            Color ${ventas.color}<br/>
            Cuello: ${ventas.cuello}<br/>
            Mangas: ${ventas.mangas}<br/>
            Telas: ${ventas.tela[0]}, ${ventas.tela[1]}<br/>
            Cliente: ${ventas.cliente}<br/>
            Pago: ${ventas.pago}<br/>
        </p>
        <p style="text-align: center">
            <a href="ventas.htm">volver</a>
        </p>
    </body>
</html>
