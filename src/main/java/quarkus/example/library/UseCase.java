package quarkus.example.library;

public interface UseCase<I, O> {

    O execute(I input);

}
