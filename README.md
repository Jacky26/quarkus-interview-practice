
# Quarkus Practice

This is a Quarkus framework basic practice with provided requirement. Did this project with Quarkus because of interest on learning new things, wanted to see how well I can adapt to it and would like to see the difference between Quarkus & Spring Boot. 
In this project, I created APIs and wrote unit test, practice on clean code and file strcuture. 


## Features

- [GET] API to retrieve data from CSV file.
- [POST] API to validate data inside CSV file.


## API Reference

#### Get All Records

```http
  GET /api/data/${fileName}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `fileName` | `string` | **Required**. CSV File Name |

#### Validate Duplicate Records

```http
  POST /api/data/${fileName}/validate
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `fileName`      | `string` | **Required**. CSV File Name |




## Authors

- Jacky Chai Hong Meng

