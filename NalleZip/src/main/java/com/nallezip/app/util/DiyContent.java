/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app.util;

/**
 * Javan HashMapin sisältö, eli avain ja arvo. Erona HashMapiin luokassa on myös
 * viittaus seuraavaan olioon, jolloin olioiden keskinäisestä sijainnista
 * DiyHashMapissa on kiinnitetty olioon itseensäkin.
 *
 * @author tallbera
 */
public class DiyContent<K, V> {

    private K key; // DiyHashMapin avain
    private V value; //DiyHashMappiin tallennettu arvo        
    private DiyContent nextOne; //viittaus seuraavaan HashMapissa olevaan DiyContentiin.

    public DiyContent getNextOne() {
        return nextOne;
    }

    /**
     * DiyContentin konstruktori ottaa parametreina aina DiyHashMapin
     * tallentamiseen käytetyn avaimen ja tallennettavan arvon.
     *
     * @param key DiyHashMapin avain-arvo
     * @param value tallennettava arvo
     */
    public DiyContent(K key, V value) {
        this.key = key;
        this.setValue(value);
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setNextOne(DiyContent nextOne) {
        this.nextOne = nextOne;
    }

}
