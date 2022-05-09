package Orders;

import Models.Order;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import steps.OrderCreateSteps;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RunWith(Parameterized.class)
@DisplayName("Создание заказа с разными параметрами цвета")
public class CreateOrderParameterizedTest {


    private List<String> color;

    OrderCreateSteps ordersSteps = new OrderCreateSteps();

    public CreateOrderParameterizedTest(List<String> color) {
        this.color = color;
    }


    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{

                {Arrays.asList("BLACK")},
                {Arrays.asList("BLACK", "GREY")},
                {Arrays.asList("GREY"),},
                {null},
        };
    }
    @Test
    @DisplayName("Тест на то, создание заказа с разными цветами")
    @Description("Можно создать заказ с одним цветом, с двумя, или ни с одним и ни с другим")
    public void createOrderWithDifferentColorsTest(){
        Faker faker = new Faker();
        Order order = new Order(faker.name().firstName(),
                faker.name().lastName(),
                faker.address().streetAddressNumber(),
                RandomStringUtils.randomAlphabetic(10),
                faker.phoneNumber().cellPhone(),
                new Random().nextInt(10),
                "2020-06-06",
                RandomStringUtils.randomAlphabetic(10),
                color);
        ordersSteps.createNewOrder(order);
        ordersSteps.checkOrderCreated();

    }
}
