#### 1. Versioning and auto update of the DB model - Liquibase

#### 2. Status
Rejected

#### 3. Context
DB model shall be versioned and updated automatically on all platforms using a tool. 
Each change shall be added as a commit.

#### 4. Decision
Liquibase shall not be used as Mongo DB is used to store aggregates.

#### 5. Consequences 
