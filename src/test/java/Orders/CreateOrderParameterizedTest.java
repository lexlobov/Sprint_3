package Orders;

import Models.Order;
import com.google.gson.Gson;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import steps.OrderCreateSteps;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RunWith(Parameterized.class)
public class CreateOrderParameterizedTest {

    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private List<String> color;

    OrderCreateSteps ordersSteps = new OrderCreateSteps();

    public CreateOrderParameterizedTest(String firstName,
                                        String lastName,
                                        String address,
                                        String metroStation,
                                        String phone,
                                        int rentTime,
                                        String deliveryDate,
                                        String comment,
                                        List<String> color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }


    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{

                {       RandomStringUtils.randomAlphabetic(10),
                        RandomStringUtils.randomAlphabetic(10),
                        RandomStringUtils.randomAlphabetic(10),
                        RandomStringUtils.randomAlphabetic(10),
                        RandomStringUtils.randomAlphabetic(10),
                        new Random().nextInt(10),
                        "2020-06-06",
                        RandomStringUtils.randomAlphabetic(10),
                        Arrays.asList("BLACK")},
                {       RandomStringUtils.randomAlphabetic(10),
                        RandomStringUtils.randomAlphabetic(10),
                        RandomStringUtils.randomAlphabetic(10),
                        RandomStringUtils.randomAlphabetic(10),
                        RandomStringUtils.randomAlphabetic(10),
                        new Random().nextInt(10),
                        "2020-06-06",
                        RandomStringUtils.randomAlphabetic(10),
                        Arrays.asList("BLACK", "GREY"),},
                {       RandomStringUtils.randomAlphabetic(10),
                        RandomStringUtils.randomAlphabetic(10),
                        RandomStringUtils.randomAlphabetic(10),
                        RandomStringUtils.randomAlphabetic(10),
                        RandomStringUtils.randomAlphabetic(10),
                        new Random().nextInt(10),
                        "2020-06-06",
                        RandomStringUtils.randomAlphabetic(10),
                        Arrays.asList("GREY"),},
                {       RandomStringUtils.randomAlphabetic(10),
                        RandomStringUtils.randomAlphabetic(10),
                        RandomStringUtils.randomAlphabetic(10),
                        RandomStringUtils.randomAlphabetic(10),
                        RandomStringUtils.randomAlphabetic(10),
                        new Random().nextInt(10),
                        "2020-06-06",
                        RandomStringUtils.randomAlphabetic(10),
                        null,},
        };
    }
    @Test
    public void createOrderWithDifferentColorsTest(){
        Order order = new Order(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
        Gson gson = new Gson();
        System.out.println(gson.toJson(order));
        ordersSteps.createNewOrder(order);
        ordersSteps.checkOrderCreated();

    }
}
