/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app.util;

/**
 * Luokan tarkoitus on olla Do-it-yourself HashMap, joka korvaa sovelluksessa
 * käytetyn javan HashMapin
 *
 * @author tallbera
 */
public class DiyHashmap {

    //vielä tyhjä eli motivointiluokka. Lukutuokio hashmappeihin käynnissä...
    private static final int SIZE = 32;
    private DiyContent table[] = new DiyContent[SIZE];

    /**
     * Metodi, joka palauttaa avaimelle hash-coden. Metodin avulla hashcode
     * hoituu kaikille metodeille tässä luokassa
     *
     * @param key
     * @return
     */
    private int getHashInt(String key) {
        // onko riittävän uniikki. Millä tämä kannattaisi laskea?
        return key.hashCode();
    }

    /**
     * Palauttaa annetun avaimen takana olevan sisällön DiyContentin.
     *
     * @param key
     * @return
     */
    public DiyContent get(String key) {
        int hashValue = getHashInt(key);
        DiyContent content = table[hashValue];

        //table pitäis käydä jotenkin järkevästi läpi. For-loop, while loop? jotain...loop
        // kylläpä tänään tökkii. Takas javan peruskurssille.       
        for (int i = 0; i < table.length; i++) {
            if (!content.equals(null)) {
                if (content.getKey().equals(key)) {
                    return content;
                }
                content = content.getNextOne();
            }
        }
        return null;
    }

    /**
     * Javan Hashmapin put-metodia vastaava put-metodi.
     * Käyttää apumetodeja createNewContent ja loopAfter
     * @param key
     * @param value 
     */
    public void put(String key, String value) {
        int hashValue = getHashInt(key);
        DiyContent content = table[hashValue];

        if (content == null) {
            createNewContent(key, value, hashValue);
        } 
        else {
            if (content.getKey().equals(key)) {
                content.setValue(value);
            } else {
                loopNextOne(content, key, value);

            }
        }
    }
    
    /**Luo uuden DiyContent-olion ja asettaa sen tableen hashvaluen osoittamaan paikkaan
     * 
     * @param key
     * @param value
     * @param hashValue 
     */
    private void createNewContent(String key, String value, int hashValue) {
        DiyContent content = new DiyContent(key, value);
        table[hashValue] = content;
    }

    /**
     * Metodi käy läpi DiyContent-olion "after"-listauksen. Metodi toimii put-metodin apumetodina.
     * @param content
     * @param key
     * @param value 
     */
    private void loopNextOne(DiyContent content, String key, String value) {
        while (content.getNextOne() != null) {
            content = content.getNextOne();
        }
        DiyContent oldContent = new DiyContent(key, value);
        content.setNextOne(oldContent);
    }
}
