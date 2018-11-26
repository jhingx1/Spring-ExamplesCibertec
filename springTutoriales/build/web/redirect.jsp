
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- El dispacher servlet tiene el alias del controlador. -->
<!-- Esto nos dirigira hascia el controller con pasando el parametro QRY -->
<% response.sendRedirect("tutoriales.htm?accion=QRY"); %>

