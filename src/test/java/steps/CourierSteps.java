package steps;

import Models.ApiAnswers.OkApiAnswer;
import Models.CourierLoginOk;
import client.CreateCourierApiClient;
import client.DeleteCourierApiClient;
import client.LoginCourierApiClient;
import org.apache.commons.lang3.RandomStringUtils;

import static org.assertj.core.api.Assertions.assertThat;


public class CourierSteps {

    private String login;
    private String password;
    private String firstName;
    private long courierId;



    CreateCourierApiClient createCourierApiClient = new CreateCourierApiClient();
    LoginCourierApiClient loginCourierApiClient = new LoginCourierApiClient();
    DeleteCourierApiClient deleteCourierApiClient = new DeleteCourierApiClient();

    public void generateCourierData(){
        setLogin(RandomStringUtils.randomAlphabetic(10));
        setPassword(RandomStringUtils.randomAlphabetic(10));
        setFirstName(RandomStringUtils.randomAlphabetic(10));
    }

    public void createCourier(){
        generateCourierData();
        createCourierApiClient.createCourierPositive(login, password, firstName);
    }

    public void loginCourier(){
        setCourierId(loginCourierApiClient.loginCourierPositive(login, password).getId());

    }

    public void deleteCourier(){
        deleteCourierApiClient.deleteCourierOk(getCourierId());

    }

    public void checkCourierLoggedIn(){
        CourierLoginOk courierLoginOk = loginCourierApiClient.loginCourierPositive(login, password);
        assertThat(courierLoginOk.getId()).isNotNull();
    }



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getCourierId() {
        return courierId;
    }

    public void setCourierId(long courierId) {
        this.courierId = courierId;
    }
}
