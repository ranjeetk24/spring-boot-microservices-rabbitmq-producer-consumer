# spring-boot-microservices-rabbitmq-producer-consumer

Install RABBITMQ (TESTED on RabbitMQ 3.8.6 and Erlang 23.0.3)
Make sure rabbitmq is up and running (login to localhost:15672 username: guest, password: guest)
Install MySQL server
create database inventorydb and productdb 
Import all the projects in STS
After running zuul api gateway and eureka server, start spring-boot-microservice-rabbitmq-producer and spring-boot-microservice-rabbitmq-consumer

Publish a message from postman

http://localhost:8098/product/   (if running only producer and consumer, in this case you will get warning message "Not able to connect to unknown server", that can be ignored as eureka server is not UP)
POST
Body

{
        "id": 1,
        "productName": "LG Television",
        "productDescription": "55 inch 4K smart TV",
        "price": "62000"
}

If running along with eureka server and zuul api gateway 
http://localhost:9090/api/producer-service/product/
POST
{
        "id": 1,
        "productName": "LG Television",
        "productDescription": "55 inch 4K smart TV",
        "price": "62000"
}
Once the message is published by producer microservice, consumer microservice will listen and fetch the message from rabbitmq PRODUCT_QUEUE
and will save the data in mysql database (productdb)

This can be verified from rabbitmq management console and mysql database


Refer https://github.com/ranjeetk24