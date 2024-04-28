package get_tests;

import entity.Author;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.ValidatableResponse;
import models.positive_responses.GetAllAuthorsBooksPositiveResponseXML;
import models.positive_responses.SaveNewAuthorPositiveResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import steps.Specifications;
import steps.asertsResponses.GetAllBookAssert;
import steps.asertsResponses.GetAllBookAssertXML;

import static org.apache.commons.lang3.RandomStringUtils.*;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static steps.Specifications.*;

@Epic("Get Tests")
@Story("Get all books XML")
public class GetAllAuthorsBooksXMLTest {
    @DisplayName("Get all authors books in XML format")
    @Description("A list of all books by the author corresponding in XML format " +
            "to the entered id is returned, the list contains the created book, status code 200")
    @ParameterizedTest(name = "id = {0}")
    @ValueSource(longs = {10})
    public void getAllAuthorsBooksTest() {
        SaveNewAuthorPositiveResponse author1 = Specifications.requestSpecSaveNewAuthor(randomAlphabetic(3), randomAlphabetic(3), randomAlphabetic(3), 201);
        long id = author1.getAuthorId();

        String bookTitle = randomAlphabetic(3);
        Specifications.requestSpecSaveNewBook(bookTitle, id, 201);

        GetAllAuthorsBooksPositiveResponseXML listBooksXML = Specifications.requestSpecGetAllBooksXML(id, 200);
        Author author = listBooksXML.getBooks().get(0).getAuthor();

        GetAllBookAssertXML.verifyBodyGetBooksXML(listBooksXML, bookTitle, author);
    }
}
