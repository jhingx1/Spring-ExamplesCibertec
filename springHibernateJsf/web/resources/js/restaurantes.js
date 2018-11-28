$(function () {
    if ($.trim($("#msg_validacion").text()) !== "") {
        $("#msg_validacion").css("visibility", "visible");
    }
    
    if ($.trim($("#msg_servidor").text()) !== "") {
        $("#msg_servidor").css("visibility", "visible");
    }
});

function categoriasQry() {
    window.location = "faces/categoriasQry.xhtml";
}

function restaurantesIns() {
    window.location = "faces/restaurantesIns.xhtml";
}

function restaurantesDel() {
    var ids = [];

    $("input[name='idrestaurante_del']:checked").each(function () {
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
                    $("#form_del\\:restaurantesDel").click();
                }
            }
        });
    }
}

function restaurantesUpd() {
    var id = $("input[name='idrestaurante_upd']:checked").val();

    if (isNaN(id)) {
        message("Advertencia", "Seleccione Fila para Actualizar Datos");
    } else {
        $("#form_get\\:idrestaurante").val(id);
        $("#form_get\\:restaurantesGet").click();
    }
}


