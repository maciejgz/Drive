# Architectural concept
## Architectural assumptions
- **NIE SKUPIAC SIE NA SZCZEGOLACH FUNKCJONALNOSCI - CELEM JEST ANALIZA ARCHITEKTURY MIKROSERWISOWEJ I TESTY ROZWIAZAN**
- architektura projektowana przy wykorzystaniu: DDD, Event Storming, Bounded Context
- aplikacja złożona z mikroserwisów z API Gateway na CQRS - komunikacja pomiędzy mikroserwisami z wykorzystaniem Event Driver Architecture na Kafce
- aplikacja BE zbudowana w Spring Cloud z wykorzystaniem Kafka jako systemu messaggingu
- API gateway zabezpieczone przez spring security z JWT oparte na rolach i strukturze danych usera ze spring security
- Baza danych: mongodb. Każdy z mikroserwisów posiada własną bazę danych.
- ELK: zbieranie logów - opcjonalne. wstępnie wyszukiwanie i full text search (jeżeli potrzebny) w mongodb
- aplikacja FE napisana w Angularze
- rozszerzalność aplikacji przy wykorzystaniu: docker, kubernetes.
- rozważyć hazelcast jako holder autentykacji i distributed cache - https://medium.com/tech-tajawal/microservice-authentication-and-authorization-solutions-e0e5e74b248a
- w celu weryfikacji działania rozszerzalności aplikacji należy napisać testy wydajnościowe i symulację ruchu w aplikacji
- opcjonalnie Keycloak jako źródło autoryzacji
- trackowanie issues w githubie

## General concept

## ADR

## Metrics