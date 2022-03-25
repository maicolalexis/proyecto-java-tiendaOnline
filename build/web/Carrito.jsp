<%-- 
    Document   : Carrito
    Created on : 13/01/2022, 09:35:10 PM
    Author     : varga
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <%@include file="commons/CDN(4).jsp"%>
        <link rel="stylesheet" href="css/Global_U.jsp" type="text/css">
    </head>
    <body>
        <%@include file="commons/Co_Usu/Cabecera_U.jsp"%>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 sidebar-col">
                    <%@include file="commons/Co_Usu/SideBar_U.jsp" %>
                </div>
                <table border="1">
                    <thead>
                        <tr>
                            <th></th>
                            <th>Costo</th>
                            <th>Descripcion</th>
                        </tr>                       
                    </thead>
                    <tbody>
                        <tr>
                            <c:forEach var="carrito" items="${car}">
                            <td>${carrito.getNombre() }</td>
                            <td>${carrito.getPrecioFinal()}</td>
                            <td>${carrito.getDescrip()}</td>
                            </c:forEach>
                        </tr>
                    </tbody>
                </table>
            </div> 
        </div> 
    </body>
</html>

