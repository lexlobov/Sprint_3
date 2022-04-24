package steps;

import Models.ApiAnswers.BadRequestApiAnswer;
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

    public void checkCourierLoginReturnsId(){
        CourierLoginOk courierLoginOk = loginCourierApiClient.loginCourierPositive(login, password);
        assertThat(courierLoginOk.getId()).isGreaterThan(1l);
    }

    public void checkLoginNotEnoughData(String login, String password){
        BadRequestApiAnswer badRequestApiAnswer = loginCourierApiClient.loginCourierBadRequest(login, password);
        assertThat(badRequestApiAnswer.getMessage()).isEqualTo("Недостаточно данных для входа");
    }

    public void checkLoginIncorrectPassword(){
        String incorrectPassword = RandomStringUtils.randomAlphabetic(10);
        BadRequestApiAnswer badRequestApiAnswer = loginCourierApiClient.loginCourierBadRequest(login, incorrectPassword);
        assertThat(badRequestApiAnswer.getMessage()).isEqualTo("Учетная запись не найдена");
    }

    public void checkLoginIncorrectLogin(){
        String incorrectLogin = RandomStringUtils.randomAlphabetic(10);
        BadRequestApiAnswer badRequestApiAnswer = loginCourierApiClient.loginCourierBadRequest(incorrectLogin, password);
        assertThat(badRequestApiAnswer.getMessage()).isEqualTo("Учетная запись не найдена");
    }

    public void checkCourierCreated(){
        generateCourierData();
        OkApiAnswer okApiAnswer = createCourierApiClient.createCourierPositive(login, password, firstName);
        assertThat(okApiAnswer.isOk()).isEqualTo(true);
    }

    public void checkSameNameCourierCantBeCreated(){
        generateCourierData();
        createCourierApiClient.createCourierPositive(login, password, firstName);
        BadRequestApiAnswer badRequestApiAnswer = createCourierApiClient.createCourierBadRequest(login, password, firstName);
        assertThat(badRequestApiAnswer.getMessage()).isEqualTo("Этот логин уже используется");
    }

    public void checkCreateCourierNotEnoughData(String login, String password, String firstName){
        BadRequestApiAnswer badRequestApiAnswer = createCourierApiClient.createCourierBadRequest(login, password, firstName);
        assertThat(badRequestApiAnswer.getMessage()).isEqualTo("Недостаточно данных для создания учетной записи");
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
