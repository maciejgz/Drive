#### 1. Title
Metrics gathering

#### 2. Status 
Accepted

#### 3. Context 
Metrics of each component should be stored into centralized component. JVM metrics shall be collected as well as custom metric regarding connectivity, app performannce on the business level.

#### 4. Decision 
Stack: </br>
- Micrometer with custom and built in metrics
- Prometheus - as time series db for storing metrics using HTTP interfaces from Spring Boot micrometers endpoints
- Grafana - dashboards - easy integration with many data sources

#### 5. Consequences 
Another component. To be considered if the common elasticseach already in the system shall be used instead of Prometheus.