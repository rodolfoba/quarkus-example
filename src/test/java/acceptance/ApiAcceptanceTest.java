package acceptance;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import quarkus.example.feature.list.ItemListResourceV1_0;
import quarkus.example.library.test.AcceptanceTest;

@AcceptanceTest
class ApiAcceptanceTest {

    static final String API_ENDPOINT = "/api";
    static final String RESOURCE_VERSION = "/1.0";
    static final String RESOURCE_PATH = API_ENDPOINT + RESOURCE_VERSION + "/list";

    @Test    
    void withoutLists() {
        given().when().get(RESOURCE_PATH).then().statusCode(200).and().body("", empty());
    }

    @Test    
    void listCreation() {
        var dto = new ItemListResourceV1_0.ItemListRestDto(UUID.randomUUID(), "Test List");
        given().body(dto).contentType(ContentType.JSON).when().post(RESOURCE_PATH).then().statusCode(201);
    }

}
