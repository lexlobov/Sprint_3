package steps;

import client.CreateCourierApiClient;
import client.DeleteCourierApiClient;
import client.LoginCourierApiClient;
import org.apache.commons.lang3.RandomStringUtils;

public class CourierSteps {

    private String login = RandomStringUtils.randomAlphabetic(10);
    private String password = RandomStringUtils.randomAlphabetic(10);
    private String firstName = RandomStringUtils.randomAlphabetic(10);
    private long courierId;

    public long getCourierId() {
        return courierId;
    }

    public void setCourierId(long courierId) {
        this.courierId = courierId;
    }

    CreateCourierApiClient createCourierApiClient = new CreateCourierApiClient();
    LoginCourierApiClient loginCourierApiClient = new LoginCourierApiClient();
    DeleteCourierApiClient deleteCourierApiClient = new DeleteCourierApiClient();

    public void createCourier (){
        createCourierApiClient.createCourierPositive(login, password, firstName);
    }

    public void loginCourier(){
        setCourierId(loginCourierApiClient.loginCourierPositive(login, password).getId());

    }

    public void deleteCourier(){
        deleteCourierApiClient.deleteCourierOk(getCourierId());

    }


}
