package client;

import Models.Courier;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class CreateCourierApiClient extends BaseHTTPClient{

    private final String createCourierUri = "/api/v1/courier";

    public ValidatableResponse createCourier(Courier courier){
        return given().spec(baseSpec())
                .body(courier)
                .when()
                .post(createCourierUri)
                .then();
    }

}
