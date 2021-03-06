# Githubwebhook

Githubwebhook is an api for receiving issues from github and list its events 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software

```
Java 8
Maven 3.5.0 or Maven 3.5.0++
Docker 7.09.1-ce 
```

### Installing

A step by step series of examples that tell you how to get a development env running


```
Execute the command below to package. The fisrt time is going to break dont worry.
        mvn package -Dmaven.test.skip=true
        
Access project's folder by terminal and execute the following instructions to get app up:
        docker-compose up --build -d
        
Execute the command below to create all tables:
         mvn package -Dmaven.test.skip=true 
     
```


## Running the tests

How to run the automated tests for this system


```
Execute the command below to package. The fisrt time is going to break dont worry.
        mvn package -Dmaven.test.skip=true

Execute the command below to get the test environment up. Make sure that two services are up after run the below command.
        docker-compose up --build -d
        
Execute the command below to create all tables:
         mvn package -Dmaven.test.skip=true 

Finally execute the command below to run integration test:
         mvn test
```

## Developing Environment

Project's architecture 
```
Routers configuration, Database configuration and Application configuration you can find at com.githubwebhook.config folder
In case you need to change database configuration you are going to find hiraki.properties and its property inside DbConfig.class
In case you need to change server's port you have to change inside  Main.kt

Why do you have to do these configuration to get a developing environment ?
Because developing profile has not created yet.
```

## Endpoints

```
Get             /issues/:id/events          Replace :id for your issue id
Post            /payload
```


## Built With

* [Javalin](https://javalin.io/)            - The web framework used
* [Jetbrains Exposed](https://github.com/JetBrains/Exposed/wiki)     - Used to make queries.
* [Koin](https://insert-koin.io/)     - Used to inject dependencies.
* [Maven](https://maven.apache.org/)        - Dependency Management
* [Assured](http://rest-assured.io/)        - Used to make request
* [Cucumber](https://cucumber.io/)          - Used to make tests
* [Liquibase](https://www.liquibase.org/)   - Used to deploy database schema and logic changes.




## Author

* **Paulo Augusto**  - *Initial work* - [githubwebhook](https://github.com/paulo3425/githubwebhook)
* **Any question**  -  [E-mail](paulo-3425@hotmail.com)





