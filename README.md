Weather API: Spring Boot Coding Dojo
---

### Introduction

This is an application that requests weather data given a city name from [OpenWeather](https://openweathermap.org/) and stores the result in a database.

### For Configuring the app use the application.yml file:

#### Database Connection:

##### In the following property set the Data-Base Postgres URL in the form *jdbc:postgresql://server:port/data-base-name* 
-   spring.datasource.url

##### In the following property set the Data-Base userName:

-   spring.datasource.username

##### In the following property set the Data-Base password:
-   spring.datasource.password

#### OpenWeather Connection:

##### In the following property set the ApiKey:
-   weather.api.appId

### For Building the app is needed:

-   Java 11
-   Maven 3.x

### For Building the app type:

-   mvn clean install

### For Running the app type:

-   mvn spring-boot:run

### For Accessing the API Documentation:

#### JSON format:

-   http://localhost:8080/api-docs

#### HTML format:

-   http://localhost:8080/api-ui.html

#### Sample Request For Testing and Getting the Weather Data:

-   http://localhost:8080/weather?city=Amsterdam
