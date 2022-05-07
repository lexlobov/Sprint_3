package client;

import Models.Order;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class OrderApiClient extends BaseHTTPClient{

    private final String orderUri = "/api/v1/orders";
    private final String orderTrackUri = "/api/v1/orders/track" ;

    public ValidatableResponse createOrderApiClient(Order order){
        return given().spec(baseSpec())
                .body(order)
                .when()
                .post(orderUri)
                .then();
    }

    public ValidatableResponse getOrdersByCourierIdApiClient(long courierId){
        return given().spec(baseSpec())
                .queryParams("courierId", courierId)
                .when()
                .get(orderUri)
                .then();
    }

    public ValidatableResponse orderAcceptByCourier(long orderId, long courierId){
        return given().spec(baseSpec())
                .queryParams("courierId", courierId)
                .when()
                .get(orderUri + orderId)
                .then();
    }

    public ValidatableResponse getOrderByTrackNumber(long trackNumber){
        return given().spec(baseSpec())
                .queryParams("courierId", trackNumber)
                .when()
                .get(orderTrackUri)
                .then();
    }


}
