package quarkus.example.library;

public class ExceptionChecker {

    private ExceptionChecker() {}

    public static boolean isValid(Runnable runnable) {
        try {
            runnable.run();
        } catch (RuntimeException e) {
            return false;
        }

        return true;
    }

}


