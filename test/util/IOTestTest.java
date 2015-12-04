/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;
import junit.framework.TestCase;
import logic.Test;

/**
 *
 * @author ivan
 */
public class IOTestTest extends TestCase {
    
    public IOTestTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getListTest method, of class IOTest.
     */
    public void testGetListTest() {
        System.out.println("getListTest");
        IOTest instance = new IOTest();
        List<Test> expResult = null;
        List<Test> result = instance.getListTest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sageTest method, of class IOTest.
     */
    public void testSageTest() {
        System.out.println("sageTest");
        IOTest instance = new IOTest();
        instance.sageTest();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
