FROM openjdk:8
ADD target/consume-service.jar consume-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "consume-service.jar"]