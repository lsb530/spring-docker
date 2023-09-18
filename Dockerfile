#FROM ubuntu:latest
FROM amazoncorretto:17
LABEL authors="boki"
COPY build/libs/spring-docker.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]