package client;

import Models.Order;
import Models.Orders;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class OrderApiClient extends BaseHTTPClient{

    private final String orderUri = "/api/v1/orders";
    private final String orderTrackUri = "/api/v1/orders/track";
    private final String orderAcceptUri = "/api/v1/orders/accept/";

    public ValidatableResponse createOrder(Order order){
        return given().spec(baseSpec())
                .body(order)
                .when()
                .post(orderUri)
                .then();
    }

    public Orders getOrdersByCourierId(int courierId){
        return given().spec(baseSpec())
                .queryParam("courierId", courierId)
                .get(orderUri)
                .body().as(Orders.class);

    }

    public ValidatableResponse orderAcceptByCourier(long orderId, int courierId){
        return given().spec(baseSpec())
                .queryParam("courierId", courierId)
                .when()
                .put(orderAcceptUri + orderId)
                .then();
    }

    public ValidatableResponse getOrderByTrackNumber(int trackNumber){
        return given().spec(baseSpec())
                .queryParam("t", trackNumber)
                .when()
                .get(orderTrackUri)
                .then();
    }


}
