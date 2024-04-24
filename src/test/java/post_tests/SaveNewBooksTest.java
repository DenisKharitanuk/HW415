package post_tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.positive_responses.GetAllAuthorsBooksPositiveResponse;
import models.positive_responses.SaveNewAuthorPositiveResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.asertsResponses.GetAllBookAssert;

import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static steps.Specifications.*;

@Epic("PostTests")
@Story("saveNewBook")
public class SaveNewBooksTest {

    @DisplayName("New book save")
    @Description("The book is saved, status code 200, the response returns the id of the saved book")
    @Test
    public void saveBookTest(){
        SaveNewAuthorPositiveResponse author = requestSpecSaveNewAuthor(randomAlphabetic(5),
                randomAlphabetic(5), randomAlphabetic(5), 201);
        long id = author.getAuthorId();

        String bookTitle = "Maleus maleficarum";
        requestSpecSaveNewBook(bookTitle, id, 201);

        List<GetAllAuthorsBooksPositiveResponse> allBooks = requestSpecGetAllBooksJSON(String.valueOf(id), 201);

        GetAllBookAssert.verifyBodyGetBooks(allBooks, id, bookTitle);
    }
}
