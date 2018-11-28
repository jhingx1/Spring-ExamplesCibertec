$(function () {
    if ($.trim($(".msg_error").html()) !== "") {
        $(".msg_error").css("visibility", "visible");
    }
});

function categoriasIns() {
    window.location = "categoriasIns";
}

function categoriasDel() {
    var ids = [];

    $("input[name='idcategoria_del']:checked").each(function () {
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
                    window.location = "categoriasDel?ids=" + ids.toString();
                }
            }
        });
    }
}

function categoriasUpd() {
    var id = $("input[name='idcategoria_upd']:checked").val();

    if (isNaN(id)) {
        message("Advertencia", "Seleccione Fila para Actualizar Datos");
    } else {
        window.location = "categoriasGet?idcategoria=" + id;
    }
}
