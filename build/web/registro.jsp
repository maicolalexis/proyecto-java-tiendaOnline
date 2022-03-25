<%-- 
    Document   : registro
    Created on : 18/11/2021, 03:11:10 PM
    Author     : SENA-WS-H50-1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title
           <%@include file="commons/cdn.jsp"%>
          <link rel="stylesheet" href="css/global.css" type="text/css">
    </head>
    <body>
        <%@include file="commons/cabecera.jsp"%>
        <br>
         <div class="container registro">
             <h1>Formulario de registro</h1>
             <form method="POST" action="RegistroControl?accion=insertar">
            <div class="row">
            <div class="col-sm-6">
            <label>Nombre</label>
            <input class="form-control placeholder bg-dark text-white" type="text" placeholder="Ingrese nombre" name="nombres">
            </div>
            <div class="col-sm-6">
            <label>Contacto</label>
            <input  class="form-control placeholder bg-dark text-white" type="text" placeholder="Ingrese el contacto" name="contacto">
            </div>
            </div>
            <div class="row">
            <div class="col-sm-6">
            <label>Correo</label>
            <input class="form-control placeholder bg-dark text-white" type="text" placeholder="Ingrese Correo" name="correo">
            </div>
            <div class="col-sm-6">
            <label>Password</label>
            <input  class="form-control placeholder bg-dark text-white" type="password" placeholder="Ingrese contraseña" name="password">
            </div>
            </div>
                 <br>
            <div class="row">
                <button type="submit" name="accion" value="insertar" class="btn btn-outline-info">Enviar</button>&nbsp;<a href="logueo.jsp" class="btn btn-outline-info">Login</a></div>
                    

            </div>
          
            </form>
             </div>
        
    </body>
</html>
