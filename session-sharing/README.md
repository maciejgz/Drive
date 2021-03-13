Spring session with redis tests.
Setup:
- redis setup in docker (ports should be correctly configured)
- run two instances of the app on port 8081 and 8082 
- run tests
 
user: admin/password

How it works?

Session created with basic auth is added to  redis and then can be taken by the user.
Spring security is using Redis as the session storage db.
Test checks if the rest template call with credentials saves JSESSIONID in the REDIS and then cleanup database.
After that, the same call with previous JSESSIONID is performed and user should not be logged out. 
Second main test checks if session is propagated to all app instances using the same SESSIONID in redis.