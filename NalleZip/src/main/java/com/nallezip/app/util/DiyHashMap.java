/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app.util;

import com.nallezip.app.util.DiyContent;

/**
 * Luokan tarkoitus on olla Do-it-yourself HashMap, joka korvaa sovelluksessa
 * käytetyn javan HashMapin. Put, get, containsKey ja size-metodit ovat metodeja, joita käytetään javan HashMap-luokan metodien tavoin.
 *
 * @author tallbera
 */
public class DiyHashMap<Key, Value> {

    //vielä tyhjä eli motivointiluokka. Lukutuokio hashmappeihin käynnissä...
    private static final int SIZE = 512;
    private DiyContent table[] = new DiyContent[SIZE];

    /**
     * Metodi, joka palauttaa avaimelle hash-coden. Metodin avulla hashcode
     * hoituu kaikille metodeille tässä luokassa
     *
     * @param key
     * @return
     */
    private int getHashInt(Key key) {
        // onko riittävän uniikki. Millä tämä kannattaisi laskea?
        return key.hashCode() % SIZE;
    }

    /**
     * Palauttaa annetun avaimen takana olevan Valuen.
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        int hashValue = getHashInt(key);
        DiyContent content = table[hashValue];

        //table pitäis käydä jotenkin järkevästi läpi. For-loop, while loop? jotain...loop
        // kylläpä tänään tökkii. Takas javan peruskurssille.       
        for (int i = 0; i < table.length; i++) {
            if (!content.equals(null)) {
                if (content.getKey().equals(key)) {
                    Value answer = (Value) content.getValue();
                    return answer;
                }
                content = content.getNextOne();
            }
        }
        return null;
    }

    /**
     * Javan Hashmapin put-metodia vastaava put-metodi. Käyttää apumetodeja
     * createNewContent ja loopAfter 
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        int hashValue = getHashInt(key);
        DiyContent content = table[hashValue];

        if (content == null) {
            createNewContent(key, value, hashValue);
        } else {
            if (content.getKey().equals(key)) {
                content.setValue(value);
            } else {
                loopNextOne(content, key, value);

            }
        }
    }

    /**
     * Luo uuden DiyContent-olion ja asettaa sen tableen hashvaluen osoittamaan
     * paikkaan
     *
     * @param key
     * @param value
     * @param hashValue
     */
    private void createNewContent(Key key, Value value, int hashValue) {
        DiyContent content = new DiyContent(key, value);
        table[hashValue] = content;
    }

    /**
     * Metodi käy läpi DiyContent-olion "after"-listauksen. Metodi toimii
     * put-metodin apumetodina.
     *
     * @param content
     * @param key
     * @param value
     */
    private void loopNextOne(DiyContent content, Key key, Value value) {
        while (content.getNextOne() != null) {
            content = content.getNextOne();
        }
        DiyContent oldContent = new DiyContent(key, value);
        content.setNextOne(oldContent);
    }

    /**
     * metodia voi käyttää HashMapin containsKey-metodia vastaavalla tavalla
     *
     * @param key
     * @return
     */
    public boolean containsKey(Key key) {

        for (DiyContent content : table) {
            if (content != null) {
                if (content.getKey().equals(key)) {
                    // System.out.println("avain löytyi");
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Kertoo DiyHashMapin tablen koon. Kannattaa huomata, että DiyHashMapin koko määräytyy ennalta tablen kokona.
     *
     * @return
     */
    public int size() {
        return table.length;
    }

}
