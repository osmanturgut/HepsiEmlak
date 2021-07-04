HepsiEmlak - Gauge Project
--------------------------------------------

This project works on Google Chrome browser.
You need to downloads chrome web driver and add this driver to Driver class. -> Driver link: https://chromedriver.chromium.org/downloads
Created as a Gauge project and added Selenium to their dependencies.
Before Running the project, you need to select mobile or web on BaseTest class
A living documentation has been created with BDD logic in Spec files.
The project includes 4 scenario , 2 web and 2 mobile.


Scenario-1 WEB:

* siteye giris yapilir ve Kiralik ilanlara gidilir
* kiralik il-ilce secimi yapilir
* oda secimi '2+1'yapilir
* site icerisinde filtresi aktif hale getirilir
* 'ARA' butonuna tiklanir
* kiralik kategorisindeki girilen filtrelerin kontrolu saglanir
* '3. siradaki' ilana gidilir
* Telefon Numarasini göster ve Kontrol et

Scenario-2 WEB:

* "web"set device type
* siteye giris yapilir ve satilik ilanlara gidilir
* il-ilce secimi yapilir
* kategori secimi yapilir
* min fiyat ve max fiyat bilgisi girilir
* bina yasi 'sifir' , '1-5' ve '6-10' secilir
* girilen filtrelere göre arama butonuna tiklanir
* satilik kategorisindeki girilen filtrelerin kontrolu saglanir


Scenario-1 MOBILE:

* Mobile Siteye Giris Yapilir ve Kiralik İlanlara Gidilir
* Mobile il-ilce Secimi Yapilir
* Mobile Oda Secimi Yapilir
* Mobile Site icerisinde Secimi Yapilir
* Mobile 'İlan Sahibini Ara' bilgisi alinir ve kontrol edilir


Scenario-2 MOBILE:

* Mobile Site acilir ve Satilik ilanlara gidilir
* Mobile Satilik ilanlarda il-ilce Secimi Yapilir
* Mobile kategoride 'İs yeri' Secimi Yapilir
* Mobile Max-Min Fiyat Bilgisi girilir
* Mobile Bina yasi 'sifir bina','1-5' ve '6-10' filtreleri girilir
* Mobile Girilen Filtreleri Kontrol eder

