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

        <script language="javascript" type="text/javascript">
            let wsUri = 'ws://127.0.0.1:9876';
            let output

            function init()
            {
                testWebSocket()
                doSend("Probando :v")
            }

            function testWebSocket()
            {
                websocket = new WebSocket(wsUri)
                websocket.onopen = function (evt) {
                    onOpen(evt)
                }
                websocket.onclose = function (evt) {
                    onClose(evt)
                }
                websocket.onmessage = function (evt) {
                    onMessage(evt)
                }
                websocket.onerror = function (evt) {
                    onError(evt)
                }
            }

            function onOpen(evt)
            {
                writeToScreen("CONNECTED")
                doSend("WebSocket rocks")
            }

            function onClose(evt)
            {
                writeToScreen("DISCONNECTED")
            }

            function onMessage(evt)
            {
                writeToScreen('RESPONSE: ' + evt.data)
                websocket.close()
            }

            function onError(evt)
            {
                writeToScreen('ERROR:' + evt.data)
            }

            function doSend(message)
            {
                writeToScreen("SENT: " + message)
                websocket.send(message)
            }

            function writeToScreen(message)
            {
                console.log(message)
            }

            window.addEventListener("load", init, false);
        </script>
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
                                <h2>Bienvenido al Sistema de Gestion Academica.</h2>
                            </center>
                        </div>
                    </div>
                    <br> <br>
                    <div class="row">
                        <div class="col-xs-1"></div>
                        <div class="col-xs-10">
                            <h3>
                                <p> El Sistema de Gestion Academica (SisGesAca) brinda los servicios de
                                    informacion que permiten procesar la información de las carreras que ofrece,
                                    los cursos que las forman, los profesores que los imparten y los alumnos
                                    inscritos. Tambien ofrece la siguiente funcionalidad:
                                </p>
                                <br>
                                <ul>
                                    <li>Gestionar cada ciclo lectivo, para lo cual debe abrir el ciclo como tal,
                                        registrar la oferta académica, es decir los cursos y grupos que se van a abrir 
                                        y los profesores que los van a impartir.
                                    </li>
                                    <br>
                                    <li>Ejecutar el proceso de matrícula, en el cual se registran los cursos y grupos
                                        específicos que matricula cada estudiante.
                                    </li>
                                    <br>
                                    <li>Realizar el proceso final del ciclo, en el cual el profesor registra las notas que obtuvieron 
                                        los estudiantes de sus grupos.
                                    </li>
                                </ul>
                            </h3>
                        </div>
                        <div class="col-xs-1"></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
