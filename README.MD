# Patient Service 🏥

![Java](https://img.shields.io/badge/Java-22-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-12-blue)
![Testcontainers](https://img.shields.io/badge/Testcontainers-1.21.3-orange)

**Patient Service** is a Spring Boot backend application for managing patient records, supporting full CRUD operations with PostgreSQL.

---

## Features
- Create, Read, Update, Delete patients
- UUID identifiers for each patient
- Integration tests with Testcontainers
- JSON API using Jackson

---

## Quick Start

### Run with Docker (PostgreSQL)
```bash
docker run --name patient-db -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=your password here -e POSTGRES_DB=db3 -p 5432:5432 -d postgres:12
Configure Application
spring.datasource.url=jdbc:postgresql://localhost:5432/db3
spring.datasource.username=postgres
spring.datasource.password=your password 
spring.jpa.hibernate.ddl-auto=update
spring.sql.init.mode=always
Run Application
./gradlew bootRun
# or
mvn spring-boot:run
API is available at: http://localhost:8080/api
REST API Examples
Create Patient
curl -X POST http://localhost:8080/api \
-H "Content-Type: application/json" \
-d '{
  "firstName":"Dima",
  "lastName":"Nemo",
  "email":"test@mail.com",
  "phoneNumber":"+1111111111",
  "dateOfBirth":"2000-01-01",
  "address":"ST test 4/3",
  "registeredDate":"2020-01-01"
}'
Get Patient by ID
curl http://localhost:8080/api/<UUID>
Get All Patients
curl http://localhost:8080/api/patients
Update Patient
curl -X PUT http://localhost:8080/api/<UUID> \
-H "Content-Type: application/json" \
-d '{ "firstName":"Sasha","phoneNumber":"+222222222" }'
Delete Patient
curl -X DELETE http://localhost:8080/api/<UUID>
Run Tests
Integration tests use Testcontainers and PostgreSQL in Docker:
./gradlew test
# or
mvn test
Project Structure
src/main/java
├─ controller  # REST endpoints
├─ dto         # Request & Response DTOs
├─ entity      # JPA entities
├─ repository  # Spring Data JPA repositories
├─ service     # Business logic
src/test/java
├─ integration # Integration tests with Testcontainers
Notes
UUID is used as the primary identifier for patients.
JSON serialization is handled via Jackson.
spring.sql.init.mode=always ensures DB scripts are executed in tests.
