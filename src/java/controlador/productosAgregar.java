/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.productosDAO;
import beens.productosBeens;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SENA-WS-H50-1
 */
public class productosAgregar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    productosBeens miRegisB = new productosBeens();
    productosDAO miRegisD = new productosDAO();
    int idUsr;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("menu");
        String opc = request.getParameter("accion");

        if (op.equals("Ppal")) {
            request.getRequestDispatcher("pro_categoria.jsp").forward(request, response);

        }
        if (op.equals("Categoria")) {
            switch (opc) {

                case "mostrar":
                    request.getRequestDispatcher("pro_categoria.jsp").forward(request, response);
                    break;

                case "insertar":

                    String nom = request.getParameter("nombre");
                    

                    miRegisB.setNombre(nom);
                    

                    miRegisD.insertar(miRegisB);

                    request.getRequestDispatcher("pro_categoria.jsp").forward(request, response);
                    break;
                default:
                    throw new AssertionError();

                case "eliminar":
                    idUsr = Integer.parseInt(request.getParameter("id"));

                    miRegisD.eliminar(idUsr);
                    request.getRequestDispatcher("pro_categoria.jsp").forward(request, response);
                    break;

                case "carga":
                    idUsr = Integer.parseInt(request.getParameter("id"));
                    productosBeens miBeans = miRegisD.cargar(idUsr);
                    request.setAttribute("Categoria", miBeans);
                    request.getRequestDispatcher("pro_categoria.jsp").forward(request, response);
                    break;
                case "modificar":

                    String nom2 = request.getParameter("nombre");
                    
                    miRegisB.setNombre(nom2);
                    
                    miRegisB.setId(idUsr);
                    miRegisD.modificar(miRegisB);

                    request.getRequestDispatcher("pro_categoria.jsp").forward(request, response);
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
