# Toteutuksesta yleisesti

Ohjelman rakenteessa toteutetut algoritmit Huffman ja Lempel Ziv Welch ovat ovat omissa paketeissaan. Itsetoteutetut tietorakenteet ja apuluokat ovat omassa util-paketissaan. Käyttöliittymä on ui-paketissa ja Tiedostojen käsittely on eriytetty io-pakettiin. Huffman-algoritmi toteutetaan kahden luokan, HuffmanAlgo:n ja HuffmanNode:n avulla. Luokka käyttää itsetehtyjä tietorakenteita DiyHashMap, DiyHeap ja DiyByteArray. DiyHashMap hoitaa javan HashMapin ja DiyHeap PriorityQueuen tehtäviä. DiyByteArray paketoi ByteArrayn ja helpottaa toimintaa. Sekin on toimintansa perusteella laskettavissa yksinkertaiseksi tietorakenteeksi. Näiden lisäksi Huffman-algoritmin toteutuksessa on käytetty runsaasti itsetehtyjä rakenteita, jotka korvaavat javan valmiita rakenteita; DiyStringBuilder, DiySet, DiyByteArrayReader ja DiyBitReader.

Lempel Ziv Welch algoritmin toteuttaa yksi luokka, LempelZivWelchAlgo. Algoritmin toiminnassa käytetään itsetehdyistä tietorakenteista DiyHashMapia ja DiyArrayListia. Lisäksi algoritmin toteutuksessa on mukana apuluokka DiyStringBuilder. Allaoleva kaavio antaa yleiskuvan sovelluksen rakenteesta ja toteutettujen luokkien keskinäisestä suhteesta.

![Luokkakaavio](https://github.com/att78/NalleZip/blob/master/documentation/NalleZip_toteutunut.png)

Ohjelmaa on tarkoitus käyttää komentoriviltä eli käyttöliittymä on tekstikäyttöliittymä.

Yleisenä huomiona voi myös todeta, että sovellus on pyritty toteuttamaan käyttäen checkstyle-vaatimuksia, joissa metodin pituus sallittu maksimipituus on 20, yksittäisen luokan tiedostopituus 600 ja muutoin noudatetaan perusmuotoiluja. Tähän on myös pääpiirteittäin päästy. Alla toteutuksen aikavaativuuksista arviot.


## Huffman
Huffmanin aikavaativuudesta. Huffman-algoritmin toteuttaa kaksi luokkaa, HuffmanAlgo ja HuffmanNode. Näistä luokista HuffmanNode ei ole aikavaatimuksen kannalta oleellinen, sillä se ei sisällä mitään sellaista, mikä aikavaativuuteen merkittävästi vaikuttaisi. Tässä tarkastellaan aikavaativuutta nimenomaisesti HuffmanAlgo-luokkaan keskittyen. Huffman-Algo on poikkeuksellisen laaja luokka. aikavaativuuden kannalta oleellisimpia ovat luokan lukuisat for-loopit ja DiyHeapin käyttö.

Pakkaus tapahtuu encodeString-metodin avulla. Ensimmäiseksi päämetodi käyttää apumetodia createPosition, joka luo dynaamisesti pakkauskirjaston ja palauttaa sen päämetodin käytettäväksi. CreatePosition-metodi sisältää for-loopin, joka looppaa syötteen läpi ja asettaa sen DiyHashMapiin ajassa O(n). DiyHashMapin put-metodi toimii vakioajassa, joten se ei ole aikavaativuutta ajatellessa erityisen merkityksellinen.

Seuraavaksi päämetodi encodeString käyttää apumetodia findRootNode.  Ensin findRootNode käyttää apumetodina createNodes-metodia. 
CreateNodes-metodi taas luo ensimmäiseksi tarvitsemansa avainnipun käyttämällä DiyHashMapin keySetForCharacters-metodia, joka toimii ajassa O(n). Tämän jälkeen createNodes luo DiyHeapin ja looppaa avainnipun läpi asettaen tarvittavat tiedot kekoon. CreateNodesin osalta tapahtuu siis kaksi operaatiota, jotka ovat O(n). 

Takaisin minimikeon juuren metsästykseen. FindRootNode käy läpi minimikeon DiyHeap ajassa O(log n). 

Tämän jälkeen päämetodi käyttää apumetodia setHuffmanTree, joka toimii vakioajassa eikä siten vaikuta merkittävästi aikavaativuuteen.
3 O(n)+ O(log n)
Seuraavaksi on päämetodin oma for-loop, joka luo pakattavan tiedon 1010-String-muodossa.

Tämän jälkeen String-muotoinen tiedosto konvertoidaan bytes[]-taulukoksi stringToBytes-metodilla, joka toimii ajassa O(n). Viimeiseksi vielä lisätään bytes-taulukon alkuun myös pakkauksessa käytetty Huffman-puu addTreeToBytes-metodilla. Tätä tietoa käytetään sitten purkamisessa hyödyksi. AddTreeToBytes-metodi käyttää kyllä for-looppia, mutta looppaa vain puun läpi. Tyypillisesti puu koko m on huomattavasti pienempi kuin n, joten looppaus tapahtuu ajassa O(m).

Yhteensä tästä kaikesta tulee pakkauksen aikavaativuudeksi 5* O(n)+O(log n) +O(m). Tämän voinee ilmaista esim: O(m)+5(n log n).

Purkamisen suorittaa päämetodi decodeString.Ensimmäiseksi käytetään apumetodia readTree, joka lukee pakatun tiedoston alusta tallennetun puun. ReadTreessa ensimmäinen for-loop, on niin lyhyt, että metodin voi katsoa toimivan käytännössä vakioajassa. ReadTreen käyttämässä apumetodissa valueWithoutTree:ssa on for-loop, joka toimii ajassa O(n).
Sen jälkeen purettavaksi saatu bytetaulukko muutetaan boolean-taulukoksi byteToBoolean-taulukoksi. Tämä käyttää for-looppia ja luku tapahtuu ajassa O(n). Tämän jälkeen saatu boolean-taulukko loopataan läpi, missä kuluu O(n)

Kaikenkaikkiaan purkaminen tapahtuu aikaluokassa O(n).



## Lempel Ziv Welch
Aikavaativuudesta. Harjoitustyö noudattaa ainakin suuntaa antavasti Kolumbian yliopiston "ClassNotesCS 3137"-dokumentissa esittämää pseudokoodia.(linkki alla).  Alla esitetty arvio harjoitustyön aikavaativuudesta perustuu kuitenkin harjoitustyön omaan koodiin ja mainitut metodit ovat nimenomaan harjoitustyön metodeja.

Ensin muodostetaan pakkaus-kirjasto metodilla createEncodeLibrary. Metodissa on yksinkertainen for-loop, jonka sisällä tallennetaan tietoa DiyHashMapiin. HashMapin tallennus tapahtuu ajassa O(1). Kokonaisuudessaan ajankäytön osalta on for-loop itse. Tämä tapahtuu aikaluokassa O(n). Tämän jälkeen kirjasto täytetään syötteen mukaisilla tiedoilla metodilla fillLibrary. Metodissa on jälleen yksinkertainen for-loop, jonka sisällä tosin if-else-tarkistus. Metodi toimii kuitenkin aikaluokassa O(n).
Enkoodaus tapahtuu siis kahden operaation, joiden aikavaatimus on O(n) avulla.  Enkoodaus tapahtuu siis lineaarisessa ajassa.

Dekoodaus toimii decodeString-metodin avulla. Päämetodilla on 3 aikavaatimuksen kannalta oleellista apumetodia. Ensimmäiseksi päämetodi käyttää puolestaan käyttää  apumetodia createDecodeLibrary. Tämä käyttää yksinkertaista for-loopia ensin luodessaan dekoodaus-kirjaston. Tämän jälkeen apumetodilla setEncodedList asetetaan enkoodattava lista toisella for-loopilla. Lopuksi decodeloop-apumetodilla rakennetaan DiyStringBuilderin avulla palautettava tiedosto kolmannella for-loopilla. Dekoodaus käyttää kolmea operaatiota, joiden kunkin aikavaatimus on O(n). Tästäkin voidaan katsoa, että koko purkamisoperaation aikavaatimus on lineaarinen ja aikaluokassa O(n). 


## Parannusehdotukset

Suurin parannuksen tarve on Huffman-algoritmissa. Algoritmi on aivan liian iso ja toteutettu kömpelöllä tavalla.Nythän algoritmi pakkaa syötteen ensin String-muotoiseksi jonoksi 101010 ja konvertoi tämän byte[]-taulukoksi. Tämän prosessin suoraviivaistaminen sellaiseksi, että syöte pakattaisiin suoraan byte[]-taulukoksi ainakin nopeuttaisi algoritmin toimintaa jonkin verran ja vähentäisi rivien määrää. Sen sijaan tiedostojen pakkaukseen tällä muutoksella ei välttämättä olisi mitään vaikutusta. Tämä poistaisi myös String-luokan maksimipituuden aiheuttamat potentiaaliset ongelmat isojen tiedostojen pakkauksissa.


## Lähteitä:

Huffman:

https://en.wikipedia.org/wiki/Huffman_coding

https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/

Lempel Ziv

http://www-math.mit.edu/~shor/PAM/lempel_ziv_notes.pdf

http://www.cs.columbia.edu/~allen/S14/NOTES/lzw.pdf

Muuta jännää:

https://www.hackerearth.com/practice/basic-programming/complexity-analysis/time-and-space-complexity/tutorial/

https://www.sciencedirect.com/topics/computer-science/compression-algorithm
