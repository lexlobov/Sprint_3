package courier;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import steps.CourierSteps;

@RunWith(Parameterized.class)
@DisplayName("Негативные сценарии авторизации при незаполенных обязатльных полях")
public class CourierLoginNegativeParameterizedTest {

    private String login;
    private String password;
    CourierSteps steps = new CourierSteps();

    public CourierLoginNegativeParameterizedTest(String login, String password){
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters
    public static Object[][] getCourierData() {
        return new Object[][]{

                {RandomStringUtils.randomAlphabetic(10),    ""},
                {"",                                              RandomStringUtils.randomAlphabetic(10)},
                {"",                                              ""}
        };
    }

    @Test
    @DisplayName("Тест на то, что для авторизации обязательны и логин, и пароль")
    public void incorrectLoginPasswordCourierTest(){
        steps.checkLoginNotEnoughData(login, password);
    }



}
