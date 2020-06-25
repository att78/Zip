# Testaus 

Työtä on testattu etenemisen mukaan esimerkkisyötteillä ja JUnit-testeillä.

## Yleisesti

Testaus on edennyt työn etenemisen myötä. Kaikkea mitä on tehty, on toteutetuksen yhteydessä testattu ensin manuaalisesti. Kun ongelmia on ratkottu
mahdollisimman pian niiden syntyhetkestä, on pystytty välttämään tilanne, jossa koodiin liittyvät ongelmat alkavat kasautua. Kun luokat
on olleet ns. periaatteessa toimivia, on niitä vielä testattu JUnit-testeillä pyrkimyksenä varmistaa luokkien metodien toiminnallisuus.
Tarvittaessa koodiin on lisätty System.out.println-kutsuja, joilla on tarkasteltu metodin sisäistä toimintaa.

## JUnit-testaus

Lähtökohtaisesti luokista on tarkoitus testata kaikki metodit poislukien getterit ja setterit. Konstruktorit testataan ainoastaan siinä
tapauksessa, että niiden toiminnassa on jotakin poikkeuksellisen monimutkaista tai virhealtista. Osa toString-metodeista testataan, sillä niiden toiminta 
saattaa olla joko toiminnan tai muun testauksen kannalta kriittistä. Tavoitteena on varmistaa, että metodit
toimivat niille tarkoitetulla tavalla, käydä läpi metodien koodin laatu ja ettei piiloon jää virhetilanteita, joita ei ole tullut ajatelleeksi. JUnit-testit on tehty kullekin luokalle samalla viikolla kuin luokat on luotu. Testeissä on paranneltavaa ja niitä onkin tarkoitus kehittää kattavammiksi kun varmuus luokkien lopullisesta olemuksesta kasvaa. Tällä hetkellä testien rivikattavuus on korkea, mutta kaikkia haaroja ei metodeista testata. 

Tällä hetkellä JUnit-testauksen rivikattavuus on korkea, mutta haaraumakattavuus on alempi.
![GeneralView](https://github.com/att78/NalleZip/blob/master/documentation/pictures/generalView.png)

Huffman-algoritmin toiminta käyttää itsetehdyistä luokista tällä hetkellä HuffmanAlgo- ja HuffmanNode-luokkia. HuffmanNode-luokasta on testattu kaikkia metodeja, mutta HuffmanAlgossa on vielä hieman aukkoja.
![Huffman](https://github.com/att78/NalleZip/blob/master/documentation/pictures/huffman.png)


Lempel Ziv Welch-algoritmin toiminnasta vastaa yksi luokka. Lisäksi Lempel Ziv Welchissä on otettu käyttöön DiyHashMap hoitamaan alussa generoitavien kirjastojen toimintaa. Manuaalisessa kokeilussa luokka näyttäisi toimivan, mutta JUnit testauksessa metodi ei toimi. Asiaa joutuu vielä tarkastelemaan tarkemmin.
![Lempel Ziv Welch](https://github.com/att78/NalleZip/blob/master/documentation/pictures/lempel.png)


DiyHashmapiin liittyviä luokkia on 2, DiyHashMap ja DiyContent. DiyContent:ille ei ole tehty testejä, sillä luokalla on ainoastaan konstuktori ja automaattisesti generoituja gettereitä ja settereitä, joiden testaaminen ei ole järkevää.

![DiyHashMap](https://github.com/att78/NalleZip/blob/master/documentation/pictures/diyHash.png)


## Suorituskyvyn testaus

Pakkausalgoritmin suorituskyvyn kannalta oleellisia mittareita ovat nopeus ja pakkautuvuus. Käsitellään ensin pakkautuvuutta. Tyypillisesti pakkautuvuus on suurta, jos pakattavan tiedoston sisäinen toisteisuus on suuri ja vastaavasti tehokas pakkaaminen on haastavaa, jos toisteisuutta on vain vähän. Pakkautuvuutta mitattiin molemmille algoritmeille testisarjalla, jossa ei ollut toistuvia tiedostoja. Mukana oli muutama muukin teksti, mutta suurimmaksi osaksi testisarja sisälsi CNN:n sivuilta löytyviä kesäkuun 2020 poliittisia analyyseja. Tietenkin näissä oli yksittäisiä toistuvia asioita, kuten presidentti Trump, mutta kokonaisuutena analyysien aiheet kuitenkin vaihtelivat ja tarjosivat monenlaista sanastoa pakattavaksi.  Tiedostojen koko vaihteli lähtien n. 10k tavusta kasvaen lähes 100k tavuun ja molemmille algoritmeille käytettiin samaa testisarjaa. Huffman-algoritmi pakkasi tiedostojen koosta riippumatta hyvinkin saman verran. Pakkautuvuus oli n.57%, mikä asettuu tiralabran sivuilla asetetun tavoitteen 40-60% pakkausasteesta sisään, joskin yläpäähän. Tähän yläpäähän asettumiseen tietenkin vaikuttaa testimateriaalikin.

![HuffmanCompressionRate](https://github.com/att78/NalleZip/blob/master/documentation/pictures/huffmancompression.png)

Ylläolevassa kuvassa y-akselilla on pakkaus% ja x-akselilla pakattujen tiedostojen koko. Testisarjan perusteella voi tehdä johtopäätöksen, ettei tiedoston koko vaikuta Huffman-algoritmin pakkauskykyyn merkittävästi. Lempel Ziv Welch erosi tässä suhteessa Huffmanista merkittävästi. Lempel Ziv Welch-algoritmia käytetään tyypillisesti suurien tiedostojen pakkaamiseen, sillä jo teoriassa algoritmin kyky pakata suuria tiedostoja tehokkaasti on parempi kuin pienien tiedostojen. Tämä näkyi myös testituloksissa.

![LZWCompression](https://github.com/att78/NalleZip/blob/master/documentation/pictures/lzwCompressinRate.png)

Kuvasta voidaan todeta, että Lempel Ziv Welch-algoritmi käyttäytyi algoritmille asetettujen odotusten mukaisesti. Pienehköjen tiedostojen pakkaus alun poikkeusta lukuunottamatta jäi hyvin pieneksi, pakkausasteen ollessa n. 60-70% mutta suuremmilla tiedostoilla LZW muuttui Huffmania tehokkaammaksi. Kuvasta voidaan myös nähdä laskeva trendi ja tehdä johtopäätös, että testisarjan jatkaminen suurempaan suuntaan olisi todennäköisesti parantanut edelleen LZW-algoritmin pakkausastetta. Lempel Ziv Welchia testattiin myös lyhyesti testisarjalla, jossa oli paljon toisteisuutta. Suurten tiedostojen parempi pakkautuvuus verrattuna pieniin tiedostoihin näkyi myös tässä testisarjassa, mikä osoittaa algoritmin toimivan LZW:lle tyypillisellä tavalla.

![LZWeasy](https://github.com/att78/NalleZip/blob/master/documentation/pictures/lzwEasy.png)

Graafista voi vetää johtopäätöksen myös siitä, että pakattava materiaali vaikuttaa merkittävästi pakkaustulokseen. Paljon toisteisuutta sisältävä materiaali pakkautui selkeästi pienemmäksi ja jo melko pienillä tiedostoilla päästiin alle 50% pakkautuvuuteen.













Vanhaa---
Viikolla 4 on tehty alustavia testejä algoritmien suorituskykyyn liittyen. Testi koodi on oheisen linkin takana: 

[Testikoodi](https://github.com/att78/NalleZip/blob/master/documentation/performance.md)

Testituloksista on myös kuvakaappaus:

![Tuloksia](https://github.com/att78/NalleZip/blob/master/documentation/pictures/suorituskykyrapsa.png)

Pakkaus:





Tuloksista voi vetää muutamia johtopäätöksiä, mutta niihin tulee suhtautua varauksella. Huffman-algoritmi on tällä hetkellä vielä hieman vajaa toiminnaltaan. Algoritmi kyllä tallentaa HuffmanTree:hen oikein, mutta visuaalisen hahmottamisen vuoksi algoritmissa on käytetty String-outputtia. todellisuudessahan tämä valinta kasvatttaa eikä pakkaa alkuperäistä syötettä. HuffmanTreestä näkee kuitenkin sen, miten algoritmi pakkaa tietoa. Kunpa sitä pakattua tietoa vielä käytettäisiin dekoodauksenkin puolella. Valmiiseen pakkaukseen tulee sekä pakattu tieto, että pakkaukseen käytetty HuffmanTree. HuffmanAlgoon tulee todennäköisesti ihan reippaita muutoksia, jotta kaikki pyörii byteinä. Tämän vuoksi algoritmien pakkauksia ei keskenään kannata nyt vertailla.

LZW algoritmin pieni pakkaus on ihan ymmärrettävää, koska kyseessä on mm. kuvatiedostojen pakkaamisessa käytettävä algoritmi. Algoritmin hyödyllisyys tulee esiin vasta huomattavasti suuremmissa kokoluokissa.




Nopeus:

Testeissa Huffman oli selkeästi nopeampi pakkaamaan kuin LZW. Yksi selittävä tekijä on LZW:n pakkauksessa käytetty javan oma List<> ja ArrayList<>, joista kumpikaan ei ole nopea rakenne. LZW: algoritmin nopeutta ei ole vertailtu sen suhteen, onko käytössä javan HashMapin vai DiyHashMap.




