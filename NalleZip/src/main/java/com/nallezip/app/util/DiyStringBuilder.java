/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app.util;

/**DiyStringBuilder jonka on tarkoitus korvata javan StringBuilder-luokka. 
 * Teknisesti tämä ei ole tietorakenne, mutta tulkitsin StringBuilderin sellaiseksi luokaksi, jota
 * toivotaan itsetehdyksi.
 *
 * @author tallbera
 */
public class DiyStringBuilder {
    private static final int BUFFER_SIZE = 16;
    private static final int BUFFER_MULTI=2;
    
    private int size;
    private char[] table; 
    
    private int count; //merkkien määrä
    
    /**
     * Konstruktori oletusarvoilla
     */
    public DiyStringBuilder(){
        this.table= new char[BUFFER_SIZE];
        this.size = BUFFER_SIZE;
    }
    
    /**
     * Konstruktori, joka ottaa sisäänsä char-taulukon
     * @param table Stringin sisältävä char taulukko
     */
    public DiyStringBuilder(char[] table){
        this.table = table;
    
    }
    
    /**
     * Konstruktori, joka ottaa sisäänsä DiyStringBuilderin halutun koon
     * @param size 
     */
//    public DiyStringBuilder(int size){
//        this.size=size;    
//    }

    public int getSize(){
    
        return size;
    }

//
    /**
     * Konstruktori, joka ottaa sisäänsä aloittavan Stringin.
     * @param initial 
     */
    public DiyStringBuilder(String initial) {
        this.table = initial.toCharArray();
    }
    
    
    public DiyStringBuilder append(String input){
        while(tableIsFull(input)){
            increaseBuffer(input);
        }
    //    updateCount(input.length()); //voiks tää olla tässä
        addInput(input); 
        
        return this;
    }
    
    public void increaseBuffer(String string){
        
        int tooSmall = this.size;
        int newSize =tooSmall*BUFFER_MULTI;
        this.size = newSize;
        char[] cache = new char[newSize];
 //       int cacheNumber = 0;

        for (int i = 0; i < this.table.length; i++){
                //, cacheNumber++) {
            char ch = table[i];
//            if (ch == null) {
//                cacheNumber--;
//                continue;
//            }
//            cache[cacheNumber] = table[i];
              cache[i]=table[i];  
        }
        this.table = null;
        this.table = new char[cache.length];
        this.table = cache;
    }
    
    public boolean tableIsFull(String input){
        return this.count+input.length()>this.size;
    }
    
//    public void updateCount(int count){
//        this.count +=count;
//    }
    
    
    private void addInput(String input){
        
        char[] toBuilder= input.toCharArray();        
        for(int i=0; i<toBuilder.length;i++){        
            table[count++]= toBuilder[i];
        }
        
//        for(int i=0;i<input.length();i++){
//            table[count+i]=input.charAt(i);            
//        } 
        
        
//        System.arraycopy(input.toCharArray(),0,this.table,this.count,table.length);
        
        
    }
    
    public String toString(){
        
        char[] characters = new char[count];
        for(int i=0; i<count;i++){
            characters[i]=table[i];
        }
        String answer = new String(characters);    
        return answer;
    }
    
}
