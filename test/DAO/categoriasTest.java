/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beens.productosBeens;
import java.util.ArrayList;
import java.util.List;
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
public class categoriasTest {
    
    public categoriasTest() {
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
     * Test of insertar method, of class categorias.
     */
    
    public void testInsertar() {
        System.out.println("insertar");
        productosBeens r = new productosBeens();
        r.setId(6);
        r.setNombre("mail");
      
        categorias instance = new categorias();
        int expResult = 0;
        int result = instance.insertar(r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getAll method, of class categorias.
     */
 
    public void testGetAll() {
        System.out.println("getAll");
        categorias instance = new categorias();
        List<productosBeens> lista = new ArrayList<>();
        List expResult = lista;
        List result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of eliminar method, of class categorias.
     */
    
    public void testEliminar() {
        System.out.println("eliminar");
        int id = 6;
        categorias instance = new categorias();
        boolean expResult = true;
        boolean result = instance.eliminar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of cargar method, of class categorias.
     */
    
    public void testCargar() {
        System.out.println("cargar");
        int id = 5;
        categorias instance = new categorias();
        productosBeens expResult = null;
        productosBeens result = instance.cargar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of modificar method, of class categorias.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        productosBeens r = new productosBeens(2, "comidas", 1);
        r.setNombre("productos de comida");
        
        categorias instance = new categorias();
        int expResult = 0;
        int result = instance.modificar(r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
