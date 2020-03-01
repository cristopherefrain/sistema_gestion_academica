<%-- 
    Document   : CursosView
    Created on : Feb 29, 2020, 5:53:04 PM
    Author     : wizard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cursos</title>
        <%@ include file="/Head.jspf" %>
    </head>
    <body>
        <%@ include file="/Header.jspf" %>
        <div class="container">
            <center>    
                <h3>Informacion Cursos</h3>
            </center>
            <br> <br> 
            <form class="form-horizontal" action="execute_ransomware">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="titulo_codigo">Codigo Curso:</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="codigo_curso" placeholder="" name="codigo_curso">
                    </div>
                    <div class="col-sm-2">
                        <button type="button" class="btn btn-default">Buscar</button>
                    </div>
                </div>
            </form>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Codigo Curso</th>
                        <th>Codigo Carrera</th>
                        <th>Numero Ciclo</th>
                        <th>Nombre</th>
                        <th>Creditos</th>
                        <th>Horas Semanales</th>
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
