# NalleZip

Projektin toteutuskieli on java. Työssä toteutetaan 2 algoritmia: Huffman algoritmi ja Lempel Ziv Welch. Ensimmäinen työn alle otettava algoritmi on Huffman, mikä valikoitui kurssin aihevinkkien perusteella. Huffman-algoritmi käyttää tallentamiseen kirjastolle puurakennetta. Tieto puretaan puusta kekorakenteen avulla. Oikein toimiessaan Huffman-algoritmi pakkaa tiedon hävittämättä sitä. Huffman-algoritmin aikavaatimus on O(nlogn).

Toinen toteutettava algoritmi on Lempel Ziv Welch. Lempel Ziv Welchissa on kiinteä kirjasto, joka rakennetaan ennen pakkausta. 
Lempel Ziv Welchin aikavaatimus on O(n), sillä kirjasto on etukäteen koodattu. Alla on esitelty alustava luokkakaavio. Siinä ei ole esitelty mitään luokkien sisäisestä olemuksesta, eikä luokkakaaviossa käsitellä itsetehtyjä tietorakenteita. Tässä on esiteltynä lähinnä konseptuaalisella tasolla se, millaisia luokkia sovelluksessa tullee olemaan.
Alustava Luokkakaavio:

![Alustava luokkakaavio](https://github.com/att78/NalleZip/blob/master/documentation/NalleZipUpdate1.jpg)


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
