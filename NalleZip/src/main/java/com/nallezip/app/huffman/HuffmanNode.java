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


    /**
     * compareTo-metodi palauttaa kahden solmun vertailutuloksen
     *
     * @param second HuffmanNode, johon verrataan
     * @return vertailutulos: jos tämän HuffmanNoden position-arvo on korkeampi kuin parametrina annetun verrattavan, luku on positiivinen. päinvastaisessa 
     * tilanteessa vertailuluku on negatiivinen.
     */
    public int compareTo(HuffmanNode second) {

        return this.position - second.position;
    }


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

    /**
     * toString-metodi on muokattu antamaan informaatiota, joka on sovelluksen kehityksessä ja testaamisessa hyödyllistä.
     * @return Kustomoidun Stringin, joka kertoo noden Character arvon ja position-arvon.
     */
    public String toString() {

        return "Character of the node is " + ch + " position of the node is " + position;
    }

}
