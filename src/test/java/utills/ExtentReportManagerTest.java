package utills;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.listners.ExtentsListeners;
import com.utills.Setup;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExtentReportManagerTest {

    public static ExtentReports extentReports;

    public static ExtentReports createInstance(String fileName, String reportName, String documentTitle) {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(fileName);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName(reportName);
        extentSparkReporter.config().setDocumentTitle(documentTitle);
        extentSparkReporter.config().setEncoding("utf-8");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }

    public static String getReportNameWithTimeStamp() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String datetime = "Report_"+dateTimeFormatter.format(localDateTime);
        return "reports/extent/" +datetime + ".html";
    }

    public static void logPassDetails(String log) {
        ExtentsListeners.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }

    public static void logFailDetails(String log) {
        ExtentsListeners.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }

    public static void logStacktrace(String log) {
        String trace = log.replaceAll(",", "<br>");
        String finalStracktrace = "<details>/n" +
                "<summary>Click here to view the Exception stackTrace</summary>/n" +
                trace + "</details>/n";
        ExtentsListeners.extentTest.get().fail(finalStracktrace);
    }

    public static void logSkippedDetails(String log) {
        ExtentsListeners.extentTest.get().skip(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
    }

    public static void logWarningDetails(String log) {
        ExtentsListeners.extentTest.get().warning(MarkupHelper.createLabel(log, ExtentColor.BLUE));
    }

    public static void logInfoDetails(String log) {
        ExtentsListeners.extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.ORANGE));
    }
    public static void logJson(String json){
        ExtentsListeners.extentTest.get().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }

    public static void logXMLBody(String json){
        ExtentsListeners.extentTest.get().info(MarkupHelper.createCodeBlock(json,CodeLanguage.XML));
    }

    public static  void  logHeaders(List<Header> headersList){
        String[][] arrayHeaders = headersList.stream().map(header -> new String[] {header.getName(), header.getValue()}).toArray(String[][] :: new);
        ExtentsListeners.extentTest.get().info(MarkupHelper.createTable(arrayHeaders));

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
