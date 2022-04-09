#### 1. Czy komunikacja pomiędzy API Gatway a serwisami powinna być synchroniczna czy asynchroniczna.

#### 2. Status

Accepted

#### 3. Context

W wersji asynchronicznej, wysłanie command powinno zwracać jedynie odpowiedź, że command zostało przyjęte i zwrócić
numer zlecenia. Następnie klient powinien odpytywać ponownie API czy zlecenie zostało już wykonane. < /br>

Inna opcja to synchroniczna komunikacja API Gateway z serwisem, do którego strzela a weryfikację całego procesu i
komunikacji asynchronicznej robi ten serwis. Połączenie pomiędzy API serwisu a API Gateway jest synchroniczne.

#### 4. Decision
Komunikacja pomiędzy API Gateway a serwisami będzie SYNCHRONICZNA po REST API.

#### 5. Consequences
Latwiejsza implementacja klienta i mniejsza złożoność API Gateway
