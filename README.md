# JPA / Hibernate One to Many Mapping Example with Spring Boot

![Hibernate Logo](https://hibernate.org/images/hibernate-logo.svg)

## Introduction

This project demonstrates how to map a one-to-many database relationship using JPA and Hibernate in a Spring Boot application. It illustrates a scenario where each post can have multiple comments associated with it.

## Project Setup

1. **Clone the Repository**: Clone this repository to your local machine using the following command:
   ```bash
   git clone https://github.com/your-username/employee-management-system.git

Database Configuration: Configure the database connection properties in the application.properties file located in src/main/resources. Replace username and password with your MySQL credentials.

spring.datasource.url=jdbc:mysql://localhost:3306/jpa_one_to_many_demo?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username=root
spring.datasource.password=root

Run the Application: Run the Spring Boot application using your IDE or the following command:

mvn spring-boot:run


Domain Models
This project defines two domain models: Post and Comment, which represent posts and comments in a blog.

JPA Auditing
JPA Auditing is enabled in this project to automatically populate the created_at and updated_at fields for each entity. The auditing configuration is done using Spring Boot's @EnableJpaAuditing annotation.

REST APIs
The project includes REST APIs to perform CRUD operations on both posts and comments. These APIs are implemented in the PostController and CommentController classes.

Exception Handling
ResourceNotFoundException is thrown when a requested resource (post or comment) is not found. This exception is handled globally and returns an HTTP status code of 404.

Dependencies
This project uses the following dependencies:

Spring Boot Web
Spring Data JPA
MySQL Driver

Directory Structure

jpa-one-to-many-demo/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── jpa/
│       │               ├── controller/
│       │               ├── exception/
│       │               ├── model/
│       │               ├── repository/
│       │               └── JpaOneToManyDemoApplication.java
│       └── resources/
│           └── application.properties
└── pom.xml

Conclusion
This project provides a comprehensive example of how to implement a one-to-many mapping using JPA and Hibernate in a Spring Boot application. You'll learn how to define domain models, configure database connections, write REST APIs, and handle exceptions effectively.
