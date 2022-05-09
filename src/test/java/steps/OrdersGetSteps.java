package steps;

import Models.Order;
import Models.Orders;
import client.OrderApiClient;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrdersGetSteps {

    private int orderId;
    private List<Order> orders;

    OrderApiClient orderApiClient = new OrderApiClient();



    @Step("Метод получения id заказа с использованием трек номера")
    public void setOrderIdByTrackNumber(int trackNumber){
    ValidatableResponse response = orderApiClient.getOrderByTrackNumber(trackNumber);
    setOrderId(response.extract().path("order.id"));
    assertThat("orderId should be greater than 0", orderId, Matchers.greaterThan(0));
    }

    @Step("Метод для принятия курьером заказа в работу")
    public void acceptOrder(int courierId){
        ValidatableResponse response = orderApiClient.orderAcceptByCourier(orderId, courierId);
        boolean  answer = response.extract().path("ok");
        assertThat("Answer should be True", answer, equalTo(true));
    }

    @Step("Метод получения списка всех заказов для конкретного курьера")
    public void getListOfOrdersByCourierId(int courierId){
        Orders orders = orderApiClient.getOrdersByCourierId(courierId);
        setOrders(orders.getOrders());
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

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
