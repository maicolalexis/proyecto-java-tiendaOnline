
<%@page import="beens.ProductoBeans"%>
<%@page import="java.util.ListIterator"%>
<%@page import="DAO.ProductoDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        
        <div class="container mt-5">
            <div class="row">
                <div class="col-sm-10" style="display: flex">
                    <%
                            List lis = new ProductoDAO().getAll();
                            ListIterator list = lis.listIterator();
                            while (list.hasNext()) {
                                ProductoBeans regM = (ProductoBeans) list.next();

                        %>
                    <div class="card" >
                        
                        
                        <div class="card-header bg-dark text-white">
                            
                            <h2><%=regM.getNombre()%></h2>
                            
                            
                        </div>
                        <div class="card-body">
                            
                            <img src="ControladorIMG?id=<%=regM.getId()%>" style="width: 200px; height: 200px;">
                            
                            
                            
                        </div>
                            <i style="text-align: center;">$<%=regM.getCosto()%></i>
                        <div class="card-footer bg-dark text-white">
                            <label><%=regM.getDescripcion()%></label>
                            <div>
                                <a href="ControladorCarrito?accion=Agregar" class="btn btn-primary">agregar a carrito</a>
                                <a href="" class="btn btn-danger">comprar</a>
                            </div>
                            
                        </div>
                        
                    </div>
                        <%
                            }
                        %> 
                </div>
            </div>
        </div>
               
                
        
    </body>
</html>

