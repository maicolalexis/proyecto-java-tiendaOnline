/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.ProductoDAO;
import beens.BeensCarrito;
import beens.ProductoBeans;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author varga
 */
@WebServlet(name = "ControladorCarrito", urlPatterns = {"/ControladorCarrito"})
public class ControladorCarrito extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    List<BeensCarrito> Listacarrito = new ArrayList<>();
    ProductoDAO DAO = new ProductoDAO();
    int IdPro;
    int item;
    int cantidad=1;
    double totalpagar=0.0;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acc = request.getParameter("accion");
        String Men = request.getParameter("menu");
        if(acc.equals("carrito")){
            request.getRequestDispatcher("Produc_Usu.jsp").forward(request,response);
        }
        if(acc.equals("Carr")){
            switch(Men){
            
                case "mostrar":
                request.getRequestDispatcher("Produc_Usu.jsp").forward(request,response); 
                break;
                case "Agregar":
                    IdPro = Integer.parseInt(request.getParameter("id"));
                    ProductoBeans P = DAO.añadirId(IdPro);
                    item=item+1;
                    BeensCarrito car = new BeensCarrito();
                    car.setItem(item);
                    car.setIdProducto(P.getId());
                    car.setNombre(P.getNombre());
                    car.setDescrip(P.getDescripcion());
                    car.setPrecioFinal(P.getCosto());
                    car.setCantidad(cantidad);
                    car.setSubToatal(cantidad*P.getCosto());
                     Listacarrito.add(car);
                    request.setAttribute("contador", Listacarrito.size());
                    request.getRequestDispatcher("ControladorCarrito?accion=carrito").forward(request,response); 
                break;
                case "Carrito":
                    totalpagar=0.0;
                    request.setAttribute("car",Listacarrito );
                    request.getRequestDispatcher("Carrito.jsp").forward(request,response);
                break;
                case "pagar":
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
