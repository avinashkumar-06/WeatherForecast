# WeatherForecast

WeatherForecast  provides weather forecasting services. It is built using Spring Boot and Maven. The application uses MySQL as its database and follows the MVC (Model-View-Controller) design pattern. It also implements Spring Security and JWT (JSON Web Token) for secure authentication.
It also offers a frontend to get weather data in a more readable way.

## Features

- **User Registration**: Users can register by providing their name, email, and password. Upon successful registration, a new user is created in the system.

- **User Authentication**: After registration, users can log in by providing their email and password. Upon successful authentication, a JWT token is generated which can be used for subsequent requests.

- **Daily Weather Forecast Retrieval**: Users can retrieve daily weather forecasts for specific locations. The forecast includes information such as date, minimum and maximum temperature, humidity, and weather description.

- **Hourly Weather Forecast Retrieval**: Users can retrieve weather forecasts for specific locations at 3-hour intervals for the next 5 days. The forecast includes information such as date, temperature, humidity, and weather description.

## Technologies Used

- Java
- Spring Boot
- Maven
- MySQL
- JWT (JSON Web Token)
- Spring Security
- Hibernate
- Spring Data JPA
- HTML
- CSS
- JavaScript

## Installation and Usage

There are two ways to use the WeatherForecast application:

### Option 1: Local Installation

1. Clone the repository to your local machine
2. Navigate to the project directory  
3. Open the `application.properties` file located in `src/main/resources/` and update the database connection details as per your local setup. For example:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```

4. Build the project using Maven with the command `mvn clean install`.
5. Run the application using the command `mvn spring-boot:run`.
6. The application will start running at `http://localhost:8181`. You can use any API testing tool like Postman to interact with the APIs.

### Option 2: Using the Deployed Application

The WeatherForecast application is also deployed on Railway.app. You can use the deployed application directly from your browser. The frontend of the application is built using HTML, CSS, and JavaScript, and you can interact with it just like any other web application.
link : https://weather-forecast-methodcoder.netlify.app/

## Limitations

This project uses a free API for educational purposes only. Please note that the free API has usage limitations and may not handle a large number of requests at the same time. In case of too many requests, the service may get interrupted and you may receive a "Too Many Requests" error from the API provider.

## API Endpoints

- `POST /weather/api/signup`: This endpoint is used for user registration. It creates a new user and saves it in the database.

- `POST /weather/api/signin`: This endpoint is used for user authentication. It first uses basic authentication and verifies the user with credentials saved in the database and then generates jwt token.

- `GET /weather/api/daysforecast/{city}`: This endpoint returns the daily weather forecast. It requires a JWT token for authentication.

- `GET /weather/api/hoursforecast/{city}`: This endpoint returns the hourly weather forecast. It requires a JWT token for authentication.

## Acknowledgements

- Thanks to [OpenWeatherMap](https://openweathermap.org/) for providing the weather data API.
- Thanks to [RapidAPI](https://rapidapi.com/) for their API services.
