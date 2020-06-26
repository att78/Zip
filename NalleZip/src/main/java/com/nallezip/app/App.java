/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app;

import com.nallezip.app.huffman.HuffmanAlgo;
import com.nallezip.app.huffman.HuffmanNode;
import com.nallezip.app.lempelziv.LempelZivWelchAlgo;
import com.nallezip.app.ui.UI;
import com.nallezip.app.util.DiyArrayList;
import com.nallezip.app.util.DiyHashMap;

/**
 *
 * @author tallbera
 */
public class App {

    public static void main(String[] args) {

        //testin arvoa muuttamalla voi halutessaan testata myös netBeansilla.
        //UI:hin pitää siinä tapauksessa lisätä tulosteita.
        boolean test = false;

        if (test && (args == null || args.length == 0)) {
            args = new String[]{"encrypt", "huffman", "test.txt", "test.huff"};
            new UI(args);

            args = new String[]{"decrypt", "huffman", "test.huff", "test-decrypted-huff.txt"};
            new UI(args);

            args = new String[]{"encrypt", "lzw", "test.txt", "test.lzw"};
            new UI(args);

            args = new String[]{"decrypt", "lzw", "test.lzw", "test-decrypted-lzw.txt"};
            new UI(args);

        } else {
            new UI(args);
        }

    }

}
