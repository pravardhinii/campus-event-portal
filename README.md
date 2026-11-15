# Campus Event & Participant Registration Portal API

A production-ready Enterprise Spring Boot REST API capstone project designed for managing collegiate events, tracks, and participant registrations.

## Key Features & Concepts Applied
- **Controller Layer:** Full CRUD REST endpoints (`@RestController`, `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`) utilizing proper HTTP status codes.
- **Service & DTO Layer:** Decouples internal database entities from external API requests using dedicated DTOs and enforces server-side validation (`@Valid`, `@NotNull`, `@Size`, `@Email`).
- **Global Exception Handling:** Centralized `@ControllerAdvice` translating validation errors and resource-not-found exceptions into structured JSON error payloads.
- **Testing Suite:** Comprehensive unit tests for services using **JUnit 5** and **Mockito**, alongside MockMvc integration tests for controller endpoints.

## 🛠️ Tech Stack
- **Language:** Java 17
- **Framework:** Spring Boot 3.x (Spring Web, Spring Data JPA, Validation)
- **Database:** H2 Database (In-Memory)
- **Testing:** JUnit 5, Mockito, Spring Test / MockMvc
- **Build Tool:** Apache Maven

Open your browser and navigate to http://localhost:8080/h2-console to inspect the database.

