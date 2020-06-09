/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app.util;

/**
 * Tarkoituksena on tehdä luokka, joka pystyy korvaamaan LempelZivwelchAlgossa
 * käytetyt List- ja ArrayList rakenteet. Luokan ei ole edes tarkoitus olla ns.
 * täydellinen javan Array List:in korvike, vaan sellainen, joka piisaa LZW:n
 * tarpeisiin. LZW käyttää listaa,jossa on Integer-tyyppisiä olioita.
 *
 * @author tallbera
 */
public class DiyArrayList {

    /**
     * diyArrayhin tallennettujen määrä. Muuttuva luku
     */
    private int amount = 0;

    /**
     * Arrayhin kerätään Integerejä
     */
    private int[] diyArray = new int[512];

    private boolean tableIsFull() {
        boolean full = false;
        if (this.diyArray.length == this.amount) {
            full = true;
        }
        return full;
    }

    private void doubleTable(int doubleSize) {

        int[] cache = new int[doubleSize];
        int cacheNumber = 0;

        for (int i = 0; i < this.diyArray.length; i++, cacheNumber++) {
            Integer value = diyArray[i];
            if (value == null) {
                cacheNumber--;
                continue;
            }
            cache[cacheNumber] = diyArray[i];
        }
        this.diyArray = null;
        this.diyArray = new int[cache.length];
        this.diyArray = cache;
    }

    public void add(int number) {

        if (tableIsFull()) {
            int doubleSize = size() * 2;
            doubleTable(doubleSize);
        }
        
        this.diyArray[amount] =number;
        this.amount++;

    }

    public int size() {
        return amount;
    }
    
    
    // remove-metodi tarvitaan vielä

}
