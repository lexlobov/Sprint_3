import Models.Courier;
import org.junit.After;
import org.junit.Test;
import steps.CourierSteps;

public class CourierCreateTest {

    CourierSteps steps = new CourierSteps();

    @After
    public void cleanUp(){
        steps.loginCourier();
        steps.deleteCourier();
    }


    @Test
    public void testCreateCourierIsCreated(){
        steps.checkCourierCreated();
    }

    @Test
    public void testSameLoginCourierCantBeCreated(){

    }
}
