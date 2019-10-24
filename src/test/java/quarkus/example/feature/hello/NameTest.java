package quarkus.example.feature.hello;

import org.junit.jupiter.api.Test;
import quarkus.example.feature.hello.Name;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void valid() {
        assertTrue(Name.isValid("Name"));
    }

    @Test
    void invalid() {
        assertFalse(Name.isValid(null));
    }

    @Test
    void creation() {
        String value = "Name";
        Name name = new Name(value);
        assertEquals(value, name.value());
    }
}