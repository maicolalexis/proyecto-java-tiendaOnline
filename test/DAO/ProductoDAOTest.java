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
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ProductoBeans r = new ProductoBeans();
        r.setNombre("sakdsakdskad");
        
        ProductoDAO instance = new ProductoDAO();
        int expResult = 1;
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
        ProductoBeans r = null;
        ProductoDAO instance = new ProductoDAO();
        int expResult = 0;
        int result = instance.modificar(r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of añadirId method, of class ProductoDAO.
     */
    @Test
    public void testAñadirId() {
        System.out.println("a\u00f1adirId");
        int id = 0;
        ProductoDAO instance = new ProductoDAO();
        ProductoBeans expResult = null;
        ProductoBeans result = instance.añadirId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
