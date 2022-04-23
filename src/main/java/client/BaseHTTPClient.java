package client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseHTTPClient {

    private final String BASE_URL = "http://qa-scooter.praktikum-services.ru";
    private final String JSON = "application/json";

    protected Response doGetRequest (String uri){
        return given()
                .header("Content-Type", JSON)
                .get(uri);
    }

        }
