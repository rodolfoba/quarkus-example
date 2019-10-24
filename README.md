# Quarkus example application
[Quarkus](https://quarkus.io)

* Quarkus application
* MicroProfile Health / Metrics / Fault Tolerance / OpenAPI / SwaggerUI
* Flyway DB 
* Prometheus
* Grafana

## Prerequisites
* [Maven 3.5.3+](https://maven.apache.org/install.html)
* [Java - JDK 11](https://adoptopenjdk.net/)

## Running application in development mode
```bash
$ docker-compose up postgres
$ mvn clean compile quarkus:dev
```

## Running jvm-mode
```bash
$ cp src/main/docker/Dockerfile.jvm src/main/docker/Dockerfile
$ mvn clean package
$ docker-compose up --build
```

## Running native-mode
```bash
$ cp src/main/docker/Dockerfile.native src/main/docker/Dockerfile
$ mvn clean package -Pnative -Dnative-image.docker-build=true
$ docker-compose up --build
```

## Endpoints
* swagger-ui at: http://localhost:8080/swagger-ui/index.html
* Grafana at: http://localhost:3000 | Login as admin/admin