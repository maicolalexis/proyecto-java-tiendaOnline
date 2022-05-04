


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
        
    </head>
    <body>
        <%@include file="commons/Cabecera_1.jsp"%>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 sidebar-col">
                    <%@include file="commons2/SideBar.jsp"%>  
                </div>

                <div class="col-sm-9 main-col">
                    <form action="ControladorUsu?menu=Usuario" method="POST"> 
                        <div class="form-group d-flex">

                            <div class="col-sm-3">

                                <label>Nombre</label>
                                <input type="text" value="${Usuario.getNombre()}" name="Nombres" class="form-control placeholder bg-dark text-white">
                            </div>
                            <div class="col-sm-3">
                                <label>Contacto</label>
                                <input type="text" value="${Usuario.getContact()}" name="Contacto" class="form-control placeholder bg-dark text-white">
                            </div>
                            <div class="col-sm-3">
                                <label>Correo</label>
                                <input type="text" value="${Usuario.getEmail()}" name="Correo" class="form-control placeholder bg-dark text-white">
                            </div>
                           <div class="col-sm-3">
                                <label>pass</label>
                                <input type="text" value="${Usuario.getEmail()}" name="Password" class="form-control placeholder bg-dark text-white">
                            </div>

                        </div>
                        
                        <button type="submit" name="accion" value="modificar"  class="btn btn-dark">
                            <i class="fas fa-edit"></i> Modificar
                        </button>
                    </form>
                    <br>
                    <br>
                    <h2>INFO. DE USUARIO</h2>

                    <table class="table table-bordered table table-dark">

                        <tr>
                            <th>ID</th>
                            <th>Nombres</th>
                            <th>Conctacto</th>
                            <th>Correo</th>
                            <th>Rol</th>
                            <th></th>
                        </tr>
                        <%
                                registroBeens regM = new registroBeens();

                        %>
                        <tr>
                            <td>${Usuario.getId()}</td>
                            <td>${Usuario.getNombre()}</td>
                            <td>${Usuario.getContact()}</td>
                            <td>${Usuario.getEmail()}</td>
                            <td>${Usuario.getRol()}</td>
                            
                            <td><center><a class="btn btn-warning" href="ControladorUsu?menu=Usuario&accion=cargar&id=${Usuario.getId()}">Actualizar</a></center></td>
                        </tr>
                    </table>

                </div>
            </div>    
        </div>
    </body>
</html>

