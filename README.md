# Library Management System

A full-stack library management application built with Spring Boot, PostgreSQL, and vanilla HTML/CSS/JavaScript.

## Features

- Dashboard statistics for books, students, librarians, borrowed books, and available books
- Book management with add, view, update, and delete operations
- Student and librarian management
- Book borrowing and return workflow
- User registration and login endpoints
- Responsive browser-based interface served by Spring Boot

## Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven
- HTML, CSS, and JavaScript
- Lombok

## Project Structure

```text
Library-Management-System/
├── backend/
│   └── src/main/
│       ├── java/com/library/
│       │   ├── controller/
│       │   ├── dto/
│       │   ├── entity/
│       │   ├── repository/
│       │   └── service/
│       └── resources/
│           ├── application.properties
│           └── static/
├── .env.example
├── .gitignore
├── pom.xml
└── RUN_INSTRUCTIONS.txt
```

## Prerequisites

Install:

- JDK 17 or newer
- Apache Maven
- PostgreSQL

## Database Setup

Create a PostgreSQL database:

```sql
CREATE DATABASE "Library_Management_system";
```

Set your PostgreSQL password as an environment variable before starting the project.

### Windows PowerShell

```powershell
$env:DB_PASSWORD="your_postgresql_password"
mvn spring-boot:run
```

### Windows Command Prompt

```bat
set DB_PASSWORD=your_postgresql_password
mvn spring-boot:run
```

### Git Bash / Linux / macOS

```bash
export DB_PASSWORD="your_postgresql_password"
mvn spring-boot:run
```

The following variables can be configured:

| Variable | Default |
|---|---|
| `DB_URL` | `jdbc:postgresql://localhost:5432/Library_Management_system` |
| `DB_USERNAME` | `postgres` |
| `DB_PASSWORD` | Empty; must be supplied if PostgreSQL requires one |
| `SERVER_PORT` | `8080` |

## Open the Application

After the application starts, open:

```text
http://localhost:8080/dashboard.html
```

API check:

```text
http://localhost:8080/api/books
```

## Main API Endpoints

| Module | Endpoint |
|---|---|
| Books | `/api/books` |
| Students | `/api/students` |
| Librarians | `/api/librarians` |
| Borrow/Return | `/api/borrow` |
| Dashboard | `/api/dashboard/stats` |
| Login | `/api/login` |

## Important Note

This is an academic/demo project. Passwords are currently handled as plain text in the application code, so authentication should be upgraded with password hashing and proper security before any production deployment.
