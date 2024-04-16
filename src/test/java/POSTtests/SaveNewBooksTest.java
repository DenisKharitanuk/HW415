package POSTtests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.ValidatableResponse;
import models.positive_responses.SaveNewAuthorPositiveResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.Specifications;
import steps.asertsResponses.GetAllBookAssert;

@Epic("PostTests")
@Story("saveNewBook")
public class SaveNewBooksTest {

    @DisplayName("New book save")
    @Description("The book is saved, status code 201, the response returns the id of the saved book")
    @Test
    public void saveBookTest(){
        SaveNewAuthorPositiveResponse author = Specifications.requestSpecSaveNewAuthor(RandomStringUtils.randomAlphabetic(5),
                RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomAlphabetic(5), 200);
        long id = author.getAuthorId();

        String bookTitle = "Maleus maleficarum";
        Specifications.requestSpecSaveNewBook(bookTitle, id, 201);

        ValidatableResponse allBooks = (ValidatableResponse) Specifications.requestSpecGetAllBooksJSON(String.valueOf(id), 200);
        GetAllBookAssert.verifyBodyGetBooks(allBooks, id, bookTitle);
    }
}
