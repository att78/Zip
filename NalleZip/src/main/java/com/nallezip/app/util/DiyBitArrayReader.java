
package com.nallezip.app.util;

/**
 * Luokka lukee taulukkoa bitti kerrallaan.
 *
 * @author tallbera
 */
public class DiyBitArrayReader {

    private byte[] bytes;
    private int byteIndex = 0;
    private int bitIndex = 0;

    /**
     * konstruktorissa asetaan luettava taulukko.
     *
     * @param bytes
     */
    public DiyBitArrayReader(byte[] bytes) {
        this.bytes = bytes;
    }

    /** Metodi on bitinlukija.
     *palauttaa true, jos löytyi 1 ja false, jos löytyi 0
     * @return
     */
    public boolean readBit() {
        int value = bytes[byteIndex] & 0xFF;
        int max = 128;
        for (int i = 0; i < bitIndex; i++) {
            if (value >= max) {
                value -= max;
            }
            max = max / 2;
        }
        if (bitIndex == 7) {
            bitIndex = 0;
            byteIndex++;
        } else {
            bitIndex++;
        }

        if (value >= max) {
            return true;
        }

        return false;
    }

    public int getByteIndex() {
        return byteIndex;
    }
    
    /**
     * palauttaa tiedon siitä, onko Byte pienempi kuin 8 tavua.
     * @return 
     */
    public boolean partialByte() {
        return bitIndex > 0;
    }

    public void setByteIndex(int byteIndex) {
        this.byteIndex = byteIndex;
    }

}
