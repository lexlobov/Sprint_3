package client;

import Models.ApiAnswers.BadRequestApiAnswer;
import Models.ApiAnswers.OkApiAnswer;
import Models.DeleteCourier;

public class DeleteCourierApiClient extends BaseHTTPClient{

    private final String baseUrl = "http://qa-scooter.praktikum-services.ru";
    private final String deleteCourierUri = "/api/v1/courier/";


    public OkApiAnswer deleteCourierOk(long id){
        DeleteCourier deleteCourier = new DeleteCourier(Long.toString(id));
        return doDeleteRequest(baseUrl + deleteCourierUri, deleteCourier).as(OkApiAnswer.class);
    }

    public BadRequestApiAnswer deleteCourierBadRequest(long id){
        DeleteCourier deleteCourier = new DeleteCourier(Long.toString(id));
        return doDeleteRequest(baseUrl + deleteCourierUri, deleteCourier).as(BadRequestApiAnswer.class);

    }
}
