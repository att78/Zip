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
public class DiySet<Key> {

    private static final int SIZE = 512;
    private final Object table[];

    public DiySet() {
        this.table = new Object[SIZE];
    }

 

    public Object[] getTable() {
        return table;
    }

}
