
# Quarkus Practice

This is a Quarkus framework basic practice with provided requirement. Did this project with Quarkus because of interest on learning new things, wanted to see how well I can adapt to it and would like to see the difference between Quarkus & Spring Boot. 
In this project, I created APIs and wrote unit test, practice on clean code and file strcuture. 

# Enhancement Done
- Added Quarkus framework
- Written GET & POST API to process the CSV
- Did code enhancement to achieve testable code, tried to write pure function as possible
- Restructured & moved the methods to respective files
- Written test cases - understand that is not covered 100% for now.
- Added custom exception handling
- Reason adding Utility & Helper classes
    - reusability in the future
    - make sure every developers can standardize in validation or helper methods
- Reason seperating Service classes
    - Each class should handle specific responsibility 
    - Easy to plug & play
- Reason added Enum special case for MatchingCriteria
    - Enable user to add new criteria in enum in the future instead of modifying the method itself. Reduce the risk of breaking code.



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

