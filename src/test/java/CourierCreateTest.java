import Models.Courier;
import org.junit.After;
import org.junit.Test;
import steps.CourierSteps;

public class CourierCreateTest {

    CourierSteps steps = new CourierSteps();


    public void cleanUp(){
        steps.loginCourier();
        steps.deleteCourier();
    }


    @Test
    public void testCreateCourierIsCreated(){
        steps.checkCourierCreated();
        cleanUp();
    }

    // Даный тест падает, так как в документации к апи укзазано не то сообщение, которое приходит по факту
    @Test
    public void testSameLoginCourierCantBeCreated(){
        steps.checkSameNameCourierCantBeCreated();
        cleanUp();
    }

    
}
