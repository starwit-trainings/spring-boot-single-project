# Exercise 3

## Base
- Solution of exercise 2: A Spring Boot web application with everything in place to start building and API now
- The `Product` entity already defined (it is used in the dummy endpoint)

## Goals
- Learn how to implement a REST controller (i.e. HTTP endpoint)
- Learn how to define more beans and how to inject those as dependencies

## Steps
- For temporary persistency define a `ProductCatalog` that can hold `Product` objects and reference them by id
- Continue implementation for the `ProductController` REST controller
    - Have the `ProductCatalog` injected, do not instantiate it within `ProductController`
    - Implement `PUT /product/{id}`, `POST /product`, `DELETE /product/{id}`
- Test your endpoints using curl (curl.exe on Windows) and Insomnia/Postman

## Hints / Challenges
- The REST controller annotations do many, many things in the background for our comfort. Can you name a few?
- Customize the error message and error code that comes back if there is an exception during controller method execution using `ResponseStatusException` or `Controller Advice` (if possible try both)