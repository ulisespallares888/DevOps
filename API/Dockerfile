FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/demo-app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/API/target/API-0.0.1-SNAPSHOT.jar"]