
# 🏢 My Task Manager
<br /> **Advanced Programming M604** 
<br /> **Java & SpringBoot Project**

# 📘 Introduction

This project aim to build and involved designing and developing a backend application to
handle the data with these things operations, including CRUD (Create, Read, Update, Delete),
and also it provide the RESTful API and also the simple GUI interface to the data and the user,
as well as strong error handling and validation.

The Task Manager application meets these needs. It is the Java 17 and also the SpringBoot
3.2.5 based web application is used in it. They are able to create the view, update, and also
delete the tasks via the RESTful API and also the browser based UI. This project also
showcases how do we utilize OOP principles, and how to integrate it with the databases
usingand also with JPA/Hibernate, plus how to control global exceptions.

# 🧾 Front-End UI Design

<img width="1456" height="1818" alt="Task_Manager  UserInterface" src="https://github.com/user-attachments/assets/a699e08a-b8a8-48ee-83e6-b210a611d6cb" />


# 📜 System Architecture

<img width="1733" height="395" alt="System Architecture" src="https://github.com/user-attachments/assets/8eccc0a6-3352-4fac-b610-0b440da2484b" />


# 📗 API Design

<img width="1305" height="334" alt="API_Design" src="https://github.com/user-attachments/assets/d9ce025f-a0d0-47c8-a2c8-db06ecd19638" />


# 📂 Repository Structure
<div>
    <pre>
task-manager-java/
├── pom.xml
└── src/main/
├── java/com/m604/taskmanager/
│ ├── TaskManagerApplication.java
│ ├── config/DataInitializer.java
│ ├── controller/TaskController.java
│ ├── dto/{ErrorResponse, TaskRequest}.java
│ ├── exception/{GlobalExceptionHandler,
│ │ InvalidInputException,
│ │ TaskNotFoundException}.java
│ ├── model/Task.java
│ ├── repository/TaskRepository.java
│ └── service/TaskService.java
└── resources/
├── application.properties
└── static/index.html
    </pre>
<div />

# 📌 **Features**
<br />✅ Backend Development
<br />✅ Data Interaction
<br />✅ API Development 
<br />✅ Error Handling

# ✨ **Objectives**
    🚀Create a Java backend using Spring Boot.
    🚀Implement an relational database with JPA.
    🚀Use a RESTful API to implement all the CRUD operations.
    🚀Make a GUI that runs in a browser.
    🚀Use holistic error-handling.
    🚀Make use of OOP concepts throughout.


# 🛠️ Technology Stack & Tools
---
| **Technology** | **Version** |**Purpose** |
| --- | --- | --- |
| **Java** | 17 (LTS) | Programming language |
| **Spring Boot** | 3.2.5 | Backend framework |
| **Spring Data** JPA | 3.2.5 | Database abstraction feature |
| **Hibernate** | 6.4.4 | ORM implementation |
| **H2 / SQLite** | 2.2.224 / 3.45.1 | Databases |
| **Maven** | 3.9.16 | Build tool |
| **Tomcat** | 10.1.20 | Embedded server |
---

# 🚀 How to Run
    Run:
01.--bash
02.--cd C:\Users\DELL\Desktop\task-manager-java
03.--mvn spring-boot:run
04.--After running above 2 commands then the server has been started on the http://localhost:5000 link which is the localhost open it in any browser which you want to run the application with the GUI.
    
# 📈 Future Improvements
    ➜ Docker containerization and Spring Security
    ➜ Pagination
    ➜ Unit tests with the JUnit
    ➜ Swagger documentation 
    ➜ cloud deployment 
    ➜ Mobile App Development

# 👨‍💻 Author

**Er. Manoj Kumar**

Aspiring Software Developer | AI & ML Enthusiast
