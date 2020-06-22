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
public class DiyByteArrayReader {

    private byte[] bytes;
    private int byteIndex = 0;

    public DiyByteArrayReader(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte readByte() {
        return bytes[byteIndex++];
    }

    public int getByteIndex() {
        return byteIndex;
    }

    public void setByteIndex(int byteIndex) {
        this.byteIndex = byteIndex;
    }
}
