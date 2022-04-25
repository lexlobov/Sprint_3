package client;

import Models.Order;
import Models.OrderCreatedOk;
import Models.Orders;

import java.util.List;

public class OrderApiClient extends BaseHTTPClient{

    private final String baseUrl = "http://qa-scooter.praktikum-services.ru";
    private final String orderUri = "/api/v1/orders";

    public OrderCreatedOk createOrderApiClient(String firstName, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDate, String comment, List<String> color){
        Order order = new Order(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
        return doPostRequest(baseUrl + orderUri, order).as(OrderCreatedOk.class);
    }

    private Orders getOrdersApiClient(){
        return  doGetRequest(baseUrl + orderUri).as(Orders.class);

    }


}
