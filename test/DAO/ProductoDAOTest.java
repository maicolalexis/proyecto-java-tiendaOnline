/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beens.ProductoBeans;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maico
 */
public class ProductoDAOTest {
    
    public ProductoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertar method, of class ProductoDAO.
     */
    
    public void testInsertar() {
        System.out.println("insertar");
        ProductoBeans r = new ProductoBeans();
        r.setId(13);
        r.setNombre("sakdsakdskad");
        r.setImagen(null);
        r.setCosto(1000);
        r.setDescripcion("sapdkas");
        r.setCantidad(2);
        r.setCategoria(1);
        ProductoDAO instance = new ProductoDAO();
        int expResult = 0;
        int result = instance.insertar(r);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getAll method, of class ProductoDAO.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        ProductoBeans r = new ProductoBeans();
        ProductoDAO instance = new ProductoDAO();
        
        List result = instance.getAll();
        
        assertNotEquals(null, result);
        
        
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of listarImg method, of class ProductoDAO.
     */
    @Test
    public void testListarImg() {
        System.out.println("listarImg");
        int id = 50;
        HttpServletResponse response = null;
        ProductoDAO instance = new ProductoDAO();
        instance.listarImg(id, response);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of eliminar method, of class ProductoDAO.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        int id = 10;
        ProductoDAO instance = new ProductoDAO();
        boolean expResult = true;
        boolean result = instance.eliminar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of cargar method, of class ProductoDAO.
     */
    @Test
    public void testCargar() {
        System.out.println("cargar");
        int id = 12;
        ProductoDAO instance = new ProductoDAO();
        ProductoBeans expResult = null;
        ProductoBeans result = instance.cargar(id);
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of modificar method, of class ProductoDAO.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        ProductoBeans r = new ProductoBeans(13, "sakdsakdskad", null, 1000, "sapdkas", 2, 1, 1);
        r.setNombre("maikitol");
        ProductoDAO instance = new ProductoDAO();
        int expResult = 0;
        int result = instance.modificar(r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of añadirId method, of class ProductoDAO.
     */
    @Test
    public void testAñadirId() {
        System.out.println("a\u00f1adirId");
        ProductoBeans r = new ProductoBeans();
        int id = 15;
      
        ProductoDAO instance = new ProductoDAO();
        ProductoBeans expResult = null;
        ProductoBeans result = instance.añadirId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
