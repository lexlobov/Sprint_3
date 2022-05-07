package client;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class BaseHTTPClient {


    private final String JSON = "application/json";
    protected final String baseUrl = "http://qa-scooter.praktikum-services.ru";

    protected Response doGetRequest (String uri){
        return given()
                .header("Content-Type", JSON)
                .get(uri);
    }
    protected Response doPostRequest(String uri, Object object){
        return given()
                .header("Content-Type", JSON)
                .body(object)
                .post(uri);
    }
    protected Response doDeleteRequest(String uri, Object object){
        return given()
                .header("Content-Type", JSON)
                .body(object)
                .delete(uri);
    }

    protected Response doPutRequest(String uri){
        return given()
                .header("Content-Type", JSON)
                .put(uri);
    }

}
