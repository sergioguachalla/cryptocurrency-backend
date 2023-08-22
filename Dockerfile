FROM eclipse-temurin:17-jdk-alpine
COPY . .
ENV DATABASE_URL "jdbc:postgresql://localhost:5432/crypto"
EXPOSE 8080
ENTRYPOINT ["java","-jar","/target/backend-0.0.1-SNAPSHOT.jar"]