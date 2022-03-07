#### 1. Select Authentication/Authorization mechanism for distributed environment

#### 2. Status 
Proposed

#### 3. Context
https://medium.com/tech-tajawal/microservice-authentication-and-authorization-solutions-e0e5e74b248a
https://dzone.com/articles/authentication-and-authorization-in-microservices

#### 4. Decision 
Authentication based on JWT/OAuth2.0/OpenID Connect implemented with Keycloack.

#### 5. Consequences 
Additional authentication centralized server is required but all the logic and requirements are already handled 
by 3rd party service. 
