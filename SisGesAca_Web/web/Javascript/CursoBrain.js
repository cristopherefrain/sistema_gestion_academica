import {combobox_carrera, combobox_ciclo} from "./ComboBoxBrain.js";

//================================================PAGELOAD
function pageLoad(event) {
    $("#buscar").on("click", listar_objetos)
    $("#agregar").on("click", set_modo_agregar)
    $("#borrar").on("click", eliminar_objeto)
    combobox_carrera()
    combobox_ciclo()
}
//================================================VALIDAR CAMPOS
function validate() {
    let codigo_curso = $("#codigo_curso").val().trim(), nombre = $("#nombre").val().trim(), creditos = $("#creditos").val().trim(), horas_semanales = $("#horas_semanales").val().trim()

    if (codigo_curso.length === 0)
        $("#validate_codigo").addClass("has-error")
    if (nombre.length === 0)
        $("#validate_nombre").addClass("has-error")
    if (creditos.length === 0)
        $("#validate_creditos").addClass("has-error")
    if (horas_semanales.length === 0)
        $("#validate_horas_semanales").addClass("has-error")
    return (codigo_curso.length === 0) || (nombre.length === 0) || (creditos.length === 0) || (horas_semanales.length === 0)
}
function reset_validate() {
    $("#validate_codigo").removeClass("has-error")
    $("#validate_nombre").removeClass("has-error")
    $("#validate_creditos").removeClass("has-error")
    $("#validate_horas_semanales").removeClass("has-error")
}
//================================================VARIABLES GLOBALES
let current_curso = {
    codigo_curso: "",
    codigo_carrera: "",
    no_ciclo: "",
    nombre: "",
    creditos: "",
    horas_semanales: ""
}
//================================================METODOS SOBRE VARIABLES
function crear_objeto() {
    let Curso = {
        codigo_curso: $("#codigo_curso").val(),
        codigo_carrera: $("#codigo_carrera").val(),
        no_ciclo: $("#numero_ciclo").val(),
        nombre: $("#nombre").val(),
        creditos: $("#creditos").val(),
        horas_semanales: $("#horas_semanales").val()
    }
    return Curso
}
//================================================METODOS SET/RESET
function set_objeto(curso) {
    $("#codigo_curso").val(curso.codigo_curso)
    $("#codigo_curso").attr("disabled", true)
    $("#codigo_carrera").val(curso.codigo_carrera)
    $("#numero_ciclo").val(curso.no_ciclo)
    $("#nombre").val(curso.nombre)
    $("#creditos").val(curso.creditos)
    $("#horas_semanales").val(curso.horas_semanales)
}
function set_modo_agregar() {
    $("#codigo_curso").attr("disabled", false)
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
    current_curso.codigo_curso = ""
    current_curso.codigo_carrera = ""
    current_curso.no_ciclo = ""
    current_curso.nombre = ""
    current_curso.creditos = ""
    current_curso.horas_semanales = ""
}
function reset_formulario_objeto() {
    $("#formulario_objeto").trigger("reset")
}
function reset_modal() {
    reset_objeto()
    reset_formulario_objeto()
    reset_validate()
    $('#modal_objeto').modal('hide')
}
function reset_page() {
    reset_modal()
    listar_objetos()
}
//================================================METODOS GENERALES
function insertar_objeto() {
    reset_validate()
    if (!validate()) {
        current_curso = crear_objeto()
        $.ajax({type: "POST",
            data: JSON.stringify(current_curso),
            contentType: "application/json",
            url: "api/curso/insertar",
            success: reset_page
        })
    }
}
function modificar_objeto() {
    reset_validate()
    if (!validate()) {
        current_curso = crear_objeto()
        $.ajax({type: "PUT",
            data: JSON.stringify(current_curso),
            contentType: "application/json",
            url: "api/curso/modificar",
            success: reset_page
        })
    }
}
function eliminar_objeto() {
    let id = id_seleccionada()
    if (id) {
        $.ajax({type: "DELETE",
            url: "api/curso/eliminar?id=" + id,
            success: reset_page
        })
    } else {
        alert("Seleccione una fila (:")
    }
}
function buscar_objeto(id) {
    $.ajax({type: "GET",
        url: "api/curso/buscar?id=" + id,
        success: set_objeto
    })
}
function listar_objetos() {
    let id = $("#filtro_busqueda").val()
//    $("#formulario_busqueda").trigger("reset")
    $.ajax({type: "GET",
        url: "api/curso/listar?id=" + id,
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
            "<td>" + objeto.codigo_curso + "</td>" +
            "<td>" + objeto.codigo_carrera + "</td>" +
            "<td>" + objeto.no_ciclo + "</td>" +
            "<td>" + objeto.nombre + "</td>" +
            "<td>" + objeto.creditos + "</td>" +
            "<td>" + objeto.horas_semanales + "</td>"
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