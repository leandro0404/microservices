FROM openjdk:17
WORKDIR /app
COPY target/auth-server*.jar app.jar


EXPOSE 9002

CMD ["java", "-jar", "app.jar"]
