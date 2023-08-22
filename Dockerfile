FROM eclipse-temurin:17-jdk-alpine
COPY target/*.jar app.jar
ENV DATABASE_URL "jdbc:postgresql://localhost:5432/crypto"
ENTRYPOINT ["java","-jar","/app.jar"]