
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
                <div class="col-sm-10" style="display: flex; ">
                    <%
                            List lis = new ProductoDAO().getAll();
                            ListIterator list = lis.listIterator();
                            while (list.hasNext()) {
                                ProductoBeans regM = (ProductoBeans) list.next();

                        %>
                    <div class="card" style="width: 400px; height:450px; " >
                        
                        
                        <div class="card-header bg-dark text-white">
                            
                            <h2><%=regM.getNombre()%></h2>
                            
                            
                        </div>
                        <div class="card-body" style="display: flex; justify-content: center;">
                            
                            <img src="ControladorIMG?id=<%=regM.getId()%>" width="200px" height="200px" >
                            
                            
                            
                        </div>
                            <i style="text-align: center;">$<%=regM.getCosto()%></i>
                        <div class="card-footer bg-dark text-white">
                            <label><%=regM.getDescripcion()%></label>
                            <div style="display: flex; justify-content: center;">
                                <a href="ControladorCarrito?accion=Agregar&id=<%=regM.getId()%>" class="btn btn-primary">agregar a carrito</a>
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

