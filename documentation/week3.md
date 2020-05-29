Ma 25.5 3h Lempel Ziviin liittyvän aineiston lukemista. Ei suju, ei ymmärrystä.

Ti 26.5 2h Lempel Zivin lukemista. Ei mainittavaa edistystä.

Ke 27.5 6 h Koodailun aloittelua, vaikka ymmärrys vajavainen onkin. Pyrkimys ratkaista LZ:n aiheuttamaa aivojumia tekemällä edes jotakin siihen liittyvää. Ainoa asia, joka on valjennut, on LZ:n kirjaston muodostaminen stringistä. Jonkinlainen käsitys siitä, miten se tehdään. Alustavasti kokeilin Lempel Ziv Welchin tekemistä. Se taitaa enkoodata jotenkin.

To 28.5 8h Pitkä päivä Lempel Ziv Welchin kanssa. Aikani materiaaleja luettua ja koodailua tehtyä päädyin siihen, että Lempel Ziv Welch oli helppolukuisin Lempel Ziv -tyyppisistä algoritmeista, joita näytti olevan useita erilaisia. Löysin aiheeseen liittyen materiaalia, joka oli riittävän helppotajuista, jotta minäkin sen ymmärsin. LZW-tyyppinen algoritmi on nyt toimivassa kunnossa. Tosin en ole ihan varma, miten hyvin se toimii kaikissa tilanteissa. Se käyttää javan valmiista rakenteista HashMapia, Listiä ja StringBuilderia.  Koska LZW otti aika koville, aikaa ei jäänyt UI:n rakentamiseen. Tiralabran ohjeissa ei ole mainittu aikataulua käyttöliittymän tekemiselle, joten jätin sen suosiolla seuraavaan viikkoon. Mitään kovin monimutkaista UI:ta tämä harjoitustyö ei tarvitse. Tein myös jokusen testin LZW:lle ja otin jacocon käyttöön. 

Pe 29.5 2h Lisää testausta LempelZivWelchAlgo-luokkaan liittyen ja dokumentaation parantelua. Checkstylen löytämien virheiden korjailua ja muuta pientä säätöä.


Yhteensä n.21 tuntia, joskin osa työtunneista hyvin rauhattomia ja katkonaisia. Silti voi sanoa, että meni jonkin verran ylitöiden puolelle. 


## Kysymys: 

mitä tarkoittaa tiralabrassa "kattava yksikkötestaus"? 

Tällä hetkellä työssä on jacoco-raportin perusteella yli 90% kokonaiskattavuus, mutta branch-kattavuus on "vain" 68%. Siitä onko testini hyviä tai huonoja minulla on kovin vajavainen käsitys. Toisaalta tiralabran FAQ:ssa sanotaan, ettei prosenteilla ole väliä vaan testien pitäisi olla hyviä. Testin hyvyyskin on suhteellinen käsite.

(Ohjelmistotekniikassa loppupalautuksen rivi- ja haaraumakattavuudesta sai täydet pisteet n. 70% kattavuudella sekä rivikattavuuden että haaraumakattavuuden perusteella. Siellä tuo taso oli piisannut jo loppupalautuksellekin mutta se on vain yksi näkökulma aiheeseen. Oli niin paljon helpompaa, kun saattoi vain tuijottaa jacoco-raportin prosentteja...)

## Viikon 4 oletetut puuhat:

1. pitää päättää teenkö kolmannenkin pakkaualgoritmin vai alanko ählätä ja sählätä omia tietorakenteita kasaan. Lempel Zivistä lukiessa tuli luettua kaikenlaista muutakin.

2. Omien tietorakenteiden tekeminen pitää aloittaa. Tällä hetkellä javan valmiista rakenteista eroon pääseminen vaatii ainakin seuraavien tietorakenteiden korvaamisen: HashMap, ArrayList, PriorityQueue ja StringBuilder.  Näistä HashMap ja StringBuilder on käytössä sekä Huffmanissa että LZWssä. Siinä mielessä ne ovat työn kannalta kriittisimmät korvattavat tietorakenteet.

myös String-luokan substring-metodin käyttöä LZW:ssä pitäisi tarkastella. Olipa se sallittu tai ei, kyseisen metodin tehokkuudesta ei ole tällä haavaa tietoa. Mielikuva, että ei ole olisi kovin tehokas toiminnaltaan. Mahdollisesti se tulisi korvata charAt-metodilla.




