

import com.nallezip.app.huffman.HuffmanNode;
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
public class HuffmanNodeTest {

    public HuffmanNodeTest() {
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
    public void testToString() {
        HuffmanNode node = new HuffmanNode();
        node.setCh('c');
        node.setPosition(1);
        String compare = node.toString();
        assertEquals(compare, "Character of the node is " + node.getCh() + " position of the node is " + node.getPosition());

    }
    
    @Test
    public void testCompareTo(){
        HuffmanNode first = new HuffmanNode();
        first.setPosition(1);
        HuffmanNode second = new HuffmanNode();
        second.setPosition(2);
        int answer = first.compareTo(second);
        assertEquals(answer, -1);
    }
    
    
    
}
