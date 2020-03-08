//================================================METODOS GENERALES//================================================METODOS GENERALES
function combobox_carrera() {
    $.ajax({type: "GET",
        url: "api/carrera/listar?id=",
        success: crear_opciones_carrera
    })
}
function combobox_ciclo() {
    $.ajax({type: "GET",
        url: "api/ciclo/listar?id=",
        success: crear_opciones_ciclo
    })
}
//================================================METODOS COMPLEMENTARIOS
function crear_opciones_carrera(lista_objetos) {
    let select = $("#codigo_carrera")
    select.find('option').remove();
    lista_objetos.forEach(objeto => opcion_carrera(select, objeto))
}
function crear_opciones_ciclo(lista_objetos) {
    let select = $("#numero_ciclo")
    select.find('option').remove();
    lista_objetos.forEach(objeto => opcion_ciclo(select, objeto))
}
function opcion_carrera(select_input, objeto) {
    $('<option>').val(objeto.codigo_carrera).text(objeto.nombre).appendTo(select_input);
}
function opcion_ciclo(select_input, objeto) {
    $('<option>').val(objeto.no_ciclo).text(objeto.numero).appendTo(select_input);
}

export {combobox_carrera, combobox_ciclo}