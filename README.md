# Blog API

A RESTful Blog API built using Spring Boot, Spring Data JPA, Hibernate, and H2 Database. This project provides CRUD operations for managing blog posts, categories, and comments while following a clean layered architecture commonly used in modern backend development.

## Features

- Create, Read, Update, and Delete (CRUD) operations
- Post Management
- Category Management
- Comment Management
- Spring Data JPA Integration
- Hibernate ORM
- H2 In-Memory Database
- RESTful API Design
- Layered Architecture (Controller, Service, Repository)
- Validation Support
- Clean and Maintainable Code Structure

## Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database
- Maven
- REST APIs

## Project Structure

src/main/java/com/blogapi/blog_api/

├── controller/

│   ├── PostController.java

│   ├── CategoryController.java

│   └── CommentController.java

│

├── entity/

│   ├── Post.java

│   ├── Category.java

│   └── Comment.java

│

├── repository/

│   ├── PostRepository.java

│   ├── CategoryRepository.java

│   └── CommentRepository.java

│

├── service/

│   ├── PostService.java

│   ├── CategoryService.java

│   └── CommentService.java

│

├── exception/

│   ├── ResourceNotFoundException.java

│   └── GlobalExceptionHandler.java

│

└── BlogApiApplication.java

## API Endpoints

### Posts

| Method | Endpoint | Description |
|----------|----------|-------------|
| GET | /api/posts | Get all posts |
| GET | /api/posts/{id} | Get post by ID |
| POST | /api/posts | Create a new post |
| PUT | /api/posts/{id} | Update a post |
| DELETE | /api/posts/{id} | Delete a post |

### Categories

| Method | Endpoint | Description |
|----------|----------|-------------|
| GET | /api/categories | Get all categories |
| GET | /api/categories/{id} | Get category by ID |
| POST | /api/categories | Create a category |
| PUT | /api/categories/{id} | Update a category |
| DELETE | /api/categories/{id} | Delete a category |

### Comments

| Method | Endpoint | Description |
|----------|----------|-------------|
| GET | /api/comments | Get all comments |
| GET | /api/comments/{id} | Get comment by ID |
| POST | /api/comments | Create a comment |
| PUT | /api/comments/{id} | Update a comment |
| DELETE | /api/comments/{id} | Delete a comment |

## Database Configuration

This project uses the H2 in-memory database for development and testing.

### H2 Console

Access the database console:

http://localhost:8080/h2-console

### H2 Credentials

JDBC URL:
jdbc:h2:mem:blogdb

Username:
SA

Password:
(leave empty)

## Running the Application

### Clone the Repository

```bash
git clone https://github.com/your-username/blog-api.git
```

### Navigate to Project Directory

```bash
cd blog-api
```

### Run the Application

Linux/Mac:

```bash
./mvnw spring-boot:run
```

Windows:

```bash
mvnw.cmd spring-boot:run
```

The application will start at:

```text
http://localhost:8080
```

## Sample Requests

### Create a Post

POST /api/posts

```json
{
  "title": "Spring Boot REST API",
  "content": "Learning Spring Boot backend development.",
  "author": "Priyanshu"
}
```

### Create a Category

POST /api/categories

```json
{
  "name": "Technology",
  "description": "Technology related articles"
}
```

### Create a Comment

POST /api/comments

```json
{
  "author": "John Doe",
  "content": "Excellent blog post!"
}
```

## Learning Outcomes

This project helped in understanding:

- Spring Boot Fundamentals
- RESTful API Development
- Dependency Injection
- Spring Data JPA
- Hibernate ORM
- Entity Relationships
- CRUD Operations
- Backend Project Structure
- API Testing with Postman
- Database Integration
- Validation and Exception Handling

## Future Improvements

- JWT Authentication
- User Registration and Login
- Role-Based Authorization
- Swagger/OpenAPI Documentation
- MySQL/PostgreSQL Integration
- Pagination and Sorting
- Search Functionality
- Docker Support
- Unit Testing and Integration Testing
- Cloud Deployment

## Author

**Priyanshu Singh**

Aspiring Java Full Stack Developer passionate about building scalable backend applications using Spring Boot, Java, and modern web technologies.

## License

This project is open-source and available for learning, educational purposes, and portfolio demonstration.
