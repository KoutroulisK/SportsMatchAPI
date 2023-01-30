# Sports Match REST API

## Introduction
This is a basic REST API which offers CRUD functionality in order to manage data for a sport match along with its odds. It has been built with JAVA and Spring Boot and utilizes PostgreSQL for its database needs.

A Postman collection with request examples and the schema of the PostgreSQL database are included.

## API Documentation

### Entities

**Match**

Entity model:
```
{
    "description":"^[a-zA-Z]+-[a-zA-Z]+$",
    "match_date":"dd/MM/yyyy",
    "match_time":"HH:mm",
    "team_a":"^[a-zA-Z]$",
    "team_b":"^[a-zA-Z]$",
    "sport":"^Football|Basketball$",
    "matchodds":[
        {
            "specifier":"^1|X|2$",
            "odd":0.00
        },
        {
            "specifier":"^1|X|2$",
            "odd":0.00
        },
        {
            "specifier":"^1|X|2$",
            "odd":0.00
        }
    ]
}
```

Entity example:
```
{
    "description":"PAO-OSFP",
    "match_date":"19/12/2022",
    "match_time":"19:30",
    "team_a":"PAO",
    "team_b":"OSFP",
    "sport":"Football",
    "matchodds":[
        {
            "specifier":"1",
            "odd":1.1
        },
        {
            "specifier":"X",
            "odd":1.2
        },
        {
            "specifier":"2",
            "odd":1.3
        }
    ]
}
```
*Fields team_a and team_b are compared with the description field in order to be validated.

**MatchOdds**

Entity model:
```
{
     "specifier":"^1|X|2$",
     "odd":0.00
}
```

Entity example:
```
{
     "specifier":"1",
     "odd":1.7
}
```

### Endpoints

**Base url: /match**

**Create endpoint**
```
method: POST

url: /create

description: Add a new match entry

body: A valid Match object

Responses: 200 – Match created, 400 – Bad request
```

**Read endpoint**
```
method: GET

url: /read/{id}

description: Get a match with the id given in the url

body: N/A

Responses: 200 – Match object, 404 – Not found
```

**Update endpoint**
```
method: PUT

url: /update/{id}

description: Update an existing match entry with the id given in the url

body: A valid Match object

Responses: 200 – Match updated, 400 – Bad request, 404 – Not found
```

**Delete endpoint**
```
method: DELETE

url: /delete/{id}

description: Delete a match entry with the id given in the url

body: N/A

Responses: 200 – Match deleted, 404 – Not found
```
