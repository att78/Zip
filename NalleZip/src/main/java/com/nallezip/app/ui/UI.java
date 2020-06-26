
package com.nallezip.app.ui;

import com.nallezip.app.huffman.HuffmanAlgo;
import com.nallezip.app.io.FileIO;
import com.nallezip.app.lempelziv.LempelZivWelchAlgo;

import java.io.IOException;

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
            long start = System.currentTimeMillis();
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
            long stop = System.currentTimeMillis();
            long time = stop - start;
            //long arvoja voidaan käyttää nopeuden testaamiseen.
            //System.out.println("operation took " + time + " ms");
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

    private void outputInfo() {
        System.out.println("Usage: nallezip encrypt/decrypt algorithm input-file output-file.\nValid algorithm names: huffman, lzw");
    }

}
