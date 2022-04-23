package client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;

public class BaseHTTPClient {

    private final String BASE_URL = "http://qa-scooter.praktikum-services.ru";
    private final String JSON = "application/json";

    protected Response doGetRequest (String uri){
        return given()
                .header("Content-Type", JSON)
                .get(uri);
    }
    protected Response doPostRequest(String uri){
        return given()
                .header("Content-Type", JSON)
                .post(uri);
    }
    protected Response doDeleteRequest(String uri){
        return given()
                .header("Content-Type", JSON)
                .delete(uri);
    }

        }
