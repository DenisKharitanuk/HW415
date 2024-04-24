package post_tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.negative_responses.NegativeResponses;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static steps.Specifications.requestSpecSaveNewBookNegative;
import static steps.asertsResponses.NegativeAsser.verifyBodyNegative;

@Epic("Post tests")
@Story("Save new book negative")
public class SaveNewBooksNegativeTest {

    @DisplayName("Saving a new book with an unknown author id")
    @Description("The book is not saved, status code 409, error 1004")
    @Test
    public void saveBookUnknownAuthorTest() {
        NegativeResponses response = requestSpecSaveNewBookNegative("Book", 666, 409);
        verifyBodyNegative(response, "1004", "Указанный автор не существует в таблице");
    }

    @DisplayName("Saving a new book with a negative id")
    @Description("The book is not saved, status code 409, error 1004")
    @ParameterizedTest(name = "id = {0}")
    @ValueSource(longs = {-1, -2,})
    public void saveBookNegativeId(long id) {
        NegativeResponses response = requestSpecSaveNewBookNegative("Title", id, 409);
        verifyBodyNegative(response, "1004", "Указанный автор не существует в таблице");
    }

    @DisplayName("Saving a new book with an empty bookTitle")
    @Description("The book is not saved, status code 400, error 1001")
    @ParameterizedTest
    @NullSource
    public void saveBookNullTitle(String bookTitle) {
        NegativeResponses response = requestSpecSaveNewBookNegative(bookTitle, 1, 400);
        verifyBodyNegative(response, "Валидация не пройдена", "Не передан обязательный параметр: bookTitle");
    }
}
