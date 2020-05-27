/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app.lempelziv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Luokka toteuttaa Lempel-Ziv-Welch-algoritmin, joka on yksi niistä Lempel
 * Ziv-algoritmeina tunnetuista algoritmeista
 *
 * @author tallbera
 */
public class LempelZivWelchAlgo {

    private List<Integer> encoded = new ArrayList();
    private HashMap<String, Integer> library = new HashMap();

    public LempelZivWelchAlgo() {
    }

    public List<Integer> encodeString(String string) {
        int length = string.length();
        createLibrary(string);
        fillLibrary(string);
        return encoded;        
    }

    /**
     * Luodaan library annetulle stringille.
     *
     * @param string
     */
    public void createLibrary(String string) {
        for (int i = 0; i < string.length(); i++) {
            library.put("" + (char) i, i);
        }
    }
    
    public void fillLibrary(String string){
        String a = "";
        String b = "";
        int size = 128;
        for (int i = 0; i < string.length(); i++) {
            b = string.substring(i, i + 1);
            String ab = a + b;
//       for(char ch : string.toCharArray()){
//           String ach = a+ch;
            if (library.containsKey(ab)) {
                a = ab;
            } else {
                encoded.add(library.get(a));
                library.put(ab,size++);
                a= ""+b;
            }            
            if(!a.equals("")){
               encoded.add(library.get(a));
            }
        }   
    }
    

}
