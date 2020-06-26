# NalleZipin käyttöohje

NalleZipillä ei ole graafista käyttöliittymää, vaan sitä käytetään komentoriviltä. NalleZip toimii varmimmin englanninkielisellä aakkostolla ja yleisimmillä erikoismerkeillä Huffmanin osalta. Huffman ei osaa ääkkösiä eikä skandinaavisia merkkejä. LZW puolisko toimii laajemmalla merkistöllä, esimerkiksi ääkkösillä. Siinäkin tulee kuitenkin esimerkiksi tyyliteltyjen erikoismerkkien kanssa helposti ongelmia.

1. Mene komentorivillä kansioon, jossa NalleZip.jar  on. Huolehdi, että pakattava tai purettava tiedosto on samassa kansiossa NalleZipin kanssa.

2. Sovelluksen voi käynnistää komennolla cubblissa ./NalleZip.jar . Muissa linuxeissa toimii ainakin  java -jar Nallezip.jar. Windows yhteensopivuutta ei ole testattu. Syöttämällä pelkästään edellämainitun ohjelma ei kuitenkaan pakkaa mitään vaan antaa käyttöohjeet. Käyttöohjeet ovat hyvin
minimalistiset, ja alla on esitelty käyttö laajemmin. NalleZipille annetaan 4 parametria, jotka on annettava oikeassa järjestyksessä ja eroteltava välilyönnillä.

  - Ensimmäinen parametri on päätös encrypt/decrypt. Encrypt pakkaa ja decrypt purkaa.
  
  - Seuraava parametri on kummalla algoritmilla pakkaus tai purkaminen tehdään. huffman tarkoittaa Huffman-algoritmia ja lzw tarkoittaa Lempel Ziv Welch-algoritmia.
  
  - Kolmas parametri annettava parametri on input-file, joka on siis jo olemassaoleva tiedosto.
  
  - Neljäs parametri on nimi tiedostolle johon sovelluksen halutaan kirjoittavan lopputulos. Tiedoston ei tarvitse olla olemassa. Tämän nimen käyttäjä saa keksiä itse.
  
3. Sovellus luo tiedoston, johon se kirjoittaa, samaan kansioon, jossa sovellus itsekin on.

