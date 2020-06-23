# NalleZip

Harjoitustyössä on tarkoitus tutkia pakkausalgoritmeja, jotka eivät hävitä tietoa(lossless compress). Näiden algoritmien jäljiltä on mahdollista purkaa pakattu viesti niin, että purettu viesti on sama kuin alkuperäinen viesti. 
Projektin toteutuskieli on java. Työssä toteutetaan 2 algoritmia: Huffman algoritmi ja Lempel Ziv Welch. Algoritmit valikoituivat pitkälti kurssisivuilla olleiden suositusten pohjalta. Huffman valikoitui suoraan kurssisivujen pohjalta. Lempel Ziv Welchin valitsin sen jälkeen, kun olin lukenut erilaisista Lempel Ziv-tyyppisistä algoritmeista. LZW vaikutti helpoimmalta ymmärtää, ja siitä löytyi hyvä yhdysvaltalaisen Kolumbian yliopiston artikkeli, jonka pohjalta oli helppo lähteä liikkeelle.

Ensimmäinen työn alle otettava algoritmi on Huffman, mikä valikoitui kurssin aihevinkkien perusteella. Huffman-algoritmi käyttää tallentamiseen kirjastolle puurakennetta. Tieto puretaan puusta kekorakenteen avulla. Oikein toimiessaan Huffman-algoritmi pakkaa tiedon hävittämättä sitä. Huffman-algoritmin aikavaatimus on O(nlogn) gavidyalay:n artikkelin mukaan. Huffman-algoritmissa rakennetaan puurakenne, jonka avulla tieto tallennetaan. Aikavaatimus muodostuu puusta minimi-nodejen erottamisesta ja minimikeon läpikäynnistä. Nodejen erottaminen tapahtuu ajassa O(n) ja minimikeon läpikäynti ajassa O(log(n)).

Toinen toteutettava algoritmi on Lempel Ziv Welch. Lempel Ziv Welchissa on kiinteä kirjasto, joka rakennetaan ennen pakkausta. 
Wikipedian artikkelin mukaan Lempel Ziv Welchin aikavaatimus on O(n), sillä kirjasto on etukäteen koodattu, jolloin pakkaaminen tapahtuu lineaarisessa ajassa.

Alla on esitelty alustava luokkakaavio. Siinä ei ole esitelty mitään luokkien sisäisestä olemuksesta, eikä luokkakaaviossa käsitellä itsetehtyjä tietorakenteita. Tässä on esiteltynä lähinnä konseptuaalisella tasolla se, millaisia luokkia sovelluksessa tullee olemaan.
Alustava Luokkakaavio:

![Alustava luokkakaavio](https://github.com/att78/NalleZip/blob/master/documentation/NalleZipUpdate1.jpg)

Molemmat algoritmit saavat syötteinä pienehköjä tiedostoja.

## Lähteitä:

Huffman:

https://en.wikipedia.org/wiki/Huffman_coding

https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/

https://www.gatevidyalay.com/huffman-coding-huffman-encoding/

Lempel Ziv

http://www-math.mit.edu/~shor/PAM/lempel_ziv_notes.pdf

http://www.cs.columbia.edu/~allen/S14/NOTES/lzw.pdf

https://en.wikipedia.org/wiki/Lempel%E2%80%93Ziv%E2%80%93Welch

Muuta jännää:

https://www.sciencedirect.com/topics/computer-science/compression-algorithm
