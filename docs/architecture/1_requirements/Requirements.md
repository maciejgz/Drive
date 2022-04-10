# 1. Requirements

## Functional requirements
 TODO opisać je w formie user stories oraz ASR workbooka i wybrać kluczowe dla architektury wymagania (ASR - Architectural significant requirements)
- Użytkownicy mogą rejestrować się w systemie.
- Użytkownicy mogą wypożyczać pojazdy w obrębie miasta.
- Obsługiwane rodzaje pojazdów: rower, hulajnoga, samochód, skuter. Lista rozszerzalna.
- Użytkownicy mogą rejestrować i udostępniać własny sprzęt. W momencie rejestracji pojazdu, użytkownik określa jaki jest koszt
  wypożyczenia sprzętu per minuta.
- Zarejestrowany użytkownik może zarówno samemu wypożyczyć czyjś sprzęt do użytku oraz wypożyczać swój sprzęt dodany do
  systemu.
- Dostawca systemu zarabia na prowizji pobieranej od wypożyczającego sprzęt - 5% z kwoty wypożyczenia.
- Użytkownik może wycofać sprzęt w dowolnym momencie, jeśli sprzęt nie jest w danym momencie wypożyczony.
- Lokalizacja aktywnych klientów i sprzętu jest przesyłana do systemu w określonych interwałach - maksymalnie 1s.
- Wyszukiwanie pojazdów na mapie w pobliżu
- Chargowanie usera po zakończonym wypożyczeniu w zewnętrznym systemie symulującym 
  
## Non-functional requirements (Quality attributes, constraints, ASR - architectural significant requirements)

- Wszystkie dane o trasie, wypożyczeniach i innych powinny być zapisywane w formie logów (Kafka?) do późniejszej analizy
- Wymagana wysoka przepustowość
- Skalowalność aplikacji na podstawie wybranych metryk, np. liczby aktywnych użytkowników
- Konteneryzacja wszystkich elementów systemu
- technologie chmurowe
- NoSQL databases aby ułatwić CQRS
- CI/CD w Travis CI
- architektura mikroserwisowa w oparciu o stack Spring Boot/Spring Cloud
- komunikacja pomiędzy serwisami powinna być asynchroniczna
- Wydzielony serwer autoryzacji - Keycloack
- Konieczne jest napisanie symulatora działania systemu

# 2. Stakeholders

List of stakeholders in the project:
- company owner
- developers
- vehicle owner
- borrower
<p>

[drawIO file](./stakeholders.drawio)
<br />

![](stakeholders.jpg)

# 3. Stakeholders business goals

<p>Opisywne w postaci: {stakeholder} needs to {business goal} because {reason/context}</p>

| Stakeholder   |                     Goal                     |                                                                                                            Context |
|---------------|:--------------------------------------------:|-------------------------------------------------------------------------------------------------------------------:|
| Company owner |          Get income from the system          |                System powinien być używany przez jak największą liczbę userów, aby zmaksymalizować przychód. <br/> |
| Developers    | zbudowanie szybkiego i przystępnego systemu  |           Odpowiednio działający system zbudowany zgodnie z założeniami clean code ułatwi jego rozwój i utrzymanie |
| Vehicle owner |       Możliwość udostępnienia sprzętu        | Z punktu widzenia właściciela pojazdu najważniejsza jest bezpieczeństwo sprzętu i wiedza na temat jego lokalizacji |
| Borrower      | łatwo dostępny system i szybkie wypożyczanie |                                                                Szybkość wypożyczenia i dokładność naliczania opłat |


# 4 Constraints

Ograniczenia nałożone przez wymagania, aktorów tworzących system lub prawo

| Constraint                | Origin |      Type | Context |
|---------------------------|:------:|----------:|--------:|
| Microservice architecture |  Dev   | Technical ||

# 5 Quality requirements

TODO

