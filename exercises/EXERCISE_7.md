# Exercise 7

## Base
- Solution of exercise 6: A Spring Boot web application with a simple product catalog and a CRUD (Create, Read, Update, Delete) HTTP-API, full API tests, proper persistance (albeit only in-memory for now) and a dev and prod profile

## Goals
- Make yourself familiar with Spring Security
- Make our application more secure by only allowing authenticated users
- Define different roles to allow fine-grained access control (i.e. users can only read products, only admins can modify)

## Steps
- Add `spring-boot-starter-security` to our project
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    ```
- Start the application and make a request to one of our API endpoints. See what happens (again, try access using different tools)
- Define a `SecurityFilterChain` bean and use the `HttpSecurity` configuration object to add some filter rules (see https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/index.html for inspiration)
    - Role USER: Can only make GET requests
    - Role ADMIN: Can make all requests
- Define a `UserDetailsService` to define two users (`user` and `admin` with corresponding roles) along with their credentials. **This serve illustrative purposes only and is obviously a terrible idea in any real application!** 
    - See documentation reference above for details
- Test your changes manually using different clients as before
- Make sure all tests still run (you can disregard / remove the `ProductControllerIntegrationTest` for this one)

## Hints / Challenges
- Have a close look at the log output to access the API
- You can disable authentication for `MockMvc` tests using `@AutoConfigureMockMvc(addFilters = false)`
- Try to get the `ProductControllerIntegrationTest` to work