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
public class ControladorU extends HttpServlet {

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
    registroDAO miRegisD = new registroDAO();
    int idUsr;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //esto es en el jsp menu y accion
        String op = request.getParameter("menu");
        String opc = request.getParameter("accion");
        
        if (op.equals("Ppal")) {
            request.getRequestDispatcher("admin/administrador.jsp").forward(request, response);

        }
        if (op.equals("Usuario")) {
            switch (opc) {

                case "mostrar":
                    request.getRequestDispatcher("admin/UsuarioPrincipal.jsp").forward(request, response);
                    break;

                case "insertar":

                    String nom = request.getParameter("Nombres");
                    String cont = request.getParameter("Contacto");
                    String email = request.getParameter("Correo");
                    String pass = request.getParameter("Password");

                    miRegisB.setNombre(nom);
                    miRegisB.setContact(cont);
                    miRegisB.setEmail(email);
                    miRegisB.setPass(pass);

                    miRegisD.insertar(miRegisB);

                    request.getRequestDispatcher("admin/UsuarioPrincipal.jsp").forward(request, response);
                    break;
                default:
                    throw new AssertionError();

                case "eliminar":
                    idUsr = Integer.parseInt(request.getParameter("id"));

                    miRegisD.eliminar(idUsr);
                    request.getRequestDispatcher("admin/UsuarioPrincipal.jsp").forward(request, response);
                    break;

                case "carga":
                    idUsr = Integer.parseInt(request.getParameter("id"));
                    registroBeens miBeans = miRegisD.cargar(idUsr);
                    request.setAttribute("usuario", miBeans);
                    request.getRequestDispatcher("admin/UsuarioPrincipal.jsp").forward(request, response);
                    break;
                    
                case "modificar":
                    String nom2 = request.getParameter("Nombres");
                    String cont2 = request.getParameter("Contacto");
                    String email2 = request.getParameter("Correo");
                    String pass2 = request.getParameter("Password");
                    miRegisB.setNombre(nom2);
                    miRegisB.setContact(cont2);
                    miRegisB.setEmail(email2);
                    miRegisB.setPass(pass2);

                    miRegisB.setId(idUsr);
                    miRegisD.modificar(miRegisB);

                    request.getRequestDispatcher("admin/UsuarioPrincipal.jsp").forward(request, response);
                    break;
        
                    
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
