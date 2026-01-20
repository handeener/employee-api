# Employee Management REST API
A CRUD API project developed with Spring Boot, PostgreSQL and Docker, featuring Swagger/OpenAPI documentation support, included unit and integration tests.

## 🚀 Features
- Create, Read, Update, Delete (CRUD) operations for managing employees
- RESTful API design 
- PostgreSQL database integration 
- Docker & docker-compose support
- Swagger/OpenAPI documentation for API endpoints
- Unit & Integration tests

##  🛠️ Technologies

| Technology        | Description           |
|-------------------|-----------------------|
| Java 21           | Programming language  |
| Spring Boot 3     | Backend framework     |
| PostgreSQL        | Database              |
| Maven             | Project management    |
| Swagger / OpenAPI | API documentation     |
| JUnit & Mockito   | Testing frameworks    |
| Docker            | Containerization      |
| Docker Compose    | Multi-container apps  |
| Lombok            | Boilerplate reduction |
| MapStruct         | Object mapping        |

## 📦 Project Structure
```
src
├── main
│   ├── java
│   │   └── com.example.employee
│   │       ├── entity            # JPA entity classes
│   │       ├── repository        # Spring Data JPA repositories
│   │       ├── controller        # REST controllers
│   │       ├── service           # Service layer
│   │       ├── mapper            # Entity models
│   │       ├── dto               # Data Transfer Objects
│   │       ├── exception         # Custom exceptions
│   │       ├── request           # Request models
│   │       ├── response          # Response models
│   │       └── EmployeeApiApplication.java # Main application class
│   └── resources
│       ├── application.yml # Application configuration
└── test
    └── java
        └── com.example.employee
            ├── controller        # Controller tests
            └── service           # Service tests
```
## 🚀 Getting Started
### Prerequisites
- Java 21 or higher
- Maven 3.6 or higher
- Docker & Docker Compose
- PostgreSQL (if not using Docker)
- Git
- IDE (IntelliJ IDEA, Eclipse, etc.)
- Postman for API testing

## ⚙️ Setup & Running the Application
### Installation
- Clone the repository:
  ```bash
  git clone http://....git
  cd employee-api
    ```
- Build the project using Maven:
- ```bash
    mvn clean install
    ```
 ### Running with Docker
- Ensure Docker and Docker Compose are installed and running.
- Use Docker Compose to build and run the application:
- ```bash
    docker-compose up --build
    ```
- The application will be accessible at `http://localhost:8080/swagger-ui.html`.

## 📄 API Documentation
- The API is documented using Swagger/OpenAPI.
- Access the Swagger UI at:
- ```
    http://localhost:8080/swagger-ui.html
    ```
## 📚 API Endpoints
- `POST /api/employees` - Create a new employee
- `GET /api/employees` - Retrieve all employees
- `GET /api/employees/{id}` - Retrieve an employee by ID
- `PUT /api/employees/{id}` - Update an existing employee by ID
- `DELETE /api/employees/{id}` - Delete an employee by ID
- PS: CORS configuration is simplified for development purposes by adding CrossOrigin annotation to controller 

## 🔧 Configuration
- Application configuration is located in `src/main/resources/application.yml`.
- Update database connection settings as needed:
- ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/employee_db
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```

## 🧪 Testing
- Run unit and integration tests using Maven:
- ```bash
    mvn test
    ```
## 🤝 Contributing
- Contributions are welcome! Please fork the repository and create a pull request with your changes.
- Ensure your code follows the existing style and includes appropriate tests.

## 🙏 Acknowledgements
- Thanks to all the open-source libraries and tools that made this project possible!
- Happy coding! 🚀
  
