package courier;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.CourierSteps;
@DisplayName("Различные варианты авторизации курьера")
public class CourierLoginTest {

    CourierSteps steps = new CourierSteps();

    @Before
    public void setUp(){
        steps.createCourier();
    }

    @After
    public void cleanUp(){
        steps.loginCourier();
        steps.deleteCourier();
    }


    @Test
    @DisplayName("Тест на то, что можно пройти авторизацию")
    public void testCourierLogin(){
        steps.checkCourierLoggedIn();
    }

    @Test
    @DisplayName("Тест на то, что при авторизации возвращается id курьера")
    public void testCourierLoggedReturnsPositiveId(){
        steps.checkCourierLoginReturnsId();
    }

    @Test
    @DisplayName("Тест на авторизацию с некорректным паролем")
    public void testCourierLoginWithIncorrectPassword(){
        steps.checkLoginIncorrectPassword();
    }

    @Test
    @DisplayName("Тест на авторизацию с некорректным логином")
    public void testCourierLoginWithIncorrectLogin(){
        steps.checkLoginIncorrectLogin();
    }

    @Test
    @DisplayName("Тест на авторизацию, когда в запросе отсутствует body")
    public void testCourierLoginWithoutBody(){
        steps.checkLoginCourierLoginWithoutBody();
    }
}
