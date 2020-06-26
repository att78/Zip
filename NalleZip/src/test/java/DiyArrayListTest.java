
import com.nallezip.app.util.DiyArrayList;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 *
 * @author tallbera
 */
public class DiyArrayListTest {

    @Test
    public void testAddAndGetWithIndex() {
        short expected = 11;
        DiyArrayList list = new DiyArrayList();
        short test1 = 10;
        list.add(test1);
        list.add(expected);
        int result = list.get(1);
        assertEquals("Wrong value from index", expected, result);
        assertEquals("Wrong size", 2, list.size());

    }

    @Test
    public void testSize() {
        short size = 2;
        DiyArrayList list = new DiyArrayList();
        list.add(size);
        list.add(size);
        assertEquals(size, list.size());
        
    }
    
    @Test
    public void testGetFirst(){
        DiyArrayList list = new DiyArrayList();
        short first= 1;
        short second = 2;
        short third = 3;
        list.add(first);
        list.add(second);
        list.add(third);
        int answer = list.getFirst();
        assertEquals(1,answer);
           
    }
    
    @Test
    public void testTableLength(){
        DiyArrayList list = new DiyArrayList(512);
        assertEquals(list.getDiyArray().length,512);
        short first=1;
        list.add(first);
        assertEquals(list.getDiyArray().length, 1024);
    }

    
    @Test
    public void testGet(){
        DiyArrayList list = new DiyArrayList();
        short first = 1;
        list.add(first);
        int answer = list.get(550);
        assertEquals(answer, -1);

    }
    
    @Test
    public void testToString(){
        DiyArrayList list = new DiyArrayList();
        short first = 1;
        list.add(first);
        assertEquals("DiyArrayList amount= 1 diyArray: {1, }", list.toString());
    
    }
}
