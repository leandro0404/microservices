FROM openjdk:17
WORKDIR /app
COPY target/api-application*.jar app.jar


EXPOSE 9005

CMD ["java", "-jar", "app.jar"]
