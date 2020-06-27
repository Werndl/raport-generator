# Raport generator
## Spis treści
* [Wprowadzenie](#wprowadzenie)
* [Uruchomienie aplikacji](#uruchomienie-aplikacji)
* [Menu](#menu)
* [Raporty](#raporty)
* [Koniec pracy programu](#koniec-pracy-programu)
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
### Wymagania
- JDK-13.0.1.9
- Maven
- dowolne IDE, np. IntelliJ IDEA lub Eclipse
### Instalacja
```sh
$ git clone
```
Administrator katalogu odpowiedzialny jest za dopilnowanie poprawnego nazewnictwa pliku, tj. plik powinien być nazwany unikalnie dla każdego pracownika Imie_Nazwisko.

W przypadku występowania pracowników o takim samym nazwisku, do nazwy pliku konieczne jest wprowadzenie unikalnego numeru w celu rozróżnienia tych dwóch osób. Sposób numeracji pozostawiony jest do decyzji użytkownika, jednakże w dalszym funkcjonowaniu programu, nazwa ta będzie konsekwentnie przypisana do pracownika.

Opis zachowania programu w przypadku błędnych danych opisany jest w rozdziale 6. Obsługa blędów.

Aplikacja po uruchomieniu wyświetla ekran powitalny i prosi użytkownika o wprowadzenie ścieżki do katalogu danych.

```sh
++++++++++++++++++++++++++++++++++++++++++
Witamy w programie raportów pracowniczych!

Proszę podać ścieżkę katalogu danych:
```
### Uruchomienie
Aby uruchomić program, należy, w konsoli wpisać polecenie:
```sh
java -jar
```
oraz podać pełną ścieżkę wygenerowanego pliku z rozszerzeniem .jar.

## Menu
Po odczycie danych z katalogu, na ekranie aplikacji zostanie wyświetlone MENU, z którego użytkownik wybierze interesujący go raport.
```sh
Wybierz z poniższych opcji raport który chcesz wygenerować:
Raport 1: Alfabetyczna lista pracowników za dany rok. WPISZ: 1
Raport 2: Alfabetyczna lista projektów za dany rok. WPISZ: 2
Raport 3: Szczegółowy wykaz pracy danego pracownika. WPISZ: 3
Raport 4: Procentowe zaangażowanie danego pracownika w projekty za dany rok. WPISZ: 4
Raport 5: Szczegółowy wykaz pracy w danym projekcie, pokazujący liczbę godzin wypracowanych przez poszczególnych pracowników w danym projekcie. WPISZ: 5
Raport 6: Generowanie wykresu słupkowego do raportu 2. WPISZ: 6
Log błędów: Zapis błędów w podanych danych. WPISZ: 8
Wyjście z programu. WPISZ: 0

Wpisz wybraną opcję: 
```

Zadaniem użytkownika jest wprowadzenie do konsoli kodu raportu, który chce wygenerować.
## Raporty
#### Raport nr 1
Parametrem raportu jest rok. 
```sh
Generowanie raportu numer: 1
++++++++++++++++++++++++++++++++++++++++++
Podaj rok, dla którego chcesz wygenerować raport: 2018
++++++++++++++++++++++++++++++++++++++++++
Alfabetyczna lista pracowników za rok 2018
Lp         Pracownik                      Godziny [h]
1          Damian Kowal                   194,70     
2          Katarzyna Mara                 135       
3          Marta Bolas                    72        
Suma:                                     401,70     
++++++++++++++++++++++++++++++++++++++++++

Czy chcesz wygenerować raport do pliku Excel?
WPISZ: 1 jeśli TAK, wciśnij inny klawisz jeśli NIE: 
```
Użytkownik dostanie opcję ponownego wygenerowania raportu. Jeśli się na to zdecyduje zostanie przekierowany do MENU.
#### Raport nr 2
Parametrem raportu jest rok.
```ssh
Generowanie raportu numer: 2
++++++++++++++++++++++++++++++++++++++++++
Podaj rok, dla którego chcesz wygenerować raport: 2020
++++++++++++++++++++++++++++++++++++++++++
Alfabetyczna lista projektów za rok 2020
Lp         Projekt                        Godziny [h]
1          Projekt 1                      312,20    
2          Projekt 2                      353,86    
3          Projekt 3                      315,61    
Suma:                                     981,67  
++++++++++++++++++++++++++++++++++++++++++

Czy chcesz wygenerować raport do pliku Excel?
WPISZ: 1 jeśli TAK, wciśnij inny klawisz jeśli NIE: 
```
Użytkownik dostanie opcję ponownego wygenerowania raportu. Jeśli się na to zdecyduje zostanie przekierowany do MENU.
#### Raport nr 3
Parametrami raportu są rok i pracownik. 
```sh
Generowanie raportu numer: 3
++++++++++++++++++++++++++++++++++++++++++
Podaj rok, dla którego chcesz wygenerować raport: 2018
Podaj imię i nazwisko osoby, dla której chcesz wygenerować raport: Damian Kowal
++++++++++++++++++++++++++++++++++++++++++
Damian Kowal | Szczegółowy wykaz pracy za rok 2018
Lp         Miesiąc         Projekt              Godziny [h]
1          Styczeń         Projekt 1            13,50     
2          Styczeń         Projekt 3            1,20      
3          Styczeń         Projekt2             16        
4          Luty            Projekt 1            21        
5          Marzec          Projekt 1            18        
6          Kwiecień        Projekt 1            22        
7          Kwiecień        Projekt 2            18        
8          Maj             Projekt 1            27        
9          Maj             Projekt 2            18        
10         Sierpień        Projekt 3            40           
++++++++++++++++++++++++++++++++++++++++++

Czy chcesz wygenerować raport do pliku Excel?
WPISZ: 1 jeśli TAK, wciśnij inny klawisz jeśli NIE: 
```
Użytkownik dostanie opcję ponownego wygenerowania raportu. Jeśli się na to zdecyduje zostanie przekierowany do MENU.
#### Raport nr 4
Parametrem raportu jest rok. 
```sh
```
Użytkownik dostanie opcję ponownego wygenerowania raportu. Jeśli się na to zdecyduje zostanie przekierowany do MENU.
#### Raport nr 5
Parametrem raportu jest nazwa projektu. 
```sh
Generowanie raportu numer: 5
++++++++++++++++++++++++++++++++++++++++++
Podaj projekt, dla którego chcesz wygenerować raport: Projekt 1
++++++++++++++++++++++++++++++++++++++++++
Szczegółowy wykaz pracy w projekcie: Projekt 1
Lp         Pracownik                      Godziny [h]
1          Damian Kowal                   101,50    
2          Karol Strassburger             278       
3          Mario Budowlaniec              182,82    
4          Roksana Ekogroszek             110,76    
Suma:                                     673,08  
++++++++++++++++++++++++++++++++++++++++++

Czy chcesz wygenerować raport do pliku Excel?
WPISZ: 1 jeśli TAK, wciśnij inny klawisz jeśli NIE: 
```
Użytkownik dostanie opcję ponownego wygenerowania raportu. Jeśli się na to zdecyduje zostanie przekierowany do MENU.
#### Raport nr 6
Parametrem raportu jest rok. W nowym oknnie zostanie wyświetlony wykres słupkowy do raportu 2.

Użytkownik dostanie opcję ponownego wygenerowania raportu. Jeśli się na to zdecyduje zostanie przekierowany do MENU.
### Log błędów
Istnieje możliwość wyświetlenia błędów w podanych danych. Po wybraniu przez użytkownika kodu 8, na konsoli zostanie pokazany rodzaj błędu oraz jego konkretną lokalizację w pliku. Każdy zapis błędu przedstawia również ścieżkę pliku, w którym program znalazł nieprawidłowe dane.
### Generacja reportu do pliku Excel
```sh
Czy chcesz wygenerować raport do pliku Excel?
WPISZ: 1 jeśli TAK, wciśnij inny klawisz jeśli NIE: 
1
Proszę podać ścieżkę do zapisania pliku:C:\Users\Beata\Documents
Proszę podać nazwę raportu: 2020_projekty
Wygenerowany raport jest dostępny w wybranej lokalizacji!
```
## Koniec pracy programu
Program można zakończyć z dwóch poziomów aplikacji. 
Z poziomu opcji MENU, po wybraniu kodu 0, program zakończy swoją pracę.
```sh
Wybierz z poniższych opcji raport który chcesz wygenerować:
Raport 1: Alfabetyczna lista pracowników za dany rok. WPISZ: 1
Raport 2: Alfabetyczna lista projektów za dany rok. WPISZ: 2
Raport 3: Szczegółowy wykaz pracy danego pracownika. WPISZ: 3
Raport 4: Procentowe zaangażowanie danego pracownika w projekty za dany rok. WPISZ: 4
Raport 5: Szczegółowy wykaz pracy w danym projekcie, pokazujący liczbę godzin wypracowanych przez poszczególnych pracowników w danym projekcie. WPISZ: 5
Raport 6: Generowanie wykresu słupkowego do raportu 2. WPISZ: 6
Log błędów: Zapis błędów w podanych danych. WPISZ: 8
Wyjście z programu. WPISZ: 0

Wpisz wybraną opcję: 0
Koniec pracy
```
Istnieje również możliwość zakończenia pracy aplikacji po wygenerowaniu raportu. Użytkownik zostanie zapytany o chęć generacji kolejnego raportu (wciśnięcie klawisza 1). Po wciśnięciu dowolnego klawisze, który nie równa się 1, program zakończy pracę.
```sh
Czy chcesz wygenerować kolejny raport?
WPISZ: 1 jeśli TAK, wciśnij inny klawisz jeśli NIE: 
Any
Koniec pracy
```
## Obsluga bledow
### Niepoprawna ścieżka katalogu
W przypadku podania przez użytkownika błędnej ścieżki do katalogu danych, program odpowiednio zareaguje. Zostanie wyświetlony komunikat, że podana ścieżka jest błędna. Aplikacja zapyta użytkownika o ponowne wprowadzenie ścieżki.
```sh
++++++++++++++++++++++++++++++++++++++++++
Witamy w programie raportów pracowniczych!

Proszę podać ścieżkę katalogu danych: invalid path

PODANA ŚCIEŻKA JEST BŁĘDNA

Proszę podać ścieżkę katalogu danych: 
```
### Niepoprawny format pliku
Program akceptuje tylko pliki z rozszerzeniem xls. Wszystkie inne typy plików (np. txt, xlsx, doc, etc.) zostaną zignorowane.
### Niepoprawne dane
Program zapisuje wszystkie napotkane błędy w danych pliku Excel w logu błędów.
#### Puste komórki
W przypadku gdy program daje informację, że komórka jest pusta, a znajduje się na końcu dokumentu, to mogą tam już być wprowadzone jakieś opcje - wtedy należy usunąć wiersz, żeby nie wyświetlał się komunikat.
```sh
Projekt: Projekt 1 - Komorka (7, 1) jest pusta!
```
#### Daty niezgodne ze strukturą folderu
Daty w pliku .xls muszą być zgodne ze  strukturą katalogu. Jeżeli w pliku znajduje się data, która wskazuje na inny folder, program uzna to jako błąd danych.
```sh
Projekt: Projekt2 - Komorka (2, 1) - data nie jest zgodna z układem katalogow!
```
#### Błędne dane
Jeżeli program wyłapie jakiekolwiek inne błędy w danych, które nie spełniają wymagań, uzna je jako błąd danych.
```sh
Projekt: Projekt 3 - Komorka (3, 1) ma niepoprawne dane!
```
### Błędne parametry raportów
W przypadku gdy użytkownik poda niewłaściwy kod raportu, który chce wygenerować, w MENU zostanie poinformowany o tym fakcie przez właściwy komunikat.
```sh
Wybierz z poniższych opcji raport który chcesz wygenerować:
Raport 1: Alfabetyczna lista pracowników za dany rok. WPISZ: 1
Raport 2: Alfabetyczna lista projektów za dany rok. WPISZ: 2
Raport 3: Szczegółowy wykaz pracy danego pracownika. WPISZ: 3
Raport 4: Procentowe zaangażowanie danego pracownika w projekty za dany rok. WPISZ: 4
Raport 5: Szczegółowy wykaz pracy w danym projekcie, pokazujący liczbę godzin wypracowanych przez poszczególnych pracowników w danym projekcie. WPISZ: 5
Raport 6: Generowanie wykresu słupkowego do raportu 2. WPISZ: 6
Log błędów: Zapis błędów w podanych danych. WPISZ: 8
Wyjście z programu. WPISZ: 0

Wpisz wybraną opcję: 9
Podana wartość jest błędna, spróbuj ponownie.
```
W takim wypadku, MENU wyświetli się po raz kolejny, w celu wprowadzenia właściwego kodu.
#### Raport nr 1
Parametrem raportu jest rok. W przypadku wprowadzenia niewłaściwego parametru, który nie istnieje w katalogu danych, zostanie wyświetlony odpowiedni komunikat, że danych na wybrany rok brakuje.
```sh
Generowanie raportu numer: 1
++++++++++++++++++++++++++++++++++++++++++
Podaj rok, dla którego chcesz wygenerować raport: 214
Brak danych na rok 214

++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++

Czy chcesz wygenerować kolejny raport?
WPISZ: 1 jeśli TAK, wciśnij inny klawisz jeśli NIE: 
```
Użytkownik dostanie opcję ponownego wygenerowania raportu. Jeśli się na to zdecyduje zostanie przekierowany do MENU.
#### Raport nr 2
Parametrem raportu jest rok. W przypadku wprowadzenia niewłaściwego parametru, który nie istnieje w katalogu danych, zostanie wyświetlony odpowiedni komunikat, że danych na wybrany rok brakuje.
```sh
Generowanie raportu numer: 2
++++++++++++++++++++++++++++++++++++++++++
Podaj rok, dla którego chcesz wygenerować raport: 2014
Projektu nie prowadzono w 2014 roku!

++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++

Czy chcesz wygenerować kolejny raport?
WPISZ: 1 jeśli TAK, wciśnij inny klawisz jeśli NIE: 
```
Użytkownik dostanie opcję ponownego wygenerowania raportu. Jeśli się na to zdecyduje zostanie przekierowany do MENU.
#### Raport nr 3
Parametrami raportu są rok i pracownik. W przypadku wprowadzenia niewłaściwego parametru, który nie istnieje w katalogu danych, zostanie wyświetlony odpowiedni komunikat na każdy z przypadków.
Przy nie istniejącym roku, zostanie wyświetlona informacja o braku danych na wybrany rok.
```sh
Generowanie raportu numer: 3
++++++++++++++++++++++++++++++++++++++++++
Podaj rok, dla którego chcesz wygenerować raport: 2014
Podaj imię i nazwisko osoby, dla której chcesz wygenerować raport: Katarzyna Mara
Brak danych na rok 2014
++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++

Czy chcesz wygenerować kolejny raport?
WPISZ: 1 jeśli TAK, wciśnij inny klawisz jeśli NIE: 
```
Jeżeli pracownik w ogóle nie istnieje w danym katalogu, użytkownik zostanie o tym fakcie poinformowany.
```sh
Generowanie raportu numer: 3
++++++++++++++++++++++++++++++++++++++++++
Podaj rok, dla którego chcesz wygenerować raport: 2018
Podaj imię i nazwisko osoby, dla której chcesz wygenerować raport: Jan Kowalski
Pracownik Jan Kowalski nie istnieje!
++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++

Czy chcesz wygenerować kolejny raport?
WPISZ: 1 jeśli TAK, wciśnij inny klawisz jeśli NIE: 
```
Jeżeli pracownik istnieje w katalogu i folder wybranego roku znajduje się w katalogu, ale pracownik nie posiada danych w tym roku, program wyświetli odpowiedni komunikat.
```sh
Generowanie raportu numer: 3
++++++++++++++++++++++++++++++++++++++++++
Podaj rok, dla którego chcesz wygenerować raport: 2019
Podaj imię i nazwisko osoby, dla której chcesz wygenerować raport: Katarzyna Mara
Brak danych pracownika na rok 2019
++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++

Czy chcesz wygenerować kolejny raport?
WPISZ: 1 jeśli TAK, wciśnij inny klawisz jeśli NIE: 
```
Użytkownik dostanie opcję ponownego wygenerowania raportu. Jeśli się na to zdecyduje zostanie przekierowany do MENU.
#### Raport nr 4
Parametrem raportu jest rok. W przypadku wprowadzenia niewłaściwego parametru, który nie istnieje w katalogu danych, zostanie wyświetlony odpowiedni komunikat, że danych na wybrany rok brakuje.
```sh

```
Użytkownik dostanie opcję ponownego wygenerowania raportu. Jeśli się na to zdecyduje zostanie przekierowany do MENU.
#### Raport nr 5
Parametrem raportu jest nazwa projektu. W przypadku wprowadzenia niewłaściwego parametru, który nie istnieje w katalogu danych, zostanie wyświetlony odpowiedni komunikat, że dane wybranego projektu nie istnieją.
```sh
Generowanie raportu numer: 5
++++++++++++++++++++++++++++++++++++++++++
Podaj projekt, dla którego chcesz wygenerować raport: Projekt NoName
Projekt o nazwie Projekt NoName nie istnieje!

++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++

Czy chcesz wygenerować kolejny raport?
WPISZ: 1 jeśli TAK, wciśnij inny klawisz jeśli NIE:  
```
Użytkownik dostanie opcję ponownego wygenerowania raportu. Jeśli się na to zdecyduje zostanie przekierowany do MENU.
### Błędy przy generacji pliku Excel
W momencie generowania raportu, użytkownik zostanie poproszony o podanie ścieżki, w której będzie chciał zapisać plik. Jeśli będzie ona nieprawidłowa, zostanie wyświetlony odpowiedni komunikat i zapytanie czy użytkownik chce spróbować ponownie.
```sh
++++++++++++++++++++++++++++++++++++++++++

Czy chcesz wygenerować raport do pliku Excel?
WPISZ: 1 jeśli TAK, wciśnij inny klawisz jeśli NIE: 
1
Proszę podać ścieżkę do zapisania pliku: invalid path
PODANA ŚCIEŻKA JEST BŁĘDNA
WPISZ: 1 jeśli chcesz spróbować jeszcze raz lub wciśnij inny klawisz jeśli chcesz wrócić do menu.
any
Powrót do Menu
++++++++++++++++++++++++++++++++++++++++++

Czy chcesz wygenerować kolejny raport?
WPISZ: 1 jeśli TAK, wciśnij inny klawisz jeśli NIE: 
```
Jeśli użytkownik wpisze dowolny klawisz z wyjątkiem 1, menu do generacji pliku zostanie zamknięte. Jeśli się na to zdecyduje zostanie przekierowany do MENU. Użytkownik dostanie opcję ponownego wygenerowania raportu.
Jeśli użytkownik będzie chciał zapisać plik w folderze katalogu, program na to nie pozwoli.
```sh
++++++++++++++++++++++++++++++++++++++++++

Czy chcesz wygenerować raport do pliku Excel?
WPISZ: 1 jeśli TAK, wciśnij inny klawisz jeśli NIE: 
1
Proszę podać ścieżkę do zapisania pliku:E:\jnodz\Documents\IT\PROJEKT\raport-generator\resources\dane1
Plik nie może zostać zapisany w katalogu danych. Spróbuj ponownie
Proszę podać ścieżkę do zapisania pliku:
```
Zadaniem użytkownika jest podanie innej lokalizacji folderu.
