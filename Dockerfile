FROM openjdk:17-jdk-alpine
EXPOSE 8080
WORKDIR /app
COPY target/spring-boot-rest.jar /app/app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]