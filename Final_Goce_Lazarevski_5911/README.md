# API Documentation

## Student API

### Get all students
**GET** `/students`
```json
[{
    "id": 1,
    "firstName": "Goce",
    "lastName": "Lazarevski",
    "email": "goce@123.com",
    "year": "SOPHOMORE"
}, {
    "id": 2,
    "firstName": "Gocka",
    "lastName": "Lazarev",
    "email": "gocka@321.com",
    "year": "SENIOR"
}, {
    "id": 3,
    "firstName": "Gogo",
    "lastName": "Lazarov",
    "email": "gogo@yahoo.com",
    "year": "SOPHOMORE"
}, {
    "id": 4,
    "firstName": "Georgi",
    "lastName": "Lazareski",
    "email": "georgi@gmail.com",
    "year": "SOPHOMORE"
}, {
    "id": 5,
    "firstName": "Gjorgji",
    "lastName": "Lazarevikj",
    "email": "gjorgji@gmail.com",
    "year": "FRESHMAN"
}, {
    "id": 6,
    "firstName": "George",
    "lastName": "Lazarus",
    "email": "george@outlook.com",
    "year": "FRESHMAN"
}]
```

### Get student by ID
**GET** `/students/{id}`
```json
{
    "id": 1,
    "firstName": "Goce",
    "lastName": "Lazarevski",
    "email": "goce@123.com",
    "year": "SOPHOMORE"
}
```

### Add a new student
**POST** `/students`
```json
{
  "firstName": "Goce",
  "lastName": "Lazarevski",
  "email": "random@email.com",
  "yearEnum": "SOPHOMORE"
}
```

### Create an assignment
**POST** `/rooms/{roomId}/students/{studentId}/assignments`
```json
{
  "studentId": 1,
  "roomId": 202,
  "startDate": "2025-06-01",
  "endDate": "2025-06-15"
}
```

### Checkout assignment
**PATCH** `/assignments/{id}/checkout`
```json
{
  "id": 101,
  "studentId": 1,
  "roomId": 202,
  "startDate": "2025-06-01",
  "endDate": "2025-06-15",
  "status": "checked out",
  "checkoutDate": "2025-06-10"
}

```