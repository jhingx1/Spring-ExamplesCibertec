<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p style="width: 200px;margin: auto">
           Usuario
        </p>
        <hr style="width: 200px;margin: auto"/>
        <p style="width: 200px;margin: auto">
            Nombre ${usuarios.nombre}<br/>
            Genero ${usuarios.genero}<br/>
            Pais ${usuarios.pais}<br/>
            Acerda Ud. ${usuarios.acerca}<br/>
            Comunidades ${usuarios.comunidad[0]}, ${usuarios.comunidad[1]},${usuarios.comunidad[2]}<br/>                     
        </p>
        <p style="text-align: center">
            <a href="usuarios.htm">volver</a>
        </p>
    </body>
</html>
