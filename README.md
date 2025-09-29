
# ⚔️ Ninja Registration System

This project is a robust, layered-architecture application built with **Spring Boot** for managing ninjas and their associated missions. It demonstrates modern Java backend development practices such as database migration, ORM, and layered application design.

---

## 🚀 Overview

The **Sistema de Cadastro de Ninjas** is designed to manage the core data of a ninja-based organization.  
It emphasizes a **One-to-Many relationship** where a Mission can have multiple Ninjas, but each Ninja belongs to a single Mission.

### Key Features

- **Ninja Management**: CRUD operations for ninjas, including attributes like *Name, Age, Email, and Rank*.
- **Mission Assignment**: Assign a Ninja to a specific Mission.
- **Mission Management**: CRUD operations for missions (*Title, Description*).
- **Layered Architecture**: Clear separation of concerns (Controller, Service, Repository) for maintainability and scalability.

---

## 💻 Technical Stack and Tools

| Category           | Technology                    | Purpose                                                                 |
|--------------------|-------------------------------|-------------------------------------------------------------------------|
| Backend Framework  | Spring Boot                   | Rapid development, dependency injection, and auto-configuration.        |
| Persistence        | Spring Data JPA (Hibernate)   | Simplifies data access with ORM and declarative transaction management. |
| Database           | H2 Database                   | Lightweight, in-memory database for development/testing.                |
| Database Migration | Flyway                        | Reliable management of schema changes.                                  |
| Build Tool         | Maven                         | Dependency management and project build lifecycle.                      |
| Containerization   | Docker                        | External DB configuration and consistent environments.                  |
| Version Control    | Git / GitHub                  | Code versioning and collaboration.                                      |
| Query Language     | SQL                           | Schema definition and database manipulation.                            |

---

## 📐 Architecture and Design

### Layered Architecture

The application follows a standard **N-Tier / Layered Architecture** ensuring high cohesion and low coupling:

- **Controller Layer (REST API)**: Handles HTTP requests, validates input, and maps results to responses.
- **Service Layer (Business Logic)**: Orchestrates transactions, enforces rules (e.g., Mission ↔ Ninja relationships).
- **Repository Layer (Data Access)**: Interacts with the database using Spring Data JPA.

### Data Model

- **Ninja Entity**: Holds ninja details (`id`, `name`, `age`, `email`, `rank`).  
  → Contains a foreign key to the assigned Mission.
- **Mission Entity**: Stores mission details (`id`, `title`, `description`).  
  → Represents the “One” side of the **One-to-Many** relationship.

**Relationship**:  
`1 Mission → N Ninjas`

### Database Migration with Flyway

- Ensures the application always starts with a consistent database state.
- Schema versions are tracked and reproducible across environments.

---

## 🛠️ Configuration and Execution

### Prerequisites
- Java Development Kit (JDK) 17+
- Maven

### Getting Started

**Clone the repository:**
```bash
git clone https://github.com/horaciomuller/CadastroDeNinjas.git
cd CadastroDeNinjas
```

**Build the project:**
```bash
mvn clean install
```

**Run the application:**
```bash
mvn spring-boot:run
```

The app will run with the **H2 in-memory database**.

### Access the Application

- **API Root:** [http://localhost:8080](http://localhost:8080)
- **H2 Console:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)  
  (Check `application.properties` for JDBC URL and credentials.)

---

## 📜 Swagger / API Documentation

This project integrates **Swagger / OpenAPI** for easy exploration and testing of the REST API.

- **Swagger UI:** [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- Provides interactive documentation for all endpoints, including:
  - Create, read, update, and delete **Ninjas**
  - Create, read, update, and delete **Missions**
- Automatically displays **request and response models** (`NinjaDTO`, `QuestDTO`) and all required parameters.
- Helps developers and testers **understand and try the API** without needing external tools.

---

## 📈 Learnings and Future Enhancements

### Learnings
- Implementing layered architecture in Spring Boot.
- Applying ORM with JPA for complex relationships.
- Managing schema migrations with Flyway.
- Leveraging in-memory DBs for fast development/test cycles.

### Potential Enhancements
- Add **Spring Security** with role-based access control (RBAC).
- Implement **Integration Testing** for REST APIs.
- Swap H2 with a persistent DB like PostgreSQL/MySQL (via Docker Compose).  
