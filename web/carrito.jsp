<%-- 
    Document   : carrito
    Created on : 3/05/2022, 05:00:54 PM
    Author     : SENA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="commons/cdn.jsp"%>
    </head>
    <body>
        <%@include file="commons/cabeceraCarrito.jsp" %>
        <div class="container mt-4">
            
            <div class="row">
                
                <div class="col-sm-8">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Item<th>
                                <th>Nombre</th>
                                <th>Descripcion</th>
                                <th>precio</th>
                                <th>cantidad<th>
                                <th>SubTotal<th>
                                <th>Accion</th>
                                
                            </tr>
                            
                        </thead>
                        <tbody>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                
                                
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header">
                            <h3>generar compra</h3>
                        </div>
                        <div class="card-body">
                            <label>Subtotal:</label>
                            <input type="text" readonly="" class="form-control">
                            <label>Descuento:</label>
                            <input type="text" readonly="" class="form-control">
                            <label>Total Pagar:</label>
                            <input type="text" readonly="" class="form-control">
                        </div>
                        <div class="card-footer">
                            <a href="" class="btn btn-info btn-block">realizar pago</a>
                            <a href="" class="btn btn-danger btn-block">generar compra</a>
                            
                            
                        </div>
                    </div>
            </div>
        </div>
    </body>
</html>
