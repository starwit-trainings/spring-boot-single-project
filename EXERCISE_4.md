# Exercise 4

## Base
- Solution of exercise 3: A Spring Boot web application with a simple product catalog and a CRUD (Create, Read, Update, Delete) HTTP-API

## Goals
- Learn how to use Spring Boot test slice for Spring MVC (i.e. API tests)
- For all future changes, we want to fix our API behavior with tests, so that possible clients won't break without us noticing

## Steps
- Make yourself familiar with the existing test in `ProductControllerTest` (play with it if your unsure what an option does)
- Implement basic tests for all other API endpoints in `ProductController`
    - Always test the happy path, but also verify that the correct response code is returned in case of an error
- Make sure that all the tests succeed (i.e. "are green")

## Hints / Challenges
- `@SpringBootTest` initializes the entire Application Context but does not start the web server by default and instead mocks it, which is faster and easier to control
- Make the test class more concise by provisioning the application with some test data before every test (e.g. `@BeforeEach`)
- Start the actual web server to run the tests (see here: https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing.spring-boot-applications.with-running-server). What are the implications of both approaches?