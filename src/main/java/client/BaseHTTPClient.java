package client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseHTTPClient {


    private final String JSON = "application/json";
    protected final String baseUrl = "http://qa-scooter.praktikum-services.ru";

    protected RequestSpecification baseSpec(){
    return new RequestSpecBuilder()
            .setContentType(JSON)
            .setBaseUri(baseUrl)
            .build();
    }

}
