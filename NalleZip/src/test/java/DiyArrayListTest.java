
import com.nallezip.app.util.DiyArrayList;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tallbera
 */
public class DiyArrayListTest {
    
    @Test
    public void testAddAndGetWithIndex() {
        int expected = 11;
        DiyArrayList list = new DiyArrayList();
        list.add(10);
        list.add(expected);
        int result = list.get(1);
        assertEquals("Wrong value from index", expected, result);
        assertEquals("Wrong size", 2, list.size());
        
        
    }
    
}
