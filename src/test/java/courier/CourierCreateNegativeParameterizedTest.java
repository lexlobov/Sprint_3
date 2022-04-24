package courier;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import steps.CourierSteps;
@RunWith(Parameterized.class)
public class CourierCreateNegativeParameterizedTest {

    private String login;
    private String password;
    private String firstName;
    CourierSteps steps = new CourierSteps();

    public CourierCreateNegativeParameterizedTest(String login, String password, String firstName){
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    @Parameterized.Parameters
    public static Object[][] getCourierData() {
        return new Object[][]{

                {RandomStringUtils.randomAlphabetic(10), "", ""},
                {"", RandomStringUtils.randomAlphabetic(10), ""},
                {"", RandomStringUtils.randomAlphabetic(10), ""},
                {RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(10), ""},
                {"", RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(10)},
                {RandomStringUtils.randomAlphabetic(10), "", RandomStringUtils.randomAlphabetic(10)},
                {"", "", ""},
        };
    }

    // Один из тестов падает, так как в документации не указано, что поле firstName - необязательное
    @Test
    public void createCourierNotEnoughDataTest(){
        steps.checkCreateCourierNotEnoughData(login, password, firstName);
    }
}
