package client;


import Models.ApiAnswers.BadRequestApiAnswer;
import Models.ApiAnswers.OkApiAnswer;
import Models.Courier;
import Models.CourierLoginOk;

public class CourierLoginApiClient extends BaseHTTPClient {

    private final String baseUrl = "http://qa-scooter.praktikum-services.ru";
    private final String createCourierUri = "/api/v1/courier/login";

    public CourierLoginOk createCourierOk(String login, String password){
        Courier courier = new Courier(login, password);
        CourierLoginOk courierLoginOk = doPostRequest(baseUrl +  createCourierUri, courier).as(CourierLoginOk.class);
        return courierLoginOk;
    }
    public BadRequestApiAnswer createCourierBadRequest(String login, String password){
        Courier courier = new Courier(login, password);
        BadRequestApiAnswer badRequestApiAnswer = doPostRequest(baseUrl + createCourierUri, courier).as(BadRequestApiAnswer.class);
        return badRequestApiAnswer;
    }


}
