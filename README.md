## Drive
### Opis
Portal do udostępniania i wypożyczania różnego typu pojazdów do poruszania się po mieście.
Głównym 

#### Założenia biznesowe
- Użytkownicy mogą wypożyczać sprzęt pozostawiony w mieście.
- Obsługiwane rodzaje sprzętu: rower, hulajnoga, samochód, skuter. Lista rozszerzalna.
- Użytkownicy mogą rejestrować i udostępniać własny sprzęt. W momencie rejestracji, użytkownik określa jaki jest koszt 
  wypożyczenia sprzętu. Dla ułatwienia per minuta.
- Po rejestracji użytkownik musi zamontować nadajnik GPS otrzymany (zamówienie pominięte) od Administratora 
  po pewnym czasie i dopiero po tej akcji, sprzęt jest dostępny do wypożyczenia (od razu).
- Zarejestrowany użytkownik może zarówno samemu wypożyczyć czyjś sprzęt jak i wypożyczać swój sprzęt.
- Dostawca systemu zarabia na prowizji pobieranej od wypożyczającego sprzęt.
- Użytkownik może wycofać sprzęt w dowolnym momencie, jeśli sprzęt nie jest wypożyczony. Usunięcie nadajnika pominięte.

#### Założenia techniczne
- **NIE SKUPIAC SIE NA SZCZEGOLACH FUNKCJONALNOSCI - CELEM JEST ANALIZA ARCHITEKTURY I TESTY ROZWIAZAN**
- architektura projektowana przy wykorzystaniu: DDD, Event Storming, Bounded Context
- aplikacja złożona z mikroserwisów z API Gateway - komunikacja pomiędzy mikroserwisami z wykorzystaniem Event Driver Architecture
- aplikacja BE zbudowana w Spring Cloud z wykorzystaniem Kafka jako systemu messaggingu
- API gateway zabezpieczone przez spring security z JWT oparte na rolach i strukturze danych usera ze spring security
- Baza danych: mongodb. Każdy z mikroserwisów posiada własną bazę danych.
- ELK: zbieranie logów - opcjonalne. wstępnie wyszukiwanie i full text search (jeżeli potrzebny) w mongodb
- aplikacja FE napisana w Angularze
- rozszerzalność aplikacji przy wykorzystaniu: docker, kubernetes.
- rozważyć hazelcast jako holder autentykacji i distributed cache - https://medium.com/tech-tajawal/microservice-authentication-and-authorization-solutions-e0e5e74b248a
- w celu weryfikacji działania rozszerzalności aplikacji należy napisać testy wydajnościowe i symulację ruchu w aplikacji
- opcjonalnie Keycloack jako źródło autoryzacji.

#### Planowanie architektury
##### Diagram C4 systemu
- TODO

##### Metryki
- TODO - techniczne i biznesowe

##### Big picture event storming
- https://miro.com/app/board/o9J_kw9maMs=/
- /docs/event_storming/
- podział na subdomeny
- ograniczenie funkcjonalności 

#### Design Level Event Storming
- po znalezieniu bounded contextów należy dla każdego z nich przeprowadzić analizę design i określić: komendy, widoki i resztę

##### ADR
- https://medium.com/better-programming/here-is-a-simple-yet-powerful-tool-to-record-your-architectural-decisions-5fb31367a7da
- w katalogu /docs/ADR/

###### Architektura systemowa
- TODO

###### Architektura aplikacji
- TODO

##### Behavioral tests in Spock
- TODO

#### CI/CD
- https://dzone.com/articles/applying-cicd-to-java-apps-using-spring-boot

#### Sample pet clinic
- https://github.com/spring-petclinic/spring-petclinic-microservices

#### Fake data generator
- https://github.com/DiUS/java-faker




