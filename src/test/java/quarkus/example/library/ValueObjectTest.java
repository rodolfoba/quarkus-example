package quarkus.example.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValueObjectTest {

    @Test
    void anIntegerValueObject() {
        var one = new AnIntegerValueObject(1);
        assertEquals(1, one.value());

        var anotherOne = new AnIntegerValueObject(1);
        assertTrue(one.sameAs(anotherOne));
        assertTrue(anotherOne.sameAs(one));

        assertEquals(one.hashCode(), anotherOne.hashCode());
    }

    static class AnIntegerValueObject extends ValueObject<Integer> {

        AnIntegerValueObject(Integer value) {
            super(value);
        }
    }

}
