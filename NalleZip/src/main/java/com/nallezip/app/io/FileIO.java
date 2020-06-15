/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app.io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


//import sun.security.util.IOUtils;

/**
 *
 * @author tallbera
 */
public class FileIO {
    
    private int inputLength;
    private String input;
    
    
    public FileIO(String filename){
        Path route = Paths.get(filename);
       
        try{
            input = Files.readString(route);
        
        }catch(Exception e){
        }    
    }

    public int getInputLength() {
        return input.length();
    }

    public String getInput() {
        return input;
    }
    
    
    

}
