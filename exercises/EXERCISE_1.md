# Exercise 1

## Base
- An empty project

## Goals
- A Spring Boot application that outputs a simple (externally) configurable greeting
- Making sure that your development environment works (Java, Maven, git, etc.)
- Start learning about configuration properties and how to configure them

## Steps
- Make sure that you have a JDK 21 on your computer (if not: https://adoptium.net)
- Make sure that you have Maven and Git installed (you can also use the Maven wrapper in the generated project)
- Use Spring Initializr to generate a project skeleton (https://start.spring.io)
- Run application and see what happens (`./mvnw clean spring-boot:run`)
- Implement a `CommandLineRunner` that outputs a simple greeting (`System.out.println()` is fine) after application context start 
- Now make (part of) the greeting configurable using the property `greeting.text`

## Hints
- Use Maven, Java 17 and Spring Boot 3.1.4
- Maven artifact metadata
    - group: training.spring-boot
    - artifact: webshop
    - package name: training.spring-boot.webshop

## Challenges
- You can overwrite properties with environment variables, try different ways
- Have a look at the documentation for `CommandLineRunner`. What is the minimal version you can come up with to achieve our goal?