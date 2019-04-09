FROM maven:3.6-jdk-11-slim

WORKDIR /app/
COPY target/lib /app/lib
COPY target/*-runner.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]