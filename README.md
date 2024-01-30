# auth-registration
API REST ful of users registration

### Api Rest 

### Common Validations
-   Empty
-   Null

| Api Rest | Method | Protected | Validations | Request | Response |
| ------ | ------ | ------ | ------ | ------ | ------ |
| /v1/unprotected/doSignIn | POST| false | format email,format password,check user exist email, email and password coincidence|{"name":"FirstNameExample LastNameExample","email":"email@example.com","password":"Passwordexampler12","phones":[{"number":"946644558","city_code":"1","country_code":"57"}]} | {"id":1,"created":"16-02-2020 22:34:26","modified":"16-02-2020 22:35:07","last_login":"16-02-2020 22:35:07","token":"eyJhbGciOiJIUzI1NiJ9","active":true}

