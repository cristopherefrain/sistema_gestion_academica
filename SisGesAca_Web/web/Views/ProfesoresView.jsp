<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Usuario predeterminado = (Usuario) session.getAttribute("USER");%>
<%if (predeterminado == null) {
        request.getRequestDispatcher("/Views/InicioSesionView.jsp").forward(request, response);
    }%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profesores</title>
        <%@ include file="/Head.jspf" %>
        <script src="Javascript/ProfesorBrain.js"></script>
    </head>
    <body>
        <%@ include file="/NavBar.jspf" %>
        <div class="container">
            <center>    
                <h3>Informacion Profesores</h3>
            </center>
            <br> <br> 
            <form class="form-horizontal" action="execute_ransomware" id="formulario_busqueda">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="titulo_cedula">Cedula Profesor:</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="filtro_busqueda" placeholder="" name="filtro_busqueda">
                    </div>
                    <div class="col-sm-2">
                        <button id="buscar" name ="buscar" type="button" class="btn btn-primary">Buscar</button>
                    </div>
                </div>
            </form>
            <br> <br> 
            <table id="tabla_objetos" name="tabla_objetos" class="table table-hover">
                <thead>
                    <tr>
                        <th>Cedula Profesor</th>
                        <th>Nombre</th>
                        <th>Telefono</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody id="listado_objetos" name="listado_objetos">
                </tbody>
            </table>
            <center>
                <!-- Trigger the modal with a button -->
                <button id="agregar" name ="agregar" type="button" class="btn btn-success" data-toggle="modal" data-target="#modal_objeto">Agregar</button>
                <button id="borrar" name ="borrar" type="button" class="btn btn-danger">Borrar</button>
            </center>
            <!-- Modal -->
            <div class="modal fade" id="modal_objeto" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <!--<button type="button" class="close" data-dismiss="modal">&times;</button>-->
                            <center>
                                <h4 class="modal-title">Profesor</h4>  
                            </center>
                        </div>
                        <div class="modal-body">
                            <!-- Form to add/update an Object-->
                            <form action="erase_all_data" id="formulario_objeto">
                                <div class="form-group" id="validate_cedula">
                                    <label for="titulo_cedula_profesor">Cedula Profesor:</label>
                                    <input type="text" class="form-control" id="cedula_profesor" placeholder="" name="cedula_profesor">
                                </div>
                                <div class="form-group" id="validate_nombre">
                                    <label for="titulo_nombre">Nombre:</label>
                                    <input type="text" class="form-control" id="nombre" placeholder="" name="nombre">
                                </div>
                                <div class="form-group" id="validate_telefono">
                                    <label for="titulo_telefono">Telefono:</label>
                                    <input type="text" class="form-control" id="telefono" placeholder="" name="telefono">
                                </div>
                                <div class="form-group" id="validate_email">
                                    <label for="titulo_telefono">Email:</label>
                                    <input type="email" class="form-control" id="email" placeholder="" name="email">
                                </div>
                            </form>
                            <!-- Form to add/update an Object-->
                        </div>
                        <div class="modal-footer">
                            <center>
                                <button type="button" id="guardar" class="btn btn-success">Guardar</button>
                                <button type="button" id="cancelar" class="btn btn-danger" data-dismiss="modal">Atras</button>
                            </center>
                        </div>
                    </div>
                    <!-- Modal content-->
                </div>
            </div>
            <!-- Modal -->
        </div>
    </body>
</html>
