/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app.huffman;

/**
 * Luokka tarjoaa Huffman-algoritmille solmuluokan.
 *
 * @author tallbera
 */
public class HuffmanNode implements Comparable<HuffmanNode> {

    private HuffmanNode left;
    private HuffmanNode right;
    private char ch;
    private int position;
    
//    public HuffmanNode(){
//    }

//    public HuffmanNode(HuffmanNode left, HuffmanNode right, char ch, int position) {
//        this.left = left;
//        this.right = right;
//        this.ch = ch;
//        this.position = position;
//    }

    /**
     * compareTo-metodi palauttaa kahden solmun vertailutuloksen
     * 
     * @param second
     * @return 
     */
    
    public int compareTo(HuffmanNode second){
    
        return this.position-second.position;
    }
    
    /**
     * Metodi palauttaa true, jos solmu on lehti ja false, jos solmu ei ole lehti
     * @return 
     */
    
//    public boolean isItLeaf() {
//
//        if ((left == null) && (right == null)) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public HuffmanNode getLeft() {
        return left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public char getCh() {
        return ch;
    }

    public int getPosition() {
        return position;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    
    public String toString(){
    
        return "Character of the node is "+ch+" position of the node is "+position;
    }

}
