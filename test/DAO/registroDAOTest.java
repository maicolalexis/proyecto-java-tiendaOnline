/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beens.registroBeens;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SENA
 */
public class registroDAOTest {
    
    public registroDAOTest() {
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
     * Test of insertar method, of class registroDAO.
     */
  
    public void testInsertar() {
        System.out.println("insertar");
        registroBeens r = new registroBeens();
        
        r.setNombre("maikitol");
        r.setContact("sjdsjd");
        r.setEmail("nsdjsdjsajd");
        r.setPass("sjfjdfjd");
        
        registroDAO instance = new registroDAO();
        int expResult = 0;
        int result = instance.insertar(r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of validar method, of class registroDAO.
     */
    @Test
    public void testValidar() {
        System.out.println("validar");
        String usr = "maikitol";
        String pss = "123";
        registroDAO instance = new registroDAO();
        registroBeens expResult = null;
        registroBeens result = instance.validar(usr, pss);
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getAll method, of class registroDAO.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        registroDAO instance = new registroDAO();
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of eliminar method, of class registroDAO.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        int id = 0;
        registroDAO instance = new registroDAO();
        boolean expResult = false;
        boolean result = instance.eliminar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargar method, of class registroDAO.
     */
    @Test
    public void testCargar() {
        System.out.println("cargar");
        int id = 0;
        registroDAO instance = new registroDAO();
        registroBeens expResult = null;
        registroBeens result = instance.cargar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificar method, of class registroDAO.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        registroBeens r = null;
        registroDAO instance = new registroDAO();
        int expResult = 0;
        int result = instance.modificar(r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAl method, of class registroDAO.
     */
    @Test
    public void testGetAl() {
        System.out.println("getAl");
        registroDAO instance = new registroDAO();
        List expResult = null;
        List result = instance.getAl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
