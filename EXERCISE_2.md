# Exercise 2

## Base
- Solution exercise 1: A Spring Boot application that outputs a simple (externally) configurable greeting

## Goals
- Turn the project into a full-fledged web application (with many niceties of Spring MVC and Spring Boot behind the curtain)
- Get familiar with some important server configuration options
- Get familiar with some tools for making HTTP requests for debugging

## Steps
- Add spring-boot-starter-web and spring-boot-starter-actuator to Maven project
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    ```
- Start the project and see what happens now. What is different than before?
- Check out `http://localhost:8080/` via Browser, curl (curl.exe in Windows) and Insomnia/Postman
- Check out default monitoring endpoint of Spring Boot Actuator (`/actuator/health`)
- Test some of the most common web/server configuration parameters and see what happens after every change
    - Increase log level for request processing: `logging.level.org.springframework.web=DEBUG`
    - Change the Context Path: `server.servlet.context-path=/some-context-path`
    - Change the server port: `server.port=8081`

## Hints / Challenges
- Spring Boot has many more available Actuator endpoints that can be enabled (https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator.endpoints). In a production environment that should be done with caution though!
    - Try it and check out all endpoints: `management.endpoints.web.exposure.include=*`
- Run your two instances of your application at the same time on different ports