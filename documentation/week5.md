Ma 8.6 2h DiyArrayListin väsäämistä.

Ti 9.6 4h DiyArrayListin väsäämistä ja bugien korjaamista (erityisesti DiyHashMapin containsKey-metodista). LempelZivWelchAlgosta on nyt poistettu kaikki importit javan valmiisiin tietorakenteisiin(HashMap ja ArrayList) sekä rajapintaan List. Suurien tietorakenteiden osalta LZW on nyt kokonaan itsetehty. Jäljellä on tietenkin se Stringbuilder, joka ei ole tietorakenne mutta...
Käyttöliittymän tekeminen tuli myös aloitettua.

Ke 10.6. 4h Vertaisarvioinnin tekeminen vei n. 2 tuntia. Loppuaika mennyt tulevien tietorakenteiden suunnitteluun. Ainakin jonkinlainen minimikeko
tulisi vielä tehdä. Olin tekemässä Set:tiäkin kunnes tajusin, että Set:hän on rajapinta ja se on itseasiassa siten sallittu. Toisaalta se lienee Listin tavoin hidas. 
Epävarmaolo sen suhteen, mitä StringBuilderille tekisi. Lukemani perusteella StringBuilder on optimoitu nimenomaisesti
nopeaksi ja pakkausta edistäväksi. Onko sen korvaamisessa näin ollen mitään järkeä? Itsetehty on todennäköisesti hitaampi. LZW toimii varsin mallikelpoisesti ja
pakkaavasti tällä hetkellä. Toisaalta jos koko homman kääntäisi vielä byte-virraksi, niin sitä Stringbuilderiakaan ei tarvitse-sen paremmin javan omaa kuin itsetehtyä.

To 11.6 5h Jatkoin tällä kertaa Huffman-algoritmiin liittyen. Aloitin minimikeon rakentamisen luokkaan DiyHeap. Luokan perusrunko tuli rakennettua.

Pe 12.6 4h DiyArrayList:in testaus, DiyArrayListin kommentointi, DiyHeapin testauksen aloittaminen, DiyHeapin bugien korjaus, DiyHeapin javadocien aloittaminen. 

Yhteensä n. 19h. Tuntimäärä on hieman yli mutta paljon selittyy sillä, että perjantaiaamuna minulla ei ollut aikataulutetuista opinnoista enää jäljellä kuin tämän kurssin harjoitustyön tekemistä. Räpläsin lähinnä siksi, että sattui poikkeuksellisesti olemaan aikaa. Toisen kurssin harjoitustyö on nyt ladattu moodleen.  Siksipä minulla olisi aikaa myös räplätä iltapäivä, joten saa nähdä, miten iltapäivä etenee. Ulkona UV-varoitus, joten eipä nyt happeakaan kannata mennä haukkaamaan.

Viikolla 6 on edessä Huffmanin "melvaus". Huffman pitäisi laittaa toimimaan byte-tyypin avulla. Huffmaniin pitäisi ottaa käyttöön DiyHashMap ja DiyHeap. Näistä ensimmäinen on nyt jo toimivaksi todettu, DiyHeapin kanssa saattaa vielä teknisiä yllätyksiä tulla. Huffmaniin voisi vielä kehitellä Set:ille jonkin oman korvikkeen. Set:hän on rajapinta eikä teknisesti siten kiellettyjen listalla, mutta sen korvikkeessakaan tuskin kauaa nokka tuhisisi. Oma DiySet voisi ehkä jopa olla nopeampi. DiyStringBuilderiakin LZW:tä varten voi harkita, jos sattuu oikein intoilemaan. Toisaalta viikolla 6 on tarkoitus tehdä myös IO-luokka, joka mahdollistaa tekstitiedostojen pakkailua ja purkamista. Kuulostaa paljolta, mutta olen tällä hetkellä kohtalaisen luottavainen.  Jos kaikki menee putkeen, viikolle 7 jää lähinnä yleinen viimeistely ja käyttöliittymän hiominen ja manuaalin kirjoittelu. Jos ei mene putkeen, viikolle 7 jää vähän enemmän tekemistä.

