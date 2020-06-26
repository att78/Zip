
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
     *
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

    /**
     * metodi, jolla lisätä parametrina annetun luvun.
     *
     * @param ch merkki, joka lisätään avainsettiin.
     */
    public void add(Character ch) {

        this.table[this.amount] = ch;
        this.amount++;

    }

    /**
     * DiySetin toString-metodi on muoattu kehitystyötä varten sopivaksi.
     *
     * @return muokattu kuvaus luokasta
     */
    public String toString() {

        String string = "{";
        for (int i = 0; i < table.length; i++) {
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
