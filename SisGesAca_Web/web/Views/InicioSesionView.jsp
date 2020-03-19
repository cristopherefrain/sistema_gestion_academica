<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesion</title>
        <%@ include file="/Head.jspf" %>
        <script src="Javascript/InicioSesionBrain.js" type="module"></script>
    </head>
    <body>
        <%@ include file="/NavBar.jspf" %>
        <div class="container">
            <center> 
                <div class="col-sm-offset-4 col-sm-4">
                    <br><br><br>
                    <h3>Inicio de Sesion</h3>
                    <hr>
                    <form action="erase_all_data" id="formulario_inicio_sesion">
                        <div class="form-group"  id="validate_cedula">
                            <label for="text">Cedula</label>
                            <input type="text" class="form-control" id="cedula" name="cedula">
                        </div>
                        <div class="form-group" id="validate_clave">
                            <label for="contraseña">Clave</label>
                            <input type="password" class="form-control" id="clave" name="clave">
                        </div>
                        <br>
                        <div class="form-group"> 
                            <button id="acceder" name ="acceder" type="button"  class="btn btn-success btn-block">Ingresar</button>
                        </div>
                        <div class="form-group">  
                            <button id="regresar" name ="regresar" type="button"  class="btn btn-danger btn-block">Regresar</button>
                        </div>
                    </form> 
                    <hr>
                </div>
            </center>
        </div>
    </body>
</html>
