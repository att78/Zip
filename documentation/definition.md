# NalleZip

Projektin tavoitteena on tutkia pakkausalgoritmien toimintaa. Tavoitteena on rakentaa tietoa hävittämätön pakkausalgoritmi. Pakkausalgoritmit ovat mielenkiintoisia, sillä ennen tätä harjoitustyötä minulla ei ole niiden toiminnasta mitään käsitystä.

Projektin toteutuskieli on java. Ensimmäinen työn alle otettava algoritmi on Huffman, mikä valikoitui kurssin aihevinkkien perusteella. Huffman-algoritmi käyttää tallentamiseen kirjastolle puurakennetta. Tieto puretaan puusta kekorakenteen avulla. Oikein toimiessaan tämä pakkaa tiedon hävittämättä sitä. Eli kaikki pakattu on palautettavissa alkuperäistä vastaavaan muotoon.

Pohdinnan alla on vielä se, mitä muita voisi kurssin puitteissa tutkiskella.(eli muita mielenkiintoisia vaihtoehtoja saa ehdottaa). Mahdollisia vaihtoehtoja muiden toteutettavien joukkoon on ainakin kurssin vinkeissä mainittu Lempel Ziv.

Alla on esitelty alustava luokkakaavio. Siinä ei ole esitelty luokkien sisäisestä olemuksesta, sillä harjoitustyön edetessä luokkien sisällä tapahtuu rajua myllerrystä javan valmiiden rakenteiden korvautuessa omilla rakenteilla. Alkuvaiheessa suunnitelmissa ei ole varmaa käsitystä siitä, millaisia ne omat rakenteet tulevat olemaan. Siksipä tässä on esiteltynä lähinnä konseptuaalisella tasolla se, millaisia luokkia sovelluksessa tullee olemaan.
Alustava Luokkakaavio:

![Alustava luokkakaavio](https://github.com/att78/NalleZip/blob/master/documentation/NalleZip.jpg)


## Lähteitä:

Huffman:

https://en.wikipedia.org/wiki/Huffman_coding

https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/

Lempel Ziv

http://www-math.mit.edu/~shor/PAM/lempel_ziv_notes.pdf

Muuta jännää:

https://www.sciencedirect.com/topics/computer-science/compression-algorithm
