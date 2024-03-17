package utills;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static utills.ExtentReportManagerTest.printRequestLogInReport;

public class RestUtils {

    private static RequestSpecification getRequestSpecification(String endpoint, String requestPlayLoad, Map<String, String> headers) {

        return RestAssured.given()
                .baseUri(endpoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPlayLoad);

    }


    public static Response performPost(String endpoint, String requestPlayLoad, Map<String, String> headers) {
        RequestSpecification httpRequest = getRequestSpecification(endpoint, requestPlayLoad, headers);
        Response response = httpRequest.post();
        printRequestLogInReport(httpRequest);
        return response;

    }

    public static Response performPut(int id, String endpoint, String requestPlayLoad, Map<String, String> headers) {
        RequestSpecification httpRequest = getRequestSpecification(endpoint, requestPlayLoad, headers);
        httpRequest.pathParam("id", id);
        Response response = httpRequest.put("{id}");
        printRequestLogInReport(httpRequest);
        return response;

    }

    public static Response performUpdate() {
        return null;

    }

    public static Response performGet(String endpoint, String requestPlayLoad, Map<String, String> headers) {
        RequestSpecification httpRequest = getRequestSpecification(endpoint, requestPlayLoad, headers);
        Response response = httpRequest.get();
        printRequestLogInReport(httpRequest);
        return response;

    }

    public static Response performGetId(int id, String endpoint, String requestPlayLoad, Map<String, String> headers) {
        RequestSpecification httpRequest = getRequestSpecification(endpoint, requestPlayLoad, headers);
        httpRequest.pathParam("id", id);
        Response response = httpRequest.get("{id}");
        printRequestLogInReport(httpRequest);
        return response;
    }


}
