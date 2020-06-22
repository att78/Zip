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

    private char[] table;

    private int count = 0;

    /**
     * Konstruktori oletusarvoilla
     */
    public DiyStringBuilder() {
        this.table = new char[BUFFER_SIZE];
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

    public int length() {

        return this.count;
    }

    /**
     * Konstruktori, joka ottaa sisäänsä aloittavan Stringin.
     *
     * @param initial
     */
    public DiyStringBuilder(String initial) {
        this.table = initial.toCharArray();
        this.count = initial.length();
    }

    /**
     * metodi,joka lisää DiyStringBuilderiin syötteen, kun syöte on String
     *
     * @param input
     * @return
     */
    public DiyStringBuilder append(String input) {
        while (tableIsFull(input.length())) {
            increaseBuffer();
        }

        addInput(input);

        return this;
    }

    /**
     * metodi, joka lisää DiyStringBuilderiin syötteen, kun syöte on char
     *
     * @param input
     * @return
     */
    public DiyStringBuilder append(char input) {
        while (tableIsFull(1)) {
            increaseBuffer();
        }
        table[count++] = input;

        return this;
    }

    /**
     * kasvattaa DiyStringBuilderin taulukkoa.
     */
    public void increaseBuffer() {
        if (this.table.length == 0) {
            //palauttaa oletustaulukon, jos edellinen tyhjeni
            this.table = new char[BUFFER_SIZE];
            return;
        }

        int tooSmall = this.table.length;
        int newSize = tooSmall * BUFFER_MULTI;
        char[] cache = new char[newSize];
        for (int i = 0; i < this.table.length; i++) {
            cache[i] = table[i];
        }
        this.table = null;
        this.table = new char[cache.length];
        this.table = cache;
    }

    /**
     * tarkistaa onko taulukko jo täynnä.
     *
     * @param inputLength
     * @return
     */
    public boolean tableIsFull(int inputLength) {
        return this.count + inputLength >= this.table.length;
    }

    /**
     * Append-metodin apumetodi, joka lisää syötteen table-tauluun.
     *
     * @param input
     */
    private void addInput(String input) {

        char[] toBuilder = input.toCharArray();
        for (int i = 0; i < toBuilder.length; i++) {
            table[count++] = toBuilder[i];
        }
    }

    /**
     * toString-metodi, joka palauttaa DiyStringBuilderin keräämän Stringin.
     *
     * @return
     */
    public String toString() {

        char[] characters = new char[count];
        for (int i = 0; i < count; i++) {
            characters[i] = table[i];
        }
        String answer = new String(characters);
        return answer;
    }

    /**
     * Javan StringBuilder-luokan deleteCharAt-metodia vastaava metodi. Poistaa
     * char:in parametrina saadusta indeksistä.
     *
     * @param index
     */
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
