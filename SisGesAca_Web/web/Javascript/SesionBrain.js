function logout_system() {
    $.ajax({type: "PUT",
        url: "api/iniciosesion/salir",
        success: redirectLogin,
    })
}
function redirectLogin(objeto) {
    window.location.replace("http://localhost:8080/SisGesAca_Web/InicioSesion");
}
