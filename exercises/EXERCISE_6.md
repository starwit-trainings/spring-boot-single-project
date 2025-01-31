# Exercise 6

## Base
- Solution of exercise 5: A Spring Boot web application with a simple product catalog and a CRUD (Create, Read, Update, Delete) HTTP-API, full API tests, proper persistance (albeit only in-memory for now)

## Goals
- Learn how to use Spring Profiles
- Make our application adaptable to running in two very different environments
- Have a look at Spring events

## Steps
- We will create two profiles, `dev` and `prod`, `dev` will add some demo data to the database, enable debug logging and all actuator endpoints, whereas `prod` will not.
- Create a Bean `DemoDataLoader` that is tied to profile `dev`
    - It should load a couple of products (that we could do interesting queries on later) into the app
    - Data should not be loaded if the database is not empty
    - Implement the data loader as an `ApplicationListener` that listens for a suitable Spring event (e.g. )
- Add a REST endpoint `/product/all` that returns all products in the database
- Add a test
- Create a properties file `application-dev.properties` that enables many features you would like to have during development (i.e. Spring Actuator endpoints, Log-Level, etc.)
- Create a properties file `application-prod.properties` that does nothing for now (maybe change the greeting)
- Test the `dev` profile by activating it through `spring.profiles.active=dev`
- Try activating the profile in different ways (environment variable, JVM parameter)

## Hints / Challenges
- Write a test that verifies that the test data is fully loaded if the profile `dev` is active (`@ActiveProfiles("dev")` in a test)