# Product REST API
Product REST API is an micorservice related to Product based REST  appplication and implemeneted using Java Spring Boot for integarting with other systems/applications. This API has the following operations,

## List of APIs

```bash
1. Create Product (POST /Products)
2. Get Products (GET /Products)
3. Get Product by ProductId (GET /Products/{productId})
4. Update Product (PUT /Products/{productId})
5. Delete Product (Delete /Products/{productId})
```

## API Reference

#### Create Product

To create product in the system

```http
  POST /products
```
 
Headers
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `authorization` | `string` | **Optional**. authorization Credentials like Client Id and Client Secret | - To be added in future scope
| `X-Correlation-Id` | `string` | **Optional**. 16 didgits UUID |
| `content-type` | `string` | **Required**. Application/json |

Sample Request Body
```bash
{
   "id": 1000,
   "name": "Dell model 1",
   "category": "Dell",
   "status": "Active",
   "price": 27000.0,
   "quantity": 2
}
```
Sample Success Response

```bash
StatusCode as 200
Product Created Successfully
```

#### Get All Products
To retrieve all products from the system.

```http
  GET /products
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `authorization` | `string` | **Optional**. authorization Credentials like Client Id and Client Secret | - To be added in future scope
| `X-Correlation-Id` | `string` | **Optional**. 16 didgits UUID |

Sample Response
```bash
Statuscode as 200
[
    {
        "id": 1000,
        "name": "Dell model 1",
        "category": "Dell",
        "status": "Active",
        "price": 27000.0,
        "quantity": 2
    },
    {
        "id": 1001,
        "name": "Dell model 1",
        "category": "Dell",
        "status": "Active",
        "price": 27000.0,
        "quantity": 2
    }
]

```

#### Get Products by Id
To retrive product details based on Product Id

```http
  GET /products/${productId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `productId`      | `string` | **Required**. Product Id to fetch respective Product details |

Sample Response
```bash
Statuscode as 200
{
    "id": 1000,
    "name": "Dell model 1",
    "category": "Dell",
    "status": "Active",
    "price": 27000.0,
    "quantity": 2
    }
```
Error Response If product Not Found
```bash
StatusCode as 404
{
  "errorType": "404 NOT_FOUND",
  "errorCode": "404",
  "errorMessage": "Product Not Found"
}
```
#### Update Product by Id
To update product details based on Product Id

```http
  PUT /products/${productId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `productId`      | `string` | **Required**. Product Id to fetch respective Product details |

Sample Request Body,
```bash
{
   "name": "Iphone X",
   "category": "Iphone",
   "status": "Active",
   "price": 37000.0,
   "quantity": 5
  }
```

Sample Response
```bash
Statuscode as 200
{
    "id": 1000,
	"name": "Iphone X",
   "category": "Iphone",
   "status": "Active",
   "price": 37000.0,
   "quantity": 5
    }
```
Error Response If product Not Found
```bash
StatusCode as 404
{
  "errorType": "404 NOT_FOUND",
  "errorCode": "404",
  "errorMessage": "Product Not Found"
}
```

#### Delete Product by Id
To delete a product from the system based on Product Id

```http
  DELETE /products/${productId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `productId`      | `string` | **Required**. Product Id to fetch respective Product details |


Sample Response
```bash
Statuscode as 200
Product deleted Successfully
```
Error Response If product Not Found
```bash
StatusCode as 404
{
  "errorType": "404 NOT_FOUND",
  "errorCode": "404",
  "errorMessage": "Product Not Found"
}
```
## Tech stack
Client: Java and Spring Boot
Server: Tomcat

## Deployment

To complile this project run

```bash
  gradle clean build
```
To deploy this project run

```bash
  java -jar <snapshot-name>.jar
```
![image](https://github.com/KathaSudharshan/ProductRESTAPI/assets/138109855/637e123a-af24-4931-a27a-12927d1d9a02)

## Screenshots 
Beloe are the local run screenshots for reference
Create Product
![image](https://github.com/KathaSudharshan/ProductRESTAPI/assets/138109855/312810f8-d99a-485a-9db4-e12d684892f1)
Get Products
![image](https://github.com/KathaSudharshan/ProductRESTAPI/assets/138109855/7d95790f-2a65-4ee7-874b-8ab8620a829a)
Get Product By Id 
![image](https://github.com/KathaSudharshan/ProductRESTAPI/assets/138109855/7d9cca5c-ed01-44e1-b7b7-c252c970aa0b)
Get Product By Id if not found
![image](https://github.com/KathaSudharshan/ProductRESTAPI/assets/138109855/73fad174-e30e-4950-99bd-551e83d36bd9)
Update Product by Id
![image](https://github.com/KathaSudharshan/ProductRESTAPI/assets/138109855/93f37e45-38e1-4f90-b2c0-d2c0ec0450c1)
Delete Product by Id
![image](https://github.com/KathaSudharshan/ProductRESTAPI/assets/138109855/501836ad-92a0-40cd-a4de-8c0e8d910974)







