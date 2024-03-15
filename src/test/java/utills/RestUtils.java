package utills;

import com.utills.ExtentReportManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

import java.util.Map;

public class RestUtils {

    private static RequestSpecification getRequestSpecification(String endpoint, Map<String,Object> requestPlayLoad, Map<String,String> headers){

        return RestAssured.given()
                .baseUri(endpoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPlayLoad);

    }





    public static Response performPost(String endpoint, Map<String,Object> requestPlayLoad, Map<String,String> headers){

        RequestSpecification httpRequest = getRequestSpecification(endpoint, requestPlayLoad, headers);
        Response response = httpRequest.post();
        printRequestLogInReport(httpRequest);
        return response;

    }

    public static Response performPut(){
        return null;

    }

    public static Response performUpdate(){
        return null;

    }

    public static Response performGet(String endpoint, Map<String,Object> requestPlayLoad, Map<String,String> headers){
        RequestSpecification httpRequest = getRequestSpecification(endpoint,requestPlayLoad,headers);
        Response response = httpRequest.get();
        printRequestLogInReport(httpRequest);
        return response;

    }
    public static Response performGetId(int id,String endpoint, Map<String,Object> requestPlayLoad, Map<String,String> headers){
        RequestSpecification httpRequest = getRequestSpecification(endpoint,requestPlayLoad,headers);
        httpRequest.pathParam("id",id);
        Response response = httpRequest.get("{id}");
        printRequestLogInReport(httpRequest);
        return response;
    }



    public static void printRequestLogInReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManagerTest.logInfoDetails("Endpoint is " + queryableRequestSpecification.getURI());
        ExtentReportManagerTest.logInfoDetails("Method is " + queryableRequestSpecification.getMethod());
        ExtentReportManagerTest.logInfoDetails("Headers are ");
        ExtentReportManagerTest.logHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtentReportManagerTest.logInfoDetails("Request body is ");
        ExtentReportManagerTest.logJson(queryableRequestSpecification.getBody());
    }

    public static void printResponseLogInReport(Response response) {
        ExtentReportManagerTest.logInfoDetails("Response status is " + response.getStatusCode());
        ExtentReportManagerTest.logInfoDetails("Response Headers are ");
        ExtentReportManagerTest.logHeaders(response.getHeaders().asList());
        ExtentReportManagerTest.logInfoDetails("Response body is ");
        ExtentReportManagerTest.logJson(response.getBody().prettyPrint());
    }


}
