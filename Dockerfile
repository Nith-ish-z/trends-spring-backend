# # Use Java 21 runtime
# FROM eclipse-temurin:21-jre
# WORKDIR /app
#
# # Copy the pre-built JAR from repo
# COPY target/*.jar app.jar
#
# # Expose the port your Spring Boot app runs on
# EXPOSE 8090
#
# # Run the JAR
# ENTRYPOINT ["java", "-jar", "app.jar"]
# ---------- Build stage ----------
# ---------- BUILD STAGE ----------
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# ---------- RUNTIME STAGE ----------
FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8090
ENTRYPOINT ["java", "-jar", "app.jar"]
