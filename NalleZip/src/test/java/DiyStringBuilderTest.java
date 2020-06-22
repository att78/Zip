/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.nallezip.app.util.DiyStringBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tallbera
 */
public class DiyStringBuilderTest {
    
    public DiyStringBuilderTest() {
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

    @Test
    public void toStringTest(){
    
        String bear = "nalle";
        DiyStringBuilder builder = new DiyStringBuilder();
        builder.append(bear);
        String result = builder.toString();
        //System.out.println("Result: " + result + ", size: " + result.length());
        assertEquals("nalle", result);        
    }
    
    @Test
    public void tableIsFullTest(){
        String string = "012345678901234567890";
        DiyStringBuilder builder = new  DiyStringBuilder(); //oletuskoko 16
        assertEquals(0,builder.length());//palauttaa taulukon koon
        builder.append(string);
        assertEquals(21, builder.length());//palauttaa taulukon koon
        
        
    }
    
    
    
    
}
