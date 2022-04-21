<%-- 
    Document   : usuarios
    Created on : 22/11/2021, 02:38:01 PM
    Author     : SENA-WS-H50-1
--%>




<%@page import="beens.productosBeens"%>
<%@page import="DAO.categorias"%>
<%@page import="beens.ProductoBeans"%>
<%@page import="DAO.ProductoDAO"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
        <%@include file="../commons/cdn.jsp"%>
        <link rel="stylesheet" href="../commons/Global.css" type="text/css">
    </head>
    <body>
        <%@include file="../commons/Cabecera_1.jsp"%>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 sidebar-col">
                    <%@include file="../commons2/SideBar.jsp"%>
                </div>

                <div class="col-sm-9 main-col">
                    <br>
                    <br>
                    <h2>LISTA DE PRODUCTOS</h2>

                    <table class="table table-bordered table table-dark">

                        <tr>
                            <th>ID</th>
                            <th>Nombres</th>
                            <th>Costo</th>
                            <th>Descripcion</th>
                            <th>cantidad</th>
                            <th>Estado</th>
                            <th>Categoria</th>
                        </tr>
                        <%
                            List lis = new ProductoDAO().getAll();
                            ListIterator list = lis.listIterator();
                            while (list.hasNext()) {
                                ProductoBeans regM = (ProductoBeans) list.next();

                        %>
                        <tr>

                            <td><%= regM.getId()%></td>
                            <td><%= regM.getNombre()%></td>
                            <td><%= regM.getCosto()%></td>
                            <td><%= regM.getDescripcion()%></td>
                            <td><%= regM.getCantidad()%></td>
                            <td><%= regM.getEstado()%></td>
                            <td><%= regM.getCategoria()%></td>
                        </tr>
                        <div class="card-footer">
                            <%= regM.getDescripcion() %>
                            <div>
                                <center>
                                    <a  href="ControladorCarrito?accion=Carr&menu=Agregar&id=<%= regM.getId()%>"  class="btn btn-primary">
                                        <i class="fas fa-user-plus"></i> Carrito
                                    </a>
                                    <a  href="ControladorCarrito?accion=Carr&menu=Agregar"  class="btn btn-success">
                                        <i class="fas fa-user-plus"></i> Comprar
                                    </a>
                                </center>
                            </div>
                        </div>
                        <%
                            }
                        %>
                    </table>

                </div>
            </div>    
        </div>
    </body>
</html>