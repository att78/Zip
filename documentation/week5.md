Ma 8.6 2h DiyArrayListin väsäämistä.

Ti 9.6 4h DiyArrayListin väsäämistä ja bugien korjaamista (erityisesti DiyHashMapin containsKey-metodista). LempelZivWelchAlgosta on 
nyt poistettu kaikki importit javan valmiisiin tietorakenteisiin(HashMap ja ArrayList) sekä rajapintaan List. Suurien tietorakenteiden osalta LZW on nyt kokonaan itsetehty.
Käyttöliittymän tekeminen tuli myös aloitettua.

Ke 10.6. 4h Vertaisarvioinnin tekeminen vei n. 2 tuntia. Loppuaika mennyt tulevien tietorakenteiden suunnitteluun. Ainakin jonkinlainen minimikeko
tulisi vielä tehdä. Olin tekemässä Set:tiäkin kunnes tajusin, että Set:hän on rajapinta ja se on itseasiassa siten sallittu. Toisaalta se lienee Listin tavoin hidas. 
Epävarmaolo sen suhteen, mitä StringBuilderille tekisi. Lukemani perusteella StringBuilder on optimoitu nimenomaisesti
nopeaksi ja pakkausta edistäväksi. Onko sen korvaamisessa näin ollen mitään järkeä? Itsetehty on todennäköisesti hitaampi. LZW toimii varsin mallikelpoisesti ja
pakkaavasti tällä hetkellä. Toisaalta jos koko homman kääntäisi vielä byte-virraksi, niin sitä Stringbuilderiakaan ei tarvitse-sen paremmin javan omaa kuin itsetehtyä.

