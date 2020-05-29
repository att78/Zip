Ma 25.5 3h Lempel Ziviin liittyvän aineiston lukemista. Ei suju, ei ymmärrystä.

Ti 26.5 2h Lempel Zivin lukemista. Ei mainittavaa edistystä.

Ke 27.5 6 h Koodailun aloittelua, vaikka ymmärrys vajavainen onkin. Pyrkimys ratkaista LZ:n aiheuttamaa aivojumia tekemällä edes jotakin siihen liittyvää. Ainoa asia, joka on valjennut, on LZ:n kirjaston muodostaminen stringistä. Jonkinlainen käsitys siitä, miten se tehdään. Alustavasti kokeilin Lempel Ziv Welchin tekemistä. Se taitaa enkoodata jotenkin.

To 28.5 8h Pitkä päivä Lempel Ziv Welchin kanssa. Aikani materiaaleja luettua ja koodailua tehtyä päädyin siihen, että Lempel Ziv Welch oli helppolukuisin Lempel Ziv -tyyppisistä algoritmeista, joita näytti olevan useita erilaisia. Löysin aiheeseen liittyen materiaalia, joka oli riittävän helppotajuista, jotta minäkin sen ymmärsin. LZW-tyyppinen algoritmi on nyt toimivassa kunnossa. Tosin en ole ihan varma, miten hyvin se toimii kaikissa tilanteissa. Se käyttää javan valmiista rakenteista HashMapia, Listiä ja StringBuilderia.  Koska LZW otti aika koville, aikaa ei jäänyt UI:n rakentamiseen. Tiralabran ohjeissa ei ole mainittu aikataulua käyttöliittymän tekemiselle, joten jätin sen suosiolla seuraavaan viikkoon. Mitään kovin monimutkaista UI:ta tämä harjoitustyö ei tarvitse. Tein myös jokusen testin LZW:lle ja otin jacocon käyttöön. 

Pe 29.5 1h Lisää testausta LempelZivWelchAlgo-luokkaan liittyen ja dokumentaation parantelua.

