FROM openjdk:8
ADD target\eurekaserver-0.0.1-SNAPSHOT.jar eureka-microservice.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar","eureka-microservice.jar"]