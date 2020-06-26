
package com.nallezip.app.util;

/**
 * itsetehty ByteArray-luokka
 *
 * @author tallbera
 */
public class DiyByteArray {

    private byte[] bytes;
    private int byteIndex = 0;
    private int bitIndex = 0;

    public DiyByteArray(int size) {
        bytes = new byte[size];
    }
    
    
    

    /**
     * kirjoittaa bitin taulukkoon.
     *
     * @param value
     */
    public void writeBit(boolean value) {
        int byteValue = bytes[byteIndex] & 0xFF;
        byteValue *= 2;
        if (value) {
            byteValue++;
        }
        bytes[byteIndex] = (byte) byteValue;
        if (bitIndex == 7) {
            bitIndex = 0;
            byteIndex++;
        } else {
            bitIndex++;
        }
    }

    /**
     * kirjoittaa byten taulukkoon.
     *
     * @param byteValue
     */
    public void writeByte(byte byteValue) {
        bytes[byteIndex++] = byteValue;
    }

    /**
     * metodi tutkii DiyByteArray:n koon
     *
     * @return DiyByteArrayn pituus
     */
    public int getSize() {
        int size = byteIndex;
        if (bitIndex > 0) {
            size++;
        }
        return size;
    }

    /**
     * palauttaa byte-taulukon.
     *
     * @return
     */
    public byte[] getBytes() {
        byte[] result = new byte[getSize()];
        int i = 0;
        for (; i < byteIndex; i++) {
            result[i] = bytes[i];
        }
        if (bitIndex > 0) {
            int value = bytes[i] & 0xFF;;
            for (int j = bitIndex; j < 8; j++) {
                value *= 2;
            }
            result[i] = (byte) value;

        }

        return result;
    }

}
