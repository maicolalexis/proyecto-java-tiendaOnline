/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author maico
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//este es un "CategoriasDAO"
package DAO;

import ConexionBD.ConexBD;
import beens.productosBeens;//categoria

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
//TODO ESTA COMENTADO EN LA CLASE DE REGISTRODAO

public class categorias {
    ConexBD con = new ConexBD();
    Connection cnx;
    PreparedStatement ps;
    ResultSet rs;
    int resultado;
    
 
    public int insertar(productosBeens r) {
       
        String sql = "insert into categoria_productos(nombre_cat)"
                + "values(?)";
        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);

            ps.setString(1, r.getNombre());

            ps.executeUpdate();

        } catch (Exception e) {
        }
        return resultado;
    } 
    public List getAll() {
        String sql = "select * from categoria_productos";
        List<productosBeens> lista = new ArrayList<>();

        try {

            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                productosBeens regM = new productosBeens();
                regM.setId(rs.getInt("id_categoria"));
                regM.setNombre(rs.getString("nombre_cat"));
                
                regM.setEstado(rs.getInt("estado"));
               

                lista.add(regM);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            Logger.getLogger(categorias.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
    public boolean eliminar(int id) {
        String sql = "delete from categoria_productos where id_categoria=" + id;

        try {
            cnx = con.ConexBD();
            Statement st = cnx.createStatement();
            int estado = st.executeUpdate(sql);
            if (estado > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            Logger.getLogger(categorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     public productosBeens cargar(int id) {
        productosBeens miRegisB = new productosBeens();
        String sql = "select * from categoria_productos where id_categoria=" + id;
        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                miRegisB.setNombre(rs.getString(2));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            Logger.getLogger(productosBeens.class.getName()).log(Level.SEVERE, null, ex);
        }
        return miRegisB;
    }
   

   public int modificar(productosBeens r) {

        String sql = "UPDATE categoria_productos SET nombre_cat=?" + " WHERE id_categoria=?";
        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);

            ps.setString(1, r.getNombre());
           
            
            ps.setInt(2, r.getId());

            ps.executeUpdate();

        } catch (Exception e) {
        }
        return resultado;
    } 

}
