package courier;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import steps.CourierSteps;

public class CourierCreateTest {

    CourierSteps steps = new CourierSteps();


    public void cleanUp(){
        steps.loginCourier();
        steps.deleteCourier();
    }


    @Test
    @DisplayName("Тест на то, что при создании курьера возвращается верная структура ответа")
    public void testCreateCourierIsCreated(){
        steps.checkCourierCreateReturnsOkTrue();
        cleanUp();
    }

    // Даный тест падает, так как в документации к апи укзазано не то сообщение, которое приходит по факту
    @Test
    @DisplayName("Тест, что нельзя создать двух курьеров с одинаковым логином")
    public void testSameLoginCourierCantBeCreated(){
        steps.checkSameNameCourierCantBeCreated();
        cleanUp();
    }

    @Test
    @DisplayName("Тест на то, что курьер создается")
    public void testCourierCreated(){
        steps.checkCourierCreated();
        cleanUp();
    }


}
