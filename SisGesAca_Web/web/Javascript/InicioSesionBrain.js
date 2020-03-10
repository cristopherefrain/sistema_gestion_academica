//================================================PAGELOAD
function pageLoad(event) {
    reset_page()
    $("#acceder").on("click", login_system)
}
//================================================VALIDAR CAMPOS
function validate() {
    let cedula = $("#cedula").val().trim(), clave = $("#clave").val().trim()

    if (cedula.length === 0)
        $("#validate_cedula").addClass("has-error")
    if (clave.length === 0)
        $("#validate_clave").addClass("has-error")

    return (cedula.length === 0) || (clave.length === 0)
}
function reset_validate() {
    $("#validate_cedula").removeClass("has-error")
    $("#validate_clave").removeClass("has-error")
}
//================================================VARIABLES GLOBALES
let current_usuario = {
    cedula: "",
    clave: "",
    tipo_usuario: "",
}
//================================================METODOS SOBRE VARIABLES
function crear_objeto() {
    let Usuario = {
        cedula: $("#cedula").val(),
        clave: $("#clave").val(),
        tipo_usuario: "SYSDBA"
    }
    return Usuario
}
//================================================METODOS SET/RESET
function reset_page() {
    $("#formulario_inicio_sesion").trigger("reset")
}
//================================================METODO LOGIN
function login_system() {
    reset_validate()
    if (!validate()) {
        current_usuario = crear_objeto()
        $.ajax({type: "PUT",
            data: JSON.stringify(current_usuario),
            contentType: "application/json",
            url: "api/iniciosesion/ingresar",
            success: redirectPage,
        })
    }
}
function redirectPage(objeto) {
    if (objeto) {
        window.location.replace("http://localhost:8080/SisGesAca_Web/");
    } else {
        $("#validate_cedula").addClass("has-error")
        $("#validate_clave").addClass("has-error")
    }
}
//================================================PAGELOAD
$(pageLoad)