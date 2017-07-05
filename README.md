### Spring Boot Template Project

This project demonstrates the use of **Spring Boot** for creating a simple RESTful API
and how we can integrate **Swagger** for documentation and API testing,
as well as **Rest Assured** for integration/regression testing


#### Technologies used in the project

* [Maven](https://maven.apache.org/)
* [Spring Boot](http://projects.spring.io/spring-boot/) stack
    * Spring Data JPA (for persistence)
    * Spring MVC (for REST endpoints)
* [Swagger UI](https://github.com/swagger-api/swagger-ui) (for API testing)
* [Rest Assured](https://github.com/rest-assured/rest-assured) (for integration testing)

#### Prerequisites installed

* Oracle JDK 1.8
* Maven
* IDE or editor of your choice

#### Getting started

To start this web application just follow these steps:

1. Build the project via Maven:

    <code>$ mvn clean install</code>

2. Start the application:
    * In your IDE invoke the class method <code>Application#main</code> to start the server , *or*
    * From command line execute:

    <code>$ java -jar target/springboot-0.1-SNAPSHOT.jar</code>

3. Browse to the application root for API documentation:

    [http://localhost:8080/](http://localhost:8080)

#### Information

* Spring boot automatically provides an embedded Tomcat server and a persistence layer based on Hibernate (as JPA provider).
* Data are automatically stored in an in-memory database. Changes are lost after restarting the application.
* All REST endpoints can be tested locally with the Swagger UI frontend:

    [http://localhost:8080/](http://localhost:8080)
