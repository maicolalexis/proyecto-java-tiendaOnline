
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
        
        <div class="container mt-5 ">
            <div class="row ">
                <%
                            List lis = new ProductoDAO().getAll();
                            ListIterator list = lis.listIterator();
                            while (list.hasNext()) {
                                ProductoBeans regM = (ProductoBeans) list.next();
                                

                        %>
                        <div class="col-md-4 mt-5" id="card" style="padding: -0;">
                    
                    
                        
                        
                            <div class="card text-center bg-dark text-white" style="width: 18rem;">
                            
                            <h2><%=regM.getNombre()%></h2>
                            
                            
                        
                        <div class="card-body bg-white">
                            
                            <img src="ControladorIMG?id=<%=regM.getId()%>" width="220px" height="220px" >
                            
                            
                            
                        </div>
                            <i class="bg-white text-dark" style="text-align: center;">$<%=regM.getCosto()%></i>
                        <div class="card bg-dark text-white">
                            <label><%=regM.getDescripcion()%></label>
                            <div>
                                <a href="ControladorCarrito?accion=Agregar&id=<%=regM.getId()%>" class="btn btn-primary">agregar a carrito</a>
                                <a href="ControladorCarrito?accion=Comprar&id=<%=regM.getId()%>" class="btn btn-danger">comprar</a>
                            </div>
                        </div>
                            
                        </div>
                        
                    
                        
                </div>
                 <%
                    }
                %>           
            </div>
                
        </div>
               
                
        
    </body>
</html>

