# API Spec

## Create Product

Request:
- Method: POST
- Endpoint: `api/v1/products`
- Header:
  - Content-Type: application/json
  - Accept: application/json
- Body:

```json
{
  "id": "id product, unique",
  "name": "string",
  "price": "long",
  "quantity": "integer"
}
```

Response:

```json
{
  "code": "integer",
  "status": "string",
  "data": {
    "id": "id product, unique",
    "name": "string",
    "price": "long",
    "quantity": "integer",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

## Get Product

Request:
- Method: GET
- Endpoint: `api/v1/products/{id_product}`
- Header:
    - Accept: application/json

Response:

```json
{
  "code": "integer",
  "status": "string",
  "data": {
    "id": "id product, unique",
    "name": "string",
    "price": "long",
    "quantity": "integer",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

## Update Product

Request:
- Method: PUT
- Endpoint: `api/v1/products/{id_product}`
- Header:
    - Content-Type: application/json
    - Accept: application/json
- Body:

```json
{
  "name": "string",
  "price": "long",
  "quantity": "integer"
}
```

Response:

```json
{
  "code": "integer",
  "status": "string",
  "data": {
    "id": "id product, unique",
    "name": "string",
    "price": "long",
    "quantity": "integer",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

## List Product

Request:
- Method: GET
- Endpoint: `api/v1/products`
- Header:
  - Accept: application/json
- Query Param:
  - size: integer
  - page: integer

Response:

```json
{
  "code": "integer",
  "status": "string",
  "data": [
      {
          "id": "id product, unique",
          "name": "string",
          "price": "long",
          "quantity": "integer",
          "createdAt": "date",
          "updatedAt": "date"
      },
      {
          "id": "id product, unique",
          "name": "string",
          "price": "long",
          "quantity": "integer",
          "createdAt": "date",
          "updatedAt": "date"
      }
  ]
}
```


## Delete Product

Request:
- Method: DELETE
- Endpoint: `api/v1/products/{id_product}`
- Header:
    - Accept: application/json

Response:

```json
{
  "code": "integer",
  "status": "string"
}
```
