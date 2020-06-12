
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

    @Test
    public void testSize() {
        int size = 2;
        DiyArrayList list = new DiyArrayList();
        list.add(size);
        list.add(size);
        assertEquals(size, list.size());
        
    }
    
    @Test
    public void testGetFirst(){
        DiyArrayList list = new DiyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        int answer = list.getFirst();
        assertEquals(1,answer);
           
    }
    
    @Test
    public void testTableLength(){
        DiyArrayList list = new DiyArrayList(512);
        assertEquals(list.getDiyArray().length,512);
        list.add(1);
        assertEquals(list.getDiyArray().length, 1024);
    }

    
    @Test
    public void testGet(){
        DiyArrayList list = new DiyArrayList();
        list.add(1);
//        int answer = list.get(550);
//        assertEquals(answer, -1);
    
    }

}
