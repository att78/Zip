/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app;

import com.nallezip.app.huffman.HuffmanAlgo;
import com.nallezip.app.huffman.HuffmanNode;
import com.nallezip.app.lempelziv.LempelZivWelchAlgo;
import com.nallezip.app.util.DiyArrayList;
import com.nallezip.app.util.DiyHashMap;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author tallbera
 */
public class App {

    public static void main(String[] args) {

        String string = "Nalle on soma ja haluaa kovasti hunajaa. Nalle kiipeää puuhun. Siellä on mehiläisillä pesä. Nalle kurkottaa kohti hunajaa. Nalle kurkotti liian pitkälle ja tömähtää maahan."
                + "Nallea tömähti onneksi pehmeään heinäkasaan.";
        System.out.println("Original: " + string);
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
        DiyArrayList testing = algo.encodeString(string);
        System.out.println("Alkuperäinen koko on "+string.length());
        System.out.println("Pakattu koko on: " +testing.size());
        String answer = algo.decodeString();
        System.out.println(answer);
        
//        DiyHashMap<String,String> diy = new DiyHashMap();
//        String nalle = "Nalle";
//        
//        diy.put(nalle, nalle);
//        
//        System.out.println(diy.containsKey(nalle));
//        String answer2 = diy.get(nalle);
//        System.out.println(answer);
        System.out.println("Suorituskyvyn testausta: ");
        System.out.println("Ensin Huffman-algoritmi:");
        String test = "suorituskyvyn testaus";
        System.out.println("Käytetty testilause " + test);
        HuffmanAlgo huff = new HuffmanAlgo();
        LempelZivWelchAlgo lempel = new LempelZivWelchAlgo();

        long start = System.currentTimeMillis();
        String encoded = huff.encodeString(test);
        System.out.println("Enkoodattuna test näyttää tältä: " + encoded);
        long encodingDone = System.currentTimeMillis();
        String decoded = huff.decodeString(encoded);
        System.out.println("dekoodattu: " + decoded);
        long decodingDone = System.currentTimeMillis();

        long enc = encodingDone - start;
        System.out.println("Enkoodauksessa meni aikaa: " + enc + " millisekuntia");
        int size = huff.huffmanTree.size();

        System.out.println("Huffmantreen koko " + size + " ja test-stringin koko " + test.length());
        long dec = decodingDone - encodingDone;
        System.out.println("Huffmanin dekoodauksessa meni aikaa: " + dec + " millisekuntia");
        System.out.println("Alkuperäinen testi: " + test + " ja enkoodauksen jälkeen palautettu: " + decoded);
        System.out.println("");
        System.out.println("Sitten LZW:n testaus samalla stringillä");
        long lempelStart = System.currentTimeMillis();
        DiyArrayList lempelEncoding = lempel.encodeString(test);
        long lempelEncoded = System.currentTimeMillis();
        String lempelDecoded = lempel.decodeString();
        long lempelEnd = System.currentTimeMillis();

        long lempelEnc = lempelEncoded - lempelStart;
        long lempelFinished = lempelEnd - lempelEncoded;
        System.out.println("LZW enkoodauksessa meni aikaa " + lempelEnc + " millisekuntia");
        System.out.println("Koodattuna näyttää tältä: "+ lempelEncoding);
        System.out.println("LZW dekoodauksessa meni aikaa " + lempelFinished + " millisekuntia");
        System.out.println("LZW:ssä String on alunperin " + test.length() + " pituinen ja koodattuna se on " + lempelEncoding.size() + " pituinen");

    }

}
