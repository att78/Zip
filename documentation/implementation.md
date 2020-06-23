# Toteutuksesta yleisesti

Ohjelman rakenteessa toteutetut algoritmit Huffman ja Lempel Ziv Welch ovat ovat omissa paketeissaan. Itsetoteutetut tietorakenteet ja apuluokat ovat omassa util-paketissaan. Käyttöliittymä on ui-paketissa ja Tiedostojen käsittely on eriytetty io-pakettiin. Huffman-algoritmi toteutetaan kahden luokan, HuffmanAlgo:n ja HuffmanNode:n avulla. Luokka käyttää itsetehtyjä tietorakenteita DiyHashMap, DiyHeap ja DiyByteArray. DiyHashMap hoitaa javan HashMapin ja DiyHeap PriorityQueuen tehtäviä. DiyByteArray paketoi ByteArrayn ja helpottaa toimintaa. Sekin on toimintansa perusteella laskettavissa yksinkertaiseksi tietorakenteeksi. Näiden lisäksi Huffman-algoritmin toteutuksessa on käytetty runsaasti itsetehtyjä rakenteita, jotka korvaavat javan valmiita rakenteita; DiyStringBuilder, DiySet, DiyByteArrayReader ja DiyBitReader.

Lempel Ziv Welch algoritmin toteuttaa yksi luokka, LempelZivWelchAlgo. Algoritmin toiminnassa käytetään itsetehdyistä tietorakenteista DiyHashMapia ja DiyArrayListia. Lisäksi algoritmin toteutuksessa on mukana apuluokka DiyStringBuilder. Allaoleva kaavio antaa yleiskuvan sovelluksen rakenteesta ja toteutettujen luokkien keskinäisestä suhteesta.

![Luokkakaavio](https://github.com/att78/NalleZip/blob/master/documentation/NalleZip_toteutunut.png)

Ohjelmaa on tarkoitus käyttää komentoriviltä eli käyttöliittymä on tekstikäyttöliittymä.

Yleisenä huomiona voi myös todeta, että sovellus on pyritty toteuttamaan käyttäen checkstyle-vaatimuksia, joissa metodin pituus sallittu maksimipituus on 20, yksittäisen luokan tiedostopituus 600 ja muutoin noudatetaan perusmuotoiluja. Tähän on myös pääpiirteittäin päästy.



O-analyyseja
## Huffman


## Lempel Ziv Welch



## Lähteitä:

Huffman:

https://en.wikipedia.org/wiki/Huffman_coding

https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/

Lempel Ziv

http://www-math.mit.edu/~shor/PAM/lempel_ziv_notes.pdf

http://www.cs.columbia.edu/~allen/S14/NOTES/lzw.pdf

Muuta jännää:

https://www.sciencedirect.com/topics/computer-science/compression-algorithm
