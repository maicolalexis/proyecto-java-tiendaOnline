/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexionBD.ConexBD;
import beens.ProductoBeans;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

import java.io.InputStream;
import java.io.OutputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
//TODO ESTA COMENTADO EN LA CLASE DE REGISTRODAO

public class ProductoDAO {
    ConexBD con = new ConexBD();
    Connection cnx;
    PreparedStatement ps;
    ResultSet rs;
    int resultado;
    
 
    public int insertar(ProductoBeans r) {
       
        String sql = "insert into producto(nombres, costo, imagen, descripcion, cantidad, id_categoria)"
                + "values(?,?,?,?,?)";
        
        try {
            
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);

            ps.setString(1, r.getNombre());
            ps.setFloat(2, r.getCosto());
            
            ps.setString(4, r.getDescripcion());
            ps.setInt(5, r.getCantidad());
            ps.setInt(6, r.getCategoria());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return resultado;
    } 
    public List getAll() {
        String sql = "select * from producto";
        List<ProductoBeans> lista = new ArrayList<>();

        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            
            
            while (rs.next()) {
                
                ProductoBeans regM = new ProductoBeans();
                
                regM.setId(rs.getInt("id"));
                regM.setNombre(rs.getString("nombres"));
                regM.setImagen(rs.getBinaryStream("imagen"));
                regM.setCosto(rs.getFloat("costo"));
                regM.setDescripcion(rs.getString("descripcion"));
                regM.setCantidad(rs.getInt("cantidad"));
                regM.setEstado(rs.getInt("estado"));
                regM.setCategoria(rs.getInt("id_categoria"));
                
                lista.add(regM);
            }
                    
                    

   
        } catch (Exception e) {
            
        }

        return lista;
    }
    public void listarImg(int id, HttpServletResponse response){
        String sql ="select * from producto where id=" +id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        
            try {
                outputStream=response.getOutputStream();
                cnx = con.ConexBD();
                ps = cnx.prepareStatement(sql);
                rs = ps.executeQuery();
                if(rs.next()){
                    inputStream = rs.getBinaryStream("imagen");
                }
                bufferedInputStream= new BufferedInputStream(inputStream);
                bufferedOutputStream= new BufferedOutputStream(outputStream);
                int i = 0;
                while ((i = bufferedInputStream.read())!=-1) {                    
                    bufferedOutputStream.write(i);
                }
            } catch (Exception ex) {
                
            }    
    }
    public boolean eliminar(int id) {
        String sql = "delete from producto where id=" + id;

        try {
            cnx = con.ConexBD();
            Statement st = cnx.createStatement();
            int estado = st.executeUpdate(sql);
            if (estado > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     public ProductoBeans cargar(int id) {
        ProductoBeans miRegisB = new ProductoBeans();
        String sql = "select * from producto where id=" + id;
        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                miRegisB.setNombre(rs.getString(2));
                miRegisB.setCosto(rs.getFloat(3));
                miRegisB.setDescripcion(rs.getString(4));
                miRegisB.setCantidad(rs.getInt(5));
                miRegisB.setCategoria(rs.getInt(7));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            Logger.getLogger(ProductoBeans.class.getName()).log(Level.SEVERE, null, ex);
        }
        return miRegisB;
    }
   

  public int modificar(ProductoBeans r) {

        String sql = "UPDATE producto SET nombres=?, costo=?, descripcion=?, cantidad=?, id_categoria=?" + " WHERE id=?";
        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);

            ps.setString(1, r.getNombre());
            
            ps.setFloat(2, r.getCosto());
            ps.setString(3, r.getDescripcion());
            ps.setInt(4, r.getCantidad());
            ps.setInt(5, r.getCategoria());
            ps.setInt(6, r.getId());

            ps.executeUpdate();

        } catch (Exception e) {
        }
        return resultado;
    } 
    
    public ProductoBeans añadirId(int id){
        String SQL ="select * from productos where id="+id;
        ProductoBeans BP = new ProductoBeans();
        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                BP.setId(rs.getInt("id"));
                BP.setNombre(rs.getString("nombres"));
                BP.setCosto(rs.getFloat("costo"));
                BP.setDescripcion(rs.getString("descripcion"));
                BP.setCantidad(rs.getInt("cantidad"));
                BP.setEstado(rs.getInt("estado"));
                BP.setCategoria(rs.getInt("id_categoria"));
            }
        } catch (Exception e) {
        }
        return BP;
    }
}

