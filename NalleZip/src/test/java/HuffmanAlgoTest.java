/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.nallezip.app.huffman.HuffmanAlgo;
import com.nallezip.app.huffman.HuffmanNode;
import com.nallezip.app.util.DiyHashMap;

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
    
    //rampa testi tällä hetkellä
    @Test
    public void testCreatePosition() {
        HuffmanAlgo algo = new HuffmanAlgo();
        String nalle = "Nalle";
        DiyHashMap<Character, Integer> position = algo.createPosition(nalle);
        String compare = "{a=1, e=1, l=2, N=1}";
        //assertEquals(compare, position.toString());
        //assertEquals(4, position.size());
    }

    @Test
    public void testSetHuffmanTree() {
        HuffmanAlgo huff = new HuffmanAlgo();
        HuffmanNode node = new HuffmanNode();
        HuffmanNode right = new HuffmanNode();
        HuffmanNode left = new HuffmanNode();
        StringBuilder builder = new StringBuilder();
        DiyHashMap<Character, String> huffmanTree = new DiyHashMap();
        node.setCh('a');
        node.setPosition(1);
        node.setLeft(left);
        node.setRight(right);
        int before = huffmanTree.size();
        huff.setHuffmanTree(node, builder);
        int after = huffmanTree.size();
        assertEquals(before, after);
    }

//    @Test
//    public void testFindRootNode() {
//        DiyHashMap<Character, Integer> position = new DiyHashMap();
//        HuffmanAlgo huff = new HuffmanAlgo();
//        position.put('a', 1);
//        position.put('b', 1);
//        position.put('a', 1);
//        HuffmanNode node = huff.findRootNode(position);
//        assertEquals("Character of the node is " + '-' + " position of the node is " + 2, node.toString());
//    }

    @Test
    public void testCreateNodes() {
        DiyHashMap<Character, Integer> position = new DiyHashMap();
        HuffmanAlgo huff = new HuffmanAlgo();
        position.put('a', 1);
        position.put('b', 1);
        position.put('a', 1);
//        PriorityQueue<HuffmanNode> testQueue = huff.createNodes(position);
//        assertEquals("[Character of the node is a position of the node is 1, Character of the node is b position of the node is 1]",testQueue.toString());
        
    }
    
//    @Test 
//    public void testEncodeString(){
//    String nalle = "Nalle";
//    HuffmanAlgo huff = new HuffmanAlgo();
//    String encoded = huff.encodeString(nalle);
//    
//    assertEquals(encoded,"1111100010");
//    
//    }
//    
//    @Test
//    public void testDecodeString(){
//        
//    HuffmanAlgo huff = new HuffmanAlgo();
//    
//    String encoded= huff.encodeString("Nalle");
//    String decoded= huff.decodeString(encoded);
//    
//    assertEquals(decoded,"Nalle");
//    
//    }
    
    @Test
    public void testBinaryStringToBytes(){
        String test = "100";
        HuffmanAlgo algo = new HuffmanAlgo();
        byte[] resultBytes=algo.binaryStringToBytes(test);
        
        assertEquals(2, resultBytes.length);
        int lastLen = (int)resultBytes[0] & 0xFF;
        assertEquals(3,lastLen);
        
        int answer = (int)resultBytes[1] & 0xFF;
        assertEquals(4, answer);

        test = "00100";
        resultBytes=algo.binaryStringToBytes(test);
        
        assertEquals(2, resultBytes.length);
        answer = (int)resultBytes[1] & 0xFF;
        assertEquals(4, answer);
        

        String test2= "10001000100010";
        byte[] resultBytes2 = algo.binaryStringToBytes(test2);
//        for(int i=0;i<resultBytes2.length;i++){
//            int number =(int)resultBytes2[i];
//            System.out.println(number);        
//        }
        
        assertEquals(3,resultBytes2.length);
        answer = (int)resultBytes2[1] & 0xFF;
        assertEquals(136, answer);
        answer = (int)resultBytes2[2] & 0xFF;
        assertEquals(34, answer);
               
    }
    
//    @Test
//    public void testLastBye(){
//        HuffmanAlgo huff = new HuffmanAlgo();
//        byte[] buggedDot=huff.encodeString(".");
//        for (byte b : buggedDot) {
//            System.out.println("Byte: " + b);
//        }
//        
//        
//        
//        Boolean[] zerosAndOnes = new Boolean[16];//minkäkokoinen
//        int max = 128;
//        int number;
//        byte[] resultBytes = new byte[8]; //minkäkokoinen
//                
//        int j=0;//mikä arvo
//        int lastByteLength = (int) resultBytes[0] & 0xFF;
//        
//
//        
//    
//    }
    
    

}
