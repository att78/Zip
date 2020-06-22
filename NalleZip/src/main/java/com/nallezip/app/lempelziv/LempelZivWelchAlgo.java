/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app.lempelziv;

import com.nallezip.app.util.DiyArrayList;
import com.nallezip.app.util.DiyHashMap;
import com.nallezip.app.util.DiyStringBuilder;

/**
 * Luokka toteuttaa Lempel-Ziv-Welch-algoritmin, joka on yksi niistä Lempel
 * Ziv-algoritmeina tunnetuista algoritmeista
 *
 * @author tallbera
 */
public class LempelZivWelchAlgo {

    private DiyArrayList encoded = new DiyArrayList();
    private DiyHashMap<String, Short> library = new DiyHashMap();
    private DiyHashMap<Short, String> libraryDecoded = new DiyHashMap();
    private final short SIZE = 512;

    public LempelZivWelchAlgo() {
    }

    /**
     * Metodi enkoodaa annetun string-muotoisen syötteen. Käyttää apumetodeina
     * createLibrary- ja fillLibrary-metodeita.
     *
     * @param string pakattava String
     * @return pakatun viestin
     */
    public byte[] encodeString(String string) {

        createEncodeLibrary();
        fillLibrary(string);
        byte[] result = listToBytes();
        return result;
    }

    private byte[] listToBytes() {
        byte[] result = new byte[encoded.size() * 2];
        Short[] numbers = encoded.getDiyArray();
        for (int i = 0, j = 0; i < encoded.size(); i++) {
            byte[] bytes = shortToByteArray(numbers[i]);
            for (int k = 0; k < 2; k++) {
                result[j++] = bytes[k];
            }
        }
        return result;
    }

    /**
     * Luodaan enkoodauksessa käytetty kirjastot.
     *
     *
     */
    public void createEncodeLibrary() {
        library = new DiyHashMap();
        for (short i = 0; i < SIZE; i++) {
            library.put("" + (char) i, i);
        }
    }

    /**
     * Luodaan dekoodauksessa käytetty kirjastot.
     *
     *
     */
    public void createDecodeLibrary() {
        libraryDecoded = new DiyHashMap();
        for (short i = 0; i < SIZE; i++) {
            libraryDecoded.put(i, "" + (char) i);
        }
    }

    /**
     * Enkoodauksessa käytettävän kirjaston täyttäminen annetun syötteen
     * pohjalta
     *
     * @param string viesti
     */
    public void fillLibrary(String string) {
        String a = string.substring(0, 1);
        short size = SIZE;
        for (int i = 1; i < string.length(); i++) {
            String b = string.substring(i, i + 1);
            String ab = a + b;
            if (library.containsKey(ab)) {
                a = ab;
            } else {

                encoded.add(library.get(a));
                library.put(ab, size++);
                a = "" + b;
            }
        }
        encoded.add(library.get(a));

    }

    /**
     * Metodi dekoodaa encodeString-metodin tekemän listan ja palauttaa
     * alkuperäisen Stringin. Käyttää apumetodina decodeLoop-metodia.
     *
     * @return puretun viestin
     */
    public String decodeString(byte[] encodedBytes) {
        createDecodeLibrary();
        setEncodedList(encodedBytes);
        Short firstOne = encoded.getFirst();
        int first = (int) firstOne;
        String answer = "" + (char) first;
        DiyStringBuilder builder = new DiyStringBuilder(answer);
        decodeLoop(builder, answer);
        return builder.toString();
    }

    private void setEncodedList(byte[] encodedBytes) {
        encoded = new DiyArrayList();
        for (int i = 0; i < encodedBytes.length; i++) {
            short number = bytesToShort(encodedBytes[i], encodedBytes[++i]);
            encoded.add(number);
        }

    }

    /**
     * Metodi toimii apumetodina decodeString-metodille ja nimensä mukaisesti
     * hoitaa enkoodatun listan läpikäynnin.
     *
     * @param builder palautettavan viestin kasaaja
     * @param answer pakkauksen ensimmäinen
     */
    public void decodeLoop(DiyStringBuilder builder, String answer) {
        short size = SIZE;

        for (int i = 1; i < encoded.size(); i++) {
            Short number = encoded.get(i);
            String s = "";
            if (libraryDecoded.containsKey(number)) {
                s = libraryDecoded.get(number);
            } else if (number == size) {
                s = answer + answer.charAt(0);
            }
            builder.append(s);
            String string = answer + s.charAt(0);
            libraryDecoded.put(size++, string);
            answer = s;
        }
    }

    public DiyHashMap<String, Short> getLibrary() {
        return library;
    }

    public DiyHashMap<Short, String> getLibraryDecoded() {
        return libraryDecoded;
    }

    public DiyArrayList getEncoded() {
        return encoded;
    }

    private byte[] shortToByteArray(int number) {
        return new byte[]{
            //            (byte) ((number >> 24) & 0xff),
            //            (byte) ((number >> 16) & 0xff),
            (byte) ((number >> 8) & 0xff),
            (byte) (number)};
    }

    private short bytesToShort(byte byte1, byte byte2) {
        return (short) ((0xff & byte1) << 8
                | (0xff & byte2));
//                | (0xff & byte3) << 8
//                | (0xff & byte4));
    }

}
