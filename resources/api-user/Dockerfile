FROM openjdk:17
WORKDIR /app
COPY target/api-user*.jar app.jar


EXPOSE 9006

CMD ["java", "-jar", "app.jar"]
