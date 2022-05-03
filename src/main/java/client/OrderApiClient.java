package client;

import Models.ApiAnswers.OkApiAnswer;
import Models.Order;
import Models.Order1;
import Models.OrderCreatedOk;
import Models.Orders;

import java.util.List;

public class OrderApiClient extends BaseHTTPClient{

    private final String baseUrl = "http://qa-scooter.praktikum-services.ru";
    private final String orderUri = "/api/v1/orders";
    private final String orderTrackUri = "/api/v1/orders/track" ;

    public OrderCreatedOk createOrderApiClient(Order order){
        return doPostRequest(baseUrl + orderUri, order).as(OrderCreatedOk.class);
    }

    public Orders getOrdersByCourierIdApiClient(long courierId){
        return  doGetRequest(baseUrl + orderUri + "?courierId=" + courierId).as(Orders.class);

    }

    public OkApiAnswer orderAcceptByCourier(long orderId, long courierId){
        return doPutRequest(baseUrl + "/api/v1/orders/accept/" + orderId + "?courierId=" + courierId).as(OkApiAnswer.class);
    }

    public Order1 getOrderByTrackNumber(long trackNumber){
        return doGetRequest(baseUrl + orderTrackUri + "?t=" + trackNumber).as(Order1.class);
    }


}
