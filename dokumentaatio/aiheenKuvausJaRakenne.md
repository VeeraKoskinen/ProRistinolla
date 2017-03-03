#ProRistinolla


##AIHE:

Toteutetaan eräänlainen ristinolla -peli kaksin pelattavaksi. Pelialustana toimii 6x6 kokoinen ruudukko, johon voittaakseen tulee saada viisi omaa merkkiä peräkkäin pystysuuntaan. Jos projekti valmistuu ripeästi, on tarkoituksena laajentaa ohjelmaa siten, että pelialusta jaetaan neljään 3x3 ruutua kokoiseen alueeseen, jotka muodostavat pelialustan.

##KÄYTTÄJÄT:    Pelaaja 1 ja pelaaja 2

##PELAAJAN TOIMINNOT:


- Pelaajan merkin asettaminen (vaihe 1)

   Merkin koordinaatit ovat laudalla ja ruudussa ei ole ennestään merkkiä

![sekvenssikaavio1](merkinPelaaminen1.jpg)

   Merkin koordinaatit ovat laudan ulkopuolella, eikä merkkiä näin ollen voida pelata

![sekvenssikaavio2](merkinPelaaminen2.jpg)

- Pelilaudan osan pyörittäminen (vaihe 2)

 - onnistuu vain, jos pelaaja on asettanut jo merkin vuorollaan

- Vuoron päättäminen

 - onnistuu vain, jos vuoron vaiheet on suoritettu

- Pelin voittaminen

 - onnistuu vain, jos vuoron päätteeksi on viisi omaa merkkiä peräkkäin

- Pelin lopettaminen


##KAIKKIEN KÄYTTÄJIEN TOIMINNOT:

- Pelin käynnistäminen

- Uuden pelin aloittaminen


##LUOKKAKAAVIO
![Luokkakaavio](Luokkakaavio.png)


### Rakennekuvaus:
Ohjelma on toteutettu helpoin ja yksinkertaisin metodein. Pääosa ohjelman rakenteesta tiivistyy logiikka luokkaan, jonka metodein peliä ohjaillaan. Logiikalla on yksi pelilauta, jonka avulla pelilaudan tilannetta pidetään yllä. Pelilaudalla on puolestaan kaksi pelaajaa, jotka omaavat omat pelimerkkinsä. Itse merkit sekä pelintilat on toteutettu enumein. 

Graafisen käyttöliittymän luomiseen on käytetty swingiä. Swingillä piirretään pelilauta ja pelimerkit, pelilaudan päälle ilmestyvä pyöräytysikkuna sekä valikkopaneelit.
