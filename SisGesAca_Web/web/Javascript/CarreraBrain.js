//================================================PAGELOAD
function pageLoad(event) {
    $("#buscar").on("click", listar_objetos)
    $("#agregar").on("click", set_modo_agregar)
    $("#borrar").on("click", eliminar_objeto)
}
//================================================VARIABLES GLOBALES
let current_carrera = {
    codigo_carrera: "",
    nombre: "",
    titulo: ""
}
//================================================METODOS SOBRE VARIABLES
function crear_objeto() {
    let Carrera = {
        codigo_carrera: $("#codigo_carrera").val(),
        nombre: $("#nombre").val(),
        titulo: $("#titulo").val()
    }
    return Carrera
}
//================================================METODOS SET/RESET
function set_objeto(carrera) {
    $("#codigo_carrera").val(carrera.codigo_carrera)
    $("#codigo_carrera").attr("disabled", true)
    $("#nombre").val(carrera.nombre)
    $("#titulo").val(carrera.titulo)
}
function set_modo_agregar() {
    $("#codigo_carrera").attr("disabled", false)
    reset_modal()
    RecursiveUnbind($("#guardar"))
    $("#guardar").on("click", insertar_objeto)
}
function set_modo_editar() {
    reset_modal()
    buscar_objeto(id_seleccionada())
    RecursiveUnbind($("#guardar"))
    $("#guardar").on("click", modificar_objeto)
    $('#modal_objeto').modal('show')
}
function reset_objeto() {
    current_carrera.codigo_carrera = ""
    current_carrera.nombre = ""
    current_carrera.titulo = ""
}
function reset_formulario_objeto() {
    $("#formulario_objeto").trigger("reset")
}
function reset_modal() {
    reset_objeto()
    reset_formulario_objeto()
    $('#modal_objeto').modal('hide')
}
function reset_page() {
    reset_modal()
    listar_objetos()
}
//================================================METODOS GENERALES
function insertar_objeto() {
    current_carrera = crear_objeto()
    $.ajax({type: "POST",
        data: JSON.stringify(current_carrera),
        contentType: "application/json",
        url: "api/carrera/insertar",
        success: reset_page
    })
}
function modificar_objeto() {
    current_carrera = crear_objeto()
    $.ajax({type: "PUT",
        data: JSON.stringify(current_carrera),
        contentType: "application/json",
        url: "api/carrera/modificar",
        success: reset_page
    })
}
function eliminar_objeto() {
    let id = id_seleccionada()
    if (id) {
        $.ajax({type: "DELETE",
            url: "api/carrera/eliminar?id=" + id,
            success: reset_page
        })
    } else {
        alert("Seleccione una fila (:")
    }
}
function buscar_objeto(id) {
    $.ajax({type: "GET",
        url: "api/carrera/buscar?id=" + id,
        success: set_objeto
    })
}
function listar_objetos() {
    let id = $("#filtro_busqueda").val()
//    $("#formulario_busqueda").trigger("reset")
    $.ajax({type: "GET",
        url: "api/carrera/listar?id=" + id,
        success: crear_filas
    })
}
//================================================METODOS COMPLEMENTARIOS
function crear_filas(lista_objetos) {
    let tbody = $("#listado_objetos")
    tbody.html("")
    lista_objetos.forEach(objeto => crear_fila_objeto(tbody, objeto))
}
function crear_fila_objeto(table_body, objeto) {
    let tr = $("<tr />")
    tr.html(
            "<td>" + objeto.codigo_carrera + "</td>" +
            "<td>" + objeto.nombre + "</td>" +
            "<td>" + objeto.titulo + "</td>"
            )
    tr.click(highlight)
    tr.dblclick(set_modo_editar)
    table_body.append(tr)
}
function highlight(event) {
    let selected = $('.selected')
    if (selected[0])
        selected[0].className = ''
    event.target.parentNode.className = 'selected'
}
function RecursiveUnbind($jElement) {
// Remove this element's and all of its children's click events
    $jElement.unbind()
    $jElement.removeAttr('onclick')
    $jElement.children().each(function () {
        RecursiveUnbind($(this))
    })
}
function id_seleccionada() {
    return $("tr.selected td:first").html()
}
//================================================PAGELOAD
$(pageLoad)