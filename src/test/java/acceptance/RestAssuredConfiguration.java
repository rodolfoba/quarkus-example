package acceptance;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class RestAssuredConfiguration {

    static {
        RestAssured.baseURI = "http://localhost:8081/api";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();    
    }

    public static void setDefaultRequestSpec(String resourceBasePath) {
        RestAssured.requestSpecification = new RequestSpecBuilder().setBasePath(resourceBasePath)
                .setAccept(ContentType.JSON).setContentType(ContentType.JSON).build();
        ;
    }

}