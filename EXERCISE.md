# Exercise 1

## Base
- an empty project

## Goals
- a Spring Boot application that outputs a simple (externally) configurable greeting
- making sure that your development environment works (Java, Maven, git, etc.)
- start learning about configuration properties and how to configure them

## Steps
- Make sure that you have a JDK 17 on your computer (if not: https://adoptium.net)
- Make sure that you have Maven and Git installed (you can also use the Maven wrapper in the generated project)
- Use Spring Initializr to generate a project skeleton (start.spring.io)
- Run application and see what happens (`mvn clean spring-boot:run`)
- Implement a `CommandLineRunner` that outputs a simple greeting after application start that contains a configurable word or phrase from the property `greeting.text`

## Hints
- Use Maven, Java 17 and Spring Boot 3.1.4
- Maven artifact metadata
    - group: training.spring-boot
    - artifact: webshop
    - package name: training.spring-boot.webshop
- You can overwrite properties with environment variables, try it!