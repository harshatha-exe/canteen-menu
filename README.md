# Canteen Menu Management API
**Name:** Harshatha Rithika
**Email:** harshatharithika@gmail.com
## Overview
This Spring Boot application implements a CRUD REST API to manage canteen
menu items. It uses Java 25, Spring Boot 3.5.8, Spring Data JPA, and H2 inmemory
database.
## Endpoints
1. **Create Item**
- POST /api/items
- Body (JSON):
{
"name": "Biriyani",
"price": 60.0,
"category": "Lunch",
"availability": true
}
- Response: 201 Created with created item JSON
2. **List All Items**
- GET /api/items
- Response: 200 OK` with list of items
3. **Update Item**
- PUT /api/items/{id}
- Body: same as create
- Response: 200 OK with updated item
4. **Delete Item**
- DELETE /api/items/{id}
- Response: 204 No Content
## Validation
- name must not be blank
- price must be greater than 0
- availability is required 
## Running locally
1. Install Java 25 and Maven.
2. Build:
    mvn clean package
3. Run:
    mvn spring-boot:run

## Sample curl commands

Create:
curl -X POST http://localhost:8080/api/items -H "Content-Type: application/json" -d "{\"name\":\"Biriyani\",\"price\":60,\"category\":\"Lunch\",\"availability\":true}"

{"id":1,"name":"Biriyani","price":60.0,"category":"Lunch","availability":true}

Read:
curl http://localhost:8080/api/items

[{"id":1,"name":"Biriyani","price":60.0,"category":"Lunch","availability":true}]

Update:
curl -X PUT http://localhost:8080/api/items/1 -H "Content-Type: application/json" -d "{\"name\":\"Meals\",\"price\":40,\"category\":\"Lunch\",\"availability\":true}"

{"id":1,"name":"Meals","price":40.0,"category":"Lunch","availability":true}

Delete:
curl -X DELETE http://localhost:8080/api/items/1
