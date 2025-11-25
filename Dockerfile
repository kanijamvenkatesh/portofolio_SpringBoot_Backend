# --- Stage 1: Build the project ---
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY . .

# Build Spring Boot JAR
RUN mvn clean package -DskipTests

# --- Stage 2: Run the JAR ---
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Render injects PORT env variable
ENV PORT=8080

EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]
