package client;

import Models.Orders;

public class GetOrdersApiClient extends BaseHTTPClient{

    private final String baseUrl = "http://qa-scooter.praktikum-services.ru";

    public Orders getOrders(){
        return doGetRequest(baseUrl + "/api/v1/orders").body().as(Orders.class);
    }

    public Orders getOrdersByCourierId(long id){
        return doGetRequest(baseUrl + "/api/v1/orders?courierId=" + id).body().as(Orders.class);
    }

}
