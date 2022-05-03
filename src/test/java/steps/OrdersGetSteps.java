package steps;

import Models.Order;
import client.OrderApiClient;
import com.google.gson.Gson;
import io.qameta.allure.Step;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrdersGetSteps {

    private long orderId;
    private List<Order> orders;

    OrderApiClient orderApiClient = new OrderApiClient();



    @Step("Метод получения id заказа с использованием трек номера")
    public void setOrderIdByTrackNumber(long trackNumber){
    setOrderId(orderApiClient.getOrderByTrackNumber(trackNumber).getOrder().getId());

    }

    @Step("Метод для принятия курьером заказа в работу")
    public void acceptOrder(long courierId){
        orderApiClient.orderAcceptByCourier(orderId, courierId);
    }

    @Step("Метод получения списка всех заказов для конкретного курьера")
    public void getListOfOrdersByCourierId(long courierId){
        setOrders(orderApiClient.getOrdersByCourierIdApiClient(courierId).getOrders());
    }

    @Step("Проверка, что все поля ранее созданного заказа соответствуют тому, что попало в базу данных и возвращается в ответе")
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
