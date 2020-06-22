/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app.util;

import com.nallezip.app.util.DiyContent;

/**
 * Luokan tarkoitus on olla Do-it-yourself HashMap, joka korvaa sovelluksessa
 * käytetyn javan HashMapin. Put, get, containsKey ja size-metodit ovat
 * metodeja, joita käytetään javan HashMap-luokan metodien tavoin.
 *
 * @author tallbera
 */
public class DiyHashMap<K, V> {

    //vielä tyhjä eli motivointiluokka. Lukutuokio hashmappeihin käynnissä...
    private static final int SIZE = 512;
    private DiyContent table[] = new DiyContent[SIZE];
    private int amount = 0;

    /**
     * Metodi, joka palauttaa avaimelle hash-coden. Metodin avulla hashcode
     * hoituu kaikille metodeille tässä luokassa
     *
     * @param key avain-arvo, jonka avulla DiyHashMapista haetaan tietoja.
     * @return avaimen hashcoden.
     */
    private int getHashInt(K key) {
        //onko riittävän uniikki ja saako valmista hashcodea käyttää
        int hashCode = key.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return hashCode % SIZE;
    }

    /**
     * Palauttaa annetun avaimen takana olevan Valuen, ja huomionarvoista on,
     * ettei tämä get-metodi ole generoitu metodi.
     *
     * @param key DiyHashMapissa käytetty avain
     * @return palauttaa avaimen perusteella haetun DiyHashMapiin tallennetun
     * arvon.
     */
    public V get(K key) {
        int hashValue = getHashInt(key);
        DiyContent content = table[hashValue];

        for (int i = 0; i < table.length; i++) {
            if (content != null) {
                if (content.getKey().equals(key)) {
                    V answer = (V) content.getValue();

                    return answer;
                }
                content = content.getNextOne();
            }
        }

        return null;
    }

    /**
     * Javan Hashmapin put-metodia vastaava put-metodi. Käyttää apumetodeja
     * createNewContent ja loopNextOne. createNewContent ja loopAfter
     *
     * @param key avain, jonka perusteella tallennettava tieto löytyy.
     * @param value tallennettava tieto.
     */
    public void put(K key, V value) {
        int hashValue = getHashInt(key);
        DiyContent content = table[hashValue];

        if (content == null) {
            createNewContent(key, value, hashValue);
            amount++;
        } else {
            if (content.getKey().equals(key)) {
                content.setValue(value);
            } else {
                loopNextOne(content, key, value);

            }
        }
    }

    /**
     * Put-metodin apumetodi, joka luo uuden DiyContent-olion ja asettaa sen
     * tableen hashvaluen osoittamaan paikkaan
     *
     * @param key Hashmapin avain-arvo
     * @param value HashMapiin avaimen taakse tallennettu tieto
     * @param hashValue parametrina annettuun key:hin liittyvä hashcode.
     */
    private void createNewContent(K key, V value, int hashValue) {
        DiyContent content = new DiyContent(key, value);
        table[hashValue] = content;
    }

    /**
     * Metodi käy läpi DiyContent-olion "after"-listauksen. Metodi toimii
     * put-metodin apumetodina.
     *
     * @param content Diy-content-olio, joka on tarkoitus tallentaa
     * DiyHashMapiin.
     * @param key Tallennuksessa käytetty avain-arvo
     * @param value tallennettava arvo.
     */
    private void loopNextOne(DiyContent content, K key, V value) {
        while (content.getNextOne() != null) {
            content = content.getNextOne();
            if (content.getKey().equals(key)) {
                content.setValue(value);
                return;
            }
        }
        DiyContent oldContent = new DiyContent(key, value);
        content.setNextOne(oldContent);
        amount++;
    }

    /**
     * metodia voi käyttää HashMapin containsKey-metodia vastaavalla tavalla
     *
     * @param key avain, jonka olemassa olo DiyHashMapissa tarkastetaan.
     * @return arvo, joka on "true", jos avain on listalla ja "false", jos avain
     * ei ole listalla.
     */
    public boolean containsKey(K key) {
        int hashValue = getHashInt(key);
        DiyContent content = table[hashValue];
        for (int i = 0; i < table.length; i++) {
            if (content != null) {
                if (content.getKey().equals(key)) {
                    return true;
                }
                content = content.getNextOne();
            }
        }
        return false;
    }

    /**
     * Kertoo DiyHashMapin tablen koon. Kannattaa huomata, että DiyHashMapin
     * koko määräytyy ennalta tablen kokona.
     *
     * @return DiyHashMapin koko
     */
    public int size() {
        return amount;
    }

    /**
     * metodi, joka palauttaa "<Character, Value>"-tyypitetyn DiyHashMapin
     * avaimet DiySettinä.
     *
     * @return DiySet, jossa on Character-tyyppiset avaimet.
     */
    public DiySet keySetForCharacters() {

        DiySet diySet = new DiySet();

        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                DiyContent content = table[i];
                Character c = (char) content.getKey();
                diySet.add(c);

            }
        }
        return diySet;
    }
    
    /**
     * toString-metodi, jota on tarpeen mukaan käytetty testauksessa.
     * @return 
     */
    public String toString() {
        String answer = "{";
        for (int i = 0; i < table.length - 1; i++) {
            DiyContent content = table[i];
            if (content != null) {
                answer += content.getKey() + "=" + content.getValue() + " ,";
            }
        }
        answer += "}";

        return answer;
    }
}
