# Toteutuksesta yleisesti

NalleZipillä voi zipata tekstimuotoisia tiedostoja. Ohjelmaa on tarkoitus käyttää komentoriviltä. Sovelluksen toiminnallisuuden huomioonottaen graafisella
käyttöliittymällä ei voi saavuttaa merkittävää etua tekstikäyttöliittymään verrattuna.

![Luokkakaavio](https://github.com/att78/NalleZip/blob/master/documentation/NalleZip_toteutunut.png)


## Huffman

Huffman-koodaus käyttää luokkia Huffmantree, HuffmanNode ja itsetehtyjä tietorakenteita DiyHashMap, DiyPriorityQueue. Käytössä on myös itsetehty luokka DiyStringBuilder, joka korvaa javan StringBuilder-luokan. Huffman-algoritmi tuottaa periaatteessa dynaamisesti annetusta syötteestä pakkauksen.

## Lempel Ziv Welch

Lempel Ziv Welch-algoritmi toimii luokalla LempelZivWelchAlgo. Algoritmi käyttää itsetehtyjä tietorakenteita DiyArrayList ja DiyHashMap. Tämän lisäksi luokassa käytetään itsetehtyä luokkaa DiyStringBuilder. Luokan createLibraries-metodilla luodaan pakkaamisessa ja purkamisessa käytetyt kirjastot. Vasta sen jälkeen käytetään niitä syötteille.



## Lähteitä:

Huffman:

https://en.wikipedia.org/wiki/Huffman_coding

https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/

Lempel Ziv

http://www-math.mit.edu/~shor/PAM/lempel_ziv_notes.pdf

http://www.cs.columbia.edu/~allen/S14/NOTES/lzw.pdf

Muuta jännää:

https://www.sciencedirect.com/topics/computer-science/compression-algorithm
