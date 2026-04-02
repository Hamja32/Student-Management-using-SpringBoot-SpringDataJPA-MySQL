# Student Management System

A production-ready RESTful API built with **Spring Boot** and **MySQL**, following clean layered architecture with DTO pattern, bean validation, and global exception handling.

---

## Tech Stack

| Technology | Version |
|---|---|
| Java | 17+ |
| Spring Boot | 3.x |
| Spring Data JPA | 3.x |
| MySQL | 8.x |
| Maven | 3.x |

---

## Project Structure

```
com.StudentManagement
├── controller/
│   └── StudentController.java       # REST endpoints
├── dto/
│   └── StudentDTO.java              # Data Transfer Object
├── exception/
│   ├── ResourceNotFoundException.java
│   └── GlobalExceptionHandler.java  # Centralized error handling
├── model/
│   └── Student.java                 # JPA Entity
├── repository/
│   └── StudentRepository.java       # JPA Repository
└── service/
    └── StudentService.java          # Business logic
```

---

## Features

- Full CRUD operations — Create, Read, Update, Delete
- DTO Pattern — Entity never directly exposed to client
- Bean Validation — `@NotBlank`, `@Email`, `@Min`
- Global Exception Handling — clean `404` and `400` responses
- Custom `ResourceNotFoundException`
- MySQL database integration

---

## API Endpoints

### Get All Students
```
GET /students
```
**Response — 200 OK**
```json
[
  {
    "id": 1,
    "name": "Rahul Kumar",
    "email": "rahul@example.com",
    "age": 20,
    "course": "Computer Science"
  }
]
```

---

### Get Student by ID
```
GET /students/{id}
```
**Response — 200 OK**
```json
{
  "id": 1,
  "name": "Rahul Kumar",
  "email": "rahul@example.com",
  "age": 20,
  "course": "Computer Science"
}
```
**Response — 404 Not Found**
```json
"Student nahi mila ID: 1"
```

---

### Create Student
```
POST /students
Content-Type: application/json
```
**Request Body**
```json
{
  "name": "Rahul Kumar",
  "email": "rahul@example.com",
  "age": 20,
  "course": "Computer Science"
}
```
**Response — 201 Created**
```json
{
  "id": 1,
  "name": "Rahul Kumar",
  "email": "rahul@example.com",
  "age": 20,
  "course": "Computer Science"
}
```
**Validation Error — 400 Bad Request**
```json
{
  "name": "Name cannot be blank",
  "email": "Enter a valid email",
  "age": "Age must be 16+"
}
```

---

### Update Student
```
PUT /students/{id}
Content-Type: application/json
```
**Request Body**
```json
{
  "name": "Rahul Kumar Updated",
  "email": "rahul.new@example.com",
  "age": 21,
  "course": "Information Technology"
}
```
**Response — 200 OK**
```json
{
  "id": 1,
  "name": "Rahul Kumar Updated",
  "email": "rahul.new@example.com",
  "age": 21,
  "course": "Information Technology"
}
```

---

### Delete Student
```
DELETE /students/{id}
```
**Response — 200 OK**
```
Student delete ho gaya!
```

---

## Database Configuration

Create a MySQL database first:
```sql
CREATE DATABASE student_management;
```

Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_management
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Running the Project

**1. Clone the repository**
```bash
git clone https://github.com/yourusername/student-management-system.git
cd student-management-system
```

**2. Create MySQL database**
```sql
CREATE DATABASE student_management;
```

**3. Update application.properties** with your MySQL credentials

**4. Run the application**
```bash
mvn spring-boot:run
```

**5. API is live at**
```
http://localhost:8080
```

---

## Validation Rules

| Field | Rule |
|---|---|
| name | Cannot be blank |
| email | Must be a valid email format |
| age | Must be 16 or above |
| course | Optional |

---

## Key Concepts Implemented

**DTO Pattern** — `StudentDTO` is used for all API requests and responses. The `Student` entity is never directly exposed, keeping the API clean and secure.

**Global Exception Handling** — `@ControllerAdvice` handles all exceptions in one place. `ResourceNotFoundException` returns a clean `404`, and validation failures return a `400` with field-level error messages.

**Safe Update** — Before updating, the existing record is fetched first. If not found, a `ResourceNotFoundException` is thrown instead of silently failing.

---

## What I Learned Building This

- Why Entity and DTO should always be separate
- Validation belongs on DTO, not Entity
- How `orElseThrow()` gives clean error responses
- Importance of layered architecture in real projects
- How `@ControllerAdvice` centralizes all error handling

---

## Author

**Hamza Khna**
- GitHub: https://github.com/Hamja32
- LinkedIn: https://www.linkedin.com/in/hamja-khan/

---

*Day 6 of learning Spring Boot — building toward becoming a Full Stack Java Developer.*
