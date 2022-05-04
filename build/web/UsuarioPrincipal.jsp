


<%@page import="beens.registroBeens"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="DAO.registroDAO"%>
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
                    <form action="ControladorU?menu=Usuario" method="POST"> 
                        <div class="form-group d-flex">

                            <div class="col-sm-3">

                                <label>Nombre</label>
                                <input type="text" value="${usuario.getNombre()}" name="Nombres" class="form-control placeholder bg-dark text-white">
                            </div>
                            <div class="col-sm-3">
                                <label>Contacto</label>
                                <input type="text" value="${usuario.getContact()}" name="Contacto" class="form-control placeholder bg-dark text-white">
                            </div>
                            <div class="col-sm-3">
                                <label>Correo</label>
                                <input type="text" value="${usuario.getEmail()}" name="Correo" class="form-control placeholder bg-dark text-white">
                            </div>
                           <div class="col-sm-3">
                                <label>pass</label>
                                <input type="text" value="${usuario.getEmail()}" name="Password" class="form-control placeholder bg-dark text-white">
                            </div>

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
                    <h2>LISTA DE USUARIOS</h2>

                    <table class="table table-bordered table table-dark">

                        <tr>
                            <th>ID</th>
                            <th>Nombres</th>
                            <th>Conctacto</th>
                            <th>Correo</th>
                            <th>Rol</th>
                            <th></th>
                            <th></th>
                        </tr>
                        <%
                            List lis = new registroDAO().getAll();
                            ListIterator list = lis.listIterator();
                            while (list.hasNext()) {
                                registroBeens regM = (registroBeens) list.next();

                        %>
                        <tr>

                            <td><%= regM.getId()%></td>
                            <td><%= regM.getNombre()%></td>
                            <td><%= regM.getContact()%></td>
                            <td><%= regM.getEmail()%></td>
                            <td><%= regM.getRol()%></td>
                            <td><center><a class="btn btn-warning" href="ControladorU?menu=Usuario&accion=carga&id=<%=regM.getId()%>">Actualizar</a></center></td>
                        <td><center><a href="ControladorU?menu=Usuario&accion=eliminar&id=<%=regM.getId()%>" class="btn btn-danger">Eliminar</a></center></td>
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

