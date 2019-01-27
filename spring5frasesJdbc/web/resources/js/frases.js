
function autoresQry() {
    window.location = "../autores/qry";
}

function frasesQry() {
    window.location = "qry";
}

function frasesIns() {
    window.location = "ins";
}

function frasesDel() {
    var ids = [];

    $("input[name='idfrase_del']:checked").each(function () {
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
                    window.location = "del?ids=" + ids.toString();
                }
            }
        });
    }
}

function frasesUpd() {
    var id = $("input[name='idfrase_upd']:checked").val();

    if (isNaN(id)) {
        message("Advertencia", "Seleccione Fila para Actualizar Datos");
        
    } else {
        window.location = "get?idfrase=" + id;
    }
}
