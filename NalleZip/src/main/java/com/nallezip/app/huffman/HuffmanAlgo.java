/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app.huffman;

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

    private HashMap<Character, String> huffmanTree = new HashMap();
    private HuffmanNode root;

    /**
     * asettaa luokkamuuttujaan root Huffman-puun juurisolmun.
     *
     * @param position
     * @return
     */
    public HuffmanNode findRootNode(HashMap<Character, Integer> position) {
        Set<Character> keys = position.keySet();
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
        System.out.println(position.toString()+" size: "+position.size());
        return position;
    }

    /**
     * metodi on enkoodausta varten. Metodi käyttää apumetodeita createPosition
     * ja buildTree().
     *
     * @param string
     * @return
     */
    public String encodeString(String string) {
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
        return builder.toString();

    }
    /**
     * metodi palauttaa encodeString-metodilla koodatun Stringin alkuperäiseen muotoon.
     * @param string Syöte on ykkösiä ja nollia sisältävä String.
     * @return 
     */
    public String decodeString(String string) {
        StringBuilder builder = new StringBuilder();
        HuffmanNode node = root;
        for (int i = 0; i < string.length(); i++) {
            
            int j = Integer.parseInt(String.valueOf(string.charAt(i)));
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
     * Metodi on apumetodi decodeString-metodille. Ongelmien vuoksi ei tällä hetkellä käytössä.
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
