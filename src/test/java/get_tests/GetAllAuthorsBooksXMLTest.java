package get_tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.positive_responses.GetAllAuthorsBooksPositiveResponseXML;
import models.positive_responses.SaveNewAuthorPositiveResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import steps.asertsResponses.GetAllBookAssertXML;

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
        SaveNewAuthorPositiveResponse author = requestSpecSaveNewAuthor(randomAlphabetic(3), randomAlphabetic(3), randomAlphabetic(3), 201);
        long id = author.getAuthorId();

        String bookTitle = "GG landed in Grodno";
        requestSpecSaveNewBook("GG landed in Grodno", id, 201);

        GetAllAuthorsBooksPositiveResponseXML allBooks = requestSpecGetAllBooksXML(id, 201);

        GetAllBookAssertXML.verifyBodyGetBooksXML(allBooks ,id, bookTitle);
    }
}
