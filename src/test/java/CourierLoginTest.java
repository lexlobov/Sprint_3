import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.CourierSteps;

public class CourierLoginTest {

    CourierSteps steps = new CourierSteps();
    @Before
    public void setUp(){
        steps.createCourier();
    }

    @After
    public void tearDown(){
        steps.deleteCourier();
    }


    @Test
    public void testCourierLogin(){
        steps.checkCourierLoggedIn();

    }
}
