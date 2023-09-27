# Exercise 5

## Base
- Solution of exercise 4: A Spring Boot web application with a simple product catalog and a CRUD (Create, Read, Update, Delete) HTTP-API and some API tests

## Goals
- Learn how to use Spring Data JPA
- Learn how to query data with `JpaRepository`

## Steps
- We will now remove our simple `ProductCatalog` persistence implementation and replace it with a proper SQL database (and also remove much of the boilerplate code for accessing it)
- Add spring-boot-starter-data-jpa to the project (and the H2 in-memory database)
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
    </dependency>
    ```
- Convert `Product` into a JPA entity (add `@Entity`, give it a constructor without arguments and annotate the primary key field with `@Id` and `@GeneratedValue(strategy = GenerationType.AUTO)`)
- Create an interface `ProductRepository` that extends `JpaRepository` (see documentation link below) with an empty body
- Add `@EnableJpaRepositories` to the Application main class
- Migrate `ProductController` to use the newly created `ProductRepository`
    - Check out what methods for data access are now provided for you
    - While implementing, make sure that the behavior of the existing REST endpoints does not change
- Delete `ProductCatalog`
- Test your application (you can do it manually, but in the end all tests must succeed without changes to them)

## Hints / Challenges
- See documentation of `JpaRepository` and its superinterfaces to discover what useful methods it provides out of the box: https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
- Implement more useful methods on `ProductController`, i.e. getting all products, getting the most expensive products