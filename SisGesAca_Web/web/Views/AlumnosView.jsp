<%-- 
    Document   : AlumnosView
    Created on : Feb 29, 2020, 5:51:29 PM
    Author     : wizard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumnos</title>
        <%@ include file="/Head.jspf" %>
    </head>
    <body>
        <%@ include file="/Header.jspf" %>
        <div class="container">
            <center>    
                <h3>Informacion Alumnos</h3>
            </center>
            <br> <br> 
            <form class="form-horizontal" action="execute_ransomware">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="titulo_cedula">Cedula Alumno:</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="cedula_alumno" placeholder="" name="cedula_alumno">
                    </div>
                    <div class="col-sm-2">
                        <button type="button" class="btn btn-default">Buscar</button>
                    </div>
                </div>
            </form>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Cedula Alumno</th>
                        <th>Nombre</th>
                        <th>Telefono</th>
                        <th>Email</th>
                        <th>Fecha Nacimiento</th>
                        <th>Carrera</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
            <center>
                <button type="button" class="btn btn-primary">Agregar</button>
            </center>
        </div>
    </body>
</html>
