FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/ProvinceNames.jar app.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "/app.jar"]
