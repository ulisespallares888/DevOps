#FROM eclipse-temurin:23-jdk-alpine
#WORKDIR /app
#COPY /target/API-0.0.1-SNAPSHOT.jar API.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","API.jar"]

# =============================
# Etapa 1: Build del jar con Maven
# =============================
FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app

# Copiamos pom.xml primero para cachear dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el código fuente completo
COPY src ./src

# Compilamos el jar (sin tests)
RUN mvn clean package -DskipTests

# =============================
# Etapa 2: Contenedor ligero con JDK
# =============================
FROM eclipse-temurin:23-jdk-alpine
WORKDIR /app

# Copiamos el jar generado desde la etapa build
COPY --from=build /app/target/API-0.0.1-SNAPSHOT.jar API.jar

# Perfil docker por defecto
ENV SPRING_PROFILES_ACTIVE=docker

# Puerto expuesto
EXPOSE 8080

# Ejecutar la applicación

ENTRYPOINT ["java","-jar","API.jar","--spring.profiles.active=docker"]
