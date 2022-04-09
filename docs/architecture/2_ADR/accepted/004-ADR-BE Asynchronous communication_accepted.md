#### 1. Select technology for the BE communication layer between microservices.

#### 2. Status 
Proposed

#### 3. Context 
Komunikacja pomiędzy mikroserwisami jako event based z sagami, ale nie event storming. 
Przechowywanie danych wciąż w bazach w wersji 1.

#### 4. Decision
Asynchroniczna komunikacja pomiędzy mikroserwisami przy pomocy eventów w Kafce

#### 5. Consequences 
