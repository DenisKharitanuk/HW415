package get_tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.positive_responses.GetAllAuthorsBooksPositiveResponse;
import models.positive_responses.SaveNewAuthorPositiveResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import steps.asertsResponses.GetAllBookAssert;

import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static steps.Specifications.*;

@Story("Get all books")
@Epic("Get tests")
public class GetAllAuthorsBooksTest {

    @DisplayName("Get all authors books")
    @Description("A list of all books by the author corresponding " +
            "to the entered id is returned, the list contains the created book, status code 201")
    @ParameterizedTest(name = "id = {0}")
    @ValueSource(longs = {10})
    public void getAllAuthorsBooksTest() {
        SaveNewAuthorPositiveResponse author = requestSpecSaveNewAuthor(randomAlphabetic(5),
                randomAlphabetic(5), randomAlphabetic(5), 201);

        long id = author.getAuthorId();

        String bookTitle = "Flugegihaimer";
        requestSpecSaveNewBook("Flugegihaimer", id, 201);

        List<GetAllAuthorsBooksPositiveResponse> allBooks = requestSpecGetAllBooksJSON(String.valueOf(id), 200);

        GetAllBookAssert.verifyBodyGetBooks(allBooks, id, bookTitle);
    }
}
