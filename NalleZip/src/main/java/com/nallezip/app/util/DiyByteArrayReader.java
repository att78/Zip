
package com.nallezip.app.util;

/**
 * Luokka toimii työkaluna, jonka avulla saa luettua ByteArraysta aina seuraavan
 * byten.
 *
 * @author tallbera
 */
public class DiyByteArrayReader {

    /**
     * luettava taulukko
     */
    private byte[] bytes;
    /**
     * indeksi, josta luetaan. Alussa luetaan ensimmäisestä indeksistä eli
     * nollasta.
     */
    private int byteIndex = 0;

    /**
     * konstruktorissa määritetään luettava byte-taulukko
     *
     * @param bytes
     */
    public DiyByteArrayReader(byte[] bytes) {
        this.bytes = bytes;
    }

    /**
     * metodi lukee byten luokkamuuttujana olevasti indeksistä ja lisää indeksiä
     * yhdellä.
     *
     * @return luettu byte
     */
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
