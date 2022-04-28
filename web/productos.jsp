<%-- 
    Document   : usuarios
    Created on : 22/11/2021, 02:38:01 PM
    Author     : SENA-WS-H50-1
--%>




<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <%@include file="commons/cdn.jsp"%>
        <link rel="stylesheet" href="commons/Global.css" type="text/css">
    </head>
    <body>
        <%@include file="commons/Cabecera_1.jsp"%>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 sidebar-col">
                    <%@include file="commons/SideBar.jsp"%>  
                </div>

                <div class="col-sm-9 main-col">
                    <form action="Productos?menu=Producto" method="POST" enctype="multipart/form-data"> 
                        <div class="form-group d-flex " style="padding-top: 10px;">
                            
                            

                            <div class="col-sm-2">

                                <label>Nombre</label>
                                <input type="text" value="${Producto.getNombre()}" name="nombre" class="form-control placeholder bg-dark text-white">
                            </div>
                            
                            <div class="col-sm-2">
                             

                                <label>Costo</label>
                                <input type="text" value="${Producto.getCosto()}" name="costo" class="form-control placeholder bg-dark text-white">
                            </div>
                            
                            <div class="col-sm-4" >

                                <label>descripcion</label>
                                <input type="text" value="${Producto.getDescripcion()}" name="descripcion" class="form-control placeholder bg-dark text-white" style="width: 300px; height:38px;">
                            </div>
                            
                            <div class="col-sm-2" >

                                <label>Cantidad</label>
                                <input type="text" value="${Producto.getCantidad()}" name="cantidad" class="form-control placeholder bg-dark text-white">
                            </div>
                            <div class="col-sm-2">
                                <label>Categoria</label>
                                <select name="categoria" class="form-control placeholder bg-dark text-white">
                                    <%
                                        List lisP = new categorias().getAll();
                                        ListIterator listaI = lisP.listIterator();
                                        while (listaI.hasNext())
                                        {
                                            productosBeens liC = (productosBeens) listaI.next();
                                        
                                        %>
                                        
                                        <option value="<%=liC.getId()%>"><%=liC.getNombre()%>
                                        
                                        </option>
                                        
                                        <%
                                            }
                                        %>
                                </select>                                
                            </div>
                            
                                <div class="col-sm-2" style="margin-top: 100px; margin-left: -70%;">

                                <label>imagen</label>
                                <input type="file" name="imagen" class="bg-dark text-white" >
                            </div>
                            
                            
                            
                           

                        </div>
                            <button type="submit" name="accion" value="insertar"  class="btn btn-danger" >
                            <i class="fas fa-user-plus"></i> Guardar
                        </button>
                        <button type="submit" name="accion" value="modificar"  class="btn btn-dark">
                            <i class="fas fa-edit"></i> Modificar
                        </button>
                    </form>
                    <br>
                    <br>
                    <h2>LISTA DE PRODUCTOS</h2>
                    <%--div class="container mt-4">
                        <div class="row">
                            <c:forEach var="p" items="${producto}">
                            <div class="col-sm-4">
                                <div class="card">
                                    <div class="card-header">
                                        <lavel>${p.getNombres}</lavel>
                                    </div>
                                    <div class="card-body">
                                        <i>$54656</i>
                                        <img src="" width="200" height="180">
                                        
                                    </div>
                                    <div class="card-footer text-center"></div>
                                    <label>descripcion</label>
                                    <div>
                                        <a href="#" class="btn btn-outline-info">Agregar a carrito</a>
                                        <a href="#" class="btn btn-danger">comprar</a>
                                    </div>
                                    
                                </div>
                            </div>
                            </c:forEach>
                        </div>
                    </div--%>

                    <table class="table table-bordered table table-dark">

                        <tr>
                            <th>ID</th>
                            <th>Nombres</th>
                            <th>image</th>
                            <th>Costo</th>
                            <th>Descripcion</th>
                            <th>cantidad</th>
                            <th>Estado</th>
                            <th>Categoria</th>
                            <th></th>
                            <th></th>
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
                            <td><img src="ControladorIMG?id=<%=regM.getId()%>" width="100" height="100" style="object-fit: contain;"></td>
                            <td><%= regM.getCosto()%></td>
                            <td><%= regM.getDescripcion()%></td>
                            <td><%= regM.getCantidad()%></td>
                            <td><%= regM.getEstado()%></td>
                            <td><%= regM.getCategoria()%></td>
                            
                            <td><center><a class="btn btn-warning" href="Productos?menu=Producto&accion=carga&id=<%=regM.getId()%>">Actualizar</a></center></td>
                        <td><center><a href="Productos?menu=Producto&accion=eliminar&id=<%=regM.getId()%>" class="btn btn-danger">Eliminar</a></center></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>

                </div>
            </div>    
        </div>
    </body>
</html>