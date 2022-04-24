package courier;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import steps.CourierSteps;

@RunWith(Parameterized.class)
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
    public void incorrectLoginPasswordCourierTest(){
        steps.checkLoginNotEnoughData(login, password);
    }



}
