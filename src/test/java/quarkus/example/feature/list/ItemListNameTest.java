package quarkus.example.feature.list;

import org.junit.jupiter.api.Test;
import quarkus.example.feature.list.ItemListName;

import static org.junit.jupiter.api.Assertions.*;

class ItemListNameTest {

    @Test
    void valid() {
        assertTrue(ItemListName.isValid("Name"));
    }

    @Test
    void invalid() {
        assertFalse(ItemListName.isValid(null));
    }

    @Test
    void creation() {
        String value = "Name";
        ItemListName name = new ItemListName(value);
        assertEquals(value, name.value());
    }
}