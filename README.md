# springboottest1
Backend App which serves restful APIs

Endpoints Exposed:

GET     localhost:8080/                                   --> Home

GET     localhost:8080/productcatalog/all                 --> Returns full list of all products

GET     localhost:8080/productcatalog/{id}                --> Returns product with this id

Delete  localhost:8080/productcatalog/{id}                --> Deletes product with this id                          consumes = MediaType.APPLICATION_JSON_VALUE

PUT     localhost:8080/productcatalog/update/{id}         --> Updates the product details with this id in Database  consumes = MediaType.APPLICATION_JSON_VALUE

POST    localhost:8080/productcatalog/insert              --> Inserts a new product in Database                     consumes = MediaType.APPLICATION_JSON_VALUE
