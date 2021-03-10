Spring session with redis tests.
Setup:
- redis setup in docker
- run the app
- run tests

How it works?

Session created with basic auth is added to the redis and then can be taken by the user.
Spring security is using Redis as the session storage db.
Test checks if the rest template call with credentials saves JSESSION ID in the REDIs and then cleanup database.
After that, the same call with JSESSIONID is performed and user should not be logged out. 