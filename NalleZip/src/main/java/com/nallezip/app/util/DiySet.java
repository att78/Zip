/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app.util;

/**
 * Luokka toimii Huffman-algo-luokassa Character-tyyppiset avaimet kokoavana
 * "Settinä", joskaan ei ole varsinaisesti toiminnaltaan javan Set-luokan
 * tyyppinen.
 *
 * @author tallbera
 */
public class DiySet {

    private static final int SIZE = 512;
    private Character table[];
    private int amount = 0;

    /**
     * Konstruktorissa määritellään setin koko.
     */
    public DiySet() {
        this.table = new Character[SIZE];
    }
    
    /**
     * metodi palauttaa tablen objektimuotoisena.
     * @return 
     */
    public Object[] getTable() {
        return table;
    }

    /**
     * palauttaa Setin pituuden
     *
     * @return
     */
    public int length() {
        return amount;
    }

//    /**
//     * apumetodi, jota käytetään tarkistamaan tarvitseeko taulukon kokoa
//     * kasvattaa add-metodissa.
//     *
//     * @return
//     */
//    private boolean tableIsFull() {
//        boolean full = false;
//        if (this.table.length == this.amount) {
//            full = true;
//        }
//        return full;
//    }

//    /**
//     * apumetodi, joka hoitaa taulukon kasvatuksen, jos add-metodi huomaa
//     * taulukon olevan täynnä eikä siten pysty lisäämään uutta lukua.
//     *
//     * @param doubleSize
//     */
//    private void doubleTable(int doubleSize) {
//
//        Character[] cache = new Character[doubleSize];
//        int cacheNumber = 0;
//
//        for (int i = 0; i < this.table.length; i++, cacheNumber++) {
//            Character c = table[i];
//            if (c == null) {
//                cacheNumber--;
//                continue;
//            }
//            cache[cacheNumber] = table[i];
//        }
//        this.table = null;
//        this.table = new Character[cache.length];
//        this.table = cache;
//    }

    //Add-metodin toimintaa voisi vielä parantaa. Annetaanko setin koko suoraan HashMapin kokona tms? vai pitääkö ola valmius setin kasvattamiseen?
    /**
     * metodi, jolla lisätä parametrina annetun luvun.
     *
     * @param ch merkki, joka lisätään avainsettiin.
     */
    public void add(Character ch) {
//
//        if (tableIsFull()) {
//            int doubleSize = size() * 2;
//            doubleTable(doubleSize);
//        }

        this.table[this.amount] = ch;
        this.amount++;

    }
    
    /**
     * DiySetin toString-metodi on muoattu kehitystyötä varten sopivaksi.
     * @return muokattu kuvaus luokasta
     */
    public String toString() {

        String string = "{";
        for (int i = 0; i < table.length  ; i++) {
            if (table[i] == null) {
                break;
            }
            if (table[i] != null) {
                string += table[i];
                string += ", ";
            }
        }
        string += "}";

        return string;
    }

}
