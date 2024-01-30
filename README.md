# Auth-registration
API RESTful of users registration

### Api Rest Auth Registration
- Swagger URL: http://localhost:8081/register/swagger-ui/index.html
  
![image](https://github.com/ezorrilla/auth-registration/assets/22652830/94d9ac1c-2328-451f-ad3c-2feeff686e21)


# What does the repository contain?

  - HSQLDB memory database.
  - Java version 21 SDK.
  - Framework SpringBoot
  - Build in Maven.
  - JPA persistence with Hibernate
  - Api Rest response the requeriment.
  - Token JWT and user persistence during the session.
  - Swagger v3
  - All project have diversity of syntax for old and new java code.

## Registro
* This endpoint must receive a user with the fields "name", "email", "password", plus a list of "phone" objects, respecting the following format:
```json
    {
        "name": "Juan Rodriguez",
        "email": "juan@rodriguez.org",
        "password": "hunter2",
        "phones": [
            {
                "number": "1234567",
                "citycode": "1",			
                "contrycode": "57"
            }
        ]
    }
```

### Common Validations
-   Empty
-   Null

| Api Rest | Method | Protected | Validations | Request | Response |
| ------ | ------ | ------ | ------ | ------ | ------ |
| /api/auth/signup | POST| false | format email,format password,check user exist email, email and password, format phone |{"name":"string","email":"string","password":"YyiYiAgZpe40","phones":[{"number":"string","citycode":"string","countryCode":"string"}]} | {"data":{"id":"4f4cc0e1-cbdc-4815-804b-a7e8622b7332","created":"2024-01-30T10:15:56.964657","modified":"2024-01-30T10:15:56.964657","last_login":"2024-01-30T10:15:56.964657","token":"eyJhbGciOiJIUzI1NiJ9","isactive":true},"mensaje":"Successfully!","status":200}

### Authors

 - Elder Zorrilla Castillo

License
----
