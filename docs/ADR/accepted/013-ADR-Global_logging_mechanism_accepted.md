#### 1. How to organize generic logging mechanism

#### 2. Status 
Accepted

#### 3. Context 
Logs should be gathered from all the system components in the same, generic way.

#### 4. Decision 
Use Spring AOP for logging input of each method, exception thrown and result of the methods' execution.

#### 5. Consequences 
Not feasible for each method - standard logging shall be still used.
One common component shall be used in each component.
