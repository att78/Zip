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
     * short-tyyppinen taulukko
     */
    private short[] diyArray = new short[512];

    /**
     * tyhjä konstruktori
     */
    public DiyArrayList() {
    }

    public DiyArrayList(short[] existingArray) {
        diyArray = existingArray;
        amount = existingArray.length;
    }

    /**
     * Testausta varten toinen konstruktori.
     *
     * @param testing //testausta varten annettu koko listalle.
     */
    public DiyArrayList(int testing) {
        this.amount = testing;
    }

    /**
     * apumetodi, jota käytetään tarkistamaan tarvitseeko taulukon kokoa
     * kasvattaa add-metodissa.
     *
     * @return boolean-arvon, joka on true, jos taulu on täynnä.
     */
    private boolean tableIsFull() {
        boolean full = false;
        if (this.diyArray.length == this.amount) {
            full = true;
        }
        return full;
    }

    /**
     * apumetodi, joka hoitaa taulukon kasvatuksen, jos add-metodi huomaa
     * taulukon olevan täynnä eikä siten pysty lisäämään uutta lukua.
     *
     * @param doubleSize parametrina annettava taulukon uusi koko
     */
    private void doubleTable(int doubleSize) {

        short[] cache = new short[doubleSize];
        int cacheNumber = 0;

        for (int i = 0; i < this.diyArray.length; i++, cacheNumber++) {
            short number = diyArray[i];
//            if (number == null) {
//                cacheNumber--;
//                continue;
//            }
            cache[cacheNumber] = diyArray[i];
        }
        this.diyArray = null;
        this.diyArray = new short[cache.length];
        this.diyArray = cache;
    }

    public short[] getDiyArray() {
        return diyArray;
    }

    /**
     * metodi, jolla lisätä parametrina annetun luvun.
     *
     * @param number lisättävä luku
     */
    public void add(short number) {

        if (tableIsFull()) {
            int doubleSize = size() * 2;
            doubleTable(doubleSize);
        }
        
        this.diyArray[this.amount] = number;
        this.amount++;

    }

    /**
     * metodi, joka kertoo diyArrayListin pituuden.
     *
     * @return palauttaa luokkamuuttujan, jossa diyArrayListin koko on
     * kiinnitettynä.
     */
    public int size() {
        return amount;
    }

//    // remove-toimii väärin. Onneksi sitä ei tarvitse käyttää.
//    public void remove(Integer number) {
//
//        for (int i = 0; i < this.amount; i++) {
//            if (number.equals(this.diyArray[i])) {
//                this.diyArray[i] = null;
//                this.amount--;
//                return;
//            }
//        }
//    }
    /**
     * palauttaa aina listan ensimmäisen alkion.
     *
     * @return palauttaa listan ensimmäisen alkion
     */
    public Short getFirst() {
        Short diy = null;
        diy = this.diyArray[0];
        return diy;
    }

    /**
     * palauttaa aina parametrina annetun sijainnin mukaisen alkion.
     *
     * @param n sijainti listalla
     * @return palautettava luku.
     */
    public short get(int n) {
        if (n > size()) {
            return -1;
        }
        Short diy = null;
        diy = this.diyArray[n];
        short answer;
        if (diy != null) {
            answer = (short) diy;
            return answer;
        } else {

            return -1;
        }
    }

    /**
     * toString-metodi on muokattu testaukseen ja kehitystyöhön sopivaksi.
     *
     * @return palauttaa testaamisessa ja sovelluksen kehityksessä auttavan
     * toStringin.
     */
    @Override
    public String toString() {

        String string = "{";
        for (int i = 0; i < amount; i++) {
//            if (diyArray[i] == null) {
//                break;
//            }
//            if (diyArray[i] != null) {
            string += diyArray[i];
            string += ", ";
//            }
        }

        string += "}";
        return "DiyArrayList amount= " + amount + " diyArray: " + string;
    }

}
