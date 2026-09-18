# M604 Task Manager (Java / Spring Boot)

Simple task manager — Java version of the original Flask project.
REST API + HTML UI + database (H2 by default, SQLite optional).

## Project scope covered
- **Backend Development** → Spring Boot REST controllers + services
- **Database Interaction** → JPA + Hibernate + H2/SQLite, entity schema
- **API Development** → RESTful endpoints + web UI (index.html)
- **Error Handling** → custom exceptions + `@ControllerAdvice` global handler

## Run

Requirements: **JDK 17+** and **Maven**.

```bash
mvn spring-boot:run