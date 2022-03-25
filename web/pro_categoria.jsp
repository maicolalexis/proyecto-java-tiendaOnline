<%-- 
    Document   : usuarios
    Created on : 22/11/2021, 02:38:01 PM
    Author     : SENA-WS-H50-1
--%>




<%@page import="DAO.productosDAO"%>
<%@page import="beens.productosBeens"%>
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
                    <form action="productosAgregar?menu=Categoria" method="POST"> 
                        <div class="form-group d-flex">

                            <div class="col-sm-3">

                                <label>Nombre</label>
                                <input type="text" value="${Categoria.getNombre()}" name="nombre" class="form-control placeholder bg-dark text-white">
                            </div>
                            <!--div class="col-sm-3">
                                <label>Contacto</label>
                                <input type="text" value="$/{usuario.getContact()}" name="contacto" class="form-control">
                            </div>
                            <div class="col-sm-3">
                                <label>Correo</label>
                                <input type="text" value="$/{usuario.getEmail()}" name="correo" class="form-control">
                            </div>
                           <div class="col-sm-3">
                                <label>pass</label>
                                <input type="text" value="$/{usuario.getEmail()}" name="password" class="form-control">
                            </div-->

                        </div>
                        <button type="submit" name="accion" value="insertar"  class="btn btn-danger">
                            <i class="fas fa-user-plus"></i> Guardar
                        </button>
                        <button type="submit" name="accion" value="modificar"  class="btn btn-dark">
                            <i class="fas fa-edit"></i> Modificar
                        </button>
                    </form>
                    <br>
                    <br>
                    <h2>LISTA DE PRODUCTOS</h2>

                    <table class="table table-bordered table table-dark">

                        <tr>
                            <th>ID</th>
                            <th>Nombres</th>
                            <th>Estado</th>
                            
                            <th></th>
                            <th></th>
                        </tr>
                        <%
                            List lis = new productosDAO().getAll();
                            ListIterator list = lis.listIterator();
                            while (list.hasNext()) {
                                productosBeens regM = (productosBeens) list.next();

                        %>
                        <tr>

                            <td><%= regM.getId()%></td>
                            <td><%= regM.getNombre()%></td>
                            
                            
                            <td><%= regM.getEstado()%></td>
                            <td><center><a class="btn btn-warning" href="productosAgregar?menu=Categoria&accion=carga&id=<%=regM.getId()%>">Actualizar</a></center></td>
                        <td><center><a href="productosAgregar?menu=Categoria&accion=eliminar&id=<%=regM.getId()%>" class="btn btn-danger">Eliminar</a></center></td>
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

