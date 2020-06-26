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
    public void testOfferAndPoll() {
        DiyHeap heap = new DiyHeap(512);
        HuffmanNode node = new HuffmanNode();
        node.setPosition(12);
        assertEquals(heap.getSize(), 0);
        heap.offer(node);
        assertEquals(heap.getSize(), 1);
        HuffmanNode node2 = new HuffmanNode();
        node2.setPosition(5);
        heap.offer(node2);
        assertEquals(heap.getSize(),2);
        HuffmanNode nodeReturns = heap.poll();
        assertEquals(heap.getSize(),1);
        heap.offer(nodeReturns);
        
        
        
    }

    @Test
    public void testPoll() {
        DiyHeap heap = new DiyHeap(512);
        HuffmanNode node = new HuffmanNode();
        node.setPosition(22);
        heap.offer(node);
        HuffmanNode node2 = heap.poll();
        assertEquals(node2, node);
        assertEquals(heap.getSize(), 0);

    }

    @Test
    public void testComparisonment() {
        DiyHeap heap = new DiyHeap(512);
//        for (int i = 1; i < 11; i++) {
//            HuffmanNode node = new HuffmanNode();
//            node.setPosition(i*2);
//            heap.offer(node);
//        }
        HuffmanNode nodeExtra = new HuffmanNode();
        nodeExtra.setPosition(1);
        heap.offer(nodeExtra);
        nodeExtra = new HuffmanNode();
        nodeExtra.setPosition(9009);
        heap.offer(nodeExtra);
        nodeExtra = new HuffmanNode();
        nodeExtra.setPosition(5);
        heap.offer(nodeExtra);
        nodeExtra = new HuffmanNode();
        nodeExtra.setPosition(3);
        heap.offer(nodeExtra);

        for (int i = 1; i < 21; i++) {
            HuffmanNode node = new HuffmanNode();
            node.setPosition(i*9);
            heap.offer(node);

        }
        
        int prev = Integer.MIN_VALUE;
        for (int i = 1; i < 25; i++) {
            HuffmanNode node = heap.poll();
            //System.out.println(node.getPosition());
            assertTrue(node.getPosition() > prev);
            prev = node.getPosition();

        }

    }

}
