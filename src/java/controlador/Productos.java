/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.ProductoDAO;

import beens.ProductoBeans;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig

/**
 *
 * @author SENA-WS-H50-1
 */
public class Productos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ProductoBeans miRegisB = new ProductoBeans();
    ProductoDAO miRegisD = new ProductoDAO();
    int idUsr;
    List<ProductoBeans> productos = new ArrayList<>();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String op = request.getParameter("menu");
        String opc = request.getParameter("accion");

        if (op.equals("Ppal")) {
            request.getRequestDispatcher("admin/productos.jsp").forward(request, response);

        }
        if (op.equals("Producto")) {
            switch (opc) {

                case "mostrar":
                    request.setAttribute("ProductosBeans", productos);
                    request.getRequestDispatcher("productos.jsp").forward(request, response);
                    break;

                case "insertar":

                    String nom = request.getParameter("nombre");
                    Part part = request.getPart("imagen");
                    InputStream inputStream=part.getInputStream();
                    float cos = Float.parseFloat(request.getParameter("costo"));
                    String des = request.getParameter("descripcion");
                    int can = Integer.parseInt(request.getParameter("cantidad"));
                    int pro = Integer.parseInt(request.getParameter("categoria"));
                    
                    
                    miRegisB.setNombre(nom);
                    miRegisB.setImagen(inputStream);
                    miRegisB.setCosto(cos);
                    miRegisB.setDescripcion(des);
                    miRegisB.setCantidad(can);
                    miRegisB.setCategoria(pro);

                    miRegisD.insertar(miRegisB);

                    request.getRequestDispatcher("productos.jsp").forward(request, response);
                    break;
               

                case "eliminar":
                    idUsr = Integer.parseInt(request.getParameter("id"));

                    miRegisD.eliminar(idUsr);
                    request.getRequestDispatcher("productos.jsp").forward(request, response);
                    break;

                case "carga":
                    idUsr = Integer.parseInt(request.getParameter("id"));
                    ProductoBeans miBeans = miRegisD.cargar(idUsr);
                    request.setAttribute("Producto", miBeans);
                    request.getRequestDispatcher("productos.jsp").forward(request, response);
                    break;
                case "modificar":

                    String nom2 = request.getParameter("nombre");
                    Part part2 = request.getPart("imagen");
                    InputStream inputStream2=part2.getInputStream();
                    float cos2 = Float.parseFloat(request.getParameter("costo"));
                    String des2 = request.getParameter("descripcion");
                    int can2 = Integer.parseInt(request.getParameter("cantidad"));
                    int pro2 = Integer.parseInt(request.getParameter("categoria"));
                    
                    
                    miRegisB.setNombre(nom2);
                    miRegisB.setImagen(inputStream2);
                    miRegisB.setCosto(cos2);
                    miRegisB.setDescripcion(des2);
                    miRegisB.setCantidad(can2);
                    miRegisB.setCategoria(pro2);
                    
                    miRegisB.setId(idUsr);
                    miRegisD.modificar(miRegisB);

                    request.getRequestDispatcher("productos.jsp").forward(request, response);
                    break;
                
                    
                    
            }
        }
    }

    
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