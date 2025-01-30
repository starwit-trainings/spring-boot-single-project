# Exercise 7

## Base
- Solution of exercise 6: A Spring Boot web application with a simple product catalog and a CRUD (Create, Read, Update, Delete) HTTP-API, full API tests, proper persistance (albeit only in-memory for now) and a dev and prod profile

## Goals
- Make yourself familiar with Spring Security
- Make our application more secure by only allowing authenticated users

## Steps
- Add `spring-boot-starter-security` to our project
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    ```
- Start the application and see what happens
- Make a request to one of our API endpoints and see what happens

## Hints / Challenges
- 