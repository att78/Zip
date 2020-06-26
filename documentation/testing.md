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

Pakkausalgoritmin suorituskyvyn kannalta oleellisia mittareita ovat nopeus ja pakkautuvuus. Käsitellään ensin pakkautuvuutta. Tyypillisesti pakkautuvuus on suurta, jos pakattavan tiedoston sisäinen toisteisuus on suuri ja vastaavasti tehokas pakkaaminen on haastavaa, jos toisteisuutta on vain vähän. Pakkautuvuutta mitattiin molemmille algoritmeille testisarjalla, jossa ei ollut toistuvia tiedostoja. Mukana oli muutama muukin teksti, mutta suurimmaksi osaksi testisarja sisälsi CNN:n sivuilta löytyviä kesäkuun 2020 poliittisia analyyseja. Tietenkin näissä oli yksittäisiä toistuvia asioita, kuten presidentti Trump, mutta kokonaisuutena analyysien aiheet kuitenkin vaihtelivat ja tarjosivat monenlaista sanastoa pakattavaksi.  Tiedostojen koko vaihteli lähtien n. 10k tavusta kasvaen lähes 100k tavuun ja molemmille algoritmeille käytettiin samaa testisarjaa. Testimateriaaliin voi tutustua oheisen linkin avulla:

[Testimateriaali](https://github.com/att78/NalleZip/tree/master/documentation/testmaterial)


Huffman-algoritmi pakkasi tiedostojen koosta riippumatta hyvinkin saman verran. Pakkautuvuus oli n.57%, mikä asettuu tiralabran sivuilla asetetun tavoitteen 40-60% pakkausasteesta sisään, joskin yläpäähän. Tähän yläpäähän asettumiseen tietenkin vaikuttaa testimateriaalikin.

![HuffmanCompressionRate](https://github.com/att78/NalleZip/blob/master/documentation/pictures/huffmancompression.png)

Ylläolevassa kuvassa y-akselilla on pakkaus% ja x-akselilla pakattujen tiedostojen koko. Testisarjan perusteella voi tehdä johtopäätöksen, ettei tiedoston koko vaikuta Huffman-algoritmin pakkauskykyyn merkittävästi. Lempel Ziv Welch erosi tässä suhteessa Huffmanista merkittävästi. Lempel Ziv Welch-algoritmia käytetään tyypillisesti suurien tiedostojen pakkaamiseen, sillä jo teoriassa algoritmin kyky pakata suuria tiedostoja tehokkaasti on parempi kuin pienien tiedostojen. Tämä näkyi myös testituloksissa.

![LZWCompression](https://github.com/att78/NalleZip/blob/master/documentation/pictures/lzwCompressinRate.png)

Kuvasta voidaan todeta, että Lempel Ziv Welch-algoritmi käyttäytyi algoritmille asetettujen odotusten mukaisesti. Pienehköjen tiedostojen pakkaus alun poikkeusta lukuunottamatta jäi hyvin pieneksi, pakkausasteen ollessa n. 60-70% mutta suuremmilla tiedostoilla LZW muuttui Huffmania tehokkaammaksi. Kuvasta voidaan myös nähdä laskeva trendi ja tehdä johtopäätös, että testisarjan jatkaminen suurempaan suuntaan olisi todennäköisesti parantanut edelleen LZW-algoritmin pakkausastetta. Lempel Ziv Welchia testattiin myös lyhyesti testisarjalla, jossa oli paljon toisteisuutta. Suurten tiedostojen parempi pakkautuvuus verrattuna pieniin tiedostoihin näkyi myös tässä testisarjassa, mikä osoittaa algoritmin toimivan LZW:lle tyypillisellä tavalla.

![LZWeasy](https://github.com/att78/NalleZip/blob/master/documentation/pictures/lzwEasy.png)

Graafista voi vetää johtopäätöksen myös siitä, että pakattava materiaali vaikuttaa merkittävästi pakkaustulokseen. Paljon toisteisuutta sisältävä materiaali pakkautui selkeästi pienemmäksi ja jo melko pienillä tiedostoilla päästiin alle 50% pakkautuvuuteen.


Algoritmien suorituskykyä testattiin myös nopeuden osalta. Suorituskykyä testattiin samalla testisarjalla, jolla tutkittiin pakkautuvuutta. Huono puoli tässä oli se, että testiotokset olivat pieniä. 

![HuffmanSpeed](https://github.com/att78/NalleZip/blob/master/documentation/pictures/speedTestHuffman.png)

Kuvassa pakkautuvuuden ajoissa näkyy heijausta, eli ne eivät kasva lineaarisesti. Virhelähteenä tässä saattoi olla se testauksessa käytetyn tietokoneen muu taustalla tapahtunut toiminta. Suoritusajat ovat niin lyhyitä, että pienetkin asiat vaikuttavat tuloksiin. Alla on vastaava kuva Lempel Ziv Welch-algoritmin nopeudesta samoilla syötteillä.

![LempelSpeed](https://github.com/att78/NalleZip/blob/master/documentation/pictures/speedlempel2.png)

Yleisesti voisi todeta, että Huffman osoittautui testisarjalla suurilla sarjoilla hieman nopeammaksi.





