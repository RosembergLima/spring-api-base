# Etapa de build
FROM maven:3.9.6-eclipse-temurin-17-alpine AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa final (runtime)
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
RUN mkdir /opt/app
COPY --from=builder /app/target/spring-api-base*.jar /opt/app/japp.jar
CMD ["java", "-jar", "/opt/app/japp.jar"]
EXPOSE 8080