FROM eclipse-temurin:17-jdk-alpine as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ln -sf /usr/share/zoneinfo/America/Puerto_Rico /etc/localtime

RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)


#FROM eclipse-temurin:11
FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENV DATABASE_URL "jdbc:postgresql://192.168.1.200:5432/cryptocurrency"
ENV API_KEY ""
ENV KEYCLOAK_URL "http://host.docker.internal:8080/realms/arquitectura"
ENV RESOURCE_ID "frontend"
ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.backend.BackendApplication"]