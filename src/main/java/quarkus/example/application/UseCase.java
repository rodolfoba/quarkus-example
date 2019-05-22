package quarkus.example.application;

public interface UseCase<I, O> {

    O execute(I input);

}
