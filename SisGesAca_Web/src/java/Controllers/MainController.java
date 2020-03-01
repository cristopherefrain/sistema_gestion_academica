/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moviles
 */
@WebServlet(name = "MainController", urlPatterns = {"/Alumno", "/Alumnos", "/Carrera", "/Carreras", "/Curso", "/Cursos", "/Profesor", "/Profesores"})
public class MainController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        switch (request.getServletPath()) {
            case "/Alumno": {
                request.getRequestDispatcher("/Views/AlumnoView.jsp").forward(request, response);
            }
            break;
            case "/Alumnos": {
                request.getRequestDispatcher("/Views/AlumnosView.jsp").forward(request, response);
            }
            break;
            case "/Carrera": {
                request.getRequestDispatcher("/Views/CarreraView.jsp").forward(request, response);
            }
            break;
            case "/Carreras": {
                request.getRequestDispatcher("/Views/CarrerasView.jsp").forward(request, response);
            }
            break;
            case "/Curso": {
                request.getRequestDispatcher("/Views/CursoView.jsp").forward(request, response);
            }
            break;
            case "/Cursos": {
                request.getRequestDispatcher("/Views/CursosView.jsp").forward(request, response);
            }
            break;
            case "/Profesor": {
                request.getRequestDispatcher("/Views/ProfesorView.jsp").forward(request, response);
            }
            break;
            case "/Profesores": {
                request.getRequestDispatcher("/Views/ProfesoresView.jsp").forward(request, response);
            }
            break;
            default:
                try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>PAC-MAN</title>");
                out.println("</head>");
                out.println("<body> <center>");
                out.println("<h1>Program and Control C<  o o o " + "</h1>");
                out.println("</body> </center>");
                out.println("</html>");
            }
            break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}