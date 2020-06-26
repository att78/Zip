# Testaus 

Harjoitustyön etenemisen myötä projektia on testattu etenemisen mukaan esimerkkisyötteillä ja JUnit-testeillä. Viikolla 4 testattiin myös nopeutta alustavasti. Seuraavilla viikoilla pakkautuvuuttakin testailtiin, mutta näitä testejä ei dokumentoitu eikä raportoitu mihinkään. Kyseessä oli lähinnä sen varmistelu, että algoritmi toimii halutulla tavalla.

## Yleisesti

Testaus on edennyt työn etenemisen myötä. Kaikkea mitä on tehty, on toteutetuksen yhteydessä testattu ensin manuaalisesti. Kun ongelmia on ratkottu
mahdollisimman pian niiden syntyhetkestä, on pystytty välttämään tilanne, jossa koodiin liittyvät ongelmat alkavat kasautua. Kun luokat
on olleet ns. periaatteessa toimivia, on niitä vielä testattu JUnit-testeillä pyrkimyksenä varmistaa luokkien metodien toiminnallisuus.
Tarvittaessa koodiin on lisätty System.out.println-kutsuja, joilla on tarkasteltu metodin sisäistä toimintaa. Lopullisessa koodissa näitä kutsuja ei ole ainakaan tarkoituksellisesti jäljellä.

## JUnit-testaus

Lähtökohtaisesti luokista on tarkoitus testata kaikki metodit poislukien getterit ja setterit. Konstruktorit testataan ainoastaan siinä
tapauksessa, että niiden toiminnassa on jotakin poikkeuksellisen monimutkaista tai virhealtista. Osa toString-metodeista testataan, sillä niiden toiminta 
saattaa olla joko toiminnan tai muun testauksen kannalta kriittistä. Tavoitteena on varmistaa, että metodit
toimivat niille tarkoitetulla tavalla, käydä läpi metodien koodin laatu ja ettei piiloon jää virhetilanteita, joita ei ole tullut ajatelleeksi. JUnit-testit on tehty kullekin luokalle samalla viikolla kuin luokat on luotu. UI on rajattu testauksen ulkopuolelle. Käytännössä myös IO-luokka ja App-luokka on testauksen ulkopuolella. Alla näkyy kokonaistilanne. Rivikattavuus ja myös haaraumakattavuus on yleisnäkymän perusteella hyvillä tasoilla. Tarkempi katsaus paljastaa, että joitakin yksittäisiä aukkoja testaukseen on kyllä jäänyt. Alla jacoco-raportin mukainen kuvaus kokonaistilanteesta.

![Overall](https://github.com/att78/NalleZip/blob/master/documentation/pictures/overall.png)

Huffman-algoritmin toiminta pohjaa HuffmanAlgo- ja HuffmanNode-luokkiin. HuffmanNode-luokan 100% ei sinällään kerro koko totuutta, sillä se on verrattain yksinkertainen luokka, jota on kutsuttu paljon muiden luokkien testeissä.

![HuffmanTotal](https://github.com/att78/NalleZip/blob/master/documentation/pictures/huffman.png)


HuffmanAlgo on Huffman-algoritmin sydän. Suurin osa metodeista on hyvin testattu, mutta jokunen puute testauksessa on nähtävissä. Vakavin puute on decodeString-metodin haaraumakattavuuteen liittyvä. Metodi toimii, mutta kaikkia poikkeavia tilanteita ei ole käyty testauksessa läpi.
![HuffmanAlgo](https://github.com/att78/NalleZip/blob/master/documentation/pictures/huffmanalgo.png)


Lempel Ziv Welch-algoritmin toiminnasta vastaa yksi luokka. LZW on toiminnaltaan verrattain yksinkertainen. Suurimmat puutteet testauksessa liittyvät jälleen purkamiseen. Tästä voisi päätellä, että purkamisen eli skenaarioihin oli vaikeampi keksiä hyviä testejä kuin muihin tilanteisiin.
![Lempel Ziv Welch](https://github.com/att78/NalleZip/blob/master/documentation/pictures/LZW.png)


Util-pakkaus on työn toteutustavasta johtuen hyvin laaja. Util-pakkauksen luokkia testattiin monin tavoin paitsi luokkien rakennusvaiheessa myös algoritmeihin implementoinnin aikana. Joissakin tapauksissa luokkien lopulliseen muotoon vaikutti suuresti JUnit-testauksella saatu tieto. Tästä johtuen ei ole ihme, että util-pakkauksen testauksen rivikattavuus on korkea 92% ja haaraumakattavuus lähes yhtä korkea 87%.

![Util](https://github.com/att78/NalleZip/blob/master/documentation/pictures/util.png)


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




