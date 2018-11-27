function pi_load() {
    // jQuery
    $(".parainfo thead").addClass("ui-widget-header");
     
    // CRUD
    $(".parainfo thead .crud .ins").tooltip().attr("title", "Añadir registro");//tootip muestra un msm cuando se coloca sobre el icono
    
    $(".parainfo thead .crud .del").tooltip().attr("title", "Retirar registro");
    $(".parainfo thead .crud .upd").tooltip().attr("title", "Actualizar registro");
    
    $(".parainfo thead .crud .ins span").addClass("ui-icon ui-icon-plusthick");
    $(".parainfo thead .crud .del span").addClass("ui-icon ui-icon-minusthick");
    $(".parainfo thead .crud .upd span").addClass("ui-icon ui-icon-check");
    
    // INS
    $("#dins").dialog({
        modal: true,
        autoOpen: false
    });
    
    $(".crud .ins").click(function() {
        $("#nombre").val("");
        $("#correo").val("");
        $("#telefono").val("");
        $("#dins").dialog('open');
    });
    
    // DEL
    $(".crud .del").click(function() {
        var ids = [];

        $("input[name='_del']:checked").each(function() {
            ids.push($(this).val());
        });

        if(ids.length === 0) {
            alert("Debe seleccionar fila(s) a Retirar");
        } else {
            if(confirm("¿Retirar fila(s)?")) {
                window.location = "alumnos.htm?accion=DEL&ids="+ids.toString();
            }
        }
    });
    
    // UPD
    $("#dupd").dialog({
        modal: true,
        autoOpen: false
    });
    
    $(".crud .upd").click(function() {
        var id = $("input[name='_upd']:checked").val();

        if(isNaN(id)) {
            alert("Debe seleccionar Fila para Actualizar Datos");
        } else {
            if(confirm("¿Actualizar registro?")) {
                $.ajax({
                    url: "alumnos.htm?accion=GET&id="+id,
                    success: function(data) {
                        var dato = data.split("+++");
                        
                        if(dato.length === 4) {
                            $("#idalumno").val(dato[0]);
                            $("#nombrex").val(dato[1]);
                            $("#correox").val(dato[2]);
                            $("#telefonox").val(dato[3]);
                        
                            $("#dupd").dialog('open');
                        }
                    }
                });
            }
        }
    });
    
    // botones
    $("input[type=submit]").button();
}
