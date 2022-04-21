/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.registroDAO;
import beens.registroBeens;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SENA-WS-H50-1
 */
public class RegistroControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    registroBeens miRegisB = new registroBeens();
    String[] errores = new String[4];
    registroDAO miRegisD = new registroDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("accion");
        PrintWriter salida = response.getWriter();
        
        if (opcion.equals("insertar")) {
            if (request.getParameter("nombres").toString().length()>0 && request.getParameter("contacto").toString().length()>0 
                    && request.getParameter("correo").toString().length()>0 && request.getParameter("password").toString().length()>0) 
            {
            String nom = request.getParameter("nombres");
            String cont = request.getParameter("contacto");
            String email = request.getParameter("correo");
            String pass = request.getParameter("password");
            
            miRegisB.setNombre(nom);
            miRegisB.setContact(cont);
            miRegisB.setEmail(email);
            miRegisB.setPass(pass);
            
            miRegisD.insertar(miRegisB);
            
            response.sendRedirect("index.jsp");
            
            
            }else{
            response.sendRedirect("fallido.jsp");
            }
            
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
