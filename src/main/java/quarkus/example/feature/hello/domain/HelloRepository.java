package quarkus.example.feature.hello.domain;

import quarkus.example.feature.hello.domain.Hello;

public interface HelloRepository {

    void save(Hello hello);

}
