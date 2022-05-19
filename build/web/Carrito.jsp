<%-- 
    Document   : carrito
    Created on : 4/05/2022, 01:45:50 PM
    Author     : User1
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                <th>Item</th>
                                <th>Nombre</th>
                                <th>Descripcion</th>
                                <th>precio</th>
                                <th>cantidad</th>
                                <th>SubTotal</th>
                                <th>Accion</th>

                            </tr>

                        </thead>
                        <tbody>
                            <c:forEach var="car" items="${carrito}">


                                <tr>
                                    <td>${car.getItem()}</td>
                                    <td>${car.getNombres()}</td>
                                    <td>${car.getDescripcion()}
                                        <img src="ControladorIMG?id=${car.getId()}" width="100" height="100"> 
                                    </td>

                                    <td>${car.getCosto()}</td>
                                    <td>
                                        <input type="hidden" id="idpro" value="${car.getId()}">
                                        <input type="number" id="cantidad" value="${car.getCantidad()}" class="form-control text-center" min="1"> </td>
                                    <td>${car.getSubTotal()}</td>   
                                    <td>
                                        <input type="hidden" id="idp" value="${car.getId()}">
                                        <a href="#" class="btn btn-danger" id="btnDelete">eliminar</a>

                                    </td>




                                </tr>
                            </c:forEach>
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
                            <input type="text" value="$.${totalPagar}0" readonly="" class="form-control">
                            <label>Descuento:</label>
                            <input type="text" value="0.00" readonly="" class="form-control">
                            <label>Total Pagar:</label>
                            <input type="text" value="$.${totalPagar}0" readonly="" class="form-control">
                        </div>
                        <div class="card-footer">
                            <a href="" class="btn btn-info btn-block">realizar pago</a>
                            <a href="" class="btn btn-danger btn-block">generar compra</a>


                        </div>
                    </div>
                </div>
            </div>
            <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
            <script src="js/funciones.js" type="text/javascript"></script>
            
            
    </body>
</html>
