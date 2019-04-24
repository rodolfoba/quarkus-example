# Quarkus example application
[Quarkus](https://quarkus.io)

* Quarkus application
* MicroProfile Health / Metrics / Fault Tolerance / OpenAPI / SwaggerUI
* Prometheus
* Grafana

## Prerequisites
* [Maven 3.5.3+](https://maven.apache.org/install.html)
* [Java - OpenJDK 1.8+](https://adoptopenjdk.net/)

## Running application in development mode
```bash
$ docker-compose up postgres
$ mvn clean compile quarkus-dev
```

## Running jvm-mode
```bash
$ cp src/main/docker/Dockerfile.jvm src/main/docker/Dockerfile
$ mvn clean package
$ docker-compose up
```

## Running native-mode
```bash
$ cp src/main/docker/Dockerfile.native src/main/docker/Dockerfile
$ mvn clean package -Pnative -Dnative-image.docker-build=true
$ docker-compose up
```

* swagger-ui at: http://localhost:8080/swagger-ui/index.html
* http://localhost:8080/hello or http://localhost:8080/hello/greeting/{name}
* Grafana at: http://localhost:3000
* Login as  admin/admin
* Add datasource
* Choose prometheus
* URL = http://prom:9090
* Click Save & Test
* New Dashboard
* Query = application:quarkus_example_greeting_resource_performed_checks


