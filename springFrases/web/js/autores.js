$(function () {
    if ($.trim($(".msg_error").text()) !== "") {
        $(".msg_error").css("visibility", "visible");
    }
});

function autoresQry() {
    window.location = "autores.htm?QRY";
}

function autoresIns() {
    window.location = "autores.htm?INS_FRM";
}

function autoresDel() {
    var ids = [];

    $("input[name='idautor_del']:checked").each(function () {
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
                    window.location = "autores.htm?DEL&ids=" + ids.toString();
                }
            }
        });
    }
}

function autoresUpd() {
    var id = $("input[name='idautor_upd']:checked").val();

    if (isNaN(id)) {
        message("Advertencia", "Seleccione Fila para Actualizar Datos");
    } else {
        window.location = "autores.htm?GET&idautor=" + id;
    }
}
