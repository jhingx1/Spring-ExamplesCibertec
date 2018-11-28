$(function () {
    if ($.trim($(".msg_error").html()) !== "") {
        $(".msg_error").css("visibility", "visible");
    }
});

function categoriasQry() {
    window.location = "categoriasQry";
}

function restaurantesIns() {
    window.location = "restaurantesIns";
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
                    window.location = "restaurantesDel?ids=" + ids.toString();
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
        window.location = "restaurantesGet?idrestaurante=" + id;
    }
}
