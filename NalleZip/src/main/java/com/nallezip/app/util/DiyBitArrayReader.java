/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app.util;

/**
 *
 * @author tallbera
 */
public class DiyBitArrayReader {

    private byte[] bytes;
    private int byteIndex = 0;
    private int bitIndex = 0;

    public DiyBitArrayReader(byte[] bytes) {
        this.bytes = bytes;
    }

    public boolean readBit() {
        int value = bytes[byteIndex] & 0xFF;
        //System.out.println("Read bit " + (bitIndex+1) + " from byte with value " + value);
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
            //System.out.println("Bit value = true");
            return true;
        }
        //System.out.println("Bit value = false");
        return false;
    }

    public int getByteIndex() {
        return byteIndex;
    }

    public boolean partialByte() {
        return bitIndex > 0;
    }

    public void setByteIndex(int byteIndex) {
        this.byteIndex = byteIndex;
    }

}
