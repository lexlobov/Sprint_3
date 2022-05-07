package client;

import Models.ApiAnswers.BadRequestApiAnswer;
import Models.ApiAnswers.OkApiAnswer;
import Models.Courier;

public class CreateCourierApiClient extends BaseHTTPClient{

    private final String createCourierUri = "/api/v1/courier";

    public OkApiAnswer createCourierPositive(String login, String password, String firstName){
        Courier courier = new Courier(login, password, firstName);
        OkApiAnswer okApiAnswer = doPostRequest(baseUrl + createCourierUri, courier).as(OkApiAnswer.class);
        return okApiAnswer;
    }

    public BadRequestApiAnswer createCourierBadRequest(String login, String password, String firstName){
        Courier courier = new Courier(login, password, firstName);
        BadRequestApiAnswer badRequestApiAnswer = doPostRequest(baseUrl + createCourierUri, courier).as(BadRequestApiAnswer.class);
        return badRequestApiAnswer;
    }

}
