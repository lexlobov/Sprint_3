package steps;

import Models.Order;
import client.OrderApiClient;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
public class OrderCreateSteps {

    private int trackNumber;


    OrderApiClient orderApiClient = new OrderApiClient();

    @Step("Создание нового заказа")
    public void createNewOrder(Order order){
        setTrackNumber(orderApiClient.createOrder(order).extract().path("track"));

    }

    @Step("Проверка, что при создании заказа возвращается трек номер и он не равен нулю")
    public void checkOrderCreated(){
        assertThat(trackNumber).isNotNull().isGreaterThan(1);
    }

    @Step("Метод генерации случайных данных для заказа")
    public Order generateNewOrder(){
        return new Order(
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10),
                new Random().nextInt(10),
                "2022-06-06T00:00:00.000Z",
                RandomStringUtils.randomAlphabetic(10),
                Arrays.asList("BLACK"));
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }
}
