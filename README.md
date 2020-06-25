# Raport generator
### Wymagania
- JDK-13.0.1.9
- Maven
### Instalacja
```sh
$ git clone
```
## Spis treści
* [Wprowadzenie](#wprowadzenie)
* [Uruchomienie aplikacji](#uruchomienie-aplikacji)
* [Menu](#menu)
* [Raporty](#raporty)
* [Obsługa błędów](#obsluga-bledow)
## Wprowadzenie
### Informacje ogólne
Aplikacja jest programem konsolowym. Opiera się na wczytywaniu miesięcznych raportów tasków pracowników w formacie Excel, umieszczonych w odpowiedniej strukturze folderów: .../[YYYY]/[MM]

Każdy pracownik w folderze posiada swój własny plik nazwany Imieniem i Nazwiskiem. Pracownik może pracować przy kilku projektach, taski każdego z nich są umieszczone w odpowiednim zeszycie "Sheet'cie" z jego nazwą. Struktura pliku *.xls przedstawia się następujący sposób:

Data | Zadanie | Czas [h]
| Data        | Zadanie           | Czas [h]  |
| ------------- |:-------------:| -----:|
| 13.01.2018      | Wizyta u klienta | 7 |
| 14.01.2018      | Podsumowanie spotkania      |   5.3 |
| 15.01.2018 | Ocena wymagań przygotowanych przez Janka      |    1.2 |
Zadaniem programu jest generacja poszczególnych raportów przedstawiające wymagane zestawienie statystyczne (opis dostępnych funkcji w dalszej części).
### Wykonanie
Aplikacja została zaimplementowana w środowisku java przez zespół programistyczny Commodore 64.
## Uruchomienie aplikacji
Administrator katalogu odpowiedzialny jest za dopilnowanie poprawnego nazewnictwa pliku, tj. plik powinien być nazwany unikalnie dla każdego pracownika Imie_Nazwisko.

W przypadku występowania pracowników o takim samym nazwisku, do nazwy pliku konieczne jest wprowadzenie unikalnego numeru w celu rozróżnienia tych dwóch osób. Sposób numeracji pozostawiony jest do decyzji użytkownika, jednakże w dalszym funkcjonowaniu programu, nazwa ta będzie konsekwentnie przypisana do pracownika.

Opis zachowania programu w przypadku błędnych danych opisany jest w rozdziale 6. Obsługa blędów.
