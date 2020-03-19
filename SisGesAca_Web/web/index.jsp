<%-- 
    Document   : index
    Created on : Feb 29, 2020, 2:23:40 PM
    Author     : wizard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Gestion Academica</title>
        <%@ include file="/Head.jspf" %>
    </head>
    <body>
        <%@ include file="/NavBar.jspf" %>
        <div class="container">
            <div class="row">
                <br> <br>
                <div class="col-xs-12">
                    <div class="row">
                        <div class="col-xs-12">
                            <center>
                                <h3>Bienvenido al Sistema de Gestion Academica.</h3>
                            </center>
                        </div>
                    </div>
                    <br> <br>
                    <div class="row">
                        <div class="col-xs-1"></div>
                        <div class="col-xs-10">
                            <p> El Sistema de Gestion Academica (SisGesAca) brinda los servicios de
                                informacion que permiten procesar la información de las carreras que ofrece,
                                los cursos que las forman, los profesores que los imparten y los alumnos
                                inscritos. Tambien ofrece la siguiente funcionalidad:
                            </p>
                            <ul>
                                <li>Gestionar cada ciclo lectivo, para lo cual debe abrir el ciclo como tal,
                                    registrar la oferta académica, es decir los cursos y grupos que se van a abrir 
                                    y los profesores que los van a impartir.
                                </li>
                                <li>Ejecutar el proceso de matrícula, en el cual se registran los cursos y grupos
                                    específicos que matricula cada estudiante.
                                </li>
                                <li>Realizar el proceso final del ciclo, en el cual el profesor registra las notas que obtuvieron 
                                    los estudiantes de sus grupos.
                                </li>
                            </ul>
                        </div>
                        <div class="col-xs-1"></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
