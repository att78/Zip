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
    private int maxSize; //= 512;

//    private void diyHeapify(int index) {
//
//    }
    /**
     * Tyhjä konstruktori testausta varten
     */
    public DiyHeap() {

    }

    /**
     * Minimikeon konstruktori. Vielä tekeillä
     *
     * @param maxSize
     */
    public DiyHeap(int maxSize) {
        this.maxSize = maxSize;
        int heapMax = maxSize + 1;
        this.diyHeap = new HuffmanNode[heapMax];
        HuffmanNode node = new HuffmanNode();
        node.setPosition(Integer.MIN_VALUE); //no nysse toimii, mutta integer.Min_value on aika radikaali veto tähän käyttöön.
        diyHeap[0] = node;
    }

    /**
     * Noden vasemmanpuoleisen lapsen noden positio-arvon palauttava metodi
     *
     * @param mom Position-arvo nodelle, jolle tämä arvo lasketaan
     * @return
     */
    public int leftChild(int mom) {

        return (2 * mom);
    }

    /**
     * Noden oikeanpuoleisen lapsen noden positio-arvon palauttava metodi
     *
     * @param mom
     * @return
     */
    public int rightChild(int mom) {

        return (2 * mom) + 1;

    }

    /**
     * palauttaa vanhempi-noden positio-arvon
     *
     * @param number
     * @return
     */
    public int mom(int number) {

        return number / 2;
    }

    public int getSize() {
        return size;
    }

    /**
     * lisää kekoon yhden huffmanNoden
     *
     * @param node
     */
    public void offer(HuffmanNode node) {

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

        if (first == second) {
            return;
        }

        HuffmanNode firstNode = diyHeap[first];
        HuffmanNode secondNode = diyHeap[second];

        diyHeap[first] = secondNode;
        diyHeap[second] = firstNode;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    //
    private boolean isItLeaf(int index) {

        if (index <= size && index > (size / 2)) {
            return true;
        }
        return false;
    }

    private void diyHeapify(int index) {

//        if (!isItLeaf(index)) {
        int mom = diyHeap[index].getPosition();

        if (index > size) {
            return;
        }

        int minimumIndex = index;
        int childLeftIndex = leftChild(index);
        HuffmanNode leftChild = diyHeap[childLeftIndex];
        int childRightIndex = rightChild(index);
        HuffmanNode rightChild = diyHeap[childRightIndex];
        HuffmanNode minNode = diyHeap[minimumIndex];
        //toisenlainen iffittely, mutta ei näytä toimivan tämäkään.
        //jostain tulee nulleja? Nullien 
        if (leftChild != null && rightChild != null && rightChild != null) {
            if ((diyHeap[minimumIndex].getPosition() > diyHeap[childLeftIndex].getPosition()) && childLeftIndex <= size) {
                minimumIndex = childLeftIndex;
            }

            if (diyHeap[minimumIndex].getPosition() > diyHeap[childRightIndex].getPosition() && childRightIndex <= size) {
                minimumIndex = childRightIndex;
            }

            if (index != minimumIndex) {
                swapNodes(index, minimumIndex);
                diyHeapify(minimumIndex);
            }
        }

//vanha iffittely
//            if (mom > rightChild.getPosition() || mom > leftChild.getPosition()) {
//                if (leftChild.getPosition() < rightChild.getPosition()) {
//                    swapNodes(index, childLeftIndex);
//                    diyHeapify(childLeftIndex);
//                } else {
//                    swapNodes(index, childRightIndex);
//                    diyHeapify(childRightIndex);
//                }
//            }
//        }
    }

    public HuffmanNode poll() {

        HuffmanNode polled = diyHeap[1];
        diyHeap[1] = diyHeap[size--];
        if (size > 2) {
            diyHeapify(1);
        } else if (size == 2) {
            if (diyHeap[1].getPosition() > diyHeap[2].getPosition()) {
                swapNodes(1, 2);
            }
        }

        return polled;
    }

    public int size() {

        return size;
    }
}
