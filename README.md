# JPA / Hibernate One to Many Mapping Example with Spring Boot

![Hibernate Logo](https://hibernate.org/images/hibernate-logo.svg)

## Introduction

This project demonstrates how to map a one-to-many database relationship using JPA and Hibernate in a Spring Boot application. It illustrates a scenario where each post can have multiple comments associated with it.

## Overview

The project showcases the mapping between two tables - posts and comments - in a Blog database schema, where the posts table has a one-to-many relationship with the comments table.

## Getting Started

To create the project, follow these steps:

1. **Generate the Project**:
   - If you have Spring Boot CLI installed, run the following command in your terminal:
     ```
     spring init -n=jpa-one-to-many-demo -d=web,jpa,mysql --package-name=com.example.jpa jpa-one-to-many-demo
     ```
   - Alternatively, use Spring Initializr web tool:
     - Go to [Spring Initializr](http://start.spring.io).
     - Enter Artifact as “jpa-one-to-many-demo”.
     - Configure metadata options and select Web, JPA, and MySQL dependencies.
     - Click Generate to download the project.

2. **Configure the Database and Logging**:
   - Open `src/main/resources/application.properties` file and configure the database URL, username, and password for MySQL.
   - Ensure a database named `jpa_one_to_many_demo` exists in MySQL.

3. **Define Domain Models**:
   - Define domain models for the application, including Post and Comment entities.
   - Utilize common auditing fields like `created_at` and `updated_at`.

4. **Enable JPA Auditing**:
   - Add `@EnableJpaAuditing` annotation to the main configuration class (`JpaOneToManyDemoApplication.java`) to enable JPA Auditing.

5. **Write REST APIs**:
   - Implement REST APIs to perform CRUD operations on Post and Comment entities.
   - Controller classes are defined inside `com.example.jpa.controller` package.

## Key Points

- **Best Practice for One-to-Many Mapping**:
  - Utilize `@ManyToOne` annotation on the child entity for the best way to model a one-to-many relationship.
  - Alternatively, define a bidirectional association with `@OneToMany` on the parent side and `@ManyToOne` on the child side.

- **Automatic Table Creation**:
  - Hibernate automatically generates tables from the defined entities (`Post` and `Comment`), leveraging `spring.jpa.hibernate.ddl-auto = update`.

- **JPA Auditing**:
  - Spring Boot’s JPA Auditing feature is enabled to automatically populate audit fields (`created_at` and `updated_at`) while persisting entities.

- **Exception Handling**:
  - `ResourceNotFoundException` is thrown for cases where a post or comment could not be found.

## Directory Structure

The project directory structure is as follows:
jpa-one-to-many-demo/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/
│ │ │ └── example/
│ │ │ └── jpa/
│ │ │ ├── controller/
│ │ │ │ ├── CommentController.java
│ │ │ │ └── PostController.java
│ │ │ ├── exception/
│ │ │ │ └── ResourceNotFoundException.java
│ │ │ ├── model/
│ │ │ │ ├── AuditModel.java
│ │ │ │ ├── Comment.java
│ │ │ │ └── Post.java
│ │ │ ├── repository/
│ │ │ │ ├── CommentRepository.java
│ │ │ │ └── PostRepository.java
│ │ │ └── JpaOneToManyDemoApplication.java
│ │ └── resources/
│ │ └── application.properties
└── pom.xml


# JPA / Hibernate One to Many Mapping Example with Spring Boot

This project provides an example of implementing a one-to-many database relationship using JPA and Hibernate within a Spring Boot application.

## Key Concepts

- **One-to-Many Relationship**: Understand the concept of a one-to-many relationship between entities in a database schema.

- **JPA and Hibernate**: Learn how to use JPA (Java Persistence API) and Hibernate to map Java objects to database tables and vice versa.

- **Domain Models**: Define domain models (`Post` and `Comment` entities) to represent the data structure of the application.

- **CRUD Operations**: Implement CRUD (Create, Read, Update, Delete) operations on the entities using RESTful APIs.

- **Database Configuration**: Configure database properties such as URL, username, and password in the `application.properties` file.

- **Automatic Table Creation**: Utilize Hibernate's feature to automatically create database tables from entity classes.

- **Exception Handling**: Handle exceptions, such as resource not found, in the REST APIs using custom exception classes.

- **Directory Structure**: Understand the organization of project files and packages, including controllers, models, repositories, and the main application class.

## Conclusion

This project serves as a practical guide for learning how to work with one-to-many relationships in a Spring Boot application using JPA and Hibernate.


## Conclusion

This project provides a comprehensive example of implementing a one-to-many relationship using JPA and Hibernate within a Spring Boot application, along with RESTful APIs for CRUD operations.

