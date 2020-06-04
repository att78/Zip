/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.nallezip.app.util.DiyHashMap;
import com.nallezip.app.util.DiyContent;
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
public class DiyHashMapTest {

    public DiyHashMapTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testPut() {
        DiyHashMap<Integer, Integer> diy = new DiyHashMap();
        assertEquals(diy.size(), 512);//  tarkistus, koska diyHashMapin koon ei tule olla nolla tässä
        int test = 1;
        int test2 = 2;
        diy.put(test, test2);
        assertEquals(diy.size(), 512);
        int answer = diy.get(test);
        assertEquals(test2, answer);
    }

    @Test
    public void testGet() {
        DiyHashMap<Integer, Integer> diy = new DiyHashMap();
        int test = 1;
        int test2 = 2;
        diy.put(test, test2);
        int answer = diy.get(test);
        assertEquals(test2, answer);
    }

    @Test
    public void testSize() {
        DiyHashMap<Integer, Integer> diy = new DiyHashMap();
        assertEquals(512, diy.size());
    }
    
    
    @Test
    public void testContainsKey(){
        DiyHashMap<String, String> diy = new DiyHashMap();
        String key = "key";
        String value = "value";
        diy.put(key, value);       
        boolean answer = diy.containsKey(key);        
        assertTrue(answer);
        answer = diy.containsKey(value);
        assertFalse(answer);
    }
}
