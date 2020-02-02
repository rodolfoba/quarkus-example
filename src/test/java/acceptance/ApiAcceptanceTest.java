package acceptance;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.empty;

import java.util.UUID;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.quarkus.test.junit.QuarkusTest;
import quarkus.example.feature.list.ItemListEntity;
import quarkus.example.feature.list.ItemListResourceV1_0;
import quarkus.example.library.test.AcceptanceTest;

@QuarkusTest
@Transactional
@AcceptanceTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApiAcceptanceTest {

    private static final String RESOURCE_BASE_PATH = "/1.0/list";

    @BeforeAll
    static void beforeAll() {
        RestAssuredConfiguration.setDefaultRequestSpec(RESOURCE_BASE_PATH);
    }

    @BeforeEach
    void beforeEach() {
        ItemListEntity.deleteAll();
    }

    @Test
    void withoutLists() {
        given().when().get().then().statusCode(200).and().body("", empty());
    }

    @Test
    void listCreationAndRetrieval() {
        var dto = new ItemListResourceV1_0.ItemListRestDto(UUID.randomUUID(), "Test List");
        given().body(dto).when().post().then().statusCode(201).header("Location", containsString(dto.id.toString()));
        var responseDto = given().when().get("/{id}", dto.id).as(ItemListResourceV1_0.ItemListRestDto.class);
        assertThat(responseDto).usingRecursiveComparison().isEqualTo(dto);
    }

}
