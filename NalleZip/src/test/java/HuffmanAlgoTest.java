/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.nallezip.app.huffman.HuffmanAlgo;
import com.nallezip.app.huffman.HuffmanNode;
import java.util.HashMap;
import java.util.PriorityQueue;
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
public class HuffmanAlgoTest {

    public HuffmanAlgoTest() {
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
    public void testCreatePosition() {
        HuffmanAlgo algo = new HuffmanAlgo();
        String nalle = "Nalle";
        HashMap<Character, Integer> position = algo.createPosition(nalle);
        String compare = "{a=1, e=1, l=2, N=1}";
        assertEquals(compare, position.toString());
        assertEquals(4, position.size());
    }

    @Test
    public void testSetHuffmanTree() {
        HuffmanAlgo huff = new HuffmanAlgo();
        HuffmanNode node = new HuffmanNode();
        HuffmanNode right = new HuffmanNode();
        HuffmanNode left = new HuffmanNode();
        StringBuilder builder = new StringBuilder();
        HashMap<Character, String> huffmanTree = new HashMap();
        node.setCh('a');
        node.setPosition(1);
        node.setLeft(left);
        node.setRight(right);
        int before = huffmanTree.size();
        huff.setHuffmanTree(node, builder);
        int after = huffmanTree.size();
        assertEquals(before, after);
    }

    @Test
    public void testFindRootNode() {
        HashMap<Character, Integer> position = new HashMap();
        HuffmanAlgo huff = new HuffmanAlgo();
        position.put('a', 1);
        position.put('b', 1);
        position.put('a', 1);
        HuffmanNode node = huff.findRootNode(position);
        assertEquals("Character of the node is " + '-' + " position of the node is " + 2, node.toString());
    }

    @Test
    public void testCreateNodes() {
        HashMap<Character, Integer> position = new HashMap();
        HuffmanAlgo huff = new HuffmanAlgo();
        position.put('a', 1);
        position.put('b', 1);
        position.put('a', 1);
        PriorityQueue<HuffmanNode> testQueue = huff.createNodes(position);
        assertEquals("[Character of the node is a position of the node is 1, Character of the node is b position of the node is 1]",testQueue.toString());
        
    }
    
    @Test 
    public void testEncodeString(){
    String nalle = "Nalle";
    HuffmanAlgo huff = new HuffmanAlgo();
    String encoded = huff.encodeString(nalle);
    
    assertEquals(encoded,"1111100010");
    
    }
    
    @Test
    public void testDecodeString(){
        
    HuffmanAlgo huff = new HuffmanAlgo();
    
    String encoded= huff.encodeString("Nalle");
    String decoded= huff.decodeString(encoded);
    
    assertEquals(decoded,"Nalle");
    
    }
    

}
