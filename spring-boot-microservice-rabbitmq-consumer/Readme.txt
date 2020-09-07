Install RABBITMQ (TESTED on RabbitMQ 3.8.6 and Erlang 23.0.3)
Make sure rabbitmq is up and running (login to localhost:15672 username: guest, password: guest)
Install MySQL server
create database productdb 
use ddl-auto=create to create database tables automatically
spring.jpa.hibernate.ddl-auto=create

After running zuul-api-gateway-spring-boot, eureka-server-spring-boot produces and consumer microservice
use postman to post a message
Once the message is published by producer microservice, consumer microservice will listen and fetch the message from the rabbitmq product_queue

Refer https://github.com/ranjeetk24