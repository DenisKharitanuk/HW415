package post_tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.ValidatableResponse;
import models.positive_responses.GetAllAuthorsBooksPositiveResponse;
import models.positive_responses.SaveNewAuthorPositiveResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.Specifications;
import steps.asertsResponses.GetAllBookAssert;

import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static steps.Specifications.*;

@Epic("PostTests")
@Story("saveNewBook")
public class SaveNewBooksTest {
        @DisplayName("New book save")
        @Description("Книга сохраняется, статус-код 201, в ответе возвращается id сохранённой книги")
        @Test
        public void saveBookTest(){
            SaveNewAuthorPositiveResponse  author = Specifications.requestSpecSaveNewAuthor(RandomStringUtils.randomAlphabetic(3), RandomStringUtils.randomAlphabetic(3), RandomStringUtils.randomAlphabetic(3), 201);
            long id = author.getAuthorId();

            String bookTitle = randomAlphabetic(5);
            Specifications.requestSpecSaveNewBook(bookTitle, id, 201);



            ValidatableResponse allBooks = Specifications.requestSpecGetAllBooksJSON(String.valueOf(id), 200);
            GetAllBookAssert.verifyBodyGetBooks(allBooks, id, bookTitle);
        }
    }

