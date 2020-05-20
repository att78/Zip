/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app;

import com.nallezip.app.huffman.HuffmanAlgo;
import java.util.HashMap;

/**
 *
 * @author tallbera
 */
public class App {
    
    
    public static void main(String[] args){
    
    String string = "Nalle";
    System.out.println("Original: "+string);
    HuffmanAlgo huff = new HuffmanAlgo();
    String encoded = huff.encodeString(string);
//    System.out.println("Encoded:"+ encoded);
//   HashMap<Character, Integer> position = new HashMap();
//   position.put('a',0);
//   position.put('b',1);
//    HashMap<Character, Integer> position = huff.createPosition(string);
//    System.out.println(position);
//    huff.createNodes(position);
    
    }
    
    
}
