package steps;

import Models.Order;
import Models.OrderCreatedOk;
import client.OrderApiClient;
import static org.assertj.core.api.Assertions.assertThat;
public class OrdersSteps {

    private long trackNumber;

    OrderApiClient orderApiClient = new OrderApiClient();

    public void createNewOrder(Order order){
        setTrackNumber(orderApiClient.createOrderApiClient(order).getTrack());

    }

    public void checkOrderCreated(){
        assertThat(trackNumber).isNotNull().isGreaterThan(1l);
    }

    public long getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(long trackNumber) {
        this.trackNumber = trackNumber;
    }
}
