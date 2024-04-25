package get_tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.negative_responses.NegativeResponses;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static steps.Specifications.requestSpecGetAllBookNegative;
import static steps.Specifications.requestSpecGetAllBookNegativeNull;
import static steps.asertsResponses.NegativeAsser.verifyBodyNegative;


@Epic("GetTests")
@Story("Get all books negative")
public class GetAllBooksNegativeTest {
    @DisplayName("Get a list of books by an unknown author")
    @Description("There is no list of books in the response, status code 409")
    @Test
    public void getAllBooksUnknownAuthorTest(){
        NegativeResponses response = requestSpecGetAllBookNegative("1553", 409);
        verifyBodyNegative(response, "1004", "Указанный автор не существует в таблице");
    }

    @DisplayName("Get a list of books , id is specified in incorrect format")
    @Description("There is no list of books in the response, status code 400")
    @ParameterizedTest(name = "id = {0}")
    @ValueSource(strings = {"incorrectID"," ","null"})
    public void getAllBooksIdWrongFormatTest(String id){
        NegativeResponses response =requestSpecGetAllBookNegative(id, 400);
        verifyBodyNegative(response, "1001", "Некорректный обязательный параметр");

    }

    @DisplayName("Get a list of all books with negative id")
    @Description("Book list is not exist, status code 409")
    @ParameterizedTest(name = "id = {0}")
    @ValueSource (strings = {"-1","-2"})
    public void getAllBooksIdNegativeTest(String id){
        NegativeResponses response = requestSpecGetAllBookNegative(id, 409);
        verifyBodyNegative(response, "1004", "Указанный автор не существует в таблице");
    }

    @DisplayName("Get a list of all books without  id")
    @Description("Book list is not exist, status code 400")
    @Test
    public void getAllBooksIdNullTest(){
        NegativeResponses  response = requestSpecGetAllBookNegativeNull(400);
        verifyBodyNegative(response, "1001", "Некорректный обязательный параметр");
    }
}
