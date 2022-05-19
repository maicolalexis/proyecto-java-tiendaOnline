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
    List<ProductoBeans> PB = new ArrayList<>();
    ProductoDAO DAO = new ProductoDAO();
    ProductoBeans Pbeans = new ProductoBeans();
    int IdPro;
    int item;
    int cantidad = 1;
    float totalpagar = 0;
    BeensCarrito car;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acc = request.getParameter("accion");
        PB = DAO.getAll();

        switch (acc) {

            case "Agregar":
                int pos = 0;
                cantidad = 1;
                IdPro = Integer.parseInt(request.getParameter("id"));
                Pbeans = DAO.añadirId(IdPro);
                if (Listacarrito.size() > 0) {
                    for (int i = 0; i < Listacarrito.size(); i++) {

                        if (IdPro == Listacarrito.get(i).getId()) {
                            pos = i;
                        }

                    }
                    if (IdPro == Listacarrito.get(pos).getId()) {
                        cantidad = Listacarrito.get(pos).getCantidad() + cantidad;
                        float subtotal = Listacarrito.get(pos).getCosto() * cantidad;
                        Listacarrito.get(pos).setCantidad(cantidad);
                        Listacarrito.get(pos).setSubTotal(subtotal);

                    } else {
                        item = item + 1;
                        car = new BeensCarrito();
                        car.setItem(item);

                        car.setNombres(Pbeans.getNombre());
                        car.setDescripcion(Pbeans.getDescripcion());
                        car.setId(Pbeans.getId());
                        car.setCosto(Pbeans.getCosto());
                        car.setCantidad(cantidad);
                        car.setSubTotal(cantidad * Pbeans.getCosto());
                        Listacarrito.add(car);
                    }

                } else {
                    item = item + 1;
                    car = new BeensCarrito();
                    car.setItem(item);

                    car.setNombres(Pbeans.getNombre());
                    car.setDescripcion(Pbeans.getDescripcion());
                    car.setId(Pbeans.getId());
                    car.setCosto(Pbeans.getCosto());
                    car.setCantidad(cantidad);
                    car.setSubTotal(cantidad * Pbeans.getCosto());
                    Listacarrito.add(car);
                }

                request.setAttribute("contador", Listacarrito.size());
                request.getRequestDispatcher("ControladorCarrito?accion=index").forward(request, response);
                break;
            case "Carrito":
                totalpagar = 0;
                request.setAttribute("carrito", Listacarrito);
                for (int i = 0; i < Listacarrito.size(); i++) {
                    totalpagar = totalpagar + Listacarrito.get(i).getSubTotal();
                }
                request.setAttribute("totalPagar", totalpagar);
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;
            case "Comprar":
                IdPro = Integer.parseInt(request.getParameter("id"));
                Pbeans = DAO.añadirId(IdPro);
                item = item + 1;
                car = new BeensCarrito();
                car.setItem(item);

                car.setNombres(Pbeans.getNombre());
                car.setDescripcion(Pbeans.getDescripcion());
                car.setId(Pbeans.getId());
                car.setCosto(Pbeans.getCosto());
                car.setCantidad(cantidad);
                car.setSubTotal(cantidad * Pbeans.getCosto());
                Listacarrito.add(car);
                for (int i = 0; i < Listacarrito.size(); i++) {
                    totalpagar = totalpagar + Listacarrito.get(i).getSubTotal();
                }
                request.setAttribute("carrito", Listacarrito);
                request.setAttribute("contador", Listacarrito.size());
                request.setAttribute("totalPagar", totalpagar);
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;
            case "Delete":
                int id = Integer.parseInt(request.getParameter("idp"));
                for (int i = 0; i < Listacarrito.size(); i++) {
                    if (Listacarrito.get(i).getId() == id) {
                        Listacarrito.remove(i);

                    }

                }
                break;
            case "ActualizarCantidad":
                int idp = Integer.parseInt(request.getParameter("idp"));
                int cant = Integer.parseInt(request.getParameter("cantidad"));
                for (int i = 0; i < Listacarrito.size(); i++) {
                    if(Listacarrito.get(i).getId() == idp){
                        Listacarrito.get(i).setCantidad(cant);
                        float st = Listacarrito.get(i).getCosto()*cant;
                        Listacarrito.get(i).setSubTotal(st);
                        
                    }
                    
                }
            default:
                request.getRequestDispatcher("index.jsp").forward(request, response);

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
