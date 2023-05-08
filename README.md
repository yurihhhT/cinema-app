
<img src="https://img.freepik.com/free-vector/cinema-realistic-poster-with-illuminated-bucket-popcorn-drink-3d-glasses-reel-tickets-blue-background-with-tapes-vector-illustration_1284-77070.jpg" alt="Cinema_app_logo" width="350" height="350">

# Cinema-app

This project is a web application for a cinema. It allows users to view the schedule of movie sessions and purchase tickets for them. The application also has a user registration system, as well as a secure section with access rights to various resources, based on user roles. Additionally, users can obtain information about movies available at the cinema, including their descriptions.
The program is developed in accordance with the REST concept using such technologies as `Hibernate` and `Spring`.



## Features

- Authentication
- Authorization by role
    - `ADMIN`
        * Create and delete movies
        * Create and delete movie sessions
        * Create and delete cinema halls
        * View movies and their description
        * View movie sessions and in which cinema hall it will take place
    - `USER`
        - View movies and their description
        - View available movie sessions and in which cinema hall it will take place
        - View cinema halls
        - Choose available movie sessions and put your ticket in the cart
        - View user orders story
- Register new user (Role will be `USER` by default)



## Structure
<H3>Packages:</H3>
* `controller` - contains controllers for endpoints with different access depending on the role
    - `POST: /register` - register new user - `ALL`
    - `POST: /movies` - to create a movie - `ADMIN`
    - `GET: /movies` - to get all movies - `ADMIN` and `USER`
    - `POST: /cinema-halls` - to create cinema hall - `ADMIN`
    - `GET: /cinema-halls` - to get all cinema halls - `ADMIN` and `USER`
    - `POST: /movie-sessions` - to create movie session - `ADMIN`
    - `PUT: /movie-sessions/{id}` - to update a movie session - `ADMIN`
    - `DELETE: /movie-sessions/{id}` - to delete movie session - `ADMIN`  
    - `GET: /movie-sessions/available` - to get all available movie sessions by movieId and date - `ADMIN` and `USER`
    - `GET: /users/by-email` - to find user by email - `ADMIN`
    - `PUT: /shopping-carts/movie-sessions` - to add movie session to shopping cart - `USER`
    - `GET: /shopping-carts/by-user` - to get shopping cart by user - `USER`
    - `GET: /orders` - to get order history by current user - `USER`
    - `POST: /orders/complete` - to create order for current user - `USER`
    
You can use my POSTMAN request collection for testing - [Postman collection](https://www.postman.com/spaceflight-geoscientist-28091609/workspace/cinema-app/collection/27140793-691a19ab-e254-4069-b641-808906a29bf5?action=share&creator=27140793)
    
* `config` - stores Spring and App configuration
* `dao` - data access layer (repository) with CRUD methods in the database
* `dto` - wrapper for model objects to unify the requests and responses in controllers
* `exception` - custom exception class for DAO's exceptions 
* `lib` - contains email and password validators with its annotations
* `model` - contains models of entity for the database
* `service` - contains services that call repositories and perform business logic
* `mapper` - сonverts model objects into DTO objects and vice versa
* `util` - utility class used in a project to save DateTime pattern
* `resources` - contains properties for database


<H3>Model structure and relations</H3>
![structure.png](structure.png)



## Getting started

Please have IntelliJ IDEA Ultimate or ability to adapt following steps on your own.

You will also need: Tomcat 9.0.50 - 9.0.73, Java SDK 17+, maven 3.8.0+, SQL DBMS (tested on MySQL).

- Clone the project repository to your local machine
- Create an empty schema in your DB
- Replace the values of the `YOUR_DRIVER`, `YOUR_DATABASE_URL`, `USER_NAME` and `PASSWORD` properties in db.properties (resource directory) with the appropriate values for your database setup
- Build the project using Maven: `mvn clean install`
- Deploy the generated WAR file to servlet container such as Tomcat

When you deploy the project to Tomcat, press the fix button below and select war explored and in the application context remove the value until /.

You can login with existing users:
1. `ADMIN` - email: admin@i.ua, password: admin123
2. `USER` - email: test@i.ua, password: test1111



## Used Technologies

- `Java v17`
- `Maven v3.8`
- `Hibernate v5.6.14 final`
- `Spring v5.3.20`  
- `Spring Security v5.6.10`
- `MySQL v8.0.22`
- `Javax Servlets v4.0.1`
- `TomCat v9.0.73`



## Authors

Turchin Yuriy

[My LinkedIn](https://www.linkedin.com/in/yurii-turchyn/)


