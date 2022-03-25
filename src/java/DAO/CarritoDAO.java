/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexionBD.ConexBD;
import beens.productosBeens;//categoria
import beens.ProductoBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author varga
 */
public class CarritoDAO {
    ConexBD con = new ConexBD();
    Connection cnx;
    PreparedStatement  ps;
    ResultSet rs;
    int resultado;
    
    public int agregar(ProductoBeans Pr, productosBeens Cr){
        
        String SQL = "insert into carrito(id_categoria,id_producto)";
        
        try {
            cnx = con.ConexBD();
            ps= cnx.prepareStatement(SQL);
            
            ps.setString(1, SQL);
        } catch (Exception e) {
        }
        return resultado;
    
    
    }
}
