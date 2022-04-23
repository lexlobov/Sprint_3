package client;


import Models.ApiAnswers.BadRequestApiAnswer;
import Models.Courier;
import Models.CourierLoginOk;

public class LoginCourierApiClient extends BaseHTTPClient {

    private final String baseUrl = "http://qa-scooter.praktikum-services.ru";
    private final String loginCourierUri = "/api/v1/courier/login";

    public CourierLoginOk loginCourierPositive(String login, String password){
        Courier courier = new Courier(login, password);
        CourierLoginOk courierLoginOk = doPostRequest(baseUrl + loginCourierUri, courier).as(CourierLoginOk.class);
        return courierLoginOk;
    }
    public BadRequestApiAnswer loginCourierBadRequest(String login, String password){
        Courier courier = new Courier(login, password);
        BadRequestApiAnswer badRequestApiAnswer = doPostRequest(baseUrl + loginCourierUri, courier).as(BadRequestApiAnswer.class);
        return badRequestApiAnswer;
    }


}
