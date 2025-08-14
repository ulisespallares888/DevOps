FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY /target/API-0.0.1-SNAPSHOT.jar API.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","API.jar"]