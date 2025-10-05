Hospital Management System 🏥
Java Spring Boot backend for managing patients and doctors using PostgreSQL and Testcontainers. Full CRUD operations via JSON API.
Patient Service 🏥
Technologies: Java, Spring Boot, PostgreSQL, Testcontainers
Patient Service is a Spring Boot backend application for managing patient records, supporting full CRUD operations with PostgreSQL.
Features
Create, Read, Update, Delete patients
UUID identifiers for each patient
Integration tests with Testcontainers
JSON API using Jackson
Quick Start
Run with Docker (PostgreSQL):
docker run --name patient-db -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=your_password -e POSTGRES_DB=db3 -p 5432:5432 -d postgres:12
Configure Application:
spring.datasource.url=jdbc:postgresql://localhost:5432/db3
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.sql.init.mode=always
Run Application:
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
  "gender":"MALE",
  "weight":80.3,
  "height":180.5,
  "email":"test@mail.com",
  "phoneNumber":"+1 (22) 1111 77",
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
Doctor Service 🩺
Technologies: Java, Spring Boot, PostgreSQL, Testcontainers
Doctor Service is a Spring Boot backend application for managing doctor records, supporting full CRUD operations with PostgreSQL.
Features
Create, Read, Update, Delete doctors
Filter doctors by gender or specialization
UUID identifiers for each doctor
Integration tests with Testcontainers
JSON API using Jackson
Quick Start
Run with Docker (PostgreSQL):
docker run --name doctor-db -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=your_password -e POSTGRES_DB=dsdb -p 5432:5432 -d postgres:12
Configure Application:
spring.datasource.url=jdbc:postgresql://localhost:5432/dsdb
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.sql.init.mode=always
Run Application:
./gradlew bootRun
# or
mvn spring-boot:run
API is available at: http://localhost:8080/doc
REST API Examples
Create Doctor
curl -X POST http://localhost:8080/doc \
-H "Content-Type: application/json" \
-d '{
  "firstName":"Carl",
  "lastName":"Edge",
  "gender":"MALE",
  "email":"test@mail.com",
  "phoneNumber":"+1 (440) 330 33219",
  "specialization":"Gynaecologist",
  "rating":0.0,
  "schedule":"From Monday to Friday, From 9:00 AM to 18:00 PM"
}'
Get Doctor by ID
curl http://localhost:8080/doc/<UUID>
Get All Doctors
curl http://localhost:8080/doc/doctors
Get by Specialization
curl http://localhost:8080/doc/specialization/<specialization>
Get by Gender
curl http://localhost:8080/doc/gender/<gender>
Update Doctor
curl -X PUT http://localhost:8080/doc/<UUID> \
-H "Content-Type: application/json" \
-d '{ "firstName":"Douglas","lastName":"Duck","specialization":"Ophthalmologist" }'
Delete Doctor
curl -X DELETE http://localhost:8080/doc/<UUID>
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
UUID is used as the primary identifier for both patients and doctors
JSON serialization handled via Jackson
spring.sql.init.mode=always ensures DB scripts are executed in tests
