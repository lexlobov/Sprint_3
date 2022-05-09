package steps;

import Models.Courier;
import client.CreateCourierApiClient;
import client.DeleteCourierApiClient;
import client.LoginCourierApiClient;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class CourierSteps {

    private String login;
    private String password;
    private String firstName;
    private int courierId;



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
        Courier courier = new Courier(login, password, firstName);
        createCourierApiClient.createCourier(login, password, firstName);
    }

    @Step("Авторизация курьера с использованием логина и пароля а также сохранение Id курьера в переменную courierId")
    public void loginCourier(){
        setCourierId(loginCourierApiClient.loginCourier(login, password).extract().path("id"));
    }

    @Step("Удаление курьера с использованием courierId")
    public void deleteCourier(){
        deleteCourierApiClient.deleteCourier(getCourierId());
    }

    @Step("Проверка, что курьер авторизован, и приходит ответ")
    public void checkCourierLoggedIn(){
        ValidatableResponse response = loginCourierApiClient.loginCourier(login, password);
        int statusCode = response.extract().statusCode();
        int courierId = response.extract().path("id");
        assertThat("Status code should be 200", statusCode, equalTo(HttpStatus.SC_OK));
        assertThat("CourierId Should be returned", courierId, Matchers.notNullValue());
    }

    @Step("Проверка, что приходит id, отличный от 0")
    public void checkCourierLoginReturnsId(){
        ValidatableResponse response = loginCourierApiClient.loginCourier(login, password);
        response.extract().path("id");
        int courierId = response.extract().path("id");
        assertThat("courierId should be greater than 0", courierId, Matchers.greaterThan(1));
    }

    @Step("Проверка, когда для входа недостаточно данных")
    public void checkLoginNotEnoughData(String login, String password){
        ValidatableResponse response = loginCourierApiClient.loginCourier(login, password);
        String answer = response.extract().path("message");
        assertThat("Answer should be 'Недостаточно данных для входа'", answer, equalTo("Недостаточно данных для входа"));
    }

    @Step("Проверка, если авторизация производится с неверным паролем")
    public void checkLoginIncorrectPassword(){
        String incorrectPassword = RandomStringUtils.randomAlphabetic(10);
        ValidatableResponse response = loginCourierApiClient.loginCourier(login, incorrectPassword);
        String answer = response.extract().path("message");
        assertThat("Answer should be 'Учетная запись не найдена'", answer, equalTo("Учетная запись не найдена"));
    }

    @Step("Проверка, если авторизация происходит с неверным логином")
    public void checkLoginIncorrectLogin(){
        String incorrectLogin = RandomStringUtils.randomAlphabetic(10);
        ValidatableResponse response = loginCourierApiClient.loginCourier(incorrectLogin, password);
        String answer = response.extract().path("message");
        assertThat("Answer should be 'Учетная запись не найдена'", answer, equalTo("Учетная запись не найдена"));
    }

    @Step("Проверка, что для параметра ок возвращается значение true при создании курьера")
    public void checkCourierCreateReturnsOkTrue(){
        generateCourierData();
        ValidatableResponse response = createCourierApiClient.createCourier(login, password, firstName);
        boolean answer = response.extract().path("ok");
        assertThat("Answer should be True'", answer, equalTo(true));
    }

    @Step("Проверка, что курьер создается и при авторизации возвращается его id")
    public void checkCourierCreated(){
        generateCourierData();
        checkCourierCreateReturnsOkTrue();
        checkCourierLoggedIn();
    }

    @Step("Проверка, что два курьера с одинаквым логином не могут быть созданы")
    public void checkSameNameCourierCantBeCreated(){
        generateCourierData();
        createCourierApiClient.createCourier(login, password, firstName);
        ValidatableResponse response = createCourierApiClient.createCourier(login, password, firstName);
        String answer = response.extract().path("message");
        int status = response.extract().statusCode();
        assertThat("Message should be 'Этот логин уже используется'", answer, equalTo("Этот логин уже используется"));
        assertThat("MStatus code should be 409", status, equalTo(409));
    }

    @Step("Проверка, что для создания курьера необходимо заполнить все обязательные поля")
    public void checkCreateCourierNotEnoughData(String login, String password, String firstName){
        ValidatableResponse response = createCourierApiClient.createCourier(login, password, firstName);
        String answer = response.extract().path("message");
        int status = response.extract().statusCode();
        assertThat("Message should be 'Недостаточно данных для создания учетной записи'", answer, equalTo("Недостаточно данных для создания учетной записи"));
        assertThat("Status code should be 400", status, equalTo(400));
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

    public int getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }
}
