package client;

import Models.ApiAnswers.OkApiAnswer;
import Models.Order;
import Models.OrderByTrackApiAnswer;
import Models.OrderCreatedOk;
import Models.Orders;

public class OrderApiClient extends BaseHTTPClient{

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

    public OrderByTrackApiAnswer getOrderByTrackNumber(long trackNumber){
        return doGetRequest(baseUrl + orderTrackUri + "?t=" + trackNumber).as(OrderByTrackApiAnswer.class);
    }


}
