package client;


import Models.ApiAnswers.BadRequestApiAnswer;
import Models.Courier;
import Models.CourierLoginOk;

public class LoginCourierApiClient extends BaseHTTPClient {

    private final String baseUrl = "http://qa-scooter.praktikum-services.ru";
    private final String loginCourierUri = "/api/v1/courier/login";

    public CourierLoginOk loginCourierPositive(String login, String password){
        Courier courier = new Courier(login, password);
        return doPostRequest(baseUrl + loginCourierUri, courier).as(CourierLoginOk.class);
    }
    public BadRequestApiAnswer loginCourierBadRequest(String login, String password){
        Courier courier = new Courier(login, password);
        return doPostRequest(baseUrl + loginCourierUri, courier).as(BadRequestApiAnswer.class);

    }


}
