package get_tests;

import entity.Author;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.ValidatableResponse;
import models.positive_responses.GetAllAuthorsBooksPositiveResponse;
import models.positive_responses.GetAllAuthorsBooksPositiveResponseXML;
import models.positive_responses.SaveNewAuthorPositiveResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import steps.Specifications;
import steps.asertsResponses.GetAllBookAssert;
import steps.asertsResponses.GetAllBookAssertXML;

import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.*;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static steps.Specifications.*;
import static steps.asertsResponses.GetAllBookAssert.verifyBodyGetBooks;
import static steps.asertsResponses.GetAllBookAssertXML.*;

@Epic("Get Tests")
@Story("Get all books XML")
public class GetAllAuthorsBooksXMLTest {
    @DisplayName("Get all authors books in XML format")
    @Description("A list of all books by the author corresponding in XML format " +
            "to the entered id is returned, the list contains the created book, status code 200")
    @ParameterizedTest(name = "id = {0}")
    @ValueSource(longs = {10})
    public void getAllAuthorsBooksTest() {

        SaveNewAuthorPositiveResponse author = requestSpecSaveNewAuthor(randomAlphabetic(5),
                randomAlphabetic(5), randomAlphabetic(5), 201);
        long id = author.getAuthorId();
        String bookTitle = randomAlphabetic(5);
        requestSpecSaveNewBook(bookTitle, id, 201);


        GetAllAuthorsBooksPositiveResponseXML books= requestSpecGetAllBooksXML(id,200);

        Author author1 =books.getBook().get(0).getAuthor();
        verifyBodyGetBooksXML(books,bookTitle,author1);
    }
}
