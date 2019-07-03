package quarkus.example.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionCheckerTest {

    @Test
    void exception() {
        boolean check = ExceptionChecker.isValid(() -> Integer.valueOf("X"));
        assertFalse(check);
    }

    @Test
    void withoutException() {
        boolean check = ExceptionChecker.isValid(() -> Integer.valueOf("0"));
        assertTrue(check);
    }
}