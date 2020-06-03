/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app.util;

/**Javan HashMapin sisältö, eli avain ja arvo. Erona HashMapiin luokassa on myös viittaus seuraavaan olioon, jolloin olioiden keskinäisestä sijainnista
 * DiyHashMapissa on kiinnitetty olioon itseensäkin.
 *
 * @author tallbera
 */
public class DiyContent {
    
    
    private String key;
    private String value;
    private DiyContent nextOne;

    public DiyContent getNextOne() {
        return nextOne;
    }
    private int hashValue;
    
    public DiyContent (String key, String value){
        this.key = key;
        this.value = value;
        this.hashValue=createHashValue(key);
    }
    

    public String getKey() {
        return key;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public int createHashValue(String key){
    // onko riittävän uniikki tms...    
    int Hashvalue = key.hashCode();
        return Hashvalue;
    }

    public void setNextOne(DiyContent nextOne) {
        this.nextOne = nextOne;
    }
    
    
}
