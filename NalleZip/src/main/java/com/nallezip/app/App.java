
package com.nallezip.app;


import com.nallezip.app.ui.UI;


/**
 * Käynnistävä luokka
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
