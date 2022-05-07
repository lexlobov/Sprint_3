package client;

import Models.Courier;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class LoginCourierApiClient extends BaseHTTPClient {

    private final String loginCourierUri = "/api/v1/courier/login";

    public ValidatableResponse loginCourier(String login, String password){
        return given()
                .spec(baseSpec())
                .body(new Courier(login, password))
                .when()
                .post(loginCourierUri)
                .then();

    }
    public ValidatableResponse loginCourierWithoutBody(){
        return given()
                .spec(baseSpec())
                .when()
                .post(loginCourierUri)
                .then();

    }

}
