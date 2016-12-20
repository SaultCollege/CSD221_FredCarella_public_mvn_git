/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture3.activity1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fcarella
 */
public class BookTest {
    
    public BookTest() {
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
     * Test of orderCopies method, of class Book.
     */
    @Test
    public void testOrderCopies() {
        System.out.println("orderCopies");
        Integer num2Order = 10;
        Book instance = new Book();
        instance.orderCopies(num2Order);
        assertTrue("copies is incorrect", num2Order.equals(instance.getCopies()));
    }
    
}
