### Setup:
#### docker compose services:

- mariadb on port 3306
- mongodb port 27017
- mongo_express port 8081
- keycloack port 8080

For docker toolbox use IP assigned to the machine. for standard docker use localhost as a domain.

#### Profiles
- local-docker-toolbox - local configuration with legacy docker instance on windows 10 home
- local-docker - local configuration with a standard docker instance

#### Database
Managed by liquibase. Each modification shall be added to /resources/liquibase/drive-changeLog.xml

#### Keycloack
Users are managed in keycloack hosted with docker.
After the setup, access page: /auth/admin in keycloack to manage system using credentials from docker compose.yml</br>

##### Setup keycloack
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
  - required tables already defined in the liquibase
  - start app
  - access a main page: http://localhost:8100/
  - after clicking customers link, redirect to the keycloack and go back with tokens and secured page (users will be added automatically).
