# Architectural concept

## Architectural assumptions

- **NIE SKUPIAC SIE NA SZCZEGOLACH FUNKCJONALNOSCI - CELEM JEST ANALIZA ARCHITEKTURY MIKROSERWISOWEJ, CHMUR I TESTY ROZWIAZAN**
- architektura projektowana przy wykorzystaniu: DDD, CQRS, Event Storming (opcjonalnie), Bounded Context
- aplikacja złożona z mikroserwisów z API Gateway na CQRS - komunikacja pomiędzy mikroserwisami z wykorzystaniem Event
  Driver Architecture (nie w pełni) na Kafce
- aplikacja BE zbudowana w Spring Cloud z wykorzystaniem Kafka jako systemu messaggingu
- API gateway zabezpieczone przez spring security z JWT oparte na rolach i strukturze danych usera ze spring security i Keycloack
- Baza danych: mongodb. Każdy z mikroserwisów posiada własną bazę danych.
- ELK: zbieranie logów - opcjonalne. wstępnie wyszukiwanie geo w mongodb bez open text search
- aplikacja FE napisana w Angularze
- rozszerzalność aplikacji przy wykorzystaniu: docker, kubernetes
- rozważyć hazelcast/redis jako holder autentykacji i distributed cache. Opcjonalnie wykorzystanie tokenów
  - https://medium.com/tech-tajawal/microservice-authentication-and-authorization-solutions-e0e5e74b248a
- w celu weryfikacji działania rozszerzalności aplikacji należy napisać testy wydajnościowe i symulację ruchu w
  aplikacji
- trackowanie issues w githubie

## Requirements

[Requirements.md](./1_requirements/Requirements.md)

## Analysis

### Business processes - described during meetings with domain experts

[Business processes](./3_business_processes)

### Use cases - business processes migrated to UML processes

[Use cases](./4_use_cases)

### Data model

[Data model](./5_data_model)

## ADR

[ADRs](./2_ADR)

## Architecture

## General concept - integration architecture

[general concept](./6_architectural_concept)

### Technical architecture
[Tech arch](./7_technical_architecture)

### Infrastructure architecture
[Infrastructure arch](./8_infrastructure_architecture)

## Metrics

[Metrics](./9_metrics)
