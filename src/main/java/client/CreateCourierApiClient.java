package client;

import Models.Courier;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class CreateCourierApiClient extends BaseHTTPClient{

    private final String createCourierUri = "/api/v1/courier";

    public ValidatableResponse createCourier(String login, String password, String firstName){
        return given().spec(baseSpec())
                .body(new Courier(login, password, firstName))
                .when()
                .post(createCourierUri)
                .then();
    }

}
