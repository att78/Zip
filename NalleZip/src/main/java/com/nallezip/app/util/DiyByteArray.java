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
public class DiyByteArray {

    private byte[] bytes;
    private int byteIndex = 0;
    private int bitIndex = 0;

    public DiyByteArray(int size) {
        bytes = new byte[size];
    }

    public void writeBit(boolean value) {
        int byteValue = bytes[byteIndex] & 0xFF;
        //System.out.println("Add bit " + value + " to value " + byteValue + " bit index is " + bitIndex);
        byteValue *= 2;
        if (value) {
            byteValue++;
        }
        bytes[byteIndex] = (byte) byteValue;
        //System.out.println("Result value: " + byteValue);
        if (bitIndex == 7) {
            bitIndex = 0;
            byteIndex++;
        } else {
            bitIndex++;
        }
    }

    public void writeByte(byte byteValue) {
        bytes[byteIndex++] = byteValue;
    }

    public int getSize() {
        int size = byteIndex;
        if (bitIndex > 0) {
            size++;
        }
        return size;
    }

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
