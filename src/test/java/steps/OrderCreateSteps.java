package steps;

import Models.Order;
import client.OrderApiClient;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import java.util.Arrays;
import java.util.Random;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderCreateSteps {

    private int trackNumber;


    OrderApiClient orderApiClient = new OrderApiClient();

    @Step("Создание нового заказа")
    public void createNewOrder(Order order){
        ValidatableResponse response = orderApiClient.createOrder(order);
        int track = response.extract().path("track");
        int statusCode = response.extract().statusCode();
        assertThat("Status code should be 201", statusCode, equalTo(HttpStatus.SC_CREATED));
        setTrackNumber(track);
    }

    @Step("Проверка, что при создании заказа возвращается трек номер и он не равен нулю")
    public void checkOrderCreated(){
        assertThat(trackNumber).isNotNull().isGreaterThan(0);
    }

    @Step("Метод генерации случайных данных для заказа")
    public Order generateNewOrder(){
        Faker faker = new Faker();
        return new Order(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.address().streetAddressNumber(),
                RandomStringUtils.randomAlphabetic(10),
                faker.phoneNumber().cellPhone(),
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
