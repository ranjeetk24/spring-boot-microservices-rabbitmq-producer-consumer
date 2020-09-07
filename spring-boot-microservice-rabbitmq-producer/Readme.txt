Install RABBITMQ (TESTED on RabbitMQ 3.8.6 and Erlang 23.0.3)
Make sure rabbitmq is up and running (login to localhost:15672 username: guest, password: guest)
Install MySQL server
create database inventorydb (can be used for other logic, currently not used but db is required to run the application) 

Refer https://github.com/ranjeetk24
After running zuul-api-gateway-spring-boot and eureka-server-spring-boot and product microservice

Publish a message from postman

http://localhost:8098/product/   (if running only producer and consumer, in this case you will get warning message "Not able to connect to unknown server", that can be ignored as eureka server is not UP)
POST
Body

{
       
        "productName": "LG Television",
        "productDescription": "55 inch 4K smart TV",
        "price": "62000"
}

If running eureka server and zuul api gateway 
http://localhost:9090/api/producer-service/product/
POST
Body
{
        
        "productName": "LG Television",
        "productDescription": "55 inch 4K smart TV",
        "price": "62000"
}
Once the message is published by producer microservice, consumer microservice will listen and fetch the message from the rabbitmq product_queue and will save the message in the mysql database