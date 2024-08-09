# libraryManagementApi
# Library Management System API

## Overview
This project is a Library Management System API built using Spring Boot.

## Prerequisites
- Java 8 or higher
- Maven
- H2 Database



2. Build and run the application:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

3. Access the application at `http://localhost:8080`

## API Endpoints

### Book Management
- `GET /api/books`: Retrieve a list of all books.
- `GET /api/books/{id}`: Retrieve details of a specific book by ID.
- `POST /api/books`: Add a new book to the library.
- `PUT /api/books/{id}`: Update an existing book's information.
- `DELETE /api/books/{id}`: Remove a book from the library.

### Patron Management
- `GET /api/patrons`: Retrieve a list of all patrons.
- `GET /api/patrons/{id}`: Retrieve details of a specific patron by ID.
- `POST /api/patrons`: Add a new patron to the system.
- `PUT /api/patrons/{id}`: Update an existing patron's information.
- `DELETE /api/patrons/{id}`: Remove a patron from the system.

### Borrowing Management
- `POST /api/borrow/{bookId}/patron/{patronId}`: Allow a patron to borrow a book.
- `PUT /api/return/{bookId}/patron/{patronId}`: Record the return of a borrowed book by a patron.


