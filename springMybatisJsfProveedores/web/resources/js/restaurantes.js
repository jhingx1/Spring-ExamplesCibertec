$(function () {
    if ($.trim($("#msg_validacion").text()) !== "") {
        $("#msg_validacion").css("visibility", "visible");
    }
    
    if ($.trim($("#msg_servidor").text()) !== "") {
        $("#msg_servidor").css("visibility", "visible");
    }
});

function clientesQry() {
    window.location = "faces/clientesQry.xhtml";
}

function proveedoresIns() {
    window.location = "faces/proveedoresIns.xhtml";
}

function proveedoresDel() {
    var ids = [];

    $("input[name='idproveedor_del']:checked").each(function () {
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
                    $("#form_del\\:proveedoresDel").click();
                }
            }
        });
    }
}

function proveedoresUpd() {
    var id = $("input[name='idproveedor_upd']:checked").val();

    if (isNaN(id)) {
        message("Advertencia", "Seleccione Fila para Actualizar Datos");
    } else {
        $("#form_get\\:idproveedor").val(id);
        $("#form_get\\:proveedoresGet").click();
    }
}


