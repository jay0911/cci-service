# CCI service


##Pre-requisites
- java 17

## Setup
already tested with given postman
added scheduler for batch job
followed the api spec, but must add pagination if assuming data is large,
added index to the table assuming data is large
added liquibase for db migration management
can access h2 console and swagger api doc, http://localhost:8080/api/swagger-ui/index.html, http://localhost:8080/api/h2-console/
temporary database on h2 db
added dockerfile for readyness on containerization
add shedlock for locking on scheduler if multi node setup on kubernetes
