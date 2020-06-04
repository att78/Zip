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
toimivat niille tarkoitetulla tavalla, käydä läpi metodien koodin laatu ja ettei piiloon jää virhetilanteita, joita ei ole tullut ajatelleeksi. JUnit-testit on tehty kullekin luokalle samalla viikolla kuin luokat on luotu. Testeissä on paranneltavaa ja niitä onkin tarkoitus kehittää kattavammiksi kun varmuus luokkien lopullisesta olemuksesta kasvaa.

Tällä hetkellä JUnit-testauksen rivikattavuus on korkea, mutta haaraumakattavuus on alempi.
![GeneralView](https://github.com/att78/NalleZip/blob/master/documentation/pictures/generalView.png)





DiyHashmapiin liittyviä luokkia on 2, DiyHashMap ja DiyContent. DiyContent:ille ei ole tehty testejä, sillä luokalla on ainoastaan konstuktori ja automaattisesti generoituja gettereitä ja settereitä, joiden testaaminen ei ole järkevää.

![DiyHashMap](https://github.com/att78/NalleZip/blob/master/documentation/pictures/diyHash.png)


