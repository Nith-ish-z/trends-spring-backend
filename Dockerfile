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
FROM eclipse-temurin:21-jdk AS build
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN ./mvnw clean package -DskipTests
# OR if you don't use mvnw:
# RUN mvn clean package -DskipTests

# ---------- Runtime stage ----------
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /build/target/*.jar app.jar

EXPOSE 8090
ENTRYPOINT ["java", "-jar", "app.jar"]

