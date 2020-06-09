/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app.ui;

import java.util.Scanner;

/**
 *
 * @author tallbera
 */
public class UI {

    public void runUI() {

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("What do you want to do?");

            System.out.println("x, if you want to quit");
            System.out.println("write, if you want to write string, that we pack");
            String answer = scanner.nextLine();

            if (answer.equals("x")) {
                break;
            } else if (answer.equals("write")) {

                System.out.println("Lempel, if you want to pack with Lempel Ziv Welch Algorithm");
                System.out.println("Huffman, if you want to pack with Huffman Algorithm");
                System.out.println("Compare, if you want to compare both algorithms");
                String packedOne = scanner.nextLine();                
                
                if(packedOne.equals("Lempel")){
                
                
                }
                

            }

        }
    }

}
