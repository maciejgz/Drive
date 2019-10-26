## Drive
### Opis
Portal do udostępniania i wypożyczania różnego typu pojazdów do poruszania się po mieście.
Głównym 

#### Założenia biznesowe
- Użytkownicy mogą wypożyczać sprzęt pozostawiony w mieście
- Użytkownicy mogą rejestrować i udostępniać własny sprzęt definiując datę i miejsce jego dostępności
- Zarejestrowany użytkownik może zarówno wypożyczyć jak i wypożyczać sprzęt
- Dostawca systemu zarabia na prowizji pobieranej od wypożyczającego sprzęt

#### Założenia techniczne
- architektura projektowana przy wykorzystaniu: DDD, Event Storming, Bounded Context
- aplikacja złożona z mikroserwisów z API Gateway - komunikacja pomiędzy mikroserwisami z wykorzystaniem Event Driver Architecture
- aplikacja BE zbudowana w Spring Cloud z wykorzystaniem Kafka jako systemu messaggingu
- API gateway zabezpieczone przez spring security z JWT oparte na rolach i strukturze danych usera ze spring security
- Baza danych: mongodb. Każdy z mikroserwisów posiada własną bazę danych.
- ELK: zbieranie logów - opcjonalne. wstępnie wyszukiwanie i full text search (jeżeli potrzebny) w mongodb
- finalnie będzie aplikacja FE napisana w Angularze
- rozszerzalność aplikacji przy wykorzystaniu kubernetesa i obrazów w dokerze
- rozważyć redis jako holder autentykacji
- w celu weryfikacji działania rozszerzalności aplikacji należy napisać testy wydajnośćiowe i symulację ruchu w aplikacji


#### Planowanie architektury
##### Big picture event storming
- https://miro.com/app/board/o9J_kw9maMs=/
- /docs/event_storming/
- podział na subdomeny



