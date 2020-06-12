/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app.util;

import com.nallezip.app.huffman.HuffmanNode;

/**
 * PriorityQueuen Huffman-koodissa korvaava minimikeko.
 *
 * @author tallbera
 */
public class DiyHeap {

    private int size = 0;
    private HuffmanNode[] diyHeap = new HuffmanNode[512]; // pitäiskö olla 513 eli indeksille yksi paikka?
    private int maxSize = 512;

//    private void diyHeapify(int index) {
//
//    }

    private int mom(int number) {

        return number / 2;
    }

    private int leftChild(int mom) {

        return (2 * mom);
    }

    private int rightChild(int mom) {

        return (2 * mom) + 1;

    }

    public void add(HuffmanNode node) {

        if (size >= maxSize) {
            return;
        }
        diyHeap[++size] = node;
        int now = size;

        while (diyHeap[mom(now)].getPosition() > diyHeap[now].getPosition()) {
            swapNodes(now, mom(now));
            now = mom(now);
        }
    }

    public void swapNodes(int first, int second) {
        HuffmanNode firstNode = diyHeap[first];
        HuffmanNode secondNode = diyHeap[second];

        diyHeap[first] = secondNode;
        diyHeap[second] = firstNode;
    }

    //
    private boolean isItLeaf(HuffmanNode node) {
        int pos = node.getPosition();

        if (pos <= size && pos >= (size / 2)) {
            return true;
        }
        return false;
    }

    private void diyHeapify(HuffmanNode node) {

        if (!isItLeaf(node)) {
            HuffmanNode Leftie = node.getLeft();
            HuffmanNode Rightie = node.getRight();
            int mom = node.getPosition();
            int childLeft = leftChild(mom);
            int childRight = rightChild(mom);
            if (mom > childRight || mom > childLeft) {
                if (childLeft < childRight) {
                    swapNodes(mom, childLeft);
                    diyHeapify(Leftie);
                } else {
                    swapNodes(mom, childRight);
                    diyHeapify(Rightie);
                }
            }

        }

    }

    public HuffmanNode poll() {

        HuffmanNode polled = diyHeap[1];
        diyHeap[1] = diyHeap[size--];
        diyHeapify(diyHeap[1]);

        return polled;
    }

}
