# Toteutuksesta yleisesti

NalleZipillä voi zipata tekstimuotoisia tiedostoja. Ohjelmaa on tarkoitus käyttää komentoriviltä. Sovelluksen toiminnallisuuden huomioonottaen graafisella
käyttöliittymällä ei voi saavuttaa merkittävää etua tekstikäyttöliittymään verrattuna.


## Huffman

Huffman-koodaus käyttää luokkia Huffmantree, HuffmanNode ja itsetehtyjä tietorakenteita DiyHashMap, DiyPriorityQueue(ei vielä toteutettu) ja DiyStringBuilder(ei vielä totetutettu). Huffman-algoritmi tuottaa periaatteessa dynaamisesti annetusta syötteestä pakkauksen.

## Lempel Ziv Welch

Lempel Ziv Welch-algoritmi toimii luokalla LempelZivWelchAlgo. Luokan createLibraries-metodilla luodaan pakkaamisessa ja purkamisessa käytetyt kirjastot. Vasta sen jälkeen käytetään niitä syötteille.
