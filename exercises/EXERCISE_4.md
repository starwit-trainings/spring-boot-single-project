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
- If you have to use a value from the returned json, you can conveniently use JsonPath, that is by default included in the Spring Boot Test Dependencies (e.g. `String id = JsonPath.read(jsonResponse, "$.id").toString();`). You can get the response body from MockMvc like this: `mockMvc.perform(...).andReturn().getResponse().getContentAsString();`
- Make the test class more concise by provisioning the application with some test data before every test (e.g. `@BeforeEach` or `@BeforeAll`)
- Start the actual web server to run the tests (see here: https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing.spring-boot-applications.with-running-server). What are the implications of both approaches?