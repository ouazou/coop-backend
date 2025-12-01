# School Transport Management API

A Spring Boot application for managing school transport routes, students, and bus assignments.

## Technology Stack

- **Java Version**: 17
- **Framework**: Spring Boot 3.2.0
- **Database**: PostgreSQL
- **Database Migration**: Liquibase
- **API Documentation**: OpenAPI 3.0
- **Object Mapping**: MapStruct
- **Build Tool**: Maven

## Project Structure

```
src/main/java/com/transport/ccop/
├── api/                    # Generated API interfaces
├── controller/            
│   ├── RouteController.java
│   └── GlobalExceptionHandler.java
├── dto/                    # Generated DTOs
├── entity/
│   ├── BaseEntityModel.java
│   ├── SchoolEntity.java
│   ├── StudentEntity.java
│   ├── BusEntity.java
│   ├── RouteEntity.java
│   ├── StudentRouteEntity.java
│   └── StudentRouteId.java
├── mapper/
│   ├── RouteMapper.java
│   └── StudentMapper.java
├── repository/
│   ├── RouteRepository.java
│   ├── StudentRepository.java
│   └── StudentRouteRepository.java
└── service/
    ├── RouteService.java
    └── StudentRouteService.java
```

## Database Schema

The database consists of the following tables:

1. **schools**
    - id (PK)
    - name
    - address
    - created_at
    - updated_at

2. **students**
    - id (PK)
    - first_name
    - last_name
    - school_id (FK)
    - address
    - created_at
    - updated_at

3. **buses**
    - id (PK)
    - plate_number (unique)
    - capacity
    - created_at
    - updated_at

4. **routes**
    - id (PK)
    - name
    - bus_id (FK)
    - created_at
    - updated_at

5. **student_routes** (Junction Table)
    - student_id (PK, FK)
    - route_id (PK, FK)
    - pickup_order

## API Endpoints

### Routes

- **GET /routes**
    - Get all routes
    - Response: Array of Route objects

- **POST /routes**
    - Create a new route
    - Request Body: Route object
    - Response: Created Route object

- **GET /routes/{routeId}**
    - Get a specific route
    - Response: Route object
    - Error: 404 if route not found

- **PUT /routes/{routeId}**
    - Update a route
    - Request Body: Route object
    - Response: Updated Route object
    - Error: 404 if route not found

- **DELETE /routes/{routeId}**
    - Delete a route
    - Response: 204 No Content
    - Error: 404 if route not found

### Route Students

- **GET /routes/{routeId}/students**
    - Get all students for a route
    - Response: Array of Student objects
    - Error: 404 if route not found

- **POST /routes/{routeId}/students**
    - Add a student to a route
    - Request Body: Student object
    - Response: Added Student object
    - Error: 404 if route not found

- **DELETE /routes/{routeId}/students/{studentId}**
    - Remove a student from a route
    - Response: 204 No Content
    - Error: 404 if route or student not found

## Setup and Installation

1. **Prerequisites**
    - Java 17
    - Maven
    - PostgreSQL

2. **Database Setup**
   ```sql
   CREATE DATABASE ccop;
   ```

3. **Configuration**
   Update `src/main/resources/application.yml` with your database credentials:
   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/ccop
       username: your_username
       password: your_password
   ```

4. **Build and Run**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

5. **Access API Documentation**
    - Swagger UI: http://localhost:8080/swagger-ui.html
    - OpenAPI Spec: http://localhost:8080/v3/api-docs

## Implementation Details

### Entity Mapping

- Used MapStruct for DTO-Entity mapping
- Base entity class with audit fields (created_at, updated_at)
- Proper JPA relationships between entities

### Error Handling

- Global exception handler for consistent error responses
- Proper HTTP status codes for different scenarios
- Validation for request payloads

### Database Management

- Liquibase for database version control
- Initial schema creation
- Proper indexing and constraints

## Testing

The API can be tested using:

1. Swagger UI interface
2. Postman or similar API testing tools
3. Curl commands

Example curl commands:

```bash
# Get all routes
curl -X GET http://localhost:8080/routes

# Create a new route
curl -X POST http://localhost:8080/routes \
  -H "Content-Type: application/json" \
  -d '{
    "routeId": "73401AM",
    "circuit": "601",
    "startTime": "07:15",
    "endTime": "08:15",
    "duration": "60.49",
    "occupation": "School Route"
  }'
```

## Security Considerations

- Input validation for all endpoints
- Proper error handling to prevent information leakage
- Database connection security
- Prepared statements to prevent SQL injection

## Future Enhancements

1. Add authentication and authorization
2. Implement real-time tracking
3. Add support for route optimization
4. Implement notification system
5. Add reporting functionality

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.
