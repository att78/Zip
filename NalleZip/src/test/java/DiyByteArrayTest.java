/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.nallezip.app.util.DiyByteArray;
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
public class DiyByteArrayTest {
    
    public DiyByteArrayTest() {
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
    public void writeByteTest(){
        DiyByteArray test = new DiyByteArray(8);        
        assertEquals(0, test.getSize());
        assertEquals(0, test.getBytes().length);        
        byte testByte = 1;
        test.writeByte(testByte);
        assertEquals(1,test.getSize());
    }
     
     
}
