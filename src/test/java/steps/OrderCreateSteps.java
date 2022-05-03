package steps;

import Models.Order;
import client.OrderApiClient;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
public class OrderCreateSteps {

    private long trackNumber;

    OrderApiClient orderApiClient = new OrderApiClient();

    public void createNewOrder(Order order){
        setTrackNumber(orderApiClient.createOrderApiClient(order).getTrack());

    }

    public void checkOrderCreated(){
        assertThat(trackNumber).isNotNull().isGreaterThan(1l);
    }

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

    public long getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(long trackNumber) {
        this.trackNumber = trackNumber;
    }
}
