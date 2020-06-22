/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app.util;

/**
 * DiyStringBuilder jonka on tarkoitus korvata javan StringBuilder-luokka.
 * Teknisesti tämä ei ole tietorakenne, mutta tulkitsin StringBuilderin
 * sellaiseksi luokaksi, jota toivotaan itsetehdyksi.
 *
 * @author tallbera
 */
public class DiyStringBuilder {

    private static final int BUFFER_SIZE = 16;
    private static final int BUFFER_MULTI = 2;

    //private int size=16;
    private char[] table;

    private int count = 0; //merkkien määrä

    /**
     * Konstruktori oletusarvoilla
     */
    public DiyStringBuilder() {
        this.table = new char[BUFFER_SIZE];
        //this.size = BUFFER_SIZE;
    }

    /**
     * Konstruktori, joka ottaa sisäänsä char-taulukon
     *
     * @param table Stringin sisältävä char taulukko
     */
    public DiyStringBuilder(char[] table) {
        this.table = table;
        count = table.length;

    }

    /**
     * Konstruktori, joka ottaa sisäänsä DiyStringBuilderin halutun koon
     *
     * @param size
     */
//    public DiyStringBuilder(int size){
//        this.size=size;    
//    }
    public int length() {

        return this.count;
    }

//
    /**
     * Konstruktori, joka ottaa sisäänsä aloittavan Stringin.
     *
     * @param initial
     */
    public DiyStringBuilder(String initial) {
        this.table = initial.toCharArray();
        this.count = initial.length();
    }

    public DiyStringBuilder append(String input) {
        while (tableIsFull(input.length())) {
            increaseBuffer();
        }
        //    updateCount(input.length()); //voiks tää olla tässä
        addInput(input);

        return this;
    }

    public DiyStringBuilder append(char input) {
        while (tableIsFull(1)) {
            increaseBuffer();
        }
        //    updateCount(input.length()); //voiks tää olla tässä
        table[count++] = input;

        return this;
    }

    public void increaseBuffer() {
        if (this.table.length == 0) {
            //palautta oletustaulukko jos edellinen tyhjeni
            this.table = new char[BUFFER_SIZE];
            return;
        }
        
        int tooSmall = this.table.length;
        int newSize = tooSmall * BUFFER_MULTI;
        //  this.size = newSize;
        char[] cache = new char[newSize];
        //       int cacheNumber = 0;

        for (int i = 0; i < this.table.length; i++) {
            //, cacheNumber++) {
            char ch = table[i];
//            if (ch == null) {
//                cacheNumber--;
//                continue;
//            }
//            cache[cacheNumber] = table[i];
            cache[i] = table[i];
        }
        this.table = null;
        this.table = new char[cache.length];
        this.table = cache;
    }

    public boolean tableIsFull(int inputLength) {
        return this.count + inputLength >= this.table.length;
    }

//    public void updateCount(int count){
//        this.count +=count;
//    }
    private void addInput(String input) {

        char[] toBuilder = input.toCharArray();
        for (int i = 0; i < toBuilder.length; i++) {
            table[count++] = toBuilder[i];

        }

//        for(int i=0;i<input.length();i++){
//            table[count+i]=input.charAt(i);            
//        } 
//        System.arraycopy(input.toCharArray(),0,this.table,this.count,table.length);
    }

    public String toString() {

        char[] characters = new char[count];
        for (int i = 0; i < count; i++) {
            characters[i] = table[i];
        }
        String answer = new String(characters);
        return answer;
    }

    public void deleteCharAt(int index) {
        char[] afterRemoval = new char[count - 1];

        for (int i = 0; i < count; i++) {
            if (i < index) {
                afterRemoval[i] = table[i];
            }
            if (i == index) {
                continue;
            }
            if (i > index) {
                afterRemoval[i] = table[i + 1];
            }
        }
        table = afterRemoval;
        count--;
    }

}
