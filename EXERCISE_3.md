# Exercise 3

## Base
- Solution of exercise 2: A Spring Boot web application with everything in place to start building an API now
- The `Product` entity (it is used in the dummy endpoint)
- The `ProductCatalog` (a simple replacement for the persistence layer, that we do not yet want to deal with)

## Goals
- Learn how to implement a REST controller (i.e. HTTP endpoint)
- Learn how to define more beans and how to inject those as dependencies

## Steps
- For temporary persistency there is now a `ProductCatalog` class that can hold `Product` objects and reference them by id
- Continue implementation for the `ProductController` REST controller
    - Have the `ProductCatalog` injected with `@Autowired` (do not instantiate it yourself within `ProductController`)
    - Implement `PUT /product`, `POST /product`, `DELETE /product/{id}`
        - Status codes
            - GET: 404 if product with id not existing; 200 if found and returned
            - POST: 201 if created successfully
            - PUT: 404 if product with id not existing; 200 if updated
            - DELETE: 404 if product with id not existing; 200 if deleted
- Test your endpoints using curl (curl.exe on Windows) and Insomnia/Postman

## Hints / Challenges
- The easiest way for exception handling (transforming an exception that is thrown in the controller into a suitable HTTP status code) is to catch it and rethrow a `ResponseStatusException`
- The annotations in the REST controller do many, many things in the background for our comfort. Can you name a few examples?
- Centralize the exception handling using `@ControllerAdvice` (see here for an example: https://www.baeldung.com/exception-handling-for-rest-with-spring#controlleradvice). What are the downsides of that approach?