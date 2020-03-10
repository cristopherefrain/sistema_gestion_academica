<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Usuario predeterminado = (Usuario) session.getAttribute("USER");%>
<%if (predeterminado == null) {
        request.getRequestDispatcher("/Views/InicioSesionView.jsp").forward(request, response);
    }%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carreras</title>
        <%@ include file="/Head.jspf" %>
        <script src="Javascript/CarreraBrain.js"></script>
    </head>
    <body>
        <%@ include file="/NavBar.jspf" %>
        <div class="container">
            <center>    
                <h3>Informacion Carreras</h3>
            </center>
            <br> <br> 
            <form class="form-horizontal" action="execute_ransomware" id="formulario_busqueda">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="titulo_codigo">Codigo Carrera:</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="filtro_busqueda" placeholder="" name="filtro_busqueda">
                    </div>
                    <div class="col-sm-2">
                        <button id="buscar" name ="buscar" type="button" class="btn btn-default">Buscar</button>
                    </div>
                </div>
            </form>
            <br> <br> 
            <table id="tabla_objetos" name="tabla_objetos" class="table table-hover">
                <thead>
                    <tr>
                        <th>Codigo Carrera</th>
                        <th>Nombre</th>
                        <th>Titulo</th>
                    </tr>
                </thead>
                <tbody id="listado_objetos" name="listado_objetos">
                </tbody>
            </table>
            <center>
                <!-- Trigger the modal with a button -->
                <button id="agregar" name ="agregar" type="button" class="btn btn-default" data-toggle="modal" data-target="#modal_objeto">Agregar</button>
                <button id="borrar" name ="borrar" type="button" class="btn btn-default">Borrar</button>
            </center>
            <!-- Modal -->
            <div class="modal fade" id="modal_objeto" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <!--<button type="button" class="close" data-dismiss="modal">&times;</button>-->
                            <center>
                                <h4 class="modal-title">Carrera</h4>  
                            </center>
                        </div>
                        <div class="modal-body">
                            <!-- Form to add/update an Object-->
                            <form action="erase_all_data" id="formulario_objeto">
                                <div class="form-group" id="validate_codigo">
                                    <label for="titulo_codigo">Codigo Carrera:</label>
                                    <input type="text" class="form-control" id="codigo_carrera" placeholder="" name="codigo_carrera">
                                </div>
                                <div class="form-group" id="validate_nombre">
                                    <label for="titulo_nombre">Nombre:</label>
                                    <input type="text" class="form-control" id="nombre" placeholder="" name="nombre">
                                </div>
                                <div class="form-group" id="validate_titulo">
                                    <label for="titulo_titulo">Titulo:</label>
                                    <input type="text" class="form-control" id="titulo" placeholder="" name="titulo">
                                </div>
                            </form>
                            <!-- Form to add/update an Object-->
                        </div>
                        <div class="modal-footer">
                            <center>
                                <button type="button" id="guardar" class="btn btn-default">Guardar</button>
                                <button type="button" id="cancelar" class="btn btn-default" data-dismiss="modal">Atras</button>
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
