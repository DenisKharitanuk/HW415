package steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.negative_responses.NegativeResponses;
import models.positive_responses.GetAllAuthorsBooksPositiveResponse;
import models.positive_responses.GetAllAuthorsBooksPositiveResponseXML;
import models.positive_responses.SaveNewAuthorPositiveResponse;
import models.positive_responses.SaveNewBooksPositiveResponse;
import models.requests.GetAllAuthorsBooksRequestXML;
import models.requests.SaveNewAuthorRequest;
import models.requests.SaveNewBooksRequest;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Specifications {

    public static RequestSpecification requestSpecJSON() {

        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("http://localhost")
                .setPort(8080)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public static RequestSpecification requestSpecXML() {

        return new RequestSpecBuilder()
                .setContentType(ContentType.XML)
                .setBaseUri("http://localhost")
                .setPort(8080)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public static ResponseSpecification responseSpec(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }



    public static SaveNewAuthorPositiveResponse requestSpecSaveNewAuthor(String firstName, String familyName, String secondName, int statusCode) {
        SaveNewAuthorRequest author = new SaveNewAuthorRequest(firstName, familyName, secondName);
        return given()
                .spec(requestSpecJSON())
                .body(author)
                .when()
                .post(Endpoints.SAVE_NEW_AUTHORS_URL)
                .then()
                .spec(responseSpec(statusCode))
                .extract().as(SaveNewAuthorPositiveResponse.class);
    }
    public static NegativeResponses requestSpecSaveNewAuthorNegative(String firstName, String familyName, String secondName, int statusCode) {
        SaveNewAuthorRequest author = new SaveNewAuthorRequest(firstName, familyName, secondName);
        return given()
                .spec(requestSpecJSON())
                .body(author)
                .when()
                .post(Endpoints.SAVE_NEW_AUTHORS_URL)
                .then()
                .spec(responseSpec(statusCode))
                .extract().as(NegativeResponses.class);
    }

    public static SaveNewBooksPositiveResponse requestSpecSaveNewBook(String bookTitle, long authorID, int statusCode) {
        SaveNewAuthorRequest author = new SaveNewAuthorRequest(authorID);
        SaveNewBooksRequest book= new  SaveNewBooksRequest(bookTitle, author);

        return given()
                .spec(requestSpecJSON())
                .body(book)
                .when()
                .post(Endpoints.SAVE_NEW_BOOK_URL)
                .then().spec(responseSpec(statusCode))
                .extract().as(SaveNewBooksPositiveResponse.class);
    }
    public static NegativeResponses requestSpecSaveNewBookNegative(String bookTitle, long authorID, int statusCode) {
        SaveNewAuthorRequest author = new SaveNewAuthorRequest(authorID);
        SaveNewBooksRequest book= new  SaveNewBooksRequest(bookTitle, author);

        return given()
                .spec(requestSpecJSON())
                .body(book)
                .when()
                .post(Endpoints.SAVE_NEW_BOOK_URL)
                .then().spec(responseSpec(statusCode))
                .extract().as(NegativeResponses.class);
    }

    public static GetAllAuthorsBooksPositiveResponseXML requestSpecGetAllBooksXML(long id, int statusCode){
        GetAllAuthorsBooksRequestXML author = new GetAllAuthorsBooksRequestXML();
        author.setId(id);

        return given().spec(requestSpecXML())
                .body(author)
                .when()
                .post(Endpoints.GET_ALL_BOOKS_XML_URL)
                .then().spec(responseSpec(statusCode))
                .extract().as(GetAllAuthorsBooksPositiveResponseXML.class);
    }

    public static List<GetAllAuthorsBooksPositiveResponse> requestSpecGetAllBooksJSON(String id, int statusCode){
        return given().spec(requestSpecJSON())
                .when()
                .get(Endpoints.GET_ALL_BOOKS_URL, id)
                .then().spec(responseSpec(statusCode))
                .extract().jsonPath().getList(".", GetAllAuthorsBooksPositiveResponse.class);
    }


   public static NegativeResponses requestSpecGetAllBookNegative(String id, int statusCode){
        return given().spec(requestSpecJSON())
                .when()
                .get(Endpoints.GET_ALL_BOOKS_URL)
                .then().spec(responseSpec(statusCode))
                .extract().as(NegativeResponses.class);

   }

   public static NegativeResponses requestSpecGetAllBooksXMLNegative(long id, int statusCode){
        return given().spec(requestSpecXML())
                .when()
                .get(Endpoints.GET_ALL_BOOKS_XML_URL)
                .then().spec(responseSpec(statusCode))
                .extract().as(NegativeResponses.class);
   }

}
