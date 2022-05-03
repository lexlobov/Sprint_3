package client;

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

    private Orders getOrdersApiClient(){
        return  doGetRequest(baseUrl + orderUri).as(Orders.class);

    }


}
