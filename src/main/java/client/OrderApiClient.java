package client;

import Models.ApiAnswers.OkApiAnswer;
import Models.Order;
import Models.OrderCreatedOk;
import Models.Orders;

import java.util.List;

public class OrderApiClient extends BaseHTTPClient{

    private final String baseUrl = "http://qa-scooter.praktikum-services.ru";
    private final String orderUri = "/api/v1/orders";

    public OrderCreatedOk createOrderApiClient(Order order){
        return doPostRequest(baseUrl + orderUri, order).as(OrderCreatedOk.class);
    }

    private Orders getOrdersByCourierIdApiClient(long courierId){
        return  doGetRequest(baseUrl + orderUri + "?courierId=" + courierId).as(Orders.class);

    }

    private OkApiAnswer orderAcceptByCourier(long orderId, long courierId){
        return doPutRequest(baseUrl + "/api/v1/orders/accept/" + orderId + "?courierId=" + courierId).as(OkApiAnswer.class);
    }

    private Order getOrderByTrackNumber(long trackNumber){
        return doGetRequest(baseUrl + orderUri + "track?t=" + trackNumber).as(Order.class);
    }


}
