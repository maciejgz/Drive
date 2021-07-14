## Functional requirements

- Użytkownicy mogą wypożyczać pojazdy w obrębie miasta.
- Obsługiwane rodzaje pojazdów: rower, hulajnoga, samochód, skuter. Lista rozszerzalna.
- Użytkownicy mogą rejestrować i udostępniać własny sprzęt. W momencie rejestracji, użytkownik określa jaki jest koszt
  wypożyczenia sprzętu per minuta.
- Po rejestracji użytkownik musi zamontować nadajnik GPS otrzymany (zamówienie pominięte) od Administratora po pewnym
  czasie i dopiero po tej akcji, sprzęt jest dostępny do wypożyczenia (od razu).
- Zarejestrowany użytkownik może zarówno samemu wypożyczyć czyjś sprzęt do użytku oraz wypożyczać swój sprzęt dodany do
  systemu.
- Dostawca systemu zarabia na prowizji pobieranej od wypożyczającego sprzęt - 5% z kwoty wypożyczenia.
- Użytkownik może wycofać sprzęt w dowolnym momencie, jeśli sprzęt nie jest w danym momencie wypożyczony. W momencie
  usunięcia sprzętu nadajnik GPS jest usuwany.
- Lokalizacja klientów i nadajników jest przesyłana do systemu w określonych interwałach.
- Wyszukiwanie pojazdów na mapie z ograniczeniem obszaru.
- Chargowanie usera po zakończonym wypożyczeniu - +/- na konto usera. Jeśli user posiada swoje pojazdy, na jego konto
  dodawane są pieniądze otrzymane z wypożyczeń tych pojazdów.
  
## Non-functional requirements

- Wszystkie dane o trasie, wypożyczeniach i innych powinny być zapisywane w formie logów (Kafka) do późniejszej analizy
- Rozszerzalność aplikacji
- Konteneryzacja
- technologie chmurowe
- CI/CD
