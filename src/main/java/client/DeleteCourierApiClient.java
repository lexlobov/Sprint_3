package client;

import Models.DeleteCourier;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class DeleteCourierApiClient extends BaseHTTPClient{

    private final String deleteCourierUri = "/api/v1/courier/";

    public ValidatableResponse deleteCourier(int id){
        return given().spec(baseSpec())
                .body(new DeleteCourier(Long.toString(id)))
                .when()
                .delete(deleteCourierUri)
                .then();
    }
}
