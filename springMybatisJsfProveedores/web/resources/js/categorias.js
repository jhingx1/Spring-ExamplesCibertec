$(function () {
    if ($.trim($("#msg_validacion").text()) !== "") {
        $("#msg_validacion").css("visibility", "visible");
    }
    
    if ($.trim($("#msg_servidor").text()) !== "") {
        $("#msg_servidor").css("visibility", "visible");
    }
});

function clientesIns() {
    window.location = "faces/clientesIns.xhtml";
}

function clientesDel() {
    var ids = [];

    $("input[name='idcliente_del']:checked").each(function () {
        ids.push($(this).val());
    });

    if (ids.length === 0) {
        message("Advertencia", "Seleccione fila(s) a Retirar");
        
    } else {
        $("#message").html("¿Retirar registro(s)?");
        $("#dlg_message").dialog({
            modal: true,
            title: "Advertencia",
            width: 340,
            buttons: {
                "No": function () {
                    $(this).dialog("close");
                },
                "Si": function () {
                    $(this).dialog("close");
                    $("#form_del\\:ids").val(ids.toString());
                    $("#form_del\\:clientesDel").click();
                }
            }
        });
    }
}

function clientesUpd() {
    var id = $("input[name='idcliente_upd']:checked").val();

    if (isNaN(id)) {
        message("Advertencia", "Seleccione Fila para Actualizar Datos");
        
    } else {
        $("#form_get\\:idcliente").val(id);
        $("#form_get\\:clientesGet").click();
    }
}


