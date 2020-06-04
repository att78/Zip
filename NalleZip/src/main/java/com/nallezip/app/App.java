/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app;

import com.nallezip.app.huffman.HuffmanAlgo;
import com.nallezip.app.huffman.HuffmanNode;
import com.nallezip.app.lempelziv.LempelZivWelchAlgo;
import com.nallezip.app.util.DiyHashMap;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author tallbera
 */
public class App {

    public static void main(String[] args) {

        String string = "Nalle";
       // System.out.println("Original: " + string);
//        HuffmanAlgo huff = new HuffmanAlgo();
//        String encoded = huff.encodeString(string);
//        System.out.println("Encoded: " + encoded);
//        String decoded = huff.decodeString(encoded);
//        System.out.println("Decoded: " + decoded);
//        String test = "1111100010";
//        String decoded2=huff.decodeString(test);
//        System.out.println("decoded2: "+decoded2);
//        
//    System.out.println("Encoded:"+ encoded);
//   HashMap<Character, Integer> position = new HashMap();
//   position.put('a',0);
//   position.put('b',1);
//    HashMap<Character, Integer> position = huff.createPosition(string);
//    System.out.println(position);
//    huff.createNodes(position);
//        HashMap<Character, Integer> position = new HashMap();
//        position.put('a', 1);
//        position.put('b', 1);
//        position.put('a', 1);
//        PriorityQueue<HuffmanNode> testQueue = huff.createNodes(position);
//        System.out.println(testQueue);
//
//
        LempelZivWelchAlgo algo = new LempelZivWelchAlgo();
        List<Integer> testing = algo.encodeString(string);
        System.out.println(testing);
        String answer = algo.decodeString();
        System.out.println(answer);
//        DiyHashMap<String,String> diy = new DiyHashMap();
//        String nalle = "Nalle";
//        
//        diy.put(nalle, nalle);
//        String answer = diy.get(nalle);
//        System.out.println(answer);
    }

}
