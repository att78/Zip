/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app.huffman;

import com.nallezip.app.util.DiySet;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Huffman algoritmin toteuttava luokka
 *
 * @author tallbera
 */
public class HuffmanAlgo {

    public HashMap<Character, String> huffmanTree = new HashMap();//käännetty publiciksi suorituskykytestauksen suorittamiseksi. Ei muita syitä
    private HuffmanNode root;

    /**
     * asettaa luokkamuuttujaan root Huffman-puun juurisolmun.
     *
     * @param position
     * @return
     */
    public HuffmanNode findRootNode(HashMap<Character, Integer> position) {
        //Set<Character> keys = position.keySet();
        PriorityQueue<HuffmanNode> nodeQueue = new PriorityQueue();

        if (position.size() > 0) {
            nodeQueue = createNodes(position);
        }
        while (nodeQueue.size() > 1) {
            HuffmanNode mom = new HuffmanNode();
            HuffmanNode firstBorn = nodeQueue.poll();
            HuffmanNode secondBorn = nodeQueue.poll();
            //HuffmanNode mom = new HuffmanNode(firstBorn, secondBorn, '-', firstBorn.getPosition() + secondBorn.getPosition());

            mom.setLeft(firstBorn);
            mom.setRight(secondBorn);
            mom.setCh('-');
            mom.setPosition(firstBorn.getPosition() + secondBorn.getPosition());
            root = mom;
            nodeQueue.offer(mom);
        }
        //System.out.println("Peekataan nodejono "+ nodeQueue.peek());
        //System.out.println("peekkauksen kanssa mom Tsekkaus "+root);
        //System.out.println("Solmujonon pituus: "+ nodeQueue.size());
        //HuffmanNode testiNode = nodeQueue.peek();
        //System.out.println("Solmujonon pituus: "+testiNode.toString());
        return nodeQueue.poll();
    }

    /**
     * Luo prioriteettijonon, jossa on HuffmanNodeja Ottaa parametrina Setin,
     * jossa on HashMapin avaimia
     *
     * @param keys
     * @return
     */
    public PriorityQueue<HuffmanNode> createNodes(HashMap<Character, Integer> position) {
        Set<Character> keys = position.keySet();
        PriorityQueue<HuffmanNode> nodeQueue = new PriorityQueue();

        for (Character c : keys) {
            //HuffmanNode node = new HuffmanNode(null, null, c, position.get(c));
            HuffmanNode node = new HuffmanNode();
            node.setLeft(null);
            node.setRight(null);
            node.setCh(c);

            //System.out.println(position.get(c));
            int weight = position.get(c);
            node.setPosition(weight);
            nodeQueue.add(node);
        }
        //System.out.println("Tämä on nodequeue: " +nodeQueue.toString());
        return nodeQueue;
    }

    /**
     * metodi asettaa silmuja HuffmanTreehen(jona HashMap toimii)
     *
     * @param node
     * @param builder
     */
    public void setHuffmanTree(HuffmanNode node, StringBuilder builder) {
        //System.out.println("Builder on: "+builder);
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null) {
                huffmanTree.put(node.getCh(), builder.toString());
            } else {
                builderAppends(node, builder);
            }
        }
    }

    /**
     * metodi on apumetodi setHuffmanTree-metodille. BuilderAppends ja
     * setHuffmanTree toimivat rekursiivisesti, mutta koodin siisteyden takia
     * rekursio on pilkottu kahteen metodiin. Muuten olisi muodostunut yksi
     * jättiläinen.
     *
     * @param node
     * @param builder
     */
    public void builderAppends(HuffmanNode node, StringBuilder builder) {
        builder.append('0');
        setHuffmanTree(node.getLeft(), builder);
        builder.deleteCharAt(builder.length() - 1);

        builder.append('1');
        setHuffmanTree(node.getRight(), builder);
        builder.deleteCharAt(builder.length() - 1);
    }

    /**
     * metodi on apumetodi encodeString-metodille. Luo positioille paikat.
     *
     * @param string
     * @return
     */
    public HashMap<Character, Integer> createPosition(String string) {
        HashMap<Character, Integer> position = new HashMap();
        for (int i = 0; i < string.length(); i++) {
            // if-else-rakenteessa potentiaalisesti vikaa
            if (!position.containsKey(string.charAt(i))) {
                position.put(string.charAt(i), 0);
            }
            position.put(string.charAt(i), position.get(string.charAt(i)) + 1);

        }
        // System.out.println(position.toString() + " size: " + position.size());
        return position;
    }

    /**
     * metodi on enkoodausta varten. Metodi käyttää apumetodeita createPosition
     * ja buildTree().
     *
     * @param string
     * @return
     */
    public byte[] encodeString(String string) {
        HashMap<Character, Integer> position = createPosition(string);
        //System.out.println("Tämä on position:" +position);
        root = findRootNode(position);
        //System.out.println("Tämä on juuri: " +root);
        setHuffmanTree(root, new StringBuilder());
        //System.out.println("Tämä on puu: "+ huffmanTree);
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            //System.out.println(ch);
            //System.out.println(huffmanTree);
            builder.append(huffmanTree.get(ch));

        }
        //lasketaan binääristä integeriksi bitti kerrallaan
        String total = builder.toString();

        byte[] resultBytes = binaryStringToBytes(total);

        return resultBytes;

    }

    public byte[] binaryStringToBytes(String total) {

        int lastByteLength = total.length() % 8;

        int size = (total.length() / 8);
        if (total.length() % 8 > 0) {
            size++;
        }

        byte[] resultBytes = new byte[size + 1];
        int byteIndex = 1;
        int value = 0;
        resultBytes[0] = (byte) lastByteLength;
        for (int i = 0; i < total.length(); i++) {
            if (i % 8 == 0 && i > 0) {
                resultBytes[byteIndex] = (byte) value;
                value = 0;
                byteIndex++;
            }
            value *= 2;
            char ch = total.charAt(i);
            if (ch == '1') {
                value++;
            }
        }
        if (byteIndex == size - 1) {
            resultBytes[byteIndex] = (byte) value;
        }
        return resultBytes;
    }

    /**
     * Metodin tarkoitus on muuttaa enkoodattu byte-taulukko booleantaulukoksi,
     * jota käytetään dekoodauksessa.testaamatta
     *
     * @param resultBytes
     * @return
     */
    public Boolean[] byteToBoolean(byte[] resultBytes) {
        Boolean[] zerosAndOnes = new Boolean[resultBytes.length * 8];
        int max = 128;
        int j = 0;
        int lastByteLength = (int) resultBytes[0] & 0xFF;

        for (int i = 1; i < resultBytes.length - 1; i++) {

            byte a = resultBytes[i];
            int number = (int) a & 0xFF;
            j = zerosAndOnesRecursion(zerosAndOnes, number, j, max);
        }

        int rounds = 8 - lastByteLength;

        if (rounds < 8) {
            for (int i = 0; i < rounds; i++) {
                max = max / 2;
            }
        }
        int number = (int) resultBytes[resultBytes.length - 1] & 0xFF;
        zerosAndOnesRecursion(zerosAndOnes, number, j, max);

        return zerosAndOnes;
    }

    /**
     * Apumetodi bytesToBoolean-metodille, tämä metodi hoitaa rekursio-osan
     * booleantaulukon muodostamisesta.
     *
     * @param zerosAndOnes
     * @param number
     * @param j
     * @param max
     * @return
     */
    public int zerosAndOnesRecursion(Boolean[] zerosAndOnes, int number, int j, int max) {

        if (number >= max) {
            zerosAndOnes[j] = true;
            number = number - max;
        } else {
            zerosAndOnes[j] = false;

        }
        j++;
        max = max / 2;
        if (max > 0) {
            j = zerosAndOnesRecursion(zerosAndOnes, number, j, max);
        }
        return j;
    }

    /**
     * metodi palauttaa encodeString-metodilla koodatun Stringin alkuperäiseen
     * muotoon.
     *
     * @param string Syöte on ykkösiä ja nollia sisältävä String.
     * @return
     */
    public String decodeString(byte[] packed) {
        StringBuilder builder = new StringBuilder();
        HuffmanNode node = root;
        Boolean[] decompressed = byteToBoolean(packed);

        for (int i = 0; i < decompressed.length; i++) {
            int j = 0;
            if(decompressed[i]==null){
                break;
            }
            
            else if (decompressed[i]) {
                j = 1;
            }
            
            
            if (j == 0) {
                node = node.getLeft();

                if (node.getLeft() == null && node.getRight() == null) {
                    builder.append(node.getCh());
                    node = root;
                }

                //  appendInDecode(node);
            } else if (j == 1) {
                node = node.getRight();

                if (node.getLeft() == null && node.getRight() == null) {
                    builder.append(node.getCh());
                    node = root;
                }
                //   appendInDecode(node);
            }
        }
        return builder.toString();
    }

    /**
     * Metodi on apumetodi decodeString-metodille. Ongelmien vuoksi ei tällä
     * hetkellä käytössä.
     *
     * @param node
     */
    public void appendInDecode(HuffmanNode node) {
        StringBuilder builder = new StringBuilder();
        if (node.getLeft() == null && node.getRight() == null) {
            builder.append(node.getCh());
            node = root;
        }
    }

//    private static String[]stringTable; 
//    private static String s;
//    
//    public HuffmanAlgo(String s){
//    this.s = s;   
//    }
//    
//    public  void compress(){
//                
//    //muutetaan input char-taulukoksi
//    char[] input = s.toCharArray();
//    int[]positions=buildPositionsTable();
//    HuffmanNode root = findRootNode(positions);
//    buildStringTable(root, "");
//    
//    
//
//    
//    }
//    
//    
//    
//    public static void buildStringTable(HuffmanNode a, String string){       
//    stringTable = new String[256];
//    
//    if(!a.isItLeaf()){        
//        buildStringTable(a.getLeft(), string+'0');
//        buildStringTable(a.getRight(), string+'1');    
//    }else{
//        stringTable[a.getCh()]=string;
//    }
//    }
//    
//    // seuraavaksi pitäisi rakentaa positions-taulukko algoa varten
//    /**
//     * Metodi palauttaa solmujen position-ominaisuuteen liittyvän taulukon. Palautettavaa taulukkoa käytetään
//     * compress-metodin yhteydessä.
//     * 
//     * @return 
//     */
//    
//    public int[] buildPositionsTable(){
//    int[] positions = new int[256];
//    char[] input = s.toCharArray();
//    for(int i=0; i<s.length();i++){
//        positions[input[i]]++;    
//    }
//    
//     return positions;
//    }
//    
//    
//    /**
//     * Metodilla selvitetään juurisolmu
//     * @param positions
//     * @return 
//     */
//    public HuffmanNode findRootNode(int[] positions){
//        PriorityQueue<HuffmanNode> queue = createQueue(positions);
//    // kahden pienen puun mergeäminen
//        while(queue.size()>1){
//            HuffmanNode left = queue.poll();
//            HuffmanNode right = queue.poll();
//            HuffmanNode mom = new HuffmanNode(left,right, '\0', left.getPosition()+right.getPosition());
//            queue.add(mom);
//        }
//        return queue.poll();
//    }
//    
//    /**
//     * Metodilla luodaan prioriteettijono
//     * @param positions
//     * @return 
//     */
//    public PriorityQueue createQueue(int[]positions){
//                PriorityQueue<HuffmanNode> queue = new PriorityQueue();        
//        for(int i = 0;i<256; i++){
//                if(positions[i]>0){
//                    char ch = (char)i;
//                    queue.add(new HuffmanNode(null, null,ch,positions[i]));
//                }           
//        }
//    
//    
//    }
//    
//        
//    
}
