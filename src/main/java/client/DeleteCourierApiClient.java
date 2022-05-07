package client;

import Models.DeleteCourier;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class DeleteCourierApiClient extends BaseHTTPClient{

    private final String deleteCourierUri = "/api/v1/courier/";

    public ValidatableResponse deleteCourier(DeleteCourier deleteCourier){
        return given().spec(baseSpec())
                .body(deleteCourier)
                .when()
                .delete(deleteCourierUri)
                .then();
    }
}
