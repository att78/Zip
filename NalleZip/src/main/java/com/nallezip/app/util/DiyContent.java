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
public class DiyContent<Key,Value> {
    
    
    private Key key;
    private Value value;        
    private DiyContent nextOne;
// vielä hieman pohdintaa, millaisia rakenteita tämän kanssa tekisi..    
    private int numberKey;
    
    
    

    public DiyContent getNextOne() {
        return nextOne;
    }

    
    public DiyContent (Key key, Value value){
        this.key = key;
        this.setValue(value);
    }
    
//    public DiyContent(Integer key, String value){
//        this.numberKey = key;
//        this.value = value;
//    }
    
        

    public Key getKey() {
        return key;
    }


    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
    
    public void setNextOne(DiyContent nextOne) {
        this.nextOne = nextOne;
    }
    
    
}
