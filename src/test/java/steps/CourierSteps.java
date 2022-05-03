package steps;

import Models.ApiAnswers.BadRequestApiAnswer;
import Models.ApiAnswers.OkApiAnswer;
import Models.CourierLoginOk;
import client.CreateCourierApiClient;
import client.DeleteCourierApiClient;
import client.LoginCourierApiClient;
import io.qameta.allure.Step;
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

    @Step("Создание рандомных имени, логина и пароля для курьера")
    public void generateCourierData(){
        setLogin(RandomStringUtils.randomAlphabetic(10));
        setPassword(RandomStringUtils.randomAlphabetic(10));
        setFirstName(RandomStringUtils.randomAlphabetic(10));
    }

    @Step("Создание курьера с применением метода автогенерации данных")
    public void createCourier(){
        generateCourierData();
        createCourierApiClient.createCourierPositive(login, password, firstName);
    }

    @Step("Авторизация курьера с использованием логина и пароля а также сохранение Id курьера в переменную courierId")
    public void loginCourier(){
        setCourierId(loginCourierApiClient.loginCourierPositive(login, password).getId());
    }

    @Step("Удаление курьера с использованием courierId")
    public void deleteCourier(){
        deleteCourierApiClient.deleteCourierOk(getCourierId());
    }

    @Step("Проверка, что курьер авторизован, и приходит ответ")
    public void checkCourierLoggedIn(){
        CourierLoginOk courierLoginOk = loginCourierApiClient.loginCourierPositive(login, password);
        assertThat(courierLoginOk.getId()).isNotNull();
    }

    @Step("Проверка, что приходит id, отличный от 0")
    public void checkCourierLoginReturnsId(){
        CourierLoginOk courierLoginOk = loginCourierApiClient.loginCourierPositive(login, password);
        assertThat(courierLoginOk.getId()).isGreaterThan(1l);
    }

    @Step("Проверка, когда дял входа недостаточно данных")
    public void checkLoginNotEnoughData(String login, String password){
        BadRequestApiAnswer badRequestApiAnswer = loginCourierApiClient.loginCourierBadRequest(login, password);
        assertThat(badRequestApiAnswer.getMessage()).isEqualTo("Недостаточно данных для входа");
    }

    @Step("Проверка, если авторизация производится с неверным паролем")
    public void checkLoginIncorrectPassword(){
        String incorrectPassword = RandomStringUtils.randomAlphabetic(10);
        BadRequestApiAnswer badRequestApiAnswer = loginCourierApiClient.loginCourierBadRequest(login, incorrectPassword);
        assertThat(badRequestApiAnswer.getMessage()).isEqualTo("Учетная запись не найдена");
    }

    @Step("Проверка, если авторизация происходит с неверным логином")
    public void checkLoginIncorrectLogin(){
        String incorrectLogin = RandomStringUtils.randomAlphabetic(10);
        BadRequestApiAnswer badRequestApiAnswer = loginCourierApiClient.loginCourierBadRequest(incorrectLogin, password);
        assertThat(badRequestApiAnswer.getMessage()).isEqualTo("Учетная запись не найдена");
    }

    @Step("Проверка, что для параметра ок возвращается значение true при создании курьера")
    public void checkCourierCreateReturnsOkTrue(){
        generateCourierData();
        OkApiAnswer okApiAnswer = createCourierApiClient.createCourierPositive(login, password, firstName);
        assertThat(okApiAnswer.isOk()).isEqualTo(true);
    }

    @Step("Проверка, что курьер создается и при авторизации возвращается его id")
    public void checkCourierCreated(){
        generateCourierData();
        createCourierApiClient.createCourierPositive(login, password, firstName);
        CourierLoginOk courierLoginOk = loginCourierApiClient.loginCourierPositive(login, password);
        assertThat(courierLoginOk.getId()).isNotNull().isGreaterThan(1l);
    }

    @Step("Проверка, что два курьера с одинаквым логином не могут быть созданы")
    public void checkSameNameCourierCantBeCreated(){
        generateCourierData();
        createCourierApiClient.createCourierPositive(login, password, firstName);
        BadRequestApiAnswer badRequestApiAnswer = createCourierApiClient.createCourierBadRequest(login, password, firstName);
        assertThat(badRequestApiAnswer.getMessage()).isEqualTo("Этот логин уже используется");
    }
    @Step("Проверка, что для создания курьера необходимо заполнить все обязательные поля")
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
