# =============================
# Etapa 1: Build del jar con Maven
# =============================
FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app


COPY pom.xml .
RUN mvn dependency:go-offline


COPY src ./src


RUN mvn clean package -DskipTests

# =============================
# Etapa 2: Contenedor ligero con JDK
# =============================
FROM eclipse-temurin:23-jdk-alpine
WORKDIR /app


COPY --from=build /app/target/API-0.0.1-SNAPSHOT.jar API.jar


ENV SPRING_PROFILES_ACTIVE=prod


EXPOSE 8080


ENTRYPOINT ["java","-jar","API.jar","--spring.profiles.active=prod"]
