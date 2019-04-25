FROM openjdk:8
ADD target/consume-service-0.0.1-SNAPSHOT.jar consume-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "consume-service.jar"]