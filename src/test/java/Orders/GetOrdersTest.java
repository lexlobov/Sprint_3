package Orders;

import Models.Order;
import com.google.gson.Gson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.CourierSteps;
import steps.OrderCreateSteps;
import steps.OrdersGetSteps;

public class GetOrdersTest {


    CourierSteps courierSteps = new CourierSteps();
    OrderCreateSteps orderCreateSteps = new OrderCreateSteps();
    OrdersGetSteps ordersGetSteps = new OrdersGetSteps();
    Order newOrder = orderCreateSteps.generateNewOrder();

    @Before
    public void setUp (){
        Gson gson = new Gson();
        courierSteps.createCourier();
        courierSteps.loginCourier();
        orderCreateSteps.createNewOrder(newOrder);


    }

    @After
    public void cleanUp(){
        courierSteps.loginCourier();
        courierSteps.deleteCourier();
    }

    @Test
    public void getOrdersByCourierIdReturnsCorrectOrdersList(){
        ordersGetSteps.setOrderIdByTrackNumber(orderCreateSteps.getTrackNumber());
        ordersGetSteps.acceptOrder(courierSteps.getCourierId());
        ordersGetSteps.getListOfOrdersByCourierId(courierSteps.getCourierId());
        ordersGetSteps.checkOrderIsCorrect(newOrder);
    }




}
