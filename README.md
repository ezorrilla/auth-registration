# auth-registration
API REST ful of users registration

### Api Rest 

## Registro
* Ese endpoint deberá recibir un usuario con los campos "nombre", "correo", "contraseña", más un listado de objetos "teléfono", respetando el siguiente formato:
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
| /api/auth/signup | POST| false | format email,format password,check user exist email, email and password coincidence|{"name":"string","email":"string","password":"YyiYiAgZpe40","phones":[{"number":"string","citycode":"string","countryCode":"string"}]} | {"data":{"id":"4f4cc0e1-cbdc-4815-804b-a7e8622b7332","created":"2024-01-30T10:15:56.964657","modified":"2024-01-30T10:15:56.964657","last_login":"2024-01-30T10:15:56.964657","token":"eyJhbGciOiJIUzI1NiJ9","isactive":true},"mensaje":"Successfully!","status":200}

### Authors

 - Elder Zorrilla Castillo

License
----
