package client;

import Models.Courier;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class LoginCourierApiClient extends BaseHTTPClient {

    private final String loginCourierUri = "/api/v1/courier/login";

    public ValidatableResponse loginCourier(Courier courier){
        return given()
                .spec(baseSpec())
                .body(courier)
                .when()
                .post(loginCourierUri)
                .then();

    }


}
