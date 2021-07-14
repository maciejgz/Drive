### Setup:
#### docker compose services:

- mariadb on port 3306
- mongodb port 27017
- mongo_express port 8081
- keycloak port 8080
- drive app port 8100

For docker toolbox use IP assigned to the machine. for standard docker use localhost as a domain.

### Package build
- spring boot plugin creates executable jar </br>
`mvn clean compile package spring-boot:repackage -Dmaven.test.skip=true`

#### Profiles
- local-docker-toolbox - local configuration with legacy docker instance on windows 10 home
- local-docker - local configuration with a standard docker instance

#### Database
Managed by liquibase. Each modification shall be added to /resources/liquibase/drive-changeLog.xml

#### Keycloak
Keycloak hosted with docker manages users.
After the setup, access page: /auth/admin in keycloak to manage system using credentials from docker compose.yml</br>

##### Setup keycloak
- http://host:port/auth/admin - admin dashboard
- create the realm: drive
- create client drive with standard values except:  Valid Redirect URIs=http://appHost:port/*
- create roles: user and admin
- create user and attach the user role to him
- get token with request POST request: </br>
  curl --location --request POST 'http://192.168.99.102:8080/auth/realms/drive/protocol/openid-connect/token' \
  --header 'Content-Type: application/x-www-form-urlencoded' \
  --data-urlencode 'client_id=drive' \
  --data-urlencode 'username=user1' \
  --data-urlencode 'password=qaz123' \
  --data-urlencode 'grant_type=password'
- integrate with spring boot base on https://www.baeldung.com/spring-boot-keycloak using thymeleaf
  - during keycloak config setup correct redirect URI with * mask like `http://localhost:8100/*`
  - create roles `user` and `admin` and assign them to `user1` and `admin1`
  - create SSO client `drive`  
  - required tables already defined in the liquibase
  - start app
  - access a main page: http://localhost:8100/
  - after clicking customers link, redirect to the keycloak and go back with tokens and secured page (users will be added automatically).
  - whole KeyCloak config can be imported from json - file is stored locally, not on the repo.
  - user can login using URL like this: `http://192.168.99.102:8080/auth/realms/drive/protocol/openid-connect/auth?response_type=code&client_id=drive&scope=openid&redirect_uri=http://192.168.99.102:8100/`
  

### Code structure
Code structure is prepared for the DDD subdomains but still in the monolith app. Packages:
- user - user account info and management
- vehicle - vehicle management by the user
- search - searching for the vehicles
- rent - renting vehicle 
- gps - GPS devices management
- billing - user billing management
- travel - domain of the travel
