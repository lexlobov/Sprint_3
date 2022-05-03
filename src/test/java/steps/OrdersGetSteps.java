package steps;

import Models.Order;
import client.OrderApiClient;
import com.google.gson.Gson;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrdersGetSteps {

    private long orderId;
    private List<Order> orders;

    OrderApiClient orderApiClient = new OrderApiClient();

    public void setOrderIdByTrackNumber(long trackNumber){
    setOrderId(orderApiClient.getOrderByTrackNumber(trackNumber).getOrder().getId());

    }

    public void acceptOrder(long courierId){
        orderApiClient.orderAcceptByCourier(orderId, courierId);
    }

    public void getListOfOrdersByCourierId(long courierId){
        setOrders(orderApiClient.getOrdersByCourierIdApiClient(courierId).getOrders());
    }

    public void checkOrderIsCorrect(Order newOrder){

        assertThat(orders.get(0).getFirstName()).isEqualTo(newOrder.getFirstName());
        assertThat(orders.get(0).getLastName()).isEqualTo(newOrder.getLastName());
        assertThat(orders.get(0).getAddress()).isEqualTo(newOrder.getAddress());
        assertThat(orders.get(0).getMetroStation()).isEqualTo(newOrder.getMetroStation());
        assertThat(orders.get(0).getPhone()).isEqualTo(newOrder.getPhone());
        assertThat(orders.get(0).getRentTime()).isEqualTo(newOrder.getRentTime());
        assertThat(orders.get(0).getDeliveryDate()).isEqualTo(newOrder.getDeliveryDate());
        assertThat(orders.get(0).getComment()).isEqualTo(newOrder.getComment());
        assertThat(orders.get(0).getColor()).isEqualTo(newOrder.getColor());
    }




    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
