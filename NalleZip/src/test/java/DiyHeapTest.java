/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.nallezip.app.huffman.HuffmanNode;
import com.nallezip.app.util.DiyHeap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tämä luokka testaa DiyHeap-luokan toimintaa
 *
 * @author tallbera
 */
public class DiyHeapTest {

    public DiyHeapTest() {
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
    public void testMom() {
        DiyHeap heap = new DiyHeap();
        int number = 2;
        assertEquals(heap.mom(2), 1);

    }

    @Test
    public void testLeftChild() {
        DiyHeap heap = new DiyHeap();
        int number = 2;
        assertEquals(heap.leftChild(number), 4);

    }

    @Test
    public void testRightChild() {
        DiyHeap heap = new DiyHeap();
        int number = 2;
        assertEquals(heap.rightChild(number), 5);

    }

    @Test
    public void testAddAndPoll() {
        DiyHeap heap = new DiyHeap(512);
        HuffmanNode node = new HuffmanNode();
        assertEquals(heap.getSize(), 0);
        heap.add(node);
        assertEquals(heap.getSize(), 1);
//        DiyHeap heap2 = new DiyHeap(1);
//        heap2.setSize(1);
//        heap2.add(node);
//        assertEquals(heap2.getSize(),1);
        

    }

    @Test
    public void testPoll() {
        DiyHeap heap = new DiyHeap(512);
        HuffmanNode node = new HuffmanNode();
        heap.add(node);
        HuffmanNode node2 = heap.poll();
        assertEquals(node2, node);
        assertEquals(heap.getSize(), 0);

    }

}
