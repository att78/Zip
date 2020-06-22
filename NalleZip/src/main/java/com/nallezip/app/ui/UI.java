/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app.ui;

import com.nallezip.app.huffman.HuffmanAlgo;
import com.nallezip.app.io.FileIO;
import com.nallezip.app.lempelziv.LempelZivWelchAlgo;
import com.nallezip.app.util.DiyArrayList;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tallbera
 */
public class UI {

    private static final String ALGO_HUFFMAN = "huffman";
    private static final String ALGO_LZW = "lzw";

    boolean encrypt = true;
    String algo;

    public UI(String[] args) {
        try {
            boolean valid = readAndValidateParam(args);
            if (!valid) {
                return;
            }

            FileIO inputFile = new FileIO(args[2]);
            byte[] input = inputFile.readFile();
            FileIO outputFile = new FileIO(args[3]);

            if (algo.equals(ALGO_HUFFMAN)) {
                HuffmanAlgo algo = new HuffmanAlgo();
                byte[] result;
                if (encrypt) {
                    result = algo.encodeString(new String(input));
                } else {
                    String resultString = algo.decodeString(input);
                    result = resultString.getBytes();
                }
                outputFile.writeFile(result);
            } else {
                LempelZivWelchAlgo algo = new LempelZivWelchAlgo();
                byte[] result;
                if (encrypt) {
                    result = algo.encodeString(new String(input));
                } else {
                    String resultString = algo.decodeString(input);
                    result = resultString.getBytes();
                }
                outputFile.writeFile(result);

            }
        } catch (IOException ex) {
            System.out.println("Error processing file: " + ex.getMessage());
            ex.printStackTrace();
            outputInfo();
        }

    }

    private boolean readAndValidateParam(String[] args) {
        if (args == null || args.length != 4) {
            System.out.println("Wrong parameter count");
            outputInfo();
            return false;
        }

        if (args[0].equalsIgnoreCase("encrypt")) {
            encrypt = true;
        } else if (args[0].equalsIgnoreCase("decrypt")) {
            encrypt = false;
        } else {
            System.out.println("Wrong operation parameter");
            outputInfo();
            return false;
        }

        if (args[1].equalsIgnoreCase(ALGO_HUFFMAN)) {
            algo = ALGO_HUFFMAN;
        } else if (args[1].equalsIgnoreCase(ALGO_LZW)) {
            algo = ALGO_LZW;
        } else {
            System.out.println("Wrong algorithm name");
            outputInfo();
            return false;
        }
        return true;

    }

    public void start() {

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

                if (packedOne.equals("Lempel")) {
                    System.out.println("Please write String you want to pack: ");
                    String packThis = scanner.nextLine();
                    LempelZivWelchAlgo algo = new LempelZivWelchAlgo();
                    byte[] packed = algo.encodeString(packThis);
                    //mitäs sitten? Kerrotaanko paljonko pakkasi?

                }

            }

        }
    }

    private void outputInfo() {
        System.out.println("Usage: nallezip encrypt/decrypt algorithm input-file output-file.\nValid algorithm names: huffman, lzw");
    }

}
